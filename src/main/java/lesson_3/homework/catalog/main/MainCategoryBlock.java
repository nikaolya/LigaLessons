package lesson_3.homework.catalog.main;

public class MainCategoryBlock {

    public static final String appliancesCategoryName = "Бытовая техника";
    public static final String smartphonesAndSmartWatchesCategoryName = "Смартфоны и смарт-часы";
    public static final String tvCategoryName = "Телевизоры";
    public static final String laptopsAndTabletsCategoryName = "Ноутбуки и планшеты";
    public static final String computersCategoryName = "Компьютеры";
    public static final String headphonesAndAudioName = "Наушники и аудио техника";
    public static final String gamesAndConsolesName = "Игры и консоли";

    private MainCategory appliancesCategory;
    private MainCategory smartphonesAndSmartWatchesCategory;
    private MainCategory tvCategory;
    private MainCategory laptopsAndTabletsCategory;
    private MainCategory computersCategory;
    private MainCategory headphonesAndAudio;
    private MainCategory gamesAndConsoles;

    public MainCategoryBlock() {
        appliancesCategory = MainCategory.getCategory(appliancesCategoryName);
        smartphonesAndSmartWatchesCategory = MainCategory.getCategory(smartphonesAndSmartWatchesCategoryName);
        tvCategory = MainCategory.getCategory(tvCategoryName);
        laptopsAndTabletsCategory = MainCategory.getCategory(laptopsAndTabletsCategoryName);
        computersCategory = MainCategory.getCategory(computersCategoryName);
        headphonesAndAudio = MainCategory.getCategory(headphonesAndAudioName);
        gamesAndConsoles = MainCategory.getCategory(gamesAndConsolesName);
    }

    public MainCategory getCategory(String categoryName) {
        MainCategory category = null;
        switch (categoryName) {
            case appliancesCategoryName:
                category = appliancesCategory;
                break;
            case smartphonesAndSmartWatchesCategoryName:
                category = smartphonesAndSmartWatchesCategory;
                break;
            case tvCategoryName:
                category = tvCategory;
                break;
            case laptopsAndTabletsCategoryName:
                category = laptopsAndTabletsCategory;
                break;
            case computersCategoryName:
                category = computersCategory;
                break;
            case headphonesAndAudioName:
                category = headphonesAndAudio;
                break;
            case gamesAndConsolesName:
                category = gamesAndConsoles;
                break;
        }
        return category;
    }
}
