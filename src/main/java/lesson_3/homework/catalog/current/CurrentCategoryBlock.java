package lesson_3.homework.catalog.current;

public class CurrentCategoryBlock {

    public static final String smartphonesCategoryName = "Смартфоны";
    public static final String tabletsCategoryName = "Планшеты";
    public static final String laptopsCategoryName = "Ноутбуки";
    public static final String tvCategoryName = "Телевизоры";
    public static final String computersAndAccessoriesCategoryName = "Компьютеры и комплектующие";
    public static final String smartWatchesAndFitnessBraceletsCategoryName = "Смарт-часы и фитнес-браслеты";

    public static final String accessoriesForSmartphonesCategoryName = "Аксессуары для смартфонов";
    public static final String headphonesAndAudioCategoryName = "Наушники и аудиотехника";
    public static final String photoAndVideoCamerasCategoryName = "Фото и видеокамеры";
    public static final String gamesAndConsolesCategoryName = "Игры и консоли";
    public static final String smartHomeAndSecurityCategoryName = "Умный дом и безопасность";
    public static final String officeEquipmentName = "Офисная техника";


    private CurrentCategory smartphonesCategory;
    private CurrentCategory tabletsCategory;
    private CurrentCategory laptopsCategory;
    private CurrentCategory tvCategory;
    private CurrentCategory computersAndAccessoriesCategory;
    private CurrentCategory smartWatchesAndFitnessBraceletsCategory;

    private CurrentCategory accessoriesForSmartphonesCategory;
    private CurrentCategory headphonesAndAudioCategory;
    private CurrentCategory photoAndVideoCamerasCategory;
    private CurrentCategory gamesAndConsolesCategory;
    private CurrentCategory smartHomeAndSecurityCategory;
    private CurrentCategory officeEquipment;

    public CurrentCategoryBlock() {
        smartphonesCategory = CurrentCategory.getCategory("Изображение смартфона", smartphonesCategoryName);
        tabletsCategory = CurrentCategory.getCategory("Изображение планшета", tabletsCategoryName);
        laptopsCategory = CurrentCategory.getCategory("Изображение ноутбука", laptopsCategoryName);
        tvCategory = CurrentCategory.getCategory("Изображение телевизора", tvCategoryName);
        computersAndAccessoriesCategory = CurrentCategory.getCategory("Изображение компьютера с монитором", computersAndAccessoriesCategoryName);
        smartWatchesAndFitnessBraceletsCategory = CurrentCategory.getCategory("Изображение смарт-часов", smartWatchesAndFitnessBraceletsCategoryName);

        accessoriesForSmartphonesCategory = CurrentCategory.getCategory("Изображение чехла для смартфона", accessoriesForSmartphonesCategoryName);
        headphonesAndAudioCategory = CurrentCategory.getCategory("Изображение наушников", headphonesAndAudioCategoryName);
        photoAndVideoCamerasCategory = CurrentCategory.getCategory("Изображение фотоаппарата", photoAndVideoCamerasCategoryName);
        gamesAndConsolesCategory = CurrentCategory.getCategory("Изображение игровой консоли", gamesAndConsolesCategoryName);
        smartHomeAndSecurityCategory = CurrentCategory.getCategory("Изображение камеры наблюдения", smartHomeAndSecurityCategoryName);
        officeEquipment = CurrentCategory.getCategory("Изображение МФУ", officeEquipmentName);
    }

    public CurrentCategory getCategory(String categoryName) {
        CurrentCategory category = null;
        switch (categoryName) {
            case smartphonesCategoryName:
                category = smartphonesCategory;
                break;
            case tabletsCategoryName:
                category = tabletsCategory;
                break;
            case laptopsCategoryName:
                category = laptopsCategory;
                break;
            case tvCategoryName:
                category = tvCategory;
                break;
            case computersAndAccessoriesCategoryName:
                category = computersAndAccessoriesCategory;
                break;
            case accessoriesForSmartphonesCategoryName:
                category = accessoriesForSmartphonesCategory;
                break;
            case headphonesAndAudioCategoryName:
                category = headphonesAndAudioCategory;
                break;
            case photoAndVideoCamerasCategoryName:
                category = photoAndVideoCamerasCategory;
                break;
            case gamesAndConsolesCategoryName:
                category = gamesAndConsolesCategory;
                break;
            case smartHomeAndSecurityCategoryName:
                category = smartHomeAndSecurityCategory;
                break;
            case officeEquipmentName:
                category = officeEquipment;
                break;
            case smartWatchesAndFitnessBraceletsCategoryName:
                category = smartWatchesAndFitnessBraceletsCategory;
                break;
        }
        return category;
    }
}
