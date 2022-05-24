import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class Player {
    private String name;

    public Player(String n){
        name = n;
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

    public void save(){
        try {
            File f = new File("src/game.data");
            f.createNewFile();
            FileWriter fw = new FileWriter("src/game.data");
            fw.write(name );
            fw.close();
        }
        catch (IOException e) {
            System.out.println("Unable to create file");
            e.printStackTrace();
        }
    }
}
