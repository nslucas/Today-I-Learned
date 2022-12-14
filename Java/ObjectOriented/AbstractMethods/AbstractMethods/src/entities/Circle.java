package entities;

import entities.enums.Color;

public class Circle extends Shape {

    public Double radius;

    public Circle(){
    }

    public Circle(Color color, Double radius){
        super(color);
        this.radius = radius;
    }

    public Double area(){
        double area = Math.PI * (radius * radius);
        return area;
    }

}
