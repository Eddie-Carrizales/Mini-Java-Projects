// Edilberto Carrizales

// Description:
//   prompts the user to enter 5 numbers, stores them in an
//   array list, and displays them in increasing order.

import java.util.Scanner;
import java.util.ArrayList;

public class SortArrayList
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        //Used to create a list
        ArrayList<Integer> list = new ArrayList<Integer>();

        //Used to ask the user to enter 5 integers
        System.out.print("Enter five numbers: ");

        //to add the 5 integers entered by the user to the list
        for (int i = 0; i < 5; i++)
        {
            list.add(input.nextInt());
        }

        //will call the method so that it can sort the numbers
        sort(list);

        //used display the numbers in increasing order
        System.out.print("Numbers in increasing order are: ");

        for (int i = 0; i < list.size(); i++)
        {
            System.out.print(list.get(i) + " ");
        }

        System.out.println();
    }//end of public static void main

    public static void sort(ArrayList<Integer> list)
    {
        int num;

        //Used to go through the list
        for (int i = 0; i < list.size(); i++)
        {
            for (int j = 0; j < (list.size() - 1 ); j++)
            {
                //Used to sort the list by comparing two numbers and having the larger number switch with the smaller
                //This will sort the list in increasing order (from smallest to largest)
                if (list.get(j).compareTo(list.get(j + 1)) > 0)
                {
                    num = list.get(j);
                    list.set((j), list.get(j + 1));
                    list.set(j + 1, num);
                }
            }
        }
    }//end of public static void sort

}// end of SortArrayList class