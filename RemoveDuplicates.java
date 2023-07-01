// Edilberto Carrizales

// Description:
//  This program removes the duplicate elements from a 10 digit list of numbers
//  entered by the user.

import java.util.ArrayList;
import java.util.Scanner;

public class RemoveDuplicates
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        //Used to create a list
        ArrayList<Integer> list = new ArrayList <Integer> ();

        //Used to ask the user to enter 10 integers
        System.out.print("Enter ten integers: ");

        //to add the 10 integers entered by the user to the list
        for(int i=0;i<10;i++)
        {
            list.add(input.nextInt());
        }

        //will call the method so that it can remove duplicates
        removeDuplicate(list);
    }//end of public static void main

    public static void removeDuplicate(ArrayList<Integer> list)
    {
        //used to store the resulting elements
        ArrayList <Integer> resulting = new ArrayList<Integer> ();

        //temporary value used to get element from the list
        int num;
        for(int i=0; i < 10; i++)
        {
            num = list.get(i);

            //Used to check if the number is already present
            // if the indexOf(num) == -1 it means it is not present in the list
            if(resulting.indexOf(num) == -1)
            {
                resulting.add(num);
            }
        }

        //used display the resulting numbers
        System.out.print("The distinct integers are ");

        for(Integer i : resulting)
        {
            System.out.print( i + " ");
        }
    }//end of public static void removeDuplicate

}//end of public class removeDuplicate