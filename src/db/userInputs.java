package db;
import java.util.Scanner;

public class userInputs {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String movieName, movieDirector;
        int runningTime, releaseYear;

        System.out.println("Movie name: ");
        movieName = scan.nextLine();
        movieDirector = scan.nextLine();
        runningTime = scan.nextInt();
        releaseYear = scan.nextInt();

        scan.close();
    }
}
