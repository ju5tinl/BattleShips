import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;
public class Runner {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String name = "";
        boolean nGame = true;
        System.out.println("Welcome to BattleShips");
        System.out.println("Would you like to (s)how leaderboard or start a (n)ew game?");
        System.out.println();
        String option = s.nextLine();
        if(option.toLowerCase().equals("s")){
            try{
                File f = new File("src/game.data");
                Scanner l = new Scanner(f);
                System.out.println("LeaderBoard");
                while(l.hasNextLine()){
                    String data = s.nextLine();
                    System.out.println("Admiral" + data);
                }

            }
            catch (FileNotFoundException e){
                System.out.println("There are no games to show.");
                System.out.println("Starting new game...");
                option = "n";
            }
        }
        if(option.toLowerCase().equals("n")){
            System.out.println("Hello Admiral what is your name?");
            System.out.println();
            Scanner in = new Scanner(System.in);
            name = in.nextLine();

        }
        Player p = new Player(name);

    }
}
