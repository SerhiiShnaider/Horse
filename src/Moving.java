/**
 * Created by elvis on 28.06.2016.
 */

public class Moving {
    public Moving(int arrayLenght) {
        this.arrayLenght = arrayLenght;
    }

    private int arrayLenght;
    private int[][] arr = new int[arrayLenght][arrayLenght];
    private int[] iStep = {2, 2, -2, -2, 1, -1, 1, -1};
    private int[] jStep = {1, -1, -1, 1, -2, -2, 2, 2};

    public void move() {
        int i = 0;
        int j = 0;
        int[] minStep = {8, 0, 0};
        arr[i][j] = 1;
        for (int count = 2; count <= arrayLenght * arrayLenght; count++) {
            minStep[0] = 8;
            for (int k = 0; k < 8; k++) {
                int testCheckPossibleMoves = checkPossibleMoves(i + iStep[k], j + jStep[k]);
                if (0 <= (i + iStep[k]) && (i + iStep[k]) < arrayLenght &&
                        0 <= (j + jStep[k]) && (j + jStep[k]) < arrayLenght &&
                        arr[i + iStep[k]][j + jStep[k]] == 0 &&
                        testCheckPossibleMoves <= minStep[0]) {
                    minStep[0] = testCheckPossibleMoves;
                    minStep[1] = i + iStep[k];
                    minStep[2] = j + jStep[k];
                }
            }
            i = minStep[1];
            j = minStep[2];
            arr[i][j] = count;
        }
        for (i = 0; i < arrayLenght; i++) {
            for (j = 0; j < arrayLenght; j++) {
                if (arr[i][j] == 0) {
                    System.out.print("   X");
                } else {
                    System.out.format("%4d", arr[i][j]);
                }
            }
            System.out.println();
        }
    }

    /* Метод checkPossibleMoves(int, int) рахує кількість
     * можливих ходів на пусті клітинки з квадрата
     * заданними координатами
     */
    private int checkPossibleMoves(int i, int j) {
        int steps = 0;
        for (int k = 0; k < 8; k++) {
            if (0 <= (i + iStep[k]) && (i + iStep[k]) < arrayLenght &&
                    0 <= (j + jStep[k]) && (j + jStep[k]) < arrayLenght &&
                    arr[i + iStep[k]][j + jStep[k]] == 0) {
                steps++;
            }
        }
        return steps;
    }
}
