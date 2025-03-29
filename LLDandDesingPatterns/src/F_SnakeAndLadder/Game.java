package F_SnakeAndLadder;

import java.util.Deque;
import java.util.LinkedList;

public class Game {
    Board board;
    Dice dice;
    Deque<Player> playersList = new LinkedList<>();
    Player winner;

    public Game(){
        initializeGame();
    }

    public void initializeGame() {
        board = new Board(10,5,4);
        dice = new Dice(1);
        addPlayers();
        winner = null;

    }

    public void addPlayers(){
        Player player1 = new Player("id1",0);
        Player player2 = new Player("id2",0);
        playersList.add(player1);
        playersList.add(player2);
    }

    public void startGame(){

        if(winner == null){
            Player currentPlayerTurn =  getPlayerTurn();
            System.out.println("Currently Player " + currentPlayerTurn.id + "is rolling a dice at position " + currentPlayerTurn.currentPosition);

            int diceNumbers = dice.rollDice();


            //get the new position
            int playerNewPosition = currentPlayerTurn.currentPosition + diceNumbers;
            playerNewPosition = jumpCheck(playerNewPosition);
            currentPlayerTurn.currentPosition = playerNewPosition;

            System.out.println("player turn is:" + currentPlayerTurn.id + " new Position is: " + playerNewPosition);
            //check for winning condition
            if(playerNewPosition >= board.cells.length * board.cells.length-1){

                winner = currentPlayerTurn;
            }
        }

        System.out.println("WINNER IS:" + winner.id);
    }

    private int jumpCheck (int playerNewPosition) {

        if(playerNewPosition > board.cells.length * board.cells.length-1 ){
            return playerNewPosition;
        }

        Cell cell = board.getCell(playerNewPosition);
        if(cell.jumpObj != null && cell.jumpObj.start == playerNewPosition) {
            String jumpBy = (cell.jumpObj.start < cell.jumpObj.end)? "ladder" : "snake";
            System.out.println("jump done by: " + jumpBy);
            return cell.jumpObj.end;
        }
        return playerNewPosition;
    }


    public Player getPlayerTurn(){
        Player player = playersList.removeFirst();
        playersList.addLast(player);
        return player;
    }
}
