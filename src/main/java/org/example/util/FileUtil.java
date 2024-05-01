package org.example.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;

public class FileUtil {
    public static Integer readCount() {
        BufferedReader reader = null;
        Integer count = null;
        try {
            // Create BufferedReader to read from the file
            reader = new BufferedReader(new FileReader("src/main/resources/count.txt"));

            // Read the first line of the file
            String line = reader.readLine();

            // Assuming the file contains a single integer on the first line
            if (line != null) {
                count = Integer.parseInt(line);
                System.out.println("The count is: " + count);
            } else {
                System.out.println("The file is empty.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            // Close the BufferedReader
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    System.out.println("Failed to close the reader: " + e.getMessage());
                }
            }
        }
        return count;
    }

    public static void saveCountToFile(int count) {
        // Use try-with-resources to ensure FileWriter is closed properly
        try (FileWriter writer = new FileWriter("src/main/resources/count.txt", false)) { // 'false' to overwrite the file
            writer.write(String.valueOf(count)); // Convert the count to string and write
            writer.flush(); // Ensure data is written to the file from the writer's buffer
            System.out.println("Count has been successfully saved to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }


}
