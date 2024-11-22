package challenge.lv2;

public enum UserType {
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

    public double getDiscountRate() {
        return discountRate;
    }

    public String getUserCategory() {
        return userCategory;
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

    // 모든 사용자 유형의 정보를 출력하는 메서드
    public static void printUserTypeInformation() {
        for (UserType userType : UserType.values()) {
            System.out.printf("%d. | %-2s,|%-2.2f%-11%%n",
                    userType.index, userType.getUserCategory(), userType.getDiscountRate() * 100);
        }
    }
}