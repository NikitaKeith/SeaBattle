package Check;

public class IsAvailable {
    public static boolean available(int[][] playerField, int x, int y, int direction, int deck) {
        boolean a = true;
        if (direction == 1) {
            if (y + deck > playerField.length) {
                a = false;
            }
        }
        if (direction == 2) {
            if (x + deck > playerField.length) {
                a = false;
            }
        }
        return a;
    }
}
