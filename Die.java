import java.util.ArrayList;

public class Die
{
    int numSides;
    int lastRoll = -1;
    int rollNum = 0;


    ArrayList<String> number  = new ArrayList<String>();

    public Die() {
        numSides = 6;
    }

    public Die(int n) {
        numSides = n;
    }

    int numSides() {
        return numSides;
    }

    int roll() {
        int max = numSides;
        int min = 1;
        int range = max - min + 1;

        int roll = (int)(Math.random() * range) + min;
        lastRoll = roll;
        rollNum += 1;
        System.out.println("Roll Number: " + rollNum + " Rolled " + roll);
        return roll;
    }

    int readLastRoll() {
        if(lastRoll != -1) {
            System.out.println("Last roll was " + lastRoll);
        } else {
            System.out.println("Roll a die first");
        }
        System.out.println("Rolled a total of: " + rollNum + " times");
        return lastRoll;
    }
  
    public static void main(String[] args) {

        Die die = new Die();
        for (int i=0; i<5; i++) {
            die.roll();
        }
        die.readLastRoll();
        int sum = die.roll() + die.roll() + die.roll();
        System.out.println("Sum of three random die is: " + sum);
    }
}