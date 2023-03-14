
import java.io.*;
import java.util.*;

class MainWumpus 
{
    public static int randomnumber(int min, int max) //random Number generator for game elements 
    {
        return(int) (min + Math.random() * (max-min + 1)); 
    }
    public static void main(String [] args) throws IOException
    {
     //Initializing game veriables. 6 Different rooms   
     int currentRoom; 
     int wumpusRoom; 
     int spiderzRoom1; 
     int spiderzRoom2; 
     int pitRoom1; 
     int pitRoom2; 
     int numberofArrows;
     

     boolean wumpusAlive; 
     boolean spiderzAlive; 
     boolean pitAlive1; 
     boolean pitAlive2; 
     boolean alive; 
     boolean win; 

     char M = 'M'; 
     char S = 'S'; 

    numberofArrows = 3; //starting # of arrows 
    currentRoom = 0; //start in room 1 
    wumpusAlive = true; 
    spiderzAlive = true; 
    pitAlive1 = true; 
    pitAlive2 = true; 



    //reading in the array from the file and creating a scanner 
    Scanner CaveLayout=new Scanner(new FileReader("CaveLayout.txt"));
    int n=CaveLayout.nextInt();

    Room [] rooms=new Room[n];
    
        
    for(int i=0; i<n; i++)
    {
        rooms[i]=new Room(CaveLayout);
    }

    //Placing game elements in random rooms. Make sure nothing ends up in room #1. 
    int p = rooms.length; //total number of rooms in a cave 
    wumpusRoom = randomnumber(2, n-1); //2 is making sure nothing ends up in room 1 
    spiderzRoom1 = randomnumber(2, n-1); 
    spiderzRoom2 = randomnumber(2, n-1); 
    pitRoom1 = randomnumber(2,n-1); 
    pitRoom2 = randomnumber(2,n-1); 
    

    // Making  sure no two game elements are in the same room 
    while (wumpusRoom == spiderzRoom1 || wumpusRoom == spiderzRoom2 || wumpusRoom == pitRoom1 || wumpusRoom == pitRoom2 || spiderzRoom1 == spiderzRoom2 || spiderzRoom1 == pitRoom1 || spiderzRoom1 == pitRoom2 || spiderzRoom2 == pitRoom1 || spiderzRoom2 == pitRoom2 || pitRoom1 == pitRoom2)
    {
        wumpusRoom = randomnumber(2, n-1); //2 is making sure nothing ends up in room 1 
        spiderzRoom1 = randomnumber(2, n-1); 
        spiderzRoom2 = randomnumber(2, n-1); 
        pitRoom1 = randomnumber(2,n-1); 
        pitRoom2 = randomnumber(2,n-1); 
    }
    



    // Game Loop 
    System.out.println("Welcome to **Hunt the Wumpus!**"); 

    alive = true; 
    win = false; 
    while(alive == true && numberofArrows > 0 && win == false )
    {
        System.out.println("You are currently in room " + (currentRoom + 1)); 
        System.out.println("You have " +numberofArrows+ " arrows left. Use them wisely!"); 
        System.out.println(rooms[currentRoom ].getDescription()); //FIX THIS??
        System.out.println("There are tunnels to rooms "+ rooms[currentRoom].getAdjRoom1() + " , " + rooms[currentRoom].getAdjRoom2() + " , " + rooms[currentRoom].getAdjRoom3()); 

        if(wumpusRoom == rooms[currentRoom].getAdjRoom1() || wumpusRoom == rooms[currentRoom].getAdjRoom2()|| wumpusRoom == rooms[currentRoom].getAdjRoom3())
        {
            System.out.println("You smell some nasty Wumpus!"); 
        } 
        if(spiderzRoom1 == rooms[currentRoom].getAdjRoom1()|| spiderzRoom1 == rooms[currentRoom].getAdjRoom2()|| spiderzRoom1 == rooms[currentRoom].getAdjRoom3())
        {
            System.out.println("You hear a faint clicking noise."); 
        }
        if(pitRoom1 == rooms[currentRoom].getAdjRoom1()|| pitRoom1 == rooms[currentRoom].getAdjRoom2()|| pitRoom1 == rooms[currentRoom].getAdjRoom3())
        {
            System.out.println("You smell a dank odor. Ew"); 
        }
        else if(pitRoom2 == rooms[currentRoom].getAdjRoom1()|| pitRoom2 == rooms[currentRoom].getAdjRoom2()|| pitRoom2 == rooms[currentRoom].getAdjRoom3())
        {
            System.out.println("You smell a dank odor. Ew"); 
        }

        //asking user to move or shoot
        
            String action; 
            Scanner scan = new Scanner(System.in); 
            System.out.println("Whould you like to (M)ove or (S)hoot?"); 
            action = scan.next(); 

            if(action.equals("S"))
            {
                numberofArrows = numberofArrows - 1; 
                System.out.println("Which room would you like to shoot into?"); 

                int shootroom; 
                shootroom = scan.nextInt(); 
                if(shootroom == wumpusRoom)
                {
                    System.out.println("Your arrow goes down the tunnel and finds its mark! Congrats! You Win!!"); 
                    win = true; 
                }
                else 
                {
                    System.out.println("Your arrow goes down the tunnel and is lost.  You missed."); 
                    win = false; 
                }
            }
            else if(action.equals("M"))
            {
                System.out.println("Which room would you like to move into?"); 
                int moveroom; 
                moveroom = scan.nextInt(); 
                if(moveroom == rooms[currentRoom].getAdjRoom1()|| moveroom == rooms[currentRoom].getAdjRoom2()|| moveroom == rooms[currentRoom].getAdjRoom3() )
                {
                   currentRoom = moveroom - 1; 
                }
                else
                {
                    System.out.println("Dimwit! You can't get to there from here. Try Again!"); 
                }
            }
            
        }
    

    

    }
}