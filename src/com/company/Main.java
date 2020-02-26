package com.company;

import java.util.Scanner;

public class Main {

    static Scanner console = new Scanner(System.in);

    public static void main(String[] args) {
      int month, day = 0, year;

        System.out.print( " | Enter the month | ");
        month = inputMonth();

        System.out.print("\n | Enter the year  | ");
        year = console.nextInt();

        boolean ly = isLeapYear(year);
        int dim = dayInMonth(month, year);
        day = dow(month, day, year);
        if (ly == true&&month == 2)
            dim = 29;
        int c = 0;

        System.out.println(" \nMon  Tue  Wed  Thu  Fri  Sat  Sun\n ");
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
    public static int inputMonth() {
        int month = console.nextInt();
        while (true) {
            switch (month) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                case 12: return month;
                default:
                    System.out.print(" \n | There is not such a month in the year |\n | TRY AGAIN |  -->");
                    month = console.nextInt();
                    break;

            }
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
        wm = (int) (2.6*m+.5)%7;
        wd = (day - 1);
        w = (wy+wm+wd)%7;
        return w;
    }


    public static int dayInMonth(int month, int year) {

        int day = 0;
        switch(month) {
            case 1: day = 31;
                break;
            case 2: day = 28;
                if (year %4 == 0 && year % 100 != 0 || year %400 == 0)
                    day = 29;
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