package tictactoe;

public class Board {

    public static final int SIZE = 3;
    private int[][] board;

    public Board() {
        board = new int[3][3];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = 0;
            }
        }
    }

    public Board(int[][] board) {
        this.board = board;
    }

    public int[][] getBoard() {
        return board;
    }

    public void setBoard(int[][] board) {
        this.board = board;
    }

    public void display() {
        display(board);
    }

    private void display(int[][] b) {

        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (b[row][col] == 1) {
                    System.out.print("X ");
                } else if (b[row][col] == -1) {
                    System.out.print("O ");
                } else {
                    System.out.print("- ");
                }
            }
            System.out.println("");
        }
    }

    @Override
    public String toString() {
        display();
        return super.toString();
    }

    private int[][] getACopy(int[][] b) {
        int[][] newBoard = new int[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            System.arraycopy(b[i], 0, newBoard[i], 0, SIZE);
        }
        return newBoard;
    }

    public boolean isIdentical(Board b) {

        System.out.println("++++++++++++++++++++++++START");
        System.out.println("This: ");
        display();

        int[][] copy = getACopy(b.getBoard());

        //***********************
        for (int i = 0; i < 4; i++) {
            System.out.println("i: " + i);
            if (isSame(copy)) {
                return true;
            }

            swapHorizontally(copy);
            System.out.println("Swap horizontally");
            display(copy);
            if (isSame(copy)) {
                return true;
            }
//            swapHorizontally(copy);

            swapDiagonally(copy);
            System.out.println("Swap diagonally");
            display(copy);
            if (isSame(copy)) {
                return true;
            }
//            swapHorizontally(copy);

            swapHorizontally(copy);
            System.out.println("Swap horizontally");
            display(copy);
            if (isSame(copy)) {
                return true;
            }

            swapDiagonally(copy);
            System.out.println("Swap diagonally");
            display(copy);
            if (isSame(copy)) {
                return true;
            }

            rotateAnticlockwise(copy);
            System.out.println("Rotate");
            display(copy);

            if (isSame(copy)) {
                return true;
            }
        }
        System.out.println("++++++++++++++++++++++++++++END");
        //***********************

        return false;
    }

    private boolean isSame(int[][] b) {
        boolean isIdentical = true;
        X:
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] != b[i][j]) {
                    isIdentical = false;
                    break X;
                }
            }
        }
        return isIdentical;
    }

    private void swapDiagonally(int[][] b) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = i; j < SIZE; j++) {
                if (i != j) {
                    int t = b[i][j];
                    b[i][j] = b[j][i];
                    b[j][i] = t;
                }
            }
        }
    }

    public void swapDiagonally() {
        swapDiagonally(board);
    }

    private void swapHorizontally(int[][] b) {
        int t = b[0][0];
        b[0][0] = b[0][2];
        b[0][2] = t;

        t = b[1][0];
        b[1][0] = b[1][2];
        b[1][2] = t;

        t = b[2][0];
        b[2][0] = b[2][2];
        b[2][2] = t;
    }

    public void swapHorizontally() {
        swapHorizontally(board);
    }

    private int[][] rotateAnticlockwise(int[][] b) {
        for (int i = 0; i < 2; i++) {
            int t = b[0][0];
            b[0][0] = b[0][1];
            b[0][1] = b[0][2];
            b[0][2] = b[1][2];
            b[1][2] = b[2][2];
            b[2][2] = b[2][1];
            b[2][1] = b[2][0];
            b[2][0] = b[1][0];
            b[1][0] = t;
        }
        return b;
    }

    public void rotateAnticlockwise() {
        board = rotateAnticlockwise(board);
    }

    public int eval() {
        return 5* XO_N(1, 2) + XO_N(1, 1) - (5 * XO_N(-1, 2) + XO_N(-1, 1)) + xox();
    }

    public int XO_N(int xo, int N) {
        int n = 0;
        if (xo == 1) {
            n = -1;
        } else {
            n = 1;
        }
        int count = 0;
        X:
        for (int i = 0; i < SIZE; i++) {
            int temp = 0;
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == n) {
                    continue X;
                } else if (board[i][j] != 0) {
                    temp++;
                }
            }
            if (temp == N) {
                count++;
            }
        }

        X:
        for (int i = 0; i < SIZE; i++) {
            int temp = 0;
            for (int j = 0; j < SIZE; j++) {
                if (board[j][i] == n) {
                    continue X;
                } else if (board[j][i] != 0) {
                    temp++;
                }
            }
            if (temp == N) {
                count++;
            }
        }
        
        if (!(board[0][0] == n || board[1][1] == n || board[2][2] == n)) {
            int tot = board[0][0] + board[1][1] + board[2][2];
            if (Math.abs(tot) == N) {
                count++;
            }
        }

        if (!(board[2][0] == n || board[1][1] == n || board[0][2] == n)) {
            int tot = board[2][0] + board[1][1] + board[0][2];
            if (Math.abs(tot) == N) {
                count++;
            }
        }
        return count;
    }

    private int xox() {

        for (int i = 0; i < SIZE; i++) {

            if (board[0][i] == 1 && board[1][i] == 1 && board[2][i] == -1) {
                return -2;
            } else if (board[0][i] == 1 && board[1][i] == -1 && board[2][i] == 1) {
                return 2;
            } else if (board[0][i] == -1 && board[1][i] == 1 && board[2][i] == 1) {
                return -2;
            }

            if (board[i][0] == 1 && board[i][1] == 1 && board[i][2] == -1) {
                return -2;
            } else if (board[i][0] == 1 && board[i][1] == -1 && board[i][2] == 1) {
                return 2;
            } else if (board[i][0] == -1 && board[i][1] == 1 && board[i][2] == 1) {
                return -2;
            }

            if (board[0][0] == 1 && board[1][1] == 1 && board[2][2] == -1) {
                return -2;
            } else if (board[0][0] == 1 && board[1][1] == -1 && board[2][2] == 1) {
                return 2;
            } else if (board[0][0] == -1 && board[1][1] == 1 && board[2][2] == 1) {
                return -2;
            }

            if (board[0][i] == -1 && board[1][i] == -1 && board[2][i] == 1) {
                return 2;
            } else if (board[0][i] == -1 && board[1][i] == 1 && board[2][i] == -1) {
                return -2;
            } else if (board[0][i] == 1 && board[1][i] == -1 && board[2][i] == -1) {
                return 2;
            }

            if (board[i][0] == -1 && board[i][1] == -1 && board[i][2] == 1) {
                return 2;
            } else if (board[i][0] == -1 && board[i][1] == 1 && board[i][2] == -1) {
                return -2;
            } else if (board[i][0] == 1 && board[i][1] == -1 && board[i][2] == -1) {
                return 2;
            }

            if (board[2][0] == 1 && board[1][1] == 1 && board[0][2] == -1) {
                return 2;
            } else if (board[2][0] == 1 && board[1][1] == -1 && board[0][2] == 1) {
                return -2;
            } else if (board[2][0] == -1 && board[1][1] == 1 && board[0][2] == 1) {
                return 2;
            }
        }

        return 0;
    }

    public boolean gameOver() {
        return (XO_N(1, 3) == 1 || XO_N(-1, 3) == 1 || countEmpty() == 0);
    }

    public void makeMove(int row, int column, int player) {
        board[row][column] = player;
    }

    public int countEmpty() {
        int count = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    public Board getCopy() {
        int[][] copy = getACopy(board);
        return new Board(copy);
    }

    public static void main(String[] args) {

        int[][] b = new int[][]{
            {-1, 1, 0},
            {0, 1, 0},
            {0, 0, 0}
        };

        System.out.println("Initial board");
        Board board = new Board(b);
        board.display();

        System.out.println("Swap horizontally");
        board.swapHorizontally();
        board.display();

        System.out.println("Reset");
        board.swapHorizontally();//Reset
        board.display();

        System.out.println("Swap diagonally");
        board.swapDiagonally();
        board.display();

        System.out.println("Swap horizontally");
        board.swapHorizontally();
        board.display();

        System.out.println("Reset");
        board.swapHorizontally();//Reset
        board.display();

        System.out.println("Rotate Anticlockwise");
        board.rotateAnticlockwise();
        board.display();

        System.out.println("Swap diagonally");
        board.swapDiagonally();
        board.display();

        System.out.println("Swap horizontally");
        board.swapHorizontally();
        board.display();

        System.out.println("X1: " + board.XO_N(1, 1));
        System.out.println("X2 : " + board.XO_N(1, 2));

        System.out.println("O1: " + board.XO_N(-1, 1));
        System.out.println("O2 : " + board.XO_N(-1, 2));
        System.out.println("Eval: " + board.eval());
    }
}
