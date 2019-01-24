/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package feecalculator;
import java.util.*;

/**
 *
 * @author Naveen Kumar Puvvada
 */
public class FeeCalculatorDriver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String string;
        String stu_name;
         FeeCalculator var=new FeeCalculator(null);
        Scanner obj=new Scanner(System.in);
        System.out.println("*******************************");
        System.out.println("***Northwest Cost Calculator***");
        System.out.println("*******************************\n");
        double gpa=0.0;
        do
        {      
               do{
        System.out.print("Please enter the full name (Firstname Lastname): ");
        stu_name=obj.nextLine();
        }while(stu_name.length()==0);
        System.out.print("Please enter the number of pre-requisites: ");
        int preReq=obj.nextInt();
        obj.nextLine();
            while(preReq!=0&&preReq!=1&&preReq!=2)
            {
                System.out.print("You have entered invalid number, please re-enter either 0 or 1 or 2: ");
                preReq=obj.nextInt();
            }
        System.out.print("Please enter the number of semesters you want "
                            + "to calculate the cumulative fee: ");
        int sem=obj.nextInt();
        while(sem!=1&&sem!=2&&sem!=3&&sem!=4)
        {
            System.out.print("You have entered invalid number, please re-enter either 1 or 2 or 3 or 4: ");
            sem=obj.nextInt();
        }
        if(sem==2||sem==3||sem==4){
        System.out.print("Enter the cumulative GPA: ");            
        gpa=obj.nextDouble();
                 
        while(gpa<0.0||gpa>4){
        System.out.print("The GPA value should be in between 0 and 4, please re-enter: ");
        gpa=obj.nextDouble();}
            }
        System.out.println("");
        FeeCalculator student=new FeeCalculator(stu_name);
        System.out.println("****************************************");
        System.out.println("* Hello, "+student.toString());
        System.out.println("*------------------------------------\n" +
                            "* Your Account Summary\n" +
                            "*------------------------------------\n" +
                            "*__________________________________");
            for (int i = 1; i <= sem; i++) {
                
            System.out.printf("* Semester %d fee is:    $ %.2f * \n"
                            ,i,student.calcSemCost(i,preReq,gpa));
            }
            System.out.printf("*----------------------------------    \n* Total cost:           $ %.2f"
                    + "\n*----------------------------------    \n",student.calcTotalCost(sem, preReq, gpa));
            System.out.println("*");
            System.out.printf("* USD to INR: Rs. %.2f"
                            ,student.exchUSDToINR(student.calcTotalCost(sem, preReq, gpa)));
            System.out.printf("\n* USD to Euro: € %.2f"
                             ,student.exchUSDToEuro(student.calcTotalCost(sem, preReq, gpa)));
            System.out.println("\n****************************************"); 
            System.out.println(student.printReciept(sem, preReq, gpa));
            System.out.println("");
            System.out.print("Do you want to calculate again?(Y/N): ");
            string=obj.next();
            System.out.println("");
             
             obj.nextLine();
             
        }while(string.equalsIgnoreCase("Y"));
        if(string.equalsIgnoreCase("N"))
        {
            System.out.println("Thank You! All the best.");
        }
    }
    
}
