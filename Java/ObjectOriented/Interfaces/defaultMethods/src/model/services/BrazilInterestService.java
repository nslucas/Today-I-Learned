package model.services;

import model.services.InterestService;

import java.security.InvalidParameterException;
import java.util.InvalidPropertiesFormatException;

public class BrazilInterestService implements InterestService {
     private double interestRate;

    public BrazilInterestService(double interestRate){
        this.interestRate = interestRate;
    }

    @Override
    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

}
