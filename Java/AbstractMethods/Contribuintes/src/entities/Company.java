package entities;

import java.awt.image.ComponentSampleModel;

public class Company extends TaxPayer {

    private int numberOfEmployees;

    public Company(){
    }

    public Company(String name, Double anualIncome, int numberOfEmployees){
        super(name, anualIncome);
        this.numberOfEmployees = numberOfEmployees;
    }

    public int getNumberOfEmployees(){
        return this.numberOfEmployees;
    }

    public void setNumberOfEmployees(int numberOfEmployees){
        this.numberOfEmployees = numberOfEmployees;
    }

    public Double tax(){
        if(numberOfEmployees > 10){
           double tax =  getAnualIncome() * 0.14;
           return tax;
        }else{
            double tax =  getAnualIncome() * 0.16;
            return tax;
        }
    }
}
