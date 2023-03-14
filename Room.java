
import java.util.*;

 class Room 
{
    int roomnum;
    int spiders; 
    int pits; 
    int adjroom1; 
    int adjroom2; 
    int adjroom3;   
    String description; 
    
    public static int count = 0; 
    
     public Room(int r, int s, int p, int one, int two, int three, String d )
    {
        roomnum=r; 
        spiders=s; 
        pits=p; 
        adjroom1=one; 
        adjroom2 = two; 
        adjroom3 = three; 
        description=d; 

    }

     public Room(Scanner r) 
    {
    roomnum = r.nextInt();
    spiders = r.nextInt(); 
    pits = r.nextInt(); 
    adjroom1 = r.nextInt();
    adjroom2 = r.nextInt();
    adjroom3 = r.nextInt();
    description = r.nextLine();
    description = r.nextLine().trim();  //next line twice
    }
    // Accessors/Mutators/getters

    public int getRoomNumber()
    {
        return roomnum; 
    }

    public int getSpiders()
    {
        return spiders; 
    }

    public int getPits()
    {
        return pits; 
    }

    public int getAdjRoom1()
    {
        return adjroom1; 
    }

    public int getAdjRoom2()
    {
        return adjroom2; 
    }

    public int getAdjRoom3()
    {
        return adjroom3; 
    }

    public String getDescription()
    {
        return description; 
    }
     

}