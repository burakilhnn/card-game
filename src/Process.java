import java.util.ArrayList;

import javax.swing.ImageIcon;



public class Process {
	ArrayList<Basketballer> basketballers = new ArrayList<>();
    ArrayList<Footballer> footballers = new ArrayList<>();
    ArrayList<ImageIcon> icons = new ArrayList<>();
    
	public ArrayList<Basketballer> createBasketballerCards() {
        basketballers.add(new Basketballer("LeBron James", "LA Lakers", 97, 94, 96));
        basketballers.add(new Basketballer("Shaq", "LA Lakers", 99, 11, 10));
        basketballers.add(new Basketballer("Kevin Durant", "Brooklyn Nets", 95, 94, 95));
        basketballers.add(new Basketballer("Stephen Curry", "Golden State Warriors", 94, 99, 96));
        basketballers.add(new Basketballer("James Harden", "Houston Rockets", 96, 94, 96));
        basketballers.add(new Basketballer("Kyrie Irving", "Brooklyn Nets", 96, 92, 96));
        basketballers.add(new Basketballer("Klay Thompson", "Golden State Warriors", 92, 95, 93));
        basketballers.add(new Basketballer("Damian Lillard", "Portland Trail Blazers", 97, 94, 96));

        return basketballers;
    }

    public ArrayList<Footballer> createFootballerCards() {
        footballers.add(new Footballer("Eden Hazard","Real Madrid",87,84,89));
        footballers.add(new Footballer("Toni Kroos","Real Madrid",94,90,91));
        footballers.add(new Footballer("Lionel Messi","FC Barcelona",97,98,98));
        footballers.add(new Footballer("Thomas Muller","Bayern Munich",92,93,94));
        footballers.add(new Footballer("Neymar","Paris Saint Germain",96,95,94));
        footballers.add(new Footballer("Ricardo Quaresma","Vitoria S.C",80,90,66));
        footballers.add(new Footballer("Ronaldinho","Retired",97,98,98));
        footballers.add(new Footballer("Cristiano Ronaldo","Juventus",97,98,98));

        return footballers;
    }
	
    public ArrayList<ImageIcon> createIcons(){
    	 icons.add(new ImageIcon(new ImageIcon("img/hazard.png").getImage()));
    	 icons.add(new ImageIcon(new ImageIcon("img/kroos.png").getImage()));
    	 icons.add(new ImageIcon(new ImageIcon("img/messi.png").getImage()));
    	 icons.add(new ImageIcon(new ImageIcon("img/muller.png").getImage()));
    	 icons.add(new ImageIcon(new ImageIcon("img/neymar.png").getImage()));
    	 icons.add(new ImageIcon(new ImageIcon("img/quaresma.png").getImage()));
    	 icons.add(new ImageIcon(new ImageIcon("img/ronaldinho.png").getImage()));
    	 icons.add(new ImageIcon(new ImageIcon("img/ronaldo.png").getImage()));
    	 icons.add(new ImageIcon(new ImageIcon("img/lebron.png").getImage()));
    	 icons.add(new ImageIcon(new ImageIcon("img/shaq.png").getImage()));
    	 icons.add(new ImageIcon(new ImageIcon("img/durant.png").getImage()));
    	 icons.add(new ImageIcon(new ImageIcon("img/curry.png").getImage()));
    	 icons.add(new ImageIcon(new ImageIcon("img/harden.png").getImage()));
    	 icons.add(new ImageIcon(new ImageIcon("img/irving.png").getImage()));
    	 icons.add(new ImageIcon(new ImageIcon("img/klay.png").getImage()));
    	 icons.add(new ImageIcon(new ImageIcon("img/lillard.png").getImage()));
    	 return icons;
    }
    
}
