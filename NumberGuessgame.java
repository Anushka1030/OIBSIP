import java.util.Random;
import java.util.Scanner;

class NumberGuessgame {
    private static int MIN_RANGE=1;
    private static int MAX_RANGE=100;
    private static int MAX_ATTEMPTS=10;
    private static int MAX_ROUNDS=3;


    public static void main(String[] args) 
    {
       Random r=new Random();
       Scanner sc=new Scanner(System.in);
       int totalScore=0;

       System.out.println("----------Welcome To NUMBER GUESSING GAME----------");
       System.out.println("Total Number of Rounds are : 5");
       System.out.println("Attempts to Guess Number in Each Round :10\n");
       for(int i=1;i<=MAX_ROUNDS;i++)
       {
        int number=r.nextInt(MAX_RANGE) + MIN_RANGE;
        int attempts=0;

        System.out.printf("Round %d:Guess the number between %d and %d is %d attempts:\n",i,MIN_RANGE,MAX_RANGE, MAX_ATTEMPTS);

       while(attempts < MAX_ATTEMPTS)
       {
        System.out.println("Enter your Guess Please::");
        int guess_number=sc.nextInt();
        attempts=attempts+1;
        if(guess_number == number)
        {
            int score=MAX_ATTEMPTS - attempts;
            totalScore = totalScore + score;
            System.out.printf("***CONGRATULATIONS!!*** \nYou Guessed Correct Number\n Attempts=%d.Round Score=%d\n",attempts,score);
            break;
        }
        else if(guess_number < number)
        {
            System.out.printf("The number is greater than %d ,Attempts Left=%d\n",guess_number,MAX_ATTEMPTS -  attempts);
        }
        else if (guess_number > number)
        {
            System.out.printf("The number is less than %d ,Attempts Left=%d\n",guess_number,MAX_ATTEMPTS -  attempts);   
        }
    }
    if(attempts == MAX_ATTEMPTS)
    {
        System.out.printf("\nRound =%d\n\n",number);
        System.out.println("Attempts = 0");
        System.out.printf("The Random Number is: %d\n\n",number);
    }    
        System.out.printf("GAME OVER.TOTAL SCORE =%d\n",totalScore);
        sc.close();
        }
    }
}


