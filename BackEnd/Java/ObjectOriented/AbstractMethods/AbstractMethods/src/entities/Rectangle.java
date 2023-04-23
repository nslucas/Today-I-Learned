package entities;

import entities.enums.Color;

public class Rectangle extends Shape {

    public Double width;
    public Double height;

    public Rectangle(){

    }

    public Rectangle(Double width, Double height, Color color){
        super(color);
        this.width = width;
        this.height = height;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getHeight(){
        return this.height;
    }

    public void setHeight(Double height){
        this.height = height;
    }

    public Double area(){
        double area = width * height;
        return area;
    }
}
