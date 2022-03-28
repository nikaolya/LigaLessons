package lesson_11.homework.steps;

import lesson_11.homework.pages.listing.ListingPage;
import lesson_11.homework.pages.listing.ListingType;
import lesson_11.homework.pages.listing.ProductCard;
import lesson_11.homework.pages.listing.filters.CheckboxValue;
import lesson_11.homework.pages.listing.filters.Filter;

public class Steps {

    private ListingPage listingPage;

    public Steps() {
        listingPage = ListingPage.getListingPage();
    }

    public void clickOnCheckboxFilter(String filterName, String filterValue) {
        setGridView();
        //Общее текущее количество товаров в листинге.
        //Понадобится для проверки завершения фильтрации после нажатия на чекбокс.
        int productCount = listingPage.getProductCount();

        //Разворачиваем блок, если он скрыт, а так же разворачиваем список всех значений фильтра
        Filter filter = listingPage.getFilter(filterName);
        filter.expand();
        filter.showAllValues();

        //Нажимаем на указанный чекбокс, проверяем изменение общего количества товаров, а так же их отображения.
        CheckboxValue checkboxFilterValue = filter.getCheckboxValue(filterValue);
        checkboxFilterValue.click();
        checkThatProductListUpdated(productCount);
    }

    public void clickOnSwitcherFilter(String switcherName) {
        int productCount = listingPage.getProductCount();
        listingPage.getSwitcherFilter(switcherName).click();
        checkThatProductListUpdated(productCount);
    }

    public void searchProductInGridView(String productName) {
        //Для начала переключаем листинг на плиточный вид
        setGridView();

        //Получаем максимальное количество переключений пагинации.
        //Добавляем единицу, чтобы цикл мог просмотреть последнюю страницу, иначе мы получим 0 и цикл завершиться,
        //когда откроется последняя страница пагинации
        //По хорошему тут должна быть разница между текущей и конечной страницей пагинации + 1.
        //Это количество должно ограничивать наш цикл переключений пагинации, а разница сделала бы это по умному.
        //Но мне лень доделывать. Простите:(
        int paginationStepsCount = listingPage.getPagitationCount() + 1;
        while (paginationStepsCount != 0) {
            paginationStepsCount--;//Уменьшаем оставшееся количество итераций
            //Ждем отображения первой строки с товарами. Иначе страница скролится с непрогрузившимися товарами.
            listingPage.productRowShouldBeVisible(1);

            //После того, как мы убедились, что первая строка с товарами прогрузилась, получаем общее количество строк
            int productRowsCount = listingPage.getProductRowsCount();

            //Докручиваем страницу до каждой строки с товарами и ждем, пока в ней прогрузятся товары.
            //Таким образом заставляем страницу отобразить все товары, которые могут на ней присутствовать.
            for (int i = 0; i < productRowsCount; i++) {
                listingPage.scrollToProductsRow(i + 1);
                listingPage.productRowShouldBeVisible(i + 1);
            }

            //После этого получаем объект с нужной карточкой товара и проверяем присутствует ли она на странице.
            //Если присутствует, крутим страницу до этой карточки и завершаем поиск.
            ProductCard productCard = listingPage.getProductCard(productName);
            if (productCard.isNameDisplayed()) {
                productCard.scrollTo();
                break;
            }

            //Если мы просмотрели последнюю страницу пагинации, заканчиваем цикл
            //Иначе открываем следующую страницу пагинации
            if (listingPage.isTheLastPaginationPage()) break;
            else listingPage.clickOnNextPaginationButton();
        }
    }

    public void setGridView() {
        if (listingPage.getListingType().equals(ListingType.LIST)) {
            listingPage.clickOnGridViewButton();
            listingPage.gridViewShouldBeVisible();
        }
    }

    public void checkThatProductListUpdated(int unexpectedProductCount) {
        listingPage.productsCountShouldNotBe(unexpectedProductCount);
        listingPage.productListShouldBeVisible();
    }
}
