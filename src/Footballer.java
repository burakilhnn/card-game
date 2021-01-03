
public class Footballer extends Athlete{
	private int penalty;
    private int freekick;
    private int one_on_ones;

    public Footballer(){
        super("Unknown","Unknown");
        this.penalty = 0;
        this.freekick = 0;
        this.one_on_ones = 0;
    }
    public Footballer(String name, String team,int pen,int free,int one){
        super(name,team);
        this.penalty = pen;
        this.freekick = free;
        this.one_on_ones = one;
    }
    public void setPenalty(int penalty){
        this.penalty = penalty;
    }
    public int getPenalty(){
        return this.penalty;
    }
    public void setFreekick(int freekick){
        this.freekick = freekick;
    }
    public int getFreekick(){
        return this.freekick;
    }
    public void setOne_on_ones(int on){
        this.one_on_ones = on;
    }
    public int getOne_on_ones() {
        return this.one_on_ones;
    }
    public boolean isCardUsed(){
        return true;
    }

    @Override
    int showAthletePoints() {
        return 0;
    }
}
