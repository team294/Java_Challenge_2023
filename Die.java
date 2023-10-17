package bcr;
import java.util.Random;

public class Die {
    private static int totalDiceCreated = 0; //starts total dice created at 0
    private static int totalRolls = 0; //starts total rolls at 0
    private static int[] globalNumCounts; // creates int for the # of times a # has been rolled

    private int numSides; //int that gives number of sides of a die
    private int lastRoll; //reads last roll

    public Die() {
        this(6); //default die, 6 sides
    }

    public Die(int numSides) {
        if (numSides <= 1) {
            throw new IllegalArgumentException("Number of sides must be greater than 1"); //makes sure dice have at least 2 sides
        }
        this.numSides = numSides;
        totalDiceCreated++;
    }

    public int numSides() {
        return numSides; //method that returns numSides
    }

    public int roll() { //method that rolls dice
        Random random = new Random();
        lastRoll = random.nextInt(numSides) + 1;
        globalNumCounts[lastRoll]++;
        totalRolls++;
        return lastRoll;
    }

    public int readLastRoll() { //method that reads last roll
        if (lastRoll == 0) {
            return -1;
        }
        return lastRoll;
    }

    public static int totalCreated() {
        return totalDiceCreated; //returns amount of dice created
    }
   
    public static int totalRolls() {
        return totalRolls;
    }

    public static int numCount(int number) {
        if (number < 1 || number > globalNumCounts.length - 1) {
            throw new IllegalArgumentException("Invalid number"); //if '1' is entered, returns "invalid number" because who wants a 1-sided die
        }
        return globalNumCounts[number]; //returns times each num was rolled
    }

public static void main(String[] args) { //ADD EXTRA DICE HERE
    Die sixSidedDie = new Die();
    Die eightSidedDie = new Die(8);
    Die twelveSidedDie = new Die(12);
    Die sixteenSidedDie = new Die (16);

    //if you want to add another die, follow this:
    //int maxNumSides = Math.max(firstDie.numSides(), Math.max(secondDie.numSides(), Math.max(thirdDie.numSides(), Math.max(fourthDie.numSides(), fifthDie.numSides())))) **assuming there are 5 dice
    //please go in ascending order going down, ex:
    //Die twoSidedDie = new Die (2);
    //Die threeSidedDie = new Die (3);
    //etc.

    int maxNumSides = Math.max(sixSidedDie.numSides(), Math.max(eightSidedDie.numSides(), Math.max(twelveSidedDie.numSides(), sixteenSidedDie.numSides())));
    globalNumCounts = new int[maxNumSides + 1];

    for (int i = 0; i < 70; i++) {
        sixSidedDie.roll();
        eightSidedDie.roll();
        twelveSidedDie.roll();
        sixteenSidedDie.roll();
    }
    //make sure to add fifth die above too (if adding 5th)

    System.out.println("Total dice created: " + Die.totalCreated()); //prints total dice created
    System.out.println("Total rolls: " + Die.totalRolls); //prints total rolls performed
    System.out.println(""); //adds line of space (for easier visibility)

    System.out.println("Last roll (6-sided die): " + sixSidedDie.readLastRoll()); //last roll (of the 70) for 6-sided
    System.out.println("Last roll (8-sided die): " + eightSidedDie.readLastRoll()); //last roll (of the 70) for 8-sided
    System.out.println("Last roll (12-sided die): " + twelveSidedDie.readLastRoll()); //last roll (of the 70) for 12-sided
    System.out.println("Last roll (16-sided die): " + sixteenSidedDie.readLastRoll()); //last roll (of the 70) for 16-sided
    System.out.println(""); //adds line of space (for easier visibility)

    System.out.println("Number of times each number was rolled:"); //prints this statement
    System.out.println(""); //adds line of space (for easier visibility)
    for (int i = 1; i < globalNumCounts.length; i++) {
        System.out.println("Number of " + i + "s rolled: " + numCount(i)); //prints number of times each number (1-16 (16 being highest value of all dice) was rolled)
    }
  }
}