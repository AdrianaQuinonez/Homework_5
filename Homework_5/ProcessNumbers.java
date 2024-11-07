package Homework_5;

import java.io.*;
import java.util.*;
public class ProcessNumbers{
    public static void main(String[] args) {
        String inputFile = "Book1.csv";
        String outputFile = "stats.txt";
        List<Double> numbers = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Split by commas (assuming CSV format)
                String[] tokens = line.split(",");
                for (String token : tokens) {
                    numbers.add(Double.parseDouble(token.trim()));
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
            return;
        }

        if (numbers.size() > 0) {
            double sum = 0;
            double min = Double.MAX_VALUE;
            double max = Double.MIN_VALUE;

            for (double number : numbers) {
                sum += number;
                if (number < min) min = number;
                if (number > max) max = number;
            }

            double average = sum / numbers.size();


            try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
                writer.write("The sum of the numbers is: " + sum + "\n");
                writer.write("The lowest number is: " + min + "\n");
                writer.write("The highest number is: " + max + "\n");
                writer.write("The average of the numbers is: " + average + "\n");
                System.out.println("Results written to " + outputFile);
            } catch (IOException e) {
                System.out.println("Error writing to the file: " + e.getMessage());
            }
        } else {
            System.out.println("No numbers to process.");
        }
    }
}
