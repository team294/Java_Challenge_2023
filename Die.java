import java.util.ArrayList;
import java.util.List;


public class Die {
    int numSides;
    boolean lastroll = false;
    int x;
    List<Integer> l1 = new ArrayList<Integer>();


    public Die() {
            numSides=6;
        }
    public Die(int i) {
            numSides = i;
        }
       
   
    int roll()
    {
        int roll;
        int max = numSides;
        int min =1;
        int range = max-min+1;
        lastroll = true;
       
        roll = (int)(Math.random() * range) + min;
        l1.add(roll);
       
        return roll;
    }


    int readLastroll() {
        if (lastroll == true) {
            //System.out.println("Last Roll was: " + l1.get(0));


            return l1.get(l1.size() - 1);
        }
        else {
            System.out.println("Roll the Die First");
             
             return -1;
             }


       
     }


   


   
       
   
   
    public static void main(String[] args)
    {
        Die x = new Die(6);
        Die y = new Die(6);
        Die z = new Die(6);
        System.out.println("Number of Sides: " + x.numSides);
        System.out.println("Roll:" + x.roll());
        System.out.println("Roll:" + x.roll());
        System.out.println("Roll:" + x.roll());
        System.out.println("Roll:" + x.roll());
        System.out.println("Last Roll: " + x.readLastroll());
        int sum;
        System.out.println("Rollx:" + x.roll());
        System.out.println("Rolly:" + y.roll());
        System.out.println("Rollz:" + z.roll());
        sum = x.roll() + y.roll() + z.roll();
        System.out.println("Sum of random three die is: " + sum);




       
    }}


