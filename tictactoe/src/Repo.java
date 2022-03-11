import java.io.*;
import java.nio.file.Paths;
import java.util.*;

public class Repo {
    private static final String fileName = Paths.get("").toAbsolutePath() + "/tictactoe/src/resources/rating.txt";

    public static void writeWinner (String winnerName, String loserName){
        HashMap<String, String> rating = new HashMap<>(readData());
        if (rating.containsKey(winnerName)){
            int win = Integer.parseInt(rating.get(winnerName).split(":")[0]);
            win++;
            rating.put(winnerName, win + ":" + rating.get(winnerName).split(":")[1]);
        }else rating.put(winnerName, "1:0");
        if (rating.containsKey(loserName)){
            int los = Integer.parseInt(rating.get(loserName).split(":")[1]);
            los++;
            rating.put(loserName, rating.get(loserName).split(":")[0] + ":" + los);
        }else rating.put(loserName, "0:1");
        writeData(rating);
    }

    protected static HashMap<String, String> readData(){
        HashMap<String, String> res = new HashMap<>();
        try (FileReader fr = new FileReader(fileName)) {
            Scanner scan = new Scanner(fr);
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                String name = line.split(":")[0];
                String win = line.split(":")[1];
                String los = line.split(":")[2];
                res.put(name, win + ":" + los);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return res;
    }

    protected static void writeData(Map<String, String> data){
        String res = "";
        for (Map.Entry<String, String> st: data.entrySet()){
            res = res.concat(st.getKey() + ":" + st.getValue() + "\n");
        }
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(res);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
