package movie;
public class movie{
    private String title;
    private String director;
    private int releaseYear;
    private int runningTime;

    public movie(String title, String director, int releaseYear, int runningTime){
        this.title = title;
        this.director = director;
        this.releaseYear = releaseYear;
        this.runningTime = runningTime;
    }
    
    public String getTitle(){
        return this.title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getDirector(){
        return this.director;
    }

    public void setDirector(String director){
        this.director = director;
    }
    
    public int getYear(){
        return this.releaseYear;
    }

    public void setYear(int releaseYear){
        this.releaseYear = releaseYear;
    }

    public int getRunningTime(){
        return this.runningTime;
    }

    public void setRunningTime(){
        this.runningTime = runningTime;
    }

    public String toString(){
        return this.getTitle() + " " + this.getDirector() + " " + String.valueOf(this.getYear()) + " " + String.valueOf(this.getRunningTime()) + " minutes";
    }
    
    public static void main(String[] args){
        System.out.println("It will return movies!");

        movie m = new movie("The mask of zorro", "Martin Campbell", 1998, 90);
        System.out.println(m.getTitle());
        System.out.println(m.toString());
        m.setTitle("The legend of Zorro");
        System.out.println(m.toString());
    }
}