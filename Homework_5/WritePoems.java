package Homework_5;
import java.io.*;
public class WritePoems{
    public static void main(String[] args) {
        // Create three Poem objects
        Poem poem1 = new Poem("We Real Cool", "Gwendolyn Brooks");
        Poem poem2 = new Poem("I Know Why the Caged Bird Sings", "Maya Angelou");
        Poem poem3 = new Poem("Hope is the Thing with Feathers", "Emily Dickinson");

        // Write poem details to poems.txt
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("poems.txt"))) {
            writePoem(writer, poem1);
            writePoem(writer, poem2);
            writePoem(writer, poem3);
            System.out.println("Poem information written to poems.txt");
        } catch (IOException e) {
            System.out.println("Error writing to the file: " + e.getMessage());
        }
    }

    // Helper method to write poem info to the file
    private static void writePoem(BufferedWriter writer, Poem poem) throws IOException {
        writer.write(poem.getName() + "\n");
        writer.write(poem.getPoet() + "\n");
    }
}

class Poem {
    private String name;
    private String poet;

    public Poem(String name, String poet) {
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
