package entities;

public class Individual extends TaxPayer {

    private Double healthExpenditures;

    public Individual(){
    }

    public Individual(String name, Double anualIncome, Double healthExpenditures){
        super(name, anualIncome);
        this.healthExpenditures = healthExpenditures;
    }

    public Double getHealthExpenditures(){
        return this.healthExpenditures;
    }

    public void setHealthExpenditures(Double healthExpenditures){
        this.healthExpenditures = healthExpenditures;
    }

    public Double tax(){
        if(getAnualIncome() < 20.000){
            double tax = getAnualIncome() * 0.15;
            if(healthExpenditures > 0){
                 tax -= healthExpenditures * 0.5;
            } return tax;
        } else {
            double tax = getAnualIncome() * 0.25;
            if(healthExpenditures > 0){
                tax -= healthExpenditures * 0.5;
            } return tax;
        }
    }
}
