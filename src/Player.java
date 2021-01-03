import java.util.ArrayList;

public abstract class Player {
	private int playerID;
    private String name;
    private int score;
    public String cardList[][] = new String[2][4];

    public Player(){
       this(0,"Unknown",0);
    }

    public Player(int id,String name,int score){
        this.playerID = id;
        this.name = name;
        this.score = score;
    }
    public void setPlayerID(int id){
        this.playerID = id;
    }
    public int getPlayerID(){
        return this.playerID;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setScore(int score){
        this.score += score;
    }
    public int getScore(){
        return this.score;
    }
    public String[][] getCardList() {
        for(int i=0; i<2;i++){
            for(int j=0;j<4;j++){
                System.out.println(cardList[i][j]);
            }
        }
        return cardList;
    }
    public void setCardList(String[][] cardList) {
        this.cardList = cardList;
    }
    public void showScore(){
        System.out.println("The score of "+this.name+" is "+this.score);
    }
    abstract void pickCard(ArrayList<String> usedList, int next,String name);
}
