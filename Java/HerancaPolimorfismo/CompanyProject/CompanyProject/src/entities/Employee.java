package entities;

public class Employee {
    private String name;
    private Integer hours;
    private Double valuePerHour;

    public Employee(){
    }

    public Employee(String name, Integer hours, Double valuePerHour){
        this.name = name;
        this.hours = hours;
        this.valuePerHour = valuePerHour;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Integer getHours(){
        return this.hours;
    }

    public void setHours(Integer hours){
        this.hours = hours;
    }

    public Double getValuePerHour(){
        return this.valuePerHour;
    }

    public void setValuePerHour(Double valuePerHour){
        this.valuePerHour = valuePerHour;
    }

    public double payment(){
        return valuePerHour * hours;
    }

}
