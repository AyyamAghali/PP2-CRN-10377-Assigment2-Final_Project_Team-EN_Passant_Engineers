package movie;

import java.net.MalformedURLException;
import java.net.URL;

public class movie{
    private String title;
    private String director;
    private int releaseYear;
    private int runningTime;
    private String imagePath;

      /**
     * Constructs a new Movie instance.
     *
     * @param title        The title of the movie.
     * @param director     The director of the movie.
     * @param releaseYear  The release year of the movie.
     * @param runningTime  The running time of the movie in minutes.
     */

    public movie(String title, String director, int releaseYear, int runningTime, String imagePath){
        this.title = title;
        this.director = director;
        this.releaseYear = releaseYear;
        this.runningTime = runningTime;
        this.imagePath = imagePath;
    }
    
    public String getTitle(){
        return this.title;
    }

      public void setTitle(String title) {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Title cannot be empty");
        }
        this.title = title;
    }

    public String getDirector(){
        return this.director;
    }

     public void setDirector(String director) {
        if (director == null || director.isEmpty()) {
            throw new IllegalArgumentException("Director cannot be empty");
        }
        this.director = director;
    }
    
    public int getYear(){
        return this.releaseYear;
    }

      public void setReleaseYear(int releaseYear) {
        if (releaseYear < 1800 || releaseYear > 2100) { // Assuming valid years
            throw new IllegalArgumentException("Invalid release year");
        }
        this.releaseYear = releaseYear;
    }


    public int getRunningTime(){
        return this.runningTime;
    }

    public void setRunningTime(int runningTime) {
        if (runningTime < 0) {
            throw new IllegalArgumentException("Running time cannot be negative");
        }
        this.runningTime = runningTime;
    }

    public String getPath(){
        return this.imagePath;
    }

    public void setPath(String imagePath){
        this.imagePath = imagePath;
    }

    public URL getURL() throws MalformedURLException{
        return new URL(this.getPath());
    }

    public String toString(){
        return this.getTitle() + " " + this.getDirector() + " " + String.valueOf(this.getYear()) + " " + String.valueOf(this.getRunningTime()) + " minutes";
    }
       @Override
    public int compareTo(Movie other) {
        return this.title.compareTo(other.title); // Default sorting by title
    }

    
   /* / public static void main(String[] args){
        System.out.println("It will return movies!");

        movie m = new movie("The mask of zorro", "Martin Campbell", 1998, 90);
        System.out.println(m.getTitle());
        System.out.println(m.toString());
        m.setTitle("The legend of Zorro");
        System.out.println(m.toString());
    }/*/ 
}
