// Edilberto Carrizales

// Description:
//   This program prompts the user to enter the first 9 digits and
//   displays the 10-digit ISBN.

// changelog:
//   06/09/2021 - Carrizales
//      -Added scanner input and integer variables to enter the ISBN digits
//      -Added the checksum formula from the HW
//      -Added the system.out.print to display the 10 digit ISBN number to the user

import java.util.Scanner;

public class CheckISBN
{

    public static void main(String[] args)
    {
        //Used to take inputs from the keyboard (from the user)
        Scanner input = new Scanner(System.in);

        //Prompts user to enter ISBN number
        System.out.print("Enter the first 9 digits of an ISBN as integer: ");

        //ISBN digits entered by user
        int d1= input.nextInt();
        int d2= input.nextInt();
        int d3= input.nextInt();
        int d4= input.nextInt();
        int d5= input.nextInt();
        int d6= input.nextInt();
        int d7= input.nextInt();
        int d8= input.nextInt();
        int d9= input.nextInt();

        int checksum;

        //Used to calculate the checksum for ISBN-10
        checksum = (d1 * 1 + d2 * 2 + d3 * 3 + d4 * 4 + d5 * 5 + d6 * 6 + d7 * 7 + d8 * 8 + d9 * 9) % 11;

        //Displays ISBN-10 number with checksum
        System.out.print("The ISBN-10 number is " + d1 + d2 + d3 + d4 + d5 + d6 + d7 + d8 + d9 + checksum);


    } //end of public static void main

} //end of public class CheckISBN
