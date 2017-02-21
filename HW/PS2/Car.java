/*
This program consists of a class Car that has various functions like drive, addGas, and geGasInTank.
Name: Shikhar Bakhda
*/


import java.util.*;

public class Car {

        public double fuel_eff; //The fuel efficiency of the car, in litres/kilometers
        public double gas = 0; // The level of gas in the car. 

    //This constructor saves the fuel efficiency as 'fuel_eff'.
    public Car(double f)
        {

            fuel_eff = f;
        }

    //This function inputs the distances traveled, and calculates the remaining gas. 
    public void drive(double dist) {
        gas = gas - (dist * fuel_eff);
    }

    // This function adds a certain amount of gas, input as 'amount'. 
    public void addGas(double amount) {
        gas += amount;
    }

    //This function returns the amount of gas in the car. 
    public double getGasInTank() {
        return gas;
    }

}
