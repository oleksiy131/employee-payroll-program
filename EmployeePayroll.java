//Oleksii Dukhovenko
//Professor Ed Book
//Assignment 1

package employeepayroll;

import java.util.Scanner;

public class EmployeePayroll {

    public static void main(String[] args) {
       
        System.out.println("This program will calculate employee payroll data.");
        System.out.println("-------------------------------------------------");
        System.out.println();
        
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter the employee name (format LastName,FirstName):  ");
        String name = input.nextLine();
        
        System.out.print("Enter the hours worked: ");
        Double hours = input.nextDouble();
        
        System.out.print("Enter the hourly pay rate: ");
        Double rate = input.nextDouble();
        
        System.out.println("----------------------------------");
        System.out.println();
        
        
        
       
        //calculations
        
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
        Double regularPay = regularHours * rate;
        Double overtimeRate = rate * 1.5;
        Double overtimePay = overtimeHours * overtimeRate;
        
         if (overtimePay <= 0) 
            
        {
            overtimePay = 0.0;
        }
        
        Double totalPay = regularPay + overtimePay;
   
        
        
        
        //output
        
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
    
}
