// Edilberto Carrizales

// Description:
//   This program prompts the user to enter the size of a list (to create a list from 1 to n)
//   then it asks the user to enter a number to find in the list. The program then utilizes
//   linear search algorithm to find that number and we know it works correctly as it gives
//   that same number as the position in the list.

import java.util.Scanner;

public class GenericLinearSearch
{
    public static void main(String[] args) {

        //Used to take input from the keyboard/the user
        Scanner input = new Scanner(System.in);

        //Used to create a list from 1 to a number so that it can be linear searched
        //This will prompt the user to enter the size of this list
        System.out.print("Enter the size of the list (an integer): ");
        int size = input.nextInt();

        Integer[] list = new Integer[size];

        //Prompts the user to enter a number that he would like to find in the list
        System.out.print("Enter the number you would like to find: ");
        int number = input.nextInt();

        //to go through the list
        for (int i = 0; i < list.length; i++)
        {
            //for debugging purposes
            //System.out.print(i);
            list[i] = i;
        }

        //condition to check if the number entered exists and to display the index/position the number is at
        if (number < size + 1)
        {
            System.out.print("The number is at index: ");
            System.out.println(linearSearch(list, number));
        }
        else
        {
            System.out.print("That number is not in the list.");
        }
    }//end of public static void main

    //Used to linear search through the list and compare to find the number that is being looked for
    public static <E extends Comparable<E>> int linearSearch(E[] list, E key)
    {
        for (int i = 0; i < list.length; i++)
        {
            if (list[i].compareTo(key) == 0)
            {
                return i;
            }
        }
        return list.length;
    }
}//end of public class GenericLinearSearch
