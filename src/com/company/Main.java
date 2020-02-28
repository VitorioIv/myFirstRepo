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

        // метод
        boolean ly = isLeapYear(year);
        int dim = dayInMonth(month, year);
        day = dow(month, day, year); // day of the week
        if (ly == true&&month == 2)
            dim = 29; // if the month is a leap year, if it is the day of the week is 20 and day of the month are 29 days
        int c = 0;

        // Показване на форматирания календар за искания месец и година.
        // Използва се dow и dim методи
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

    // Този метод проверява дали зададения месец е грешен.
    // Ако е се изписва това в System.out.print
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

    // Проверява дали годината е високосна
    // input: the year
    // output: true or false
    public static boolean isLeapYear(int year) {
        if (year%4 ==0 && year%100 !=0 || year%400 ==0)
            return true;
        else
            return false;
    }

    // Функция: dow
    // Показва деня на седмицата, на който се пада даден ден
    // input: month,day & year
    // output: 0 = Monday, 1 = Tuesday...
    // wy,day,month,w
    public static int dow(int month, int day, int year) {
        int wy;
        int wd;
        int wm;
        int w;
        int m;
        if ( month < 3 )
            year = year-1;

        // изчисления за week of the year, month, week of the month, day of the week, week
        wy = (3 + year + (year/4) - (year/100) + (year/400))%7;
        m = (month + 9)%12;
        wm = (int) (2.6*m+.5)%7;
        wd = (day - 1);
        w = (wy+wm+wd)%7;
        return w;
    }

    // връща броя на дните в определен месец
    // input: month, year
    // output: броя на дните в месеца
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