import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class PlayBattleShips {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String name = "";
        String mode = "";
        boolean cheat = false;
        ArrayList<String> leaderboard = new ArrayList<String>();
        System.out.println("Welcome to BattleShips");
        System.out.print("Would you like to (s)how leaderboard or start a (n)ew game? ");
        String option = s.nextLine();
        if(option.toLowerCase().equals("s")){
            try{
                File f = new File("src/game.data");
                Scanner line = new Scanner(f);
                System.out.println("LeaderBoard");
                while(line.hasNextLine()){
                    String data = line.nextLine();
                    leaderboard.add(data);
                }
                for(int i = 1; i < leaderboard.size() + 1; i++){
                    System.out.println(i + ") Admiral " + leaderboard.get(i-1));
                }
            }
            catch (FileNotFoundException e){
                System.out.println("There are no games to show.");
                System.out.println("Starting new game...");
                option = "n";
            }
        }
        if(option.toLowerCase().equals("n")){
            System.out.print("Hello Admiral what is your name? ");
            Scanner in = new Scanner(System.in);
            name = in.nextLine();
            System.out.print("Hello Admiral " + name + " would you like to receive the information from our spy? (Cheat Mode) ");
            mode = in.nextLine();
            Player p = new Player(name);
            if(mode.toLowerCase().equals("yes")){
                cheat = true;
            }
            else{
                cheat = false;
            }
            BattleShips b = new BattleShips(cheat);
            b.createOceanMap();
            b.deployPlayerShips();
            b.deployComputerShips();
            while(b.getPlayerShips() != 0 && b.getComputerShips() != 0){
                b.Battle();
            }
            b.gameOver();



        }



    }
}
