package Action;

public class DrawField {
    public static void draw(int[][] field) {
        System.out.println("    0  1  2  3  4  5  6  7  8  9");
        for (int i = 0; i < field.length; i++) {
            System.out.print(i + "   ");
            for (int j = 0; j < field.length; j++) {

                if (field[j][i] == 0) {         //empty
                    System.out.print("-  ");
                } else if (field[j][i] == 1) {  //Ship
                    System.out.print("#  ");
                } else if (field[j][i] == 2) {  //Hit
                    System.out.print("X  ");
                } else if (field[j][i] == 3) {  //miss
                    System.out.print("o  ");
                }
            }
            System.out.println();
        }
    }
}
