public class Execute {
    private static final String USD = "USD";
    private static final String EUR = "EUR";
    private static final String UAH = "UAH";

    public static boolean checkAmount(int amount) {
        if (amount < 0) {
            throw new NotEnoughMoneyException(USD); // 1
        } else if (amount == 0) return false;  // 2
        return true; // 3
    }

}
