import java.util.Scanner;

//----------- PARTICIPANTES -----------\\
// --- Alex Carvalho - 2102085
// --- Antônio Gally - 2102145
// --- Edson Fagundes - 2102719
// --- Íris Zarate - 2102682

public class HashGame {

    // Aditional methodsr
    public static char verticalWin(char M[][]) {
        boolean isGamerOWinner = false;
        boolean isGamerXWinner = false;

        for (int col = 0; col < M.length; col++) {
            String rowValue = "";
            for (int row = 0; row < M.length; row++) {
                rowValue += M[row][col];
            }
            isGamerOWinner = rowValue.indexOf("OOO") > -1;
            isGamerXWinner = rowValue.indexOf("XXX") > -1;
            if (isGamerXWinner || isGamerOWinner)
                break;
        }

        if (isGamerOWinner)
            return 'O';
        else if (isGamerXWinner)
            return 'X';
        return '-';
    }

    public static char horizontalWin(char M[][]) {
        boolean isGamerOWinner = false;
        boolean isGamerXWinner = false;

        for (int row = 0; row < M.length; row++) {
            String colValue = "";
            for (int col = 0; col < M[row].length; col++) {
                colValue += M[row][col];
            }

            isGamerOWinner = colValue.indexOf("OOO") > -1;
            isGamerXWinner = colValue.indexOf("XXX") > -1;

            if (isGamerXWinner || isGamerOWinner)
                break;
        }

        if (isGamerOWinner)
            return 'O';
        else if (isGamerXWinner)
            return 'X';
        return '-';
    }

    public static char diagonalWin(char M[][]) {
        boolean isGamerOWinner = false;
        boolean isGamerXWinner = false;

        int[][] firstDiagonal = { { 0, 0 }, { 1, 1 }, { 2, 2 } };
        int[][] secondDiagonal = { { 0, 2 }, { 1, 1 }, { 2, 0 } };
        String diagonalValue = "";

        for (int values = 0; values < firstDiagonal.length; values++) {
            int row = firstDiagonal[values][0];
            int col = firstDiagonal[values][1];
            diagonalValue += M[row][col];
        }

        isGamerOWinner = diagonalValue.indexOf("OOO") > -1;
        isGamerXWinner = diagonalValue.indexOf("XXX") > -1;

        if (isGamerOWinner)
            return 'O';
        else if (isGamerXWinner)
            return 'X';

        diagonalValue = "";

        for (int values = 0; values < secondDiagonal.length; values++) {
            int row = secondDiagonal[values][0];
            int col = secondDiagonal[values][1];

            diagonalValue += M[row][col];
        }
        isGamerOWinner = diagonalValue.indexOf("OOO") > -1;
        isGamerXWinner = diagonalValue.indexOf("XXX") > -1;

        if (isGamerOWinner)
            return 'O';
        else if (isGamerXWinner)
            return 'X';

        return '-';
    }

    public static boolean isLastPlay(char M[][]) {
        String emptySpaces = "";

        for (int row = 0; row < M.length; row++) {
            for (int col = 0; col < M[row].length; col++) {
                if (M[row][col] == '-') {
                    emptySpaces += "-";
                }
            }
        }
        if (emptySpaces.length() > 0) {
            return false;
        }
        return true;
    }

    public static void printHash(char M[][]) {
        for (int row = 0; row < M.length; row++) {
            for (int col = 0; col < M[row].length; col++) {
                if (col == 2) {
                    System.out.println(" " + M[row][col]);
                } else
                    System.out.print(" " + M[row][col]);
            }

        }
    }

    // Default methods
    public static char[][] initialize() {
        char[][] matrix = new char[3][3];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = '-';
            }
        }
        return matrix;
    }

    public static boolean step(char M[][], int lin, int col, char gamer) {
        // validations
        boolean _lineIsValid = lin >= 0 && lin <= 2;
        boolean _colIsValid = col >= 0 && col <= 2;

        if (!_lineIsValid) {
            System.out.println("Posição inválida. Tente novamente");
            return false;
        }
        if (!_colIsValid) {
            System.out.println("Posição inválida. Tente novamente");
            return false;
        }

        boolean _spaceIsEmpty = M[lin][col] == '-';

        if (!_spaceIsEmpty) {
            System.out.println("Posição ocupada. Tente novamente");
            return false;
        }

        M[lin][col] = gamer;

        return true;
    }

    public static int status(char M[][]) {
        char verticalWin = verticalWin(M);
        char horizontalWin = horizontalWin(M);
        char diagonalWin = diagonalWin(M);
        boolean isLastPlay = isLastPlay(M);

        boolean OGamerWon = verticalWin == 'O' || horizontalWin == 'O' || diagonalWin == 'O';
        boolean XGamerWon = verticalWin == 'X' || horizontalWin == 'X' || diagonalWin == 'X';
        boolean nobodyWon = verticalWin == '-' && horizontalWin == '-' && diagonalWin == '-';

        if (!isLastPlay && nobodyWon) {
            return -1;
        } else if (nobodyWon && isLastPlay) {
            return 0;
        } else if (OGamerWon) {
            return 1;
        } else if (XGamerWon) {
            return 2;
        }

        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[][] matrix = initialize();
        int status = status(matrix);
        printHash(matrix);

        char gamer = 'O';
        while (status == -1) {
            System.out.print("Jogador '" + gamer + "' escolha a linha: ");
            int line = sc.nextInt();
            System.out.print("Jogador '" + gamer + "' escolha a coluna: ");
            int column = sc.nextInt();

            boolean canProceed = step(matrix, line, column, gamer);

            if (canProceed) {
                printHash(matrix);
                status = status(matrix);
                if (gamer == 'O')
                    gamer = 'X';
                else
                    gamer = 'O';
            }

            if (status == 0) {
                System.out.println("Houve empate!");
                break;
            } else if (status == 1) {
                System.out.println("O jogador 'O' venceu!");
                break;
            } else if (status == 2) {
                System.out.println("O jogador 'X' venceu!");
                break;
            }
        }
    }
}
