
public class Basketballer extends Athlete{
	private int two;
    private int three;
    private int freethrow;

    public Basketballer(){
        super("Unknown","Unknown");
        this.freethrow = 0;
        this.three = 0;
        this.two = 0;
    }
    public Basketballer(String name, String team,int two,int three,int freethrow){
        super(name,team);
        this.two = two;
        this.three = three;
        this.freethrow = freethrow;
    }
    public void setTwo(int two){
        this.two = two;
    }
    public int getTwo(){
        return this.two;
    }
    public void setThree(int three){
        this.three = three;
    }
    public int getThree(){
        return this.three;
    }
    public void setFreethrow(int freethrow){
        this.freethrow = freethrow;
    }
    public int getFreethrow() {
        return this.freethrow;
    }
    public boolean isCardUsed(){
        return true;
    }

    @Override
    int showAthletePoints() {
        return 0;
    }

}
