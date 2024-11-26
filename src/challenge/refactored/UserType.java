package challenge.refactored;

public enum UserType implements iConsolable {
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

    // 외부 인쇄용
    public double getDiscountRate() {
        return discountRate;
    }

    // index에 따라 할인율을 찾는 메서드
    public static double getDiscountByIndex(int index) {
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
    public String getInformation(int index){
        return String.format("%d. %s | %.2f", index, this.userCategory, this.discountRate);
    };
}