package Check;

public class isBusy {

    public static boolean istBusy(int[][] field, int x, int y, int direction, int deck) {
        boolean isB = true;

        while (deck > 0) {

            for (int i = 0; i < deck; i++) {
                if (direction == 1 && !(field[x][y + i] == 0)) {
                    isB = false;

                } else if (direction == 2 && !(field[x + i][y] == 0)) {
                    isB = false;

                }
                deck--;
            }
        }
        return isB;
    }
}
