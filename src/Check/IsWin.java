package Check;

import Players.Computer;
import Players.User;

public class IsWin {
    public static void isWin() {

        if (User.userCount == 0) {
            System.out.println(User.name + " is win, congratulations!");
        }
        if (Computer.computerCount == 0) {
            System.out.println("Computer is win, sorry!");
        }
    }
}
