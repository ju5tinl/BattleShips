
import java.util.*;

public class BattleShips {
    private int numRows;
    private int numCols;
    private int playerShips;
    private int computerShips;
    private String[][] grid;
    private int[][] missedGuesses;
    private boolean cheat;
    private int tries;

    public BattleShips(boolean cheat){
        numRows = 4;
        numCols = 4;
        playerShips = 5;
        computerShips = 5;
        grid = new String[numRows][numCols];
        missedGuesses = new int[numRows][numCols];
        this.cheat = cheat;
        tries = 0;
    }

    public void createOceanMap(){
        System.out.print("  ");
        for(int i = 0; i < numCols; i++)
            System.out.print(i);
            System.out.println();
            for(int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = " ";
                if (j == 0)
                    System.out.print(i + "|" + grid[i][j]);
                else if (j == grid[i].length - 1)
                    System.out.print(grid[i][j] + "|" + i);
                else
                    System.out.print(grid[i][j]);
            }
            System.out.println();
        }
        System.out.print("  ");
        for(int i = 0; i < numCols; i++)
            System.out.print(i);
            System.out.println();
    }

    public void deployPlayerShips(){
        Scanner input = new Scanner(System.in);
        System.out.println("\nDeploy your ships:");
        for (int i = 1; i <= playerShips; ) {
            System.out.print("Enter X coordinate for your " + i + " ship: ");
            int x = input.nextInt();
            System.out.print("Enter Y coordinate for your " + i + " ship: ");
            int y = input.nextInt();
            if((x >= 0 && x < numRows) && (y >= 0 && y < numCols) && (grid[x][y] == " "))
            {
                grid[x][y] = "@";
                i++;
            }
            else if((x >= 0 && x < numRows) && (y >= 0 && y < numCols) && grid[x][y] == "@")
                System.out.println("You can't place two or more ships on the same location");
            else if((x < 0 || x >= numRows) || (y < 0 || y >= numCols))
                System.out.println("You can't place ships outside the " + numRows + " by " + numCols + " grid");
        }
        printOceanMap();
    }

    public void deployComputerShips(){
        System.out.println("\nComputer is deploying ships");
        for (int i = 1; i <= computerShips; ) {
            int x = (int)(Math.random() * 10);
            int y = (int)(Math.random() * 10);
            if((x >= 0 && x < numRows) && (y >= 0 && y < numCols) && (grid[x][y] == " "))
            {
                grid[x][y] = "?";
                System.out.println(i + ". ship DEPLOYED");
                i++;
            }
        }
        printOceanMap();
    }

    public void Battle(){
        playerTurn();
        computerTurn();
        printOceanMap();
        System.out.println();
        System.out.println("Your ships: " + playerShips + " | Computer ships: " + computerShips);
        System.out.println();
    }

    public void playerTurn(){
        System.out.println("\nYOUR TURN");
        int x = -1, y = -1;
        do {
            Scanner input = new Scanner(System.in);
            System.out.print("Enter X coordinate: ");
            x = input.nextInt();
            System.out.print("Enter Y coordinate: ");
            y = input.nextInt();
            tries++;
            if ((x >= 0 && x < numRows) && (y >= 0 && y < numCols)) //valid guess
            {
                if (grid[x][y] == "?") //if computer ship is already there; computer loses ship
                {
                    System.out.println("Boom! You sunk the ship!");
                    grid[x][y] = "!"; //Hit mark
                    computerShips--;
                }
                else if (grid[x][y] == "@") {
                    System.out.println("Oh no, you sunk your own ship");
                    grid[x][y] = "!";
                    playerShips--;
                }
                else if (grid[x][y] == " ") {
                    System.out.println("Sorry, you missed");
                    grid[x][y] = "-";
                }
            }
            else if ((x < 0 || x >= numRows) || (y < 0 || y >= numCols))  //invalid guess
                System.out.println("You can't place ships outside the " + numRows + " by " + numCols + " grid");
        }while((x < 0 || x >= numRows) || (y < 0 || y >= numCols));  //keep re-prompting till valid guess
    }

    public void computerTurn(){
        System.out.println("\nCOMPUTER'S TURN");
        //Guess co-ordinates
        int x = 0;
        int y = 0;
        do {
            x = (int)(Math.random() * 10);
            y = (int)(Math.random() * 10);

            if ((x >= 0 && x < numRows) && (y >= 0 && y < numCols)) //valid guess
            {
                if (grid[x][y] == "@") //if player ship is already there; player loses ship
                {
                    System.out.println("The Computer sunk one of your ships!");
                    grid[x][y] = "x";
                    playerShips--;
                }
                else if (grid[x][y] == "?") {
                    System.out.println("The Computer sunk one of its own ships");
                    grid[x][y] = "!";
                    computerShips--;
                }
                else if (grid[x][y] == " ") {
                    System.out.println("Computer missed");
                    //Saving missed guesses for computer
                    if(missedGuesses[x][y] != 1)
                        missedGuesses[x][y] = 1;
                }
            }
        }while((x < 0 || x >= numRows) || (y < 0 || y >= numCols));  //keep re-prompting till valid guess
    }

    public void gameOver(){
        System.out.println("Your ships: " + playerShips + " | Computer ships: " + computerShips);
        if(playerShips > 0 && computerShips <= 0){
            System.out.println("Hooray! You won the battle :)");
            System.out.println("You won in " + tries + " turns");
            System.out.println("Check the Leaderboard for you name");
        }
        else{
            System.out.println("Sorry, you lost the battle :(");
            System.out.println();
        }
    }

    public void printOceanMap(){
        System.out.println();
        //First section of Ocean Map
        System.out.print("  ");
        for(int i = 0; i < numCols; i++)
            System.out.print(i);
            System.out.println();

        //Middle section of Ocean Map
        for(int x = 0; x < grid.length; x++) {
            System.out.print(x + "|");

            for (int y = 0; y < grid[x].length; y++){
                System.out.print(grid[x][y]);
            }

            System.out.println("|" + x);
        }

        //Last section of Ocean Map
        System.out.print("  ");
        for(int i = 0; i < numCols; i++)
            System.out.print(i);
            System.out.println();
    }

    public int getComputerShips() {
        return computerShips;
    }

    public int getPlayerShips() {
        return playerShips;
    }

}

