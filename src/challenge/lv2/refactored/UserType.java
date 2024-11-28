package challenge.lv2.refactored;

public enum UserType implements Consolable {
    VETERAN(1, "국가유공자", 0.10),
    SOLDIER(2, "군인", 0.05),
    STUDENT(3, "학생", 0.03),
    GENERAL(4, "일반", 0.00);

    private final int index;
    private final String userCategory;
    private final double discountRate; // 할인율

    // 생성자
    UserType(int index, String usercategory, double discountRate) {
        this.index = index;
        this.userCategory = usercategory;
        this.discountRate = discountRate;
    }

    // 외부 반환용
    public double getDiscountRate() {
        return discountRate;
    }

    private static double getDiscountByIndex(int index) {
        while (true) {
            for (UserType userType : UserType.values()) {
                if (userType.index == index) {
                    return userType.getDiscountRate();
                }
            }
            System.out.println("유효한 입력을 해주세요");
        }
    }

    @Override
    public String getItemsInformation(int index){
        return String.format("%d. %s | %.2f", index, this.userCategory, this.discountRate);
    };

    @Override
    public UserType getBasicItem(){
        return this;
    };
}