package application;

import java.util.Locale;
import java.util.Scanner;
import entities.Product;

public class ProgramProduct {
        public static void main(String[] args) {
                Locale.setDefault(Locale.US);
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter product data: ");
                System.out.print("Name: ");
                String name = sc.nextLine();
                System.out.print("Price: ");
                double price = sc.nextDouble();
                Product product = new Product(name, price);


                System.out.println();
                System.out.println("Product data: " + product);
                System.out.println();
                System.out.print("Enter the number of products to be added in stock: ");
                int quantity = sc.nextInt();
                product.addProducts(quantity);
                System.out.println();
                System.out.println("Updated data: " + product);
                System.out.println();
                System.out.print("Enter the number of products to be removed from stock: ");
                quantity = sc.nextInt();
                product.removeProducts(quantity);
                System.out.println();
                System.out.println("Updated data: " + product);
                sc.close();
            }
        }


        /*double xA, xB, xC, yA, yB, yC;
        System.out.println("Enter the measures of triangle X: ");
        xA = sc.nextDouble();
        xB = sc.nextDouble();
        xC = sc.nextDouble();
        System.out.println("Enter the measures of triangle Y: ");
        yA = sc.nextDouble();
        yB = sc.nextDouble();
        yC = sc.nextDouble();

        double p = (xA + xB + xC) / 2.0;
        double areaX = Math.sqrt(p * (p-xA) * (p-xB) * (p-xC));

        p = (yA + yB + yC) / 2.0;
        double areaY = Math.sqrt(p * (p-yA) * (p-yB) * (p-yC));

        System.out.printf("entities.Triangle X area: %.4f%n", areaX);
        System.out.printf("entities.Triangle Y area: %.4f%n", areaY);

        if(areaX > areaY) {
            System.out.println("Larger area: X");
        } else {
            System.out.println("Larger area: Y");
        }

         */

