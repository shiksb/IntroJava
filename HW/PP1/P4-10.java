package com.jetbrains;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        System.out.println("Enter the initial balance");
        float p = s.nextFloat();
        System.out.println("Enter the annual interest rate");
        float i = s.nextFloat()/12.0f;

        System.out.println();
        System.out.printf("Initial balance: %.2f %n",p);

        System.out.println("Annual interest rate in percent: "+(i*12));
        for(int a=1;a<=3;a++)
        {
            System.out.printf("After month %d: %.2f %n",a,p+(p*i*0.01f));
            p=p+(p*i*0.01f);
        }



    }
}