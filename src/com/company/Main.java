package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
      Scanner console = new Scanner(System.in);
      int month, day = 0, year;

        System.out.print( " | Enter the month and year (separated by space) | ");
        month = console.nextInt();
        year = console.nextInt();

        boolean ly = isLeapYear(year);
        int dim = dayInMonth(month, year);
        day = dow(month, day, year);
        if (ly == true&&month == 2)
            dim = 29;
        int c = 0;

        System.out.println("Sun   Mon   Tue   Wed   Thu   Fri   Sat");
        while(day >= 0) {
            System.out.print("     ");
            day--;
            c++;
        }
        int x = 1;
        int count = day;
        while(x <= dim) {
            System.out.printf("%-5d", x);
            x++;
            c++;
            if (c % 7 == 0)
                System.out.println();
        }
    }


    public static boolean isLeapYear(int year) {
        if (year%4 ==0 && year%100 !=0 || year%400 ==0)
            return true;
        else
            return false;
    }


    public static int dow(int month, int day, int year) {
        int wy;
        int wd;
        int wm;
        int w;
        int m;
        if ( month < 3 )
            year = year-1;

        wy = (3 + year + (year/4) - (year/100) + (year/400))%7;
        m = (month + 9)%12;
        wm = (int) (2.6 * m +.5)%7;
        wd = (day - 1);
        w = (wy +wm +wd)%7;
        return w;
    }


    public static int dayInMonth(int month, int year) {

        int day = 0;
        switch (month) {
            case 1: day = 31;
                break;
            case 2: day = 28;
                if (year %4 == 0 && year % 100 != 0 || year %400 == 0)
                    day=29;
                break;
            case 3: day = 31;
                break;
            case 4: day = 30;
                break;
            case 5: day = 31;
                break;
            case 6: day = 30;
                break;
            case 7: day = 31;
                break;
            case 8: day = 31;
                break;
            case 9: day = 31;
                break;
            case 10: day = 30;
                break;
            case 11: day = 31;
                break;
            case 12: day = 30;
                break;

        }
        return day;
    }
}

