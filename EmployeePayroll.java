
import java.io.FileWriter;
import java.io.IOException;
import java.lang.*;
import java.io.*;
import java.util.Scanner;

class EmployeePayroll {

    private static String name;
    private static double hours;
    private static double rate;

    private static double overtimeHours;
    private static double regularHours;
    private static double overtimePay;
    private static double regularPay;
    private static double overtimeRate;
    private static double totalHours;
    private  static double totalPay;



    public void calculate(){

        Double overtimeHours = hours - 40;

        if (overtimeHours <= 0)

        {
            overtimeHours = 0.0;
        }

        Double regularHours = hours;

        if (regularHours >= 40)

        {
            regularHours = 40.00;

        }
        Double totalHours = regularHours + overtimeHours;
        this.totalHours = totalHours;

        Double regularPay = regularHours * rate;
        this.regularPay = regularPay;

        Double overtimeRate = rate * 1.5;
        this.overtimeRate = overtimeRate;

        Double overtimePay = overtimeHours * overtimeRate;
        this.overtimePay = overtimePay;

        if (overtimePay <= 0)

        {
            overtimePay = 0.0;
        }

        Double totalPay = regularPay + overtimePay;
        this.totalPay = totalPay;
        //output

    }
    static public void printOutput() throws FileNotFoundException {

        //creating new file to store info in
        FileOutputStream f = new FileOutputStream("output-stored-here.txt");

        System.setOut(new PrintStream(f));
        int index;
        index = name.indexOf(',');
        String lastName = name.substring(0,index);
        String firstName = name.substring(index + 1);


        System.out.println("Payroll Data for " + firstName + " " + lastName);
        System.out.println("---------------------------");
        System.out.println();

        System.out.printf("Regular hours:     %,8.2f %n", regularHours);
        System.out.printf("Overtime hours:    %,8.2f %n", overtimeHours);
        System.out.printf("Total hours:       %,8.2f %n", totalHours);
        System.out.println();

        System.out.printf("Regular pay:      $%,8.2f %n", regularPay);
        System.out.printf("Overtime pay:     $%,8.2f %n", overtimePay);
        System.out.printf("Total pay:        $%,8.2f %n", totalPay);
    }

    public void getData(){
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the employee name (format LastName,FirstName):  ");
        String name = input.nextLine();
        this.name = name;

        System.out.print("Enter the hours worked: ");
        Double hours = input.nextDouble();
        this.hours = hours;

        System.out.print("Enter the hourly pay rate: ");
        Double rate = input.nextDouble();
        this.rate = rate;

        System.out.println("----------------------------------");
        System.out.println();
    }


    public static void main(String[] args) throws FileNotFoundException {

        System.out.println("This program will calculate employee payroll data.");
        System.out.println("-------------------------------------------------");
        System.out.println();

        EmployeePayroll roll = new EmployeePayroll();

        roll.getData();
        roll.calculate();
        printOutput();
        
        }
}
