/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package feecalculator;

/**
 *
 * @author NAVEEN KUMAR PUVVADA
 */
public class FeeCalculator {

    /**
     *declaring undergraduate incidental fee
     */
    public static final double UG_INCIDENTAL_FEE = 406.35;

    /**
     *declaring graduate incidental fee
     */
    public static final double G_INCIDENTAL_FEE = 505.72;

    /**
     *declaring graduate designated fee 
     */
    public static final double G_DESIGNATED_FEE = 115.55;

    /**
     declaring undergraduate designated fee
     */
    public static final double UG_DESIGNATED_FEE = 104.80;

    /**
     *declaring graduate textbook fee
     */
    public static final double G_TEXTBOOK_FEE = 0;

    /**
     *declaring undergraduate textbook fee
     */
    public static final double UG_TEXTBOOK_FEE = 6;

    /**
     *declaring graduate technology fee
     */
    public static final double G_TECHNOLOGY_FEE = 20.70;

    /**
     *declaring undergraduate technology fee
     */
    public static final double UG_TECHNOLOGY_FEE = 20.70;

    /**
     *declaring graduate computer fee
     */
    public static final double G_COMPUTER_FEE = 38;

    /**
     *declaring undergraduate computer fee
     */
    public static final double UG_COMPUTER_FEE = 38;

    /**
     *declaring graduate scholarship fee
     */
    public static final double G_SCHOLARSHIP_FEE = 1000;

    /**
     *declaring graduate  semester1 insurance fee
     */
    public static final double G_INSURANCESEM1_FEE = 456.48;

    /**
     *declaring graduate  semester2 insurance fee
     */
    public static final double G_INSURANCESEM2_FEE = 760.2;

    /**
     *declaring graduate  semester4 insurance fee
     */
    public static final double G_INSURANCESEM4_FEE = 456.48;

    /**
     *declaring constant for rupee
     */
    public static final double INDIAN_RUPEE = 64.55;

    /**
     *declaring constant for exchange
     */
    public static final double EURO_EXCHANGE = 0.83;

    /**
     *declaring constant for international fee
     */
    public static final double G_INTERNATIONAL_FEE = 75;

    /**
     *declaring constant for orientation fee
     */
    public static final double G_ORIENTATION_FEE = 75;
 private String studentName;

    /**
     *
     * @param studentName is the instance variable declared in private class to get given name
     */
    public FeeCalculator(String studentName) {
        this.studentName = studentName;
    }

    /**
     *
     * @return this returns the user input value
     */
    public String getStudentName() {
        return studentName;
    }

