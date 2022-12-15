package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Program {
    public static void main(String[] args) {
        String path = "C:\\temp\\in.txt";

        // the difference is that we don't need to instantiate fileReader nor bufferReader anymore and upcasting FR for BR later
        // we pass these instructions in the constructor of the try block and use File Reader inside BufferedReader constructor


        try (BufferedReader br = new BufferedReader(new FileReader(path))){
            String line = br.readLine();

            while (line != null){
                System.out.println(line);
                line = br.readLine();
        }

        } catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }

    }
}