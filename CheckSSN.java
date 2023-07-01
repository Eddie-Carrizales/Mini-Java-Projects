// Edilberto Carrizales

// Description:
//   This program prompts the user to enter a Social Security number in the format DDD-DD-DDDD, where D is a digit
//   and checks whether the input is valid.

// changelog:
//   06/10/2021 - Carrizales
//      -Added scanner, SSN string variable and a prompt for the user to enter a SSN
//      -Decided to use a boolean SSN check to determine if the SSN is valid after a set of conditions
//      -Added if else conditions to check for length and to check each character of the string
//      -Added a if else condition to print the result depending on the true or false boolean statement

import java.util.Scanner;

public class CheckSSN
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        //Prompts user to enter a Social Security Number
        System.out.print("Enter a SSN: ");
        String userSSN = input.nextLine();

        //boolean to use in the if else conditions and determine if the SSN failed the conditions
        boolean checkSSN;

        //Checks length and character by character to see if the social security number is valid
        if (userSSN.length() != 11) // if it does not have a length of 11 it automatically fails check
        {
            checkSSN = false;
        }
        else if (!Character.isDigit(userSSN.charAt(0))) //checks if the first character entered by the user is a digit
        {
            checkSSN = false;
        }
        else if (!Character.isDigit(userSSN.charAt(1))) //checks if the second character entered by the user is a digit
        {
            checkSSN = false;
        }
        else if (!Character.isDigit(userSSN.charAt(2)))
        {
            checkSSN = false;
        }
        else if (userSSN.charAt(3) != '-') //checks if the fourth character entered by the user is a dash
        {
            checkSSN = false;
        }
        else if (!Character.isDigit(userSSN.charAt(4)))
        {
            checkSSN = false;
        }
        else if (!Character.isDigit(userSSN.charAt(5)))
        {
            checkSSN = false;
        }
        else if (userSSN.charAt(6) != '-') //checks if the seventh character entered by the user is a dash
        {
            checkSSN = false;
        }
        else if (!Character.isDigit(userSSN.charAt(7)))
        {
            checkSSN = false;
        }
        else if (!Character.isDigit(userSSN.charAt(8)))
        {
            checkSSN = false;
        }
        else if (!Character.isDigit(userSSN.charAt(9)))
        {
            checkSSN = false;
        }
        else if (!Character.isDigit(userSSN.charAt(10)))
        {
            checkSSN = false;
        }
        else
        {
            checkSSN = true; // if all conditions above are met the the SSN passed the check and the boolean is true
        }

        //Displays if the social security number is valid depending on the boolean result
        if (checkSSN == true)
        {
            System.out.print(userSSN + " is a valid social security number");
        }
        else
        {
            System.out.print(userSSN + " is an invalid social security number");
        }

    } // end of public static void main
} // end of public class CheckSSN