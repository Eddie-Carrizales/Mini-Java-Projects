// Edilberto Carrizales

// Description:
//   This program reads the user's payroll information and prints a payroll statement from that information

// changelog:
//   06/10/2021 - Carrizales
//      -Added scanner, string variable for employee name, variables for hours worked, pay rate, federal tax and state tax
//      -Figured out the calculations for gross pay, federal withholding, state withholding, total deductions and net pay
//      -Added mini print report for name, hours worked, pay rate and gross pay
//      -Added mini print report for federal withholding, state withholding, total deductions, and net pay
//      -fixed format issues to remove trailing numbers after two decimals

import java.util.Scanner;

public class Payroll
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        //Prompts user to enter employee's name
        System.out.print("Enter employee's name: ");
        String name = input.next();

        //Prompts user to enter number of hours worked
        System.out.print("Enter number of hours worked in a week: ");
        double hoursWorked = input.nextDouble();

        //Prompts user to enter hourly pay rate
        System.out.print("Enter hourly pay rate: ");
        double payRate = input.nextDouble();

        //Prompts user to enter federal tax withholding rate
        System.out.print("Enter federal tax withholding rate: ");
        double federalTax = input.nextDouble();

        //Prompts user to enter state tax withholding rate
        System.out.print("Enter state tax withholding rate: ");
        double stateTax = input.nextDouble();



        //Used to calculate and store the gross pay
        double grossPay = hoursWorked * payRate;

        //Used to calculate and store the federal tax withholding rate
        double federalWithholding = grossPay * federalTax;

        //Used to calculate and store the state tax withholding rate
        double stateWithholding = grossPay * stateTax;

        //Used to calculate and store the total deductions
        double totalDeductions = federalWithholding + stateWithholding;

        //Used to calculate and store the net pay
        double netPay = grossPay - totalDeductions;


        //Used to print out the report

        //Prints out employee name
        System.out.print("\n" + "Employee Name: " + name + "\n");

        //Prints out the number of hours worked
        System.out.print("Hours Worked: " + hoursWorked + "\n");

        //Prints out the pay rate
        System.out.print("Pay Rate: $" + payRate + "\n");

        //Prints out the gross pay
        System.out.print("Gross Pay: $" + grossPay + "\n");

        //Prints out the federal and state tax reductions as well as the total deductions
        System.out.println("Deductions: ");
        System.out.print("   Federal Withholding (" + (federalTax * 100) + "%): $" + federalWithholding + "\n");
        System.out.print("   Sate Withholding (" + (stateTax * 100) + "%): $" + String.format("%.2f", stateWithholding)+ "\n");
        System.out.print("   Total Deduction: " + String.format("%.2f", totalDeductions) + "\n");

        //Prints out the net pay
        System.out.print("Net Pay: $" + String.format("%.2f", netPay) + "\n");

    } //end of public static void main
} //end of public class payroll