// Edilberto Carrizales

// Description:
//   This program prompts the user to enter an integer and displays its reversal.

import java.util.Scanner;

public class PrintIntegerReversely
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        //Prompts the user to enter a number to display in reverse
        System.out.print("Enter a number to display reversely: ");
        int number = input.nextInt();

        //displays what the number is in reverse
        System.out.print("Your number in reverse is: ");
        reverseDisplay(number);
    }//end of public static void main

    public static void reverseDisplay(int number)
    {
        // Base case (it must be at least two digits)
        if (number < 10)
        {
            System.out.println(number);
        }
        else
        {
            System.out.print(number % 10);

            // This will Recursive call itself again until done
            reverseDisplay(number / 10);
        }
    }//end of public static void reverseDisplay
}//end of public class PrintIntegerReversely

