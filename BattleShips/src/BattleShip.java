/*import java.util.Arrays;

public class BattleShip {
    private int length;
    private int playerShips;
    private int computerShips;
    private char water = '-';
    private char ship = 'S';
    private char hit = 'X';
    private char miss = '0';

    public BattleShip(){
        length = 10;
        playerShips = 5;
        computerShips = 5;
    }

    public char[][] createMap(int length, char water, char ship, int playerShips){
        char[][] map = new char[length][length];
        for(char[] row: map){
            Arrays.fill(row, water);
        }
        return placeShips(map, playerShips, water, ship);
    }

    public char[][] placeShips(char[][] map, int playerShips, char water, char ship){

    }




}
*/