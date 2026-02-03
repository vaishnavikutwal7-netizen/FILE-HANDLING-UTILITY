package programminginternship;
import java.io.*;
import java.nio.file.*;

public class FileOperations {

    // Write text to file
    static void writeFile(String fileName, String text) {
        try {
            FileWriter fw = new FileWriter(fileName);
            fw.write(text);
            fw.close();
            System.out.println("File written successfully");
        } catch (IOException e) {
            System.out.println("Error while writing file");
        }
    }

    // Read text from file
    static void readFile(String fileName) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;
            System.out.println("\nReading file:");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error while reading file");
        }
    }

    // Modify file content
    static void modifyFile(String fileName, String oldWord, String newWord) {
        try {
            String content = new String(Files.readAllBytes(Paths.get(fileName)));
            content = content.replace(oldWord, newWord);
            Files.write(Paths.get(fileName), content.getBytes());
            System.out.println("\nFile modified successfully");
        } catch (IOException e) {
            System.out.println("Error while modifying file");
        }
    }

    public static void main(String[] args) {

        String fileName = "notes.txt";

        writeFile(fileName,
                "Welcome to the CODTECH Internship.\nCertificate will be provided.");

        readFile(fileName);

        modifyFile(fileName, "CODTECH", "CODTECH IT SOLUTIONS");

        readFile(fileName);
    }
}


