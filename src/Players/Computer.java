package Players;

import Action.DrawField;
import Action.Main;
import Check.IsAvailable;
import Check.IsWin;
import Check.isBusy;

import java.util.Random;

public class Computer extends Player {
    public static Computer computer = new Computer();
    public static int[][] computerField = new int[Main.FIELD_SIZE][Main.FIELD_SIZE];
    public static int[][] computerMonitor = new int[Main.FIELD_SIZE][Main.FIELD_SIZE];
    public static int computerCount = 10;

    public int computerMove(int b) {
        Random rand = new Random();
        return rand.nextInt(b);
    }

    @Override
    public void turn() {
        Computer computer = new Computer();
        int x = computer.computerMove(9);
        int y = computer.computerMove(9);
        computer.makeShoot(User.UserField, Computer.computerMonitor, x, y);
    }

    @Override
    public void placeShips() {
        Computer computer = new Computer();

        int deck = 4;

        M:
        while (deck > 0) {

            int x = computer.computerMove(9);
            int y = computer.computerMove(9);
            int direction = computer.computerMove(1) + 1;

            if (IsAvailable.available(Computer.computerField, x, y, direction, deck)
                    && isBusy.istBusy(Computer.computerField, x, y, direction, deck)) {
                for (int i = 0; i < deck; i++) {
                    if (direction == 1) {
                        Computer.computerField[x][y + i] = 1;
                    } else if (direction == 2) {
                        Computer.computerField[x + i][y] = 1;
                    } else continue M;
                }
            } else {
                continue;
            }
            deck--;
        }
    }

    @Override
    public void makeShoot(int[][] field, int[][] monitor, int x, int y) {
        if (field[x][y] == 1) {
            Computer.computerMonitor[x][y] = 2;
            field[x][y] = 2;
            Computer.computerCount--;
            if (Computer.computerCount == 0) {
                IsWin.isWin();
            } else {
                DrawField.draw(Computer.computerMonitor);
                turn();
            }
        } else {
            field[x][y] = 3;
            Computer.computerMonitor[x][y] = 3;
            DrawField.draw(Computer.computerMonitor);
            System.out.println("Computer missed, you turn");
            User.user.turn();
        }
    }
}
