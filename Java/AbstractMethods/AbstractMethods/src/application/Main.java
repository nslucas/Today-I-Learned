package application;

import entities.Circle;
import entities.Rectangle;
import entities.Shape;
import entities.enums.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);


        List<Shape> shapes = new ArrayList<>();

        System.out.print("Enter the number of shapes: ");
        int n = sc.nextInt();


        for(int i  = 1; i <=n; i++){
            System.out.println("Shape " + i + " data: ");
            System.out.print("Rectangle or circle? (r/c) ");
            String type = sc.next();
            if (type.contains("r")) {
                System.out.print("Color (BLACK/BLUE/RED): ");
                Color color = Color.valueOf(sc.next());
                System.out.print("Width: ");
                double width = sc.nextDouble();
                System.out.print("Height: ");
                double height = sc.nextDouble();
                Rectangle r = new Rectangle(width, height, color);
                shapes.add(r);

            } else{
                System.out.print("Color (BLACK/BLUE/RED): ");
                Color color = Color.valueOf(sc.next());
                System.out.print("Radius: ");
                double radius = sc.nextDouble();

                Circle circle = new Circle(color, radius);
                shapes.add(circle);
            }
        }

        System.out.println("SHAPE AREAS: ");

        for (Shape shape : shapes) {
            System.out.println(shape.area());
        }

    }
}