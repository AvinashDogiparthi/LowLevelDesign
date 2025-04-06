package F_SnakeAndLadder;

import java.util.concurrent.ThreadLocalRandom;

public class Board {
    Cell[][] cells;

    public Board(int boardSize, int numberOfSnakes, int numberOfLadders){
        initializeCells(boardSize);
        addSnakesAndLadders(cells,numberOfSnakes,numberOfLadders);
    }

    /**
     * Based on the size of the board we are framing an board with cells
     * @param boardSize
     */
    public void initializeCells(int boardSize){

        cells = new Cell[boardSize][boardSize];

        for(int i = 0;i<boardSize;i++){
            for(int j = 0;j<boardSize;j++){
                Cell cellObj = new Cell();
                cells[i][j] = cellObj;
            }
        }
    }

    /**
     * Intializing cells and their jump objects in a random way
     * @param cells
     * @param numberOfSnakes
     * @param numberOfLadders
     */
    public void addSnakesAndLadders(Cell[][] cells, int numberOfSnakes, int numberOfLadders){

        while(numberOfSnakes>0){
            int snakeHead = ThreadLocalRandom.current().nextInt(1,cells.length*cells.length-1);
            int snakeTail = ThreadLocalRandom.current().nextInt(1, cells.length* cells.length-1);

            if(snakeTail >= snakeHead){
                continue;
            }

            Jump snakeObj = new Jump();
            Cell cellObj = getCell(snakeHead);
            cellObj.jumpObj =  snakeObj;
            numberOfSnakes--;
        }

        while(numberOfLadders>0){
            int ladderHead = ThreadLocalRandom.current().nextInt(1, cells.length* cells.length-1);
            int ladderTail = ThreadLocalRandom.current().nextInt(1, cells.length* cells.length-1);

            if(ladderHead >= ladderTail){
                continue;
            }

            Jump ladderObj = new Jump();
            Cell cellObj = getCell(ladderHead);
            cellObj.jumpObj =  ladderObj;

            numberOfLadders--;
        }
    }

    public Cell getCell(int playerPosition){
        int boardRow = playerPosition / cells.length;
        int boardColumn = (playerPosition % cells.length);
        return cells[boardRow][boardColumn];
    }


}
