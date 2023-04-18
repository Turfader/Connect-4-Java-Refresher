/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package connectfourrefresher;
import java.util.Scanner;


/**
 *
 * @author Owner
 */
public class ConnectFourRefresher {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[][] board = new String[8][8];  //board[x][y]
        String currentPlayer = "O";
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nCurrent board:");
        printBoard(board);
        System.out.println();
        
        while (true) {
            
            if (currentPlayer.equals("O")) {
                while (true) {
                    System.out.println("O to play. Choose a column 0-7");
                    int column = scanner.nextInt();
                    if (column < 7 && column >= 0) {
                        if (board[column][0] == null) {
                            board = addO(board, column);
                            currentPlayer = "X";
                            break;
                        }
                    }
                    else
                    {
                        System.out.println("Please try again");
                    }
                }
                
            }
            else if (currentPlayer.equals("X")) {
                while (true) {
                    System.out.println("X to play. Choose a column 0-7");
                    int column = scanner.nextInt();
                    if (column < 7 && column >= 0) {
                        if (board[column][0] == null) {
                            board = addX(board, column);
                            currentPlayer = "O";
                            break;
                        }
                    }
                    else
                    {
                        System.out.println("Please try again");
                    }
                }
                
            }
            
            System.out.println("\nCurrent board:");
            printBoard(board);
            System.out.println();
            
            
            if (checkWin(board, "O")){
                System.out.println("O wins!");
                break;
            }
            if (checkWin(board, "X")){
                System.out.println("X wins!");
                break;
            }
            
            
        }


    }
    
    public static boolean checkWin(String[][] myBoard, String player) {
    // check for horizontal wins
    for (int i = 0; i < myBoard.length; i++) {
        for (int j = 0; j < myBoard[0].length - 3; j++) {
            if (myBoard[i][j] == player && myBoard[i][j+1] == player
                    && myBoard[i][j+2] == player && myBoard[i][j+3] == player) {
                return true;
            }
        }
    }
    // check for vertical wins
    for (int i = 0; i < myBoard.length - 3; i++) {
        for (int j = 0; j < myBoard[0].length; j++) {
            if (myBoard[i][j] == player && myBoard[i+1][j] == player
                    && myBoard[i+2][j] == player && myBoard[i+3][j] == player) {
                return true;
            }
        }
    }
    // check for diagonal wins (top-left to bottom-right)
    for (int i = 0; i < myBoard.length - 3; i++) {
        for (int j = 0; j < myBoard[0].length - 3; j++) {
            if (myBoard[i][j] == player && myBoard[i+1][j+1] == player
                    && myBoard[i+2][j+2] == player && myBoard[i+3][j+3] == player) {
                return true;
            }
        }
    }
    // check for diagonal wins (top-right to bottom-left)
    for (int i = 0; i < myBoard.length - 3; i++) {
        for (int j = 3; j < myBoard[0].length; j++) {
            if (myBoard[i][j] == player && myBoard[i+1][j-1] == player
                    && myBoard[i+2][j-2] == player && myBoard[i+3][j-3] == player) {
                return true;
            }
        }
    }
    return false;
}
    
    public static void printBoard(String[][] myBoard) {
        for (int i=0; i<myBoard.length; i++) {
            for (int j=0; j<myBoard[i].length; j++){
                System.out.print(myBoard[j][i]+"  ");
            }
            System.out.println();
        }
    }
    
    public static String[][] addO(String[][] myBoard, int column) {
        for (int i=myBoard.length-1; i>0; i--) {
            if (myBoard[column][i] == null) {
                myBoard[column][i] = "O";
                break;
            }
        }
        return myBoard;
    }
    
    public static String[][] addX(String[][] myBoard, int column) {
        for (int i=myBoard.length-1; i>0; i--) {
            if (myBoard[column][i] == null) {
                myBoard[column][i] = "X";
                break;
            }
        }
        return myBoard;
    }
    
}
