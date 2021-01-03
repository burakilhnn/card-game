
public abstract class Athlete {
	private String name;
    private String team;

    public Athlete(){
        this("Unknown","Unknown");
    }
    public Athlete(String name, String team){
        this.name = name;
        this.team = team;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
    public void setTeam(String team){
        this.team = team;
    }
    public String getTeam() {
        return this.team;
    }
    abstract int showAthletePoints();
}
