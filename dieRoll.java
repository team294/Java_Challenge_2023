package bcr;
import java.lang.Math;
public class dieRoll{
    public static void main(String[] args) {
        //below sets a range for the random, which, on a standard 6-sided die, is 1-6
        int min = 1;
        int max = 6;
        int range = max - min + 1;

        //below gets random value 20 different times and prints out each value along with message and # of times
        for (int i = 1; i <= 20; i++){
            int roll = (int)(Math.random()*range+min);
            System.out.println("Roll #" + i + " = " + roll);
        }
    }    
}