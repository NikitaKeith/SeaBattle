package Action;

import Players.Computer;
import Players.User;

public class Main {
    public static int FIELD_SIZE = 10;


    public static void main(String[] args) {

        User.user.placeShips() ;
        Computer.computer.placeShips();
        User.user.turn();
    }
}
