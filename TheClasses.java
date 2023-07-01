// Edilberto Carrizales

// Description:
//   This program is like a template of the workers in a university.
//   It consists of Persons which are students, employees, faculty and staff,
//   each containing their names, addresses, phone numbers, emails, office names, roles, ranks, etc.
//   The program also displays some of this information to the user in a table.

public class TheClasses
{
    public static void main (String[] args)
    {
        //Used to create the person, student, employee, faculty, or staff
        Person createPerson = new Person("Jonathan", "Texas", "8322424235", "jony43@gmail.com");
        Person createStudent = new Student("Emily","Florida","8495720493","emilily@gmail.com",3);
        Person createEmployee = new Employee("Johnson","California","4830592748","renecando@gmail.com","Technology",92000);
        Person createFaculty = new Faculty("Sofia","Arizona","2840395748","sofiwofi@gmail.com","Counseling",88000,"9:00am-5:00pm","Manager");
        Person createStaff = new Staff("Delilah","New York","238572958","heytheredelilah@gmail.com","Composer",99000,"Producer");

        //Used to print the information of the person, student, employee, faculty, or staff in a neat table
        System.out.println("Class Name\t\tPerson Name\t\tStatus\t\t\tSalary\t\tOffice Hours\t\tRank\t\tTitle" );
        System.out.println();
        System.out.println(createPerson.toString());
        System.out.println(createStudent.toString());
        System.out.println(createEmployee.toString());
        System.out.println(createFaculty.toString());
        System.out.println(createStaff.toString());

    }//end of public static void main

}//end of public class TheClasses

class Person
{
    String name;
    String address;
    String phoneNumber;
    String email;

    //constructor
    public Person(String name, String address, String phoneNumber, String email)
    {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }//end of public Person

    //toString method
    public String toString()
    {
        //used to print return to main and print to the console
        //the conditional statement helps fix format for printing as a table in console
        if (getClass().getName() == "Employee")
        {
            return getClass().getName()+"\t\t"+ name + "\t";
        }
        else
        {
            return getClass().getName() + "\t\t\t" + name + "\t";
        }
    }//end of public String toString

}//end of class Person

class Student extends Person
{
    String status = "freshman"; //(freshman, sophomore, junior, or senior)

    //Used to store these definitions as a constant
    final int freshman = 1;
    final int sophomore = 2;
    final int junior = 3;
    final int senior = 4;

    //constructor
    public Student(String name, String address, String phoneNumber, String email, int Status)
    {
        super(name,address,phoneNumber,email); //Used to  refer parent class

        //conditional statement to determine if a student is a freshmant,sophomore,junior or senior based on constants
        if(Status == 1)
        {
            status = "freshman";
        }
        else if (Status == 2)
        {
            status = "sophomore";
        }
        else if (Status == 3)
        {
            status = "junior";
        }
        else if (Status == 4)
        {
            status = "Senior";
        }
        else
        {
            status = "Student";
        }

    }//end of public student

    public String toString()
    {
        return super.toString() + "\t\t" + status + "\t\t";
    }
}//end of class Student

class Employee extends Person
{
    java.util.Date dateHired;
    String office;
    double salary;

    //constructor
    public Employee(String name, String address, String phoneNumber, String email, String office, double salary)
    {
        super(name, address,phoneNumber,email); //Used to  refer parent class

        this.office = office;
        this.salary = salary;
    }//end of public Employee

    //returns to print to console (called in main)
    public String toString()
    {
        return (super.toString() + "\t\t" + office + "\t\t" + salary+ "\t\t");
    }

}//end of class Employee

class Faculty extends Employee
{
    String officeHours;
    String rank;

    //constructor
    public Faculty(String name, String address, String phoneNumber, String email, String office, int salary, String officeHours, String rank)
    {
        super(name, address, phoneNumber, email, office, salary); //Used to  refer parent class

        this.officeHours = officeHours;
        this.rank = rank;
    }//end of public Faculty

    //returns to print to console (called in main)
    public String toString()
    {
        return (super.toString() + officeHours + "\t\t" + rank);
    }

}//end of class Faculty

class Staff extends Employee
{
    String title;

    //constructor
    public Staff(String name,String address, String phoneNumber, String email, String office, int salary, String title)
    {
        super(name,address,phoneNumber,email,office,salary); //Used to  refer parent class
        this.title = title;
    }//end of public Staff

    //returns to print to console (called in main)
    public String toString()
    {
        return (super.toString() + "\t\t\t\t\t\t\t\t" + title);
    }
}//end of class Staff