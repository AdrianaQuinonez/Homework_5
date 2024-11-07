package Homework_5;
import java.io.*;

public class ReadPoems{
    public static void main(String[] args) {
        String inputFile = "poem2.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String name;
            String poet;

            while ((name = reader.readLine()) != null) {
                poet = reader.readLine();
                if (poet != null) {
                    Poem poem = new Poem(name, poet);
                    System.out.println("Poem Name: " + poem.getName());
                    System.out.println("Poet: " + poem.getPoet());
                    System.out.println();
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}

class Poem1 {
    private String name;
    private String poet;

    public Poem1(String name, String poet) {
        this.name = name;
        this.poet = poet;
    }

    public String getName() {
        return name;
    }

    public String getPoet() {
        return poet;
    }
}
