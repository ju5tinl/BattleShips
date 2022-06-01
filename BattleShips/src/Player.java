import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    private String name;
    private int attempts;

    public Player(String n, int a){
        name = n;
        attempts = a;
    }

    public Player(){
        name = "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAttempts() {
        return attempts;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }

    public void save(){
        try {
            File f = new File("src/game.data");
            f.createNewFile();
            FileWriter fw = new FileWriter("src/game.data");
            fw.write(getName() + " " + getAttempts() + " tries");
            fw.close();
        }
        catch (IOException e) {
            System.out.println("Unable to create file");
            e.printStackTrace();
        }
    }

}
