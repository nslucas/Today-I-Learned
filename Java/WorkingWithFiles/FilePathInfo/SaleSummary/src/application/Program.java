package application;

import entities.Product;

import java.io.*;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        String path = "C:\\temp\\in.csv";
        List<Product> products = new ArrayList<>();
        String outPath = "C:\\temp";
        boolean success = new File(outPath + "\\out").mkdir();
        String file = outPath + "\\out\\summary.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();

            for(int i = 0; i < line.length(); i++) {

                String[] aux = line.split(", ");
                String name = aux[0];
                Double price = Double.parseDouble(aux[1]);
                int quantity = Integer.parseInt(aux[2]);

                products.add(new Product(name, price, quantity));
                line = br.readLine();
            }

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
                for (Product product : products) {
                    bw.write(product.getName() + "," + String.format("%.2f", product.total()));
                    bw.newLine();
                }
            }catch (IOException e){
                System.out.println("Error writing file: " + e.getMessage());
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}