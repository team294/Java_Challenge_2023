public class exercise1 {
    
     public static void main(String[] args)
    {
        int max = 6;
        int min = 1;
        int range = max - min + 1;


        for (int i = 0; i<=20; i++)
        {
            int rand = (int)(Math.random() * range) + min;
            System.out.println("Roll " + i + " = " + rand);


        }
       
       


    }
   
}




