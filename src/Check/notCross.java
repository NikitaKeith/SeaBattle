package Check;

public class notCross {
    public static void crossCheck(int[][] playerField, int x, int y, int direction, int deck) {
        if (direction == 1) {
            for (int i = 0; i < deck; i++) {

                if (playerField[x - 1][y] == 1) {
                    playerField[x - 1][y] = 4;
                }
                if (playerField[x - 1][y - 1] == 1) {
                    playerField[x - 1][y - 1] = 4;
                }
                if (playerField[x - 1][y + 1] == 1) {
                    playerField[x - 1][y + 1] = 4;
                }
                if (playerField[x + 1][y] == 1) {
                    playerField[x + 1][y] = 4;
                }
                if (playerField[x + 1][y - 1] == 1) {
                    playerField[x + 1][y - 1] = 4;
                }
                if (playerField[x + 1][y + 1] == 1) {
                    playerField[x + 1][y + 1] = 4;
                }
                if (playerField[x][y - 1] == 1) {
                    playerField[x][y - 1] = 4;
                }
                if (playerField[x][y + 1] == 1) {
                    playerField[x][y + 1] = 4;
                }
                y++;
            }
        }
        if (direction == 2) {
            for (int i = 0; i < deck; i++) {

                if (playerField[x - 1][y] == 1) {
                    playerField[x - 1][y] = 4;
                }
                if (playerField[x - 1][y - 1] == 1) {
                    playerField[x - 1][y - 1] = 4;
                }
                if (playerField[x - 1][y + 1] == 1) {
                    playerField[x - 1][y + 1] = 4;
                }
                if (playerField[x + 1][y] == 1) {
                    playerField[x + 1][y] = 4;
                }
                if (playerField[x + 1][y - 1] == 1) {
                    playerField[x + 1][y - 1] = 4;
                }
                if (playerField[x + 1][y + 1] == 1) {
                    playerField[x + 1][y + 1] = 4;
                }
                if (playerField[x][y - 1] == 1) {
                    playerField[x][y - 1] = 4;
                }
                if (playerField[x][y + 1] == 1) {
                    playerField[x][y + 1] = 4;
                }
                x++;
            }
        }
    }
}