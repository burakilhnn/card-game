import java.util.ArrayList;
import java.util.Scanner;

public class Human extends Player{
	public Human(int id,String name,int score){
        super(id,name,score);
    }

    @Override
    void pickCard(ArrayList<String> usedList,int next,String name) {
        Scanner scanner = new Scanner(System.in);
        //System.out.println("The cards that human player have : ");
        //getCardList();
        String pickedBasketballer = "basketballer";
        String pickedFootballer = "footballer";
        if(next %2 == 0){
            int isSame = 1;
            while(isSame ==1){
                pickedFootballer = name;
                isSame = 1;
                for(int i=0;i<4;i++){
                    if(pickedFootballer.equalsIgnoreCase(cardList[0][i])){
                        isSame = 0;
                        cardList[0][i] = " ";
                        usedList.add(pickedFootballer);
                    }
                }
            }
            System.out.println("The picked footballer for human is : " +pickedFootballer);
        } else if(next %2 == 1){
            int isSame = 1;
            while (isSame == 1){
                pickedBasketballer = name;
                isSame = 1;
                for(int i=0;i<4;i++){
                    if(pickedBasketballer.equalsIgnoreCase(cardList[1][i])){
                        isSame = 0;
                        cardList[1][i] = " ";
                        usedList.add(pickedBasketballer);
                    }
                }
            }
            System.out.println("The picked basketballer for human is : " +pickedBasketballer);
        }

    }

}
