// Edilberto Carrizales

// Description:
//   This program reads in the radius from circle1 and the radius of circle2
//   and determines if they have the same are, it also displays their area to the user

import java.util.Scanner;
import java.lang.Comparable;

public class CircleComparable
{
    public static void main(String[] args)
    {
        //Used to read in input from the keyboard/the user
        Scanner input = new Scanner(System.in);

        //Prompts the user to enter the radius of circle1
        System.out.print("Enter radius of circle1: ");
        double circleOneRadius = input.nextDouble();

        //prompts the user to enter the radius of circle2
        System.out.print("Enter radius of circle2: ");
        double circleTwoRadius = input.nextDouble();

        //creates two new geometric objects as circles
        Circle circle1 = new Circle(circleOneRadius);
        Circle circle2 = new Circle(circleTwoRadius);

        System.out.println();

        //rhetorical question that will be answered by the program
        System.out.print("The two objects have the same area? ");

        //will use public int compareTo and to know if the circles have the same area or not (are the same)
        if (circle1.compareTo((Object)circle2) == 0)
        {
            System.out.println("true"); //when 0
        }
        else
        {
            System.out.println("false"); //when 1
        }

        System.out.println();

        //Will display the area of each circle to the user
        System.out.println("The Area of Circle1 is: "+ String.format("%.5f", circle1.getArea()));
        System.out.println("The Area of Circle2 is: "+ String.format("%.5f", circle2.getArea()));

    }//end of public static void main
}//end of public class circle comparable

//Used to define what a circle has (an area)
class GeometricObject
{
    double area;

    public double getArea()
    {
        return(area);
    }
}//end of class GeometricObject

//Used to define a circle and know that it has a radius and how to get its area
//It will also be used to compare/determine if two circles are the same or not
class Circle extends GeometricObject implements Comparable
{
    double radius;

    Circle(double r)
    {
        radius = r;
    }
    public double getArea()
    {
        return(3.143 * (radius * radius)); //radius squared x pi (area of a circle)
    }

    //Used to compare, if two radius/circles are equal it will return 0 if they are not, then a 1
    public int compareTo(Object obj)
    {
        Circle circle1 = (Circle)obj;

        if(radius == circle1.radius)
        {
            return 0;
        }
        else if(radius > circle1.radius)
        {
            return 1;
        }
        else
        {
            return -1;
        }
    }//end of public int compareTo

}//end of class
