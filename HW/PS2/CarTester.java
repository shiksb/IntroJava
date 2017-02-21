/*
This program consists of a class Tester that tests a simulation where gas is added to a car, the car is driven, more gas is added, and the car is driven again. The expected and actual amount of gas is printed. 
Name: Shikhar Bakhda
*/

public class CarTester {
    public static void main(String[] args) {
        //Creating an object of class Car, initialized to have a fuel efficiency of 5 litres/kilometer. 
        Car cars = new Car(5);
        double gas;

        //Getting the current level of gas, and printing it. 
        gas = cars.getGasInTank();
        System.out.println("Current Volume of Gas: " + gas + "\n");

        //Adding 100 litres of gas
        cars.addGas(100);
        System.out.println("Added 100 litres of gas.");

        //Driving 5 kilometres. 
        cars.drive(5);
        System.out.println("5 kilometres driven.\n");

        //Driving 5km should consume 5*5 = 25 litres of gas. Remaining gas will be 100-25 = 75litres.
        System.out.println("Expected amount of gas remaining = 75 litres");
        
        //Getting and printing the calculated amount of gas. 
        gas = cars.getGasInTank();
        System.out.println("Current amount of Gas: " + gas + "\n");

        //Adding 10 litres of gas
        cars.addGas(10);
        System.out.println("Added 10 litres of gas.");

        //Driving 50 kilometres. 
        cars.drive(15);
        System.out.println("15 kilometres driven.\n");

        //Driving 15km should consume 15*5 = 75 litres of gas. Remaining gas will be 85-75 = 10litres.
        System.out.println("Expected amount of gas remaining = 10 litres");
        
        //Getting and printing the calculated amount of gas. 
        gas = cars.getGasInTank();
        System.out.println("Current amount of Gas: " + gas);
    }
}