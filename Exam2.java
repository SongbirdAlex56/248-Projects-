import java.io.*;
import java.util.*;
import java.util.Scanner;    

class Exam2
{
    static int min(int count, int [] scorearray)
    {
        int man = 0; 
        
        for(int i = 0; i < count; i++)
        {
            if(i==0)
            {
                man = scorearray[i]; 

            }
            if(man > scorearray[i])
            {
                man = scorearray[i]; 
            }
        }
        return man; 
    }
    static int max (int count, int [] scorearray)
    {
        int man=0; 
        //System.out.println(count);

        for(int i = 0; i < count; i++)
        if(i==0)
        {
            man = scorearray[i]; 
        }
        else if(man < scorearray[i])
        {
            man = scorearray[i];
        }
        return man; 
    }
    static double average(int count, int [] scorearray)
    {
        double sum = 0.0;   //0.0 instead of 0 for double 
        for(int i =0; i < count; i++ )
        {
            sum = sum + scorearray[i]; 
        }
        
        double all = sum / (count); 

        return all; 
    }

    static double median(int count, int [] scorearray)
    {
        double mean = 0.0;
        
            if(count % 2 == 1)
            {
            
					
                mean = (scorearray[(count+1)/2-1]);		
            }
            else
            {
                
                mean = ((scorearray[count/2-1]+scorearray[count/2])/2); 
            }
        
        return mean;
        
    }
    
    
    public static void main(String [] args ) throws IOException 
    {

        System.out.println("***Welcome to the Exam Statistics Program!!*** "); 

        //1st step: getting data to read from the file 
        String filename; 
        String line; 
        Scanner cin=new Scanner(System.in); 

        System.out.print("Please enter the name of your data file: "); //Type in esp.txt
        filename=cin.nextLine(); 

        Scanner scores; 
        scores = new Scanner(new FileReader(filename)); 

        int [] scorearray; 
        scorearray=new int[100];  
        String strcount=scores.nextLine(); 
        int count = Integer.parseInt(strcount);  ///STAR STAR STAR BABY
         
        for(int i=0; i<count; i++)
        {
            scorearray[i] = scores.nextInt(); 
        }

        //calling functions 
        int man=min(count, scorearray);
        int max=max(count, scorearray);
        double average=average(count, scorearray);
        double mean=median(count, scorearray);   //calling median function 

        //printing out scores 
        System.out.println("Minimum score: "+man); 
        System.out.println("Maximum score: "+max); 
        System.out.println("Average score: "+average);
        System.out.println("Median score: " +mean);  //printing median score 

        //Letter grades 
        int numberofA = 0; 
        int numberofB = 0; 
        int numberofC = 0; 
        int numberofD = 0; 
        int numberofF = 0; 

        
        //counting letter grades 
        for(int i=0; i < count; i++) 
        {
            if(scorearray[i] >= 90)
            {
                    numberofA++;
            }
            else if(scorearray[i] >= 80 && scorearray[i] < 90)
            {
                numberofB++; 
            }
            else if(scorearray[i] >= 70 && scorearray[i] < 80)
            {
               numberofC++; 
            }
            else if(scorearray[i] >= 60 && scorearray[i] < 70)
            {
                numberofD++; 
            }
            else
            {
                numberofF++; 
            }
            

        }
            //pritning out the number of letter grades 
            System.out.println("Number of scores by letter grade:"); 
            
            System.out.println("A: "+numberofA); 
            System.out.println("B: "+numberofB);
            System.out.println("C: "+numberofC);
            System.out.println("D: "+numberofD);
            System.out.println("F: "+numberofF);

            System.out.println("There are "+count+" scores in your file." ); 

    }  //end of main 

} //end of class 