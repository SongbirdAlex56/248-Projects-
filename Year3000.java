import java.io.*;

/**
  Driver class for The Dating Game programming assignment.
  @author Jon Sorenson
*/
public class Year3000
{
  public static void main(String [] args) throws IOException
  {
    DateInterface d = new myDate();
    d.set(1,27,2019,0);  // sets the date to Sunday, January 27th, 2019
    while(d.getYear()<3000)
    {
      d.tomorrow(); // why won't you work??????????
      // un-comment the next line to help with debugging
      //System.out.println(d);
    }
    System.out.println(d);

    d.yesterday();
    // at this point, d represents January 1, 3000
    System.out.println(d);
  }
}