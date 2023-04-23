package model.services;

import model.services.InterestService;

import java.security.InvalidParameterException;
import java.util.InvalidPropertiesFormatException;

public class UsaInterestService implements InterestService {
    private double interestRate;

    public UsaInterestService(double interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public double getInterestRate() {
        return interestRate;
    }

}