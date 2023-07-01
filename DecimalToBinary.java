// Edilberto Carrizales

// Description:
//   This program prompts the user to enter a decimal number
//   and displays its binary equivalent.

import java.util.Scanner;

public class DecimalToBinary
{
    public static void main(String[] args)
    {
    Scanner input = new Scanner(System.in);

    //prompts the user to enter a decimal number to convert
    System.out.print("Enter a decimal number to convert to binary: ");

    int number = input.nextInt();

    //calls the method to convert
    dec2Bin(number);

    }//end of public static void main

    //Used to convert from decimal to binary
    public static void dec2Bin(int number)
    {
        if (number > 0)
        {
            //recursive call
            dec2Bin(number / 2);
            System.out.print(number % 2 + " ");
        }

    }//end of public static void dec2Bin
}//end of public class DecimalToBinary
