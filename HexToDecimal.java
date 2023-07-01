// Edilberto Carrizales

// Description:
//   This program prompts the user to enter a hex string and displays its decimal equivalent.

import java.util.Scanner;

public class HexToDecimal
{
    public static void main(String[] args)
    {
        //Used to take in inputs from the keyboard/the user
        Scanner input = new Scanner(System.in);

        //prompts the user to enter a decimal number to convert
        System.out.print("Enter a hex string to convert to decimal: ");

        String hexString = input.next();

        //calls the method to convert and prints it
        System.out.println("The Decimal value of " + hexString + " is " + hex2Dec(hexString) + "\n");
    }//end of public static void main

    //Used to convert from hex to decimal
    public static int hex2Dec(String hexString)
    {
        if (hexString.length() == 0)
        {
            return 0;
        }
        else
        {
            char character = Character.toUpperCase(hexString.charAt(hexString.length() - 1));
            int value = 0;

            //Conditional statement to change the hex value to decimal
            if (character >= '0' && character <= '9')
            {
                value = character - '0';
            }
            else if (character >= 'A' && character <= 'F')
            {
                value = 10 + (character - 'A');
            }
            return hex2Dec(hexString.substring(0, hexString.length() - 1)) * 16 + value;
        }

    }//end of public static int hex2Dec
}//end of public class HexToDecimal