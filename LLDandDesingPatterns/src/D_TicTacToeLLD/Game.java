package D_TicTacToeLLD;

import D_TicTacToeLLD.Model.*;

import java.util.*;

public class Game {
    Deque<Player> playersList;
    Board board;

    public Game(int size){
        initializeGame(size);
    }

    public void initializeGame(int size){
        playersList = new LinkedList<>();
        PlayingPieceO playingPieceO = new PlayingPieceO();
        PlayingPieceX playingPieceX = new PlayingPieceX();

        Player crossPlayer = new Player("Player1",playingPieceO);
        Player noughtsPlayer = new Player("Player2", playingPieceX);

        playersList.add(crossPlayer);
        playersList.add(noughtsPlayer);

        board = new Board(size);
    }

    public String startGame(){
        boolean noWinner = true;
        while(noWinner){
            //take out the player whose turn is and also put the player in the list back
            Player playerTurn = playersList.removeFirst();

            board.printBoard();
            List<Pair> freeSpaces = board.getFreeCells();
            System.out.println("Available free cells :"+freeSpaces.size());
            if(freeSpaces.isEmpty()){
                noWinner = false;
                continue;
            }

            // read the user input
            System.out.print("Player:"+playerTurn.getName()+" Enter row,column: ");
            Scanner inputScanner = new Scanner(System.in);
            String s = inputScanner.nextLine();
            String[] values = s.split(",");
            int inputRow = Integer.valueOf(values[0]);
            int inputColumn = Integer.valueOf(values[1]);

            boolean pieceAddedSuccessfully = board.addPiece(playerTurn.getPlayingPiece(),inputRow,inputColumn);

            if(!pieceAddedSuccessfully){
                System.out.print("Incorrect position chosen, try again");
                System.out.println();
                playersList.addFirst(playerTurn);
                continue;
            }

            playersList.addLast(playerTurn);

            boolean winner = isThereWinner(inputRow,inputColumn,playerTurn.getPlayingPiece().pieceType);
            if(winner){
                board.printBoard();
                return playerTurn.getName();
            }
        }

        return "tie";
    }

    public boolean isThereWinner(int row, int column, PieceType pieceType){
        boolean rowMatch = true;
        boolean columnMatch = true;
        boolean diagonalMatch = true;
        boolean antiDiagonalMatch = true;

        PlayingPiece[][] gameBoard = board.getBoard();

        // need to check in row
        for(int i = 0;i<board.getSize();i++){
            if( gameBoard[row][i]== null || gameBoard[row][i].pieceType != pieceType ) {
                rowMatch = false;
            }
        }

        //need to check in column
        for(int i = 0;i<board.getSize();i++){
            if(gameBoard[i][column] == null || gameBoard[i][column].pieceType != pieceType){
                columnMatch = false;
            }
        }

        //need to check diagonals
        for(int i=0, j=0; i<board.getSize();i++,j++) {
            if (gameBoard[i][j] == null || gameBoard[i][j].pieceType != pieceType) {
                diagonalMatch = false;
            }
        }

        //need to check anti-diagonals
        for(int i=0, j=board.getSize()-1; i< board.getSize();i++,j--) {
            if (gameBoard[i][j] == null || gameBoard[i][j].pieceType != pieceType) {
                antiDiagonalMatch = false;
            }
        }

        return rowMatch || columnMatch || diagonalMatch || antiDiagonalMatch;

    }
}
