package com.jetbrains;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        System.out.println("Enter the year y");
        int y = s.nextInt();
        System.out.println("You have chosen the year " + y);
        int a,b,c,d,e,f,g,h,j,k,m,r,n,p;
        a= y%19;
        b=y/100;
        c=y%100;
        d=b/4;
        e=b%4;
        g=((8*b)+13)/25;
        h=(19*a+b-d-g+15)%30;
        j=c/4;
        k=c%4;
        m=(a+11*h)/319;
        r=(2*e+2*j-k-h+m+32)%7;
        n=(h-m+r+90)/25;
        p=(h-m+r+n+19)%32;

        System.out.println("The expected date of Easter for year "+y+ " is "+y+"/"+n+"/"+p+". (yyyy-mm-dd)");

    }
}
