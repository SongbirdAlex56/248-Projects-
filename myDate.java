import java.util.*;

class myDate implements DateInterface 
{
    int Day; 
    int Dow; 
    int Month; 
    int Year; 


    public void set(int m, int d, int y, int dow ) //constructors 
    {
        Day=d; 
        Dow=dow; 
        Month=m; 
        Year=y; 
    }

//Setting up accessors for day, day of week, month, and year
    public int getDay()
    {
        return Day; 
    }

    public int getDow()
    {
        return Dow; 
    }

    public int getMonth() 
    {
        return Month; 
    }

    public int getYear()
    {
        return Year; 
    }
    
    

     public void tomorrow()  //will allow program to calulate the day and month
     {
        if(Month==4 || Month==6 || Month==9 || Month==11 ) //months with 30 days only 
        {
            if(Day==30)
            {
                Day=1; 
                Month++; 
            }
            else
            {
                Day++; 
            }
        }

        else if(Month == 2)
        {
            if((Year % 4 == 0  && Year % 100 != 0 )|| (Year % 100 == 0 && Year % 400 == 0)) //accounts for leap year
            {
                if(Day==29)
                {
                    Day=1; 
                    Month++; 
                }
                else
                {
                    Day++;
                }
            }
            else
            {
                if(Day==28)
                {
                    Day=1;   
                    Month++; 
                }
                else
                {
                    Day++;
                }
            }
        }

        else if(Month == 12)  //December 
        {
            if(Day == 31)
            {
                Day=1; 
                Month=1; 
                Year++; 
            }
            else
            {
                Day++; 
            }
        }

        else if(Month == 1 || Month == 3 || Month == 5 || Month == 7 || Month == 8 || Month == 10 )  //accounts for months with 31 days 
        {
            if(Day==31)
            {
                Day=1; 
                Month++; 
            }
            else
            {
                Day++; 
            }
        }

        if(Dow == 6) 
        {  
            Dow = 0;
        }
        else
        {
            Dow++;
        } 
        
        
     }



     public String toString()
    {
        
        String month = ""; //naming all of the months  string 
        if(Month == 1)
        {
            month = "January"; 
        }
        
        else if(Month == 2)
        {
            month = "February"; 
        }

        else if(Month == 3)
        {
            month = "March"; 
        }

       else if(Month == 4)
        {
            month = "April"; 
        }

        else if(Month == 5)
        {
            month = "May"; 
        }

        else if(Month == 6)
        {
            month = "June"; 
        }

        else if(Month == 7)
        {
            month = "July"; 
        }

        else if(Month == 8)
        {
            month = "August"; 
        }

        else if(Month == 9)
        {
            month = "September"; 
        }

        else if(Month == 10)
        {
            month = "October"; 
        }

       else if(Month == 11)
        {
            month = "November"; 
        }

        else if(Month == 12)
        {
            month = "December"; 
        }

        //Day of the week string 
        String weekday = ""; 

        if(Dow == 0)
        {
            weekday = "Sunday"; 
        }

        else if(Dow == 1)
        {
            weekday = "Monday"; 
        }

        else if(Dow == 2)
        {
            weekday = "Tuesday"; 
        }

       else if(Dow == 3)
        {
            weekday = "Wednesday"; 
        }

        else if(Dow == 4)
        {
            weekday = "Thursday"; 
        }

        else if(Dow == 5)
        {
            weekday = "Friday"; 
        }

        else if(Dow == 6)
        {
            weekday = "Saturday"; 
        }

        //return statement for everything 
        return weekday+"  "+month+" " +Day + ", "+ Year; 


    }
     public void yesterday()  //extra credit function that will calculate the previous day 
     {

     if(Month==5 || Month==7 || Month==10 || Month==12 )
        {
            if(Day==1)
            {
                Day=30; 
                Month--; 
            }
            else
            {
                Day--;   //-- instead of plus 
            }
        }

        else if(Month == 3)
        {
            if((Year % 4 == 0  && Year % 100 != 0 )|| (Year % 100 == 0 && Year % 400 == 0))
            {
                if(Day==1)
                {
                    Day=29; 
                    Month--; 
                }
                else
                {
                    Day--;
                }
            }
            else
            {
                if(Day==1)
                {
                    Day=28; 
                    Month--; 
                }
                else
                {
                    Day--;
                }
            }
        }

        else if(Month == 1)
        {
            if(Day == 1)
            {
                Day=31; 
                Month=12; 
                Year--; 
            }
            else
            {
                Day--; 
            }
        }

        else if(Month == 2 || Month == 4 || Month == 6 || Month == 8 || Month == 9 || Month == 11 )
        {
            if(Day==1)
            {
                Day=31; 
                Month--; 
            }
            else
            {
                Day--; 
            }
        }

        if(Dow == 0) 
        {  
            Dow = 6;
        }
        else
        {
            Dow--;
        } 
        
        
     }

} //end of class 

