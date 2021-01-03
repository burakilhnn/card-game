import java.util.ArrayList;
import java.util.Random;

public class Computer extends Player{
	public Computer(int id, String name, int score) {
        super(id, name, score);
    }

    @Override
    void pickCard(ArrayList<String> usedList,int next,String name) {
        //System.out.println("The cards that computer player have : ");
        //getCardList();
        Random random = new Random();
        int rand = random.nextInt(4);
        String pickedAthlete = "athlete";
        if(next % 2 == 0) {
            while (cardList[0][rand] == "") {
                rand = random.nextInt(4);
            }
            pickedAthlete = cardList[0][rand];
            cardList[0][rand] = "";
            usedList.add(pickedAthlete);
            System.out.println("The picked footballer for computer is : " +pickedAthlete);
        }else if(next % 2 == 1){
            while (cardList[1][rand] == "") {
                rand = random.nextInt(4);
            }
            pickedAthlete = cardList[1][rand];
            cardList[1][rand] = "";
            usedList.add(pickedAthlete);
            System.out.println("The picked basketballer for computer is : " +pickedAthlete);
        }

    }
}
