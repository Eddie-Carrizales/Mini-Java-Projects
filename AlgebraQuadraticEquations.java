// Edilberto Carrizales

// Description:
//  This program prompts the user to enter values for a, b, and c and displays the result
//  based on the discriminant. If the discriminant is positive, it will display the two roots. If
//  the discriminant is 0, it will display the one root. Otherwise, it will display “The equation has
//  no roots.”

import java.util.Scanner;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class AlgebraQuadraticEquations
{
    public static void main(String[] args)
    {
        //Used to take in input from the user/keyboard
        Scanner input = new Scanner(System.in);

        //Prompts the user to enter values for a,b,c
        System.out.println("Enter the values of a, b, and c, in that order: ");

        double a = input.nextDouble();
        double b = input.nextDouble();
        double c = input.nextDouble();

        //creates a new equation to use the values entered
        QuadraticEquation equation = new QuadraticEquation(a,b,c);

        //conditional statement to determine if the equation has roots and to prints result to user
        if (equation.getDiscriminant() > 0)
        {
            System.out.print( "The equation has two roots " + String.format("%.4f", equation.getRoot1()) + " and " + String.format("%.4f", equation.getRoot2()));
        }
        else if (equation.getDiscriminant() == 0)
        {
            System.out.print("The equation has one root " + String.format("%.4f", equation.getRoot1()));;
        }
        else
        {
            System.out.print("The equation has no roots.");
        }
    }//end of public static void main
}//end of public class AlgebraQuadraticEquations

class QuadraticEquation
{
    private double a;
    private double b;
    private double c;

    //constructor
    public QuadraticEquation(double a, double b, double c)
    {
        this.a = a;
        this.b = b;
        this.c = c;
    }//end of public QuadraticEquation

    //Accessor/getter
    public double getA()
    {
        return a;
    }

    public double getB()
    {
        return b;
    }

    public double getC()
    {
        return c;
    }

    //methods
    //Used to calculate the discriminant
    public double getDiscriminant()
    {
        return (pow(getB(), 2) - 4*getA()*getC());
    }

    //Used to calculate one of the roots
    public double getRoot1()
    {
        if (getDiscriminant() < 0)
        {
            return 0; //will return 0 if discriminant is negative (i.e. no roots)
        }
        else
        {
            return ((-(getB()) + sqrt(getDiscriminant()))/(2*getA()));
        }
    }//end of public double getRoot1

    //Used to calculate the second root
    public double getRoot2()
    {
        if (getDiscriminant() < 0)
        {
            return 0; //will return 0 if discriminant is negative (i.e. no roots)
        }
        else
        {
            return ((-(getB()) - sqrt(getDiscriminant()))/(2*getA()));
        }
    }//end of public double getRoot2

}//end of class QuadraticEquation