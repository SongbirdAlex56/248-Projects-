import java.io.*;
import java.util.*;
import java.util.Scanner;    

class guess3
{
    static int randomnumber()  //Random number generator. function will generate  a random number for the game to use 
    {
        int number = (int)(1+100*Math.random()); 
        return number; 
    }
    static void randominsult() //Random insult generator. function will generate a random insult for the game to use 
    {
        int insult = (int)(1+5*Math.random());   
        if(insult == 1) 
        {
            System.out.println("You suck. A toddler could do better than that!"); 
        }
        if(insult == 2)
        {
            System.out.println("Boo. I'm not mad,just disappointed. "); 

        }
        if(insult == 3)
        {
          System.out.println("Fix it. NOW."); 
        }
        if(insult == 4)
        {
            System.out.println("Wrong! C'mon, you can do better than that!"); 
        }
        if(insult == 5)
        {
            System.out.println("Really? Maybe use your brain next time."); 
        }
  
    }


    public static void main(String [] args) //start of main 
    {
           int userinput = 0;


            Scanner scanner_one = new Scanner(System.in); //making scanner
            int randomnumber=randomnumber(); //calling random number
            System.out.println(randomnumber);

            System.out.println("Welcome to my number guessing game!"); 
            System.out.println("I have a number between 1 and 100.  Can you guess it?"); 
            int guess = 0; 
            
               

            do
            {
                do
                {
                    System.out.print("Enter your guess please: "); 
                    guess = scanner_one.nextInt(); //guess scanner
                    
                
                        if(guess > randomnumber)
                        {
                            System.out.println("Too high! Try again.");
                            randominsult(); //calling random insult 
                        }
                        if(guess < randomnumber)
                        {
                            System.out.println("Too low!! Try again.");
                            randominsult();
                        }
                        else 
                        {
                            if(guess == randomnumber)
                            { 
                                System.out.println("You win!! Congratulations!"); 
                            }
                    
                        }
                    
                } while (guess !=randomnumber); 

                System.out.print("Game over! Would you like to play again? Please enter 1 for YES 0 for NO: "); //play again feature
                userinput = scanner_one.nextInt(); 
                if(!(userinput == 1 || userinput == 0))
                {
                    System.out.println("Invalid Input - Please enter 1 YES or 0 for NO."); //wrong input 
                }
                


            }while(userinput == 1); //end of-do while loop
               
        
        
        
        
    } 
}