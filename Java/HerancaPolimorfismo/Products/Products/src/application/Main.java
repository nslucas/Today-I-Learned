package application;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of products: ");
        int n = sc.nextInt();

        List<Product> product = new ArrayList<>();

        for(int i = 1; i <= n; i++){
            System.out.println("Product " + i + " data: ");
            System.out.print("Common, used or imported? ");
            String type = sc.next();
            System.out.print("Name: ");
            String name = sc.next();
            System.out.print("Price: ");
            double price = sc.nextDouble();

            if(type.contains("i")){
                System.out.print("Customs fee: ");
                double customsFee = sc.nextDouble();

                ImportedProduct impProduct = new ImportedProduct(name, price, customsFee);
                product.add(impProduct);
            } else if(type.contains("u")) {
                System.out.print("Manufacture date (DD/MM/YYYY): ");
                Date date = sdf.parse(sc.next());

                UsedProduct usedProduct = new UsedProduct(name, price, date);
                product.add(usedProduct);
            } else {
                Product commonProduct = new Product(name, price);
                product.add(commonProduct);
            }
        }

        System.out.println("PRICE TAGS: ");

        for (Product prod : product) {
            System.out.println(prod.priceTag());
        }

        sc.close();

    }

}