    /**
     *
     * @param studentName sets the student name from the user
     */
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    
    /**
     *
     * @return stores the given student name
     */
    public String getNameInitials(){
        String s;
        s=getStudentName().trim();
        String s1;
        s1=s.substring(0,1);
        
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' ')
            {
                s1=s1+"."+s.charAt(i+1);
            }
         
        }
        return s1.toUpperCase();
        }
    
    /**
     *
     * @param x takes number of prerequisites
     * @return the cost of prerequisite course
     */
    public double calcPrereqCost(int x){
      double z=x*(UG_INCIDENTAL_FEE+UG_DESIGNATED_FEE+UG_TEXTBOOK_FEE+UG_TECHNOLOGY_FEE+UG_COMPUTER_FEE)*3  ;
      return z;
        
    }
    
    /**
     *
     * @param y takes number of prerequisites
     * @return the number of required course
     */
    public int findReqCoursesForSem1(int y){
     int x=0;
     if(y==0)
     {
      x= 3;
     }
       if(y==1||y==2)
      {
          x= 2;
      }
     return x;
 }

    /**
     *
     * @return the required course cost for a course
     */
    public double calcReqCourseCostForOneCourse()
{
double z1=(G_INCIDENTAL_FEE+G_DESIGNATED_FEE+G_TEXTBOOK_FEE+G_TECHNOLOGY_FEE+G_COMPUTER_FEE)*3;      
return z1;
}

    /**
     *
     * @param a takes semester as input
     * @param b takes prerequisites as input
     * @param c takes grade point average as input
     * @return the scholarship for a particular semester
     */
    public double calcScholarship(int a, int b, double c)
{
    int d=0;
   if(a==1)
   {
       return G_SCHOLARSHIP_FEE;
   }
   else if((a==2||a==3)&&c>=3.33)
   {
       return ((G_INCIDENTAL_FEE)/2)*9;
}
   else if((a==4)&&(b==0)&&c>=3.33)
   {
     return ((G_INCIDENTAL_FEE)/2)*6;  
   }
   else if((a==4)&&(b==1||b==2)&&c>=3.33)
       {
           return ((G_INCIDENTAL_FEE)/2)*9;
       }
   return d;
}

    /**
     *
     * @param e takes semester as input
     * @param f takes prerequisites as input
     * @param g takes grade point average as input
     * @return the total scholarship
     */
    public double calcTotalScholarship(int e, int f, double g)
{
    double h=0;
 for(int i1=0;i1<e;i1++)
 {
     h=h+calcScholarship(i1+1,f,g);
 }
 return h;
}

    /**
     *
     * @param sem takes semester as input
     * @param preReq takes prerequisites as input
     * @param gpa takes grade point average as input
     * @return the cost for a semester 
     */
    public double calcSemCost(int sem,int preReq, double gpa){
        double preReqCost;
        int req;
        double scholarship;
        double tot=0.0;
        switch (sem) {
            case 1:
                preReqCost=calcPrereqCost(preReq);
                req=findReqCoursesForSem1(preReq);
                tot=preReqCost+(calcReqCourseCostForOneCourse()*req)
                        -G_SCHOLARSHIP_FEE+G_INSURANCESEM1_FEE
                        +G_ORIENTATION_FEE+G_INTERNATIONAL_FEE;
                break;
            case 2:
                if(gpa>=3.33){
                    scholarship=calcScholarship(sem,preReq,gpa);
                    req=3;
                    tot=(calcReqCourseCostForOneCourse()*req)-scholarship
                            +G_INSURANCESEM2_FEE+G_INTERNATIONAL_FEE;
                }
                else if(gpa<3.33){
                    req=3;
                    tot=(calcReqCourseCostForOneCourse()*req)
                            +G_INSURANCESEM2_FEE+G_INTERNATIONAL_FEE;
                }   break;
            case 3:
                if(gpa>=3.33){
                    scholarship=calcScholarship(sem,preReq,gpa);
                    req=3;
                    tot=(calcReqCourseCostForOneCourse()*req)-scholarship+G_INTERNATIONAL_FEE;
                }
                else if(gpa<3.33){
                    req=3;
                    tot=(calcReqCourseCostForOneCourse()*req)+G_INTERNATIONAL_FEE;
                }   break;
            case 4:
                if(preReq==0){
                    req=2;}
                else
                {req=3;}
                if(gpa>=3.33){
                    
                    scholarship=calcScholarship(sem,preReq,gpa);
                    tot=(calcReqCourseCostForOneCourse()*req)-scholarship+G_INSURANCESEM4_FEE+G_INTERNATIONAL_FEE;
                }
                else if(gpa<3.33){
                    tot=(calcReqCourseCostForOneCourse()*req)
                            +G_INSURANCESEM4_FEE+G_INTERNATIONAL_FEE;
                }   break;
            default:
                break;
        }
        return tot;
    }

    /**
     *
     * @param sem takes semester as input
     * @param preReq takes prerequisites as input
     * @param gpa takes grade point average as input
     * @return total cost of semester
     */
    public double calcTotalCost(int sem,int preReq,double gpa)
    {
        double total=0.0;
        for (int i = 1; i <= sem; i++) {
            total+=calcSemCost(i,preReq,gpa);
            
        }
        return total;
    }

    /**
     *
     * @param usd takes the cost input
     * @return exchange value
     */
    public double exchUSDToINR(double usd){
        return usd*INDIAN_RUPEE;
    }

    /**
     *
     * @param usd takes the cost input
     * @return exchange value
     */
    public double exchUSDToEuro(double usd){
        return usd*EURO_EXCHANGE;
    }

    @Override
    public String toString() {
        return getNameInitials()+".";
    }

    /**
     *
     * @param sem  takes semester as input   
     * @param preReq takes prerequisites as input   
     * @param gpa takes grade point average as input   
     * @return print total cost
     */
    public String printReciept(int sem, int preReq, double gpa){
        return getNameInitials()+"., on a whole the total scholarship till semester "
                +sem+" is: $ "+String.format("%.2f",calcTotalScholarship(sem,preReq,gpa))
                +"\n"+"Total fee till semester "+sem+" is: $ "
                +String.format("%.2f",calcTotalCost(sem,preReq,gpa));
      
    }
    

}