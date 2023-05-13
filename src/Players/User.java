package Players;

import Action.DrawField;
import Action.Main;
import Check.IsAvailable;
import Check.IsWin;
import Check.isBusy;

import java.util.InputMismatchException;
import java.util.Scanner;

public class User extends Player {

    public static User user = new User();
    public static int[][] UserField = new int[Main.FIELD_SIZE][Main.FIELD_SIZE];
    public static int[][] UserMonitor = new int[Main.FIELD_SIZE][Main.FIELD_SIZE];
    public static int userCount = 10;
    public static String name = name();

    public static String name() {
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Enter your name please");
        return scanner1.next();
    }

    @Override
    public void turn() throws InputMismatchException{
        System.out.println(User.name + ", make turn");
        Scanner scanner1 = new Scanner(System.in);
        try {

            System.out.println("X-axis coordinate");
            int x = scanner1.nextInt();
            System.out.println("Y-axis coordinate");
            int y = scanner1.nextInt();
            user.makeShoot(Computer.computerField, User.UserMonitor, x, y);
        }
        catch (InputMismatchException e){
            System.out.println("Wrong Symbol");
            turn();
        }
    }

    @Override
    public void placeShips() {
        Scanner scanner1 = new Scanner(System.in);
        System.out.println(User.name + ", place your ships");

        int deck = 4;

        M:
        while (deck > 0) {
            System.out.println(deck + "- deck");
            System.out.println("X-axis coordinate");
            int x = scanner1.nextInt();
            System.out.println("Y-axis coordinate");
            int y = scanner1.nextInt();
            System.out.println("1 - horizontally, 2 - vertically");
            int direction = scanner1.nextInt();

            if (IsAvailable.available(User.UserField, x, y, direction, deck)
                    && isBusy.istBusy(User.UserField, x, y, direction, deck)) {
                for (int i = 0; i < deck; i++) {

                    if (direction == 1) {
                        User.UserField[x][y + i] = 1;
                    } else if (direction == 2) {
                        User.UserField[x + i][y] = 1;
                    } else {
                        System.out.println("Wrong Number");
                        continue M;
                    }
                }
                deck--;
                DrawField.draw(User.UserField);
            } else {
                System.out.println("The ship goes out of the field or intersects with another ship");
            }
        }
    }

    @Override
    public void makeShoot(int[][] field, int[][] monitor, int x, int y) {

        if (field[x][y] == 1) {
            field[x][y] = 2;
            User.UserMonitor[x][y] = 2;
            System.out.println("Hit!");
            System.out.println("One more");
            User.userCount--;
            DrawField.draw(User.UserMonitor);
            if (User.userCount == 0) {
                IsWin.isWin();
            } else {
                turn();
            }
        } else {
            field[x][y] = 3;
            User.UserMonitor[x][y] = 3;
            DrawField.draw(User.UserMonitor);
            System.out.println("You missed, Computer's turn");
            Computer.computer.turn();
        }
    }
}
