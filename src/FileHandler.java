import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import static java.lang.System.exit;

public class FileHandler {
    public void saveToFile(String fileName, String content) {
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(content);
        } catch (Exception e) {
            exit(1);
        }

    }
    public String  readFromFile(String fileName) {
        String content = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            String line = bufferedReader.readLine();
            while (line != null) {
                content += line;
                line = bufferedReader.readLine();
            }

        } catch (Exception e) {
            exit(1);
        }
        return  content;
    }
}

