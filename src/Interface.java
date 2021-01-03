import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;
import java.awt.Font;

public class Interface {

	private JFrame frame;
	private JLabel label1;
	private JLabel lbl1;
	private JLabel lbl2;
	private JLabel lbl3;
	private JLabel lbl4;
	private JLabel lbl5;
	private JLabel lbl6;
	private JLabel lbl7;
	private JLabel lbl8;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private JLabel label5;
	private JLabel label6;
	private JLabel label7;
	private JLabel label8;
	private JLabel labelPick1;
	private JLabel labelPick2;
	private JButton btnSkill1;
	private JButton btnSkill2;
	private JButton btnSkill3;
	private JLabel playerName1;
	private JLabel playerName2;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private int cardnum = 0,buttonpick = 0;
	String[][] player1List = new String[2][4];
	String[][] player2List = new String[2][4];
	private int next1 = 0, next2 = 0;
	int pickedSkillHuman, pickedSkillComp,pickedSkill;
	private int find1,find2,find3,find4,find5,find6,find7,find8;
	private int findc1,findc2,findc3,findc4,findc5,findc6,findc7,findc8;
	String name = "";
	int a;
	
	Image back = new ImageIcon(this.getClass().getResource("back.png")).getImage();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
        
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface window = new Interface();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Interface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Process process = new Process();
		Player player1 = new Human(1,"Burak",0);
        Player player2 = new Computer(2,"Computer",0);
        ArrayList<Basketballer> basketballers = process.createBasketballerCards();
        ArrayList<Footballer> footballers = process.createFootballerCards();
        ArrayList<ImageIcon> icons = process.createIcons();
        
        int c, b = 0;
        Random random = new Random();
        Set<Integer> set = new LinkedHashSet<Integer>();
        while (set.size() < 4) {
            set.add(random.nextInt(8));
        }
        Object[] array = set.toArray();

        for(int i=0;i<4;i++){
            player1List[0][i] = footballers.get((int) array[i]).getName();
        }
        for(int i=0;i<4;i++){
            player1List[1][i] = basketballers.get((int) array[i]).getName();
        }

        for(int i=0;i<8;i++){
            c=0;
            for(int j=0;j<4;j++){
                if(footballers.get(i).getName().equalsIgnoreCase(player1List[0][j])){
                    c = 1;
                }
            }
            if(c==0){
                player2List[0][b] = footballers.get(i).getName();
                b++;
            }
        }

        b = 0;
        for(int i=0;i<8;i++){
            c=0;
            for(int j=0;j<4;j++){
                if(basketballers.get(i).getName().equalsIgnoreCase(player1List[1][j])){
                    c = 1;
                }
            }
            if(c==0){
                player2List[1][b] = basketballers.get(i).getName();
                b++;
            }
        }  
        player1.setCardList(player1List);
        player2.setCardList(player2List);
    
        ArrayList<String> usedList1 = new ArrayList<>();
        ArrayList<String> usedList2 = new ArrayList<>(); 
        
        
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(95, 158, 160));
		frame.setForeground(new Color(255, 255, 255));
		frame.setBackground(new Color(255, 255, 255));
		frame.setBounds(500, 500, 1513, 912);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lbl1 = new JLabel("");
		for(int i=0;i<8;i++) {
			if(player1List[0][0].equalsIgnoreCase(footballers.get(i).getName())) {
				find1 = i;
				break;
			}
		}
		lbl1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(next1 %2 == 1) {
					JOptionPane.showMessageDialog(null, "Please pick a basketballer card!");
				} else {
				a = 1;
				player1.pickCard(usedList1,next1,player1List[0][0]);
				player2.pickCard(usedList2, next2, name);
				for(int i=0;i<8;i++) {
					if(usedList2.get(next2).equalsIgnoreCase(footballers.get(i).getName())) {
						findc1 = i;
						break;
					}
				}
				
				lbl1.setVisible(false);
				labelPick1.setIcon(new ImageIcon(back));
				labelPick1.setVisible(true);
				label7.setVisible(false);
				labelPick2.setIcon(new ImageIcon(back));
				labelPick2.setVisible(true);
				next1++; 
				next2++;
				}
			}
		});
		lbl1.setIcon(icons.get(find1));
		lbl1.setBounds(10, 613, 163, 249);
		frame.getContentPane().add(lbl1);
		
		lbl2 = new JLabel("");
		for(int i=0;i<8;i++) {
			if(player1List[1][0].equalsIgnoreCase(basketballers.get(i).getName())) {
				find2 = i+8;
				break;
			}
		}
		lbl2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(next1 % 2 == 0) {
					JOptionPane.showMessageDialog(null, "Please pick a footballer card!");
				} else {
					a = 2;
					player1.pickCard(usedList1,next1,player1List[1][0]);
					player2.pickCard(usedList2, next2, name);
					for(int i=0;i<8;i++) {
						if(usedList2.get(next2).equalsIgnoreCase(basketballers.get(i).getName())) {
							findc2 = i;
							break;
						}
					}
					lbl2.setVisible(false);
					labelPick1.setIcon(new ImageIcon(back));
					labelPick1.setVisible(true);
					label4.setVisible(false);
					labelPick2.setIcon(new ImageIcon(back));
					labelPick2.setVisible(true);
					next1++; 
					next2++;
				}
			}
		});
		lbl2.setIcon(icons.get(find2));
		lbl2.setBounds(183, 613, 163, 249);
		frame.getContentPane().add(lbl2);
		
		lbl3 = new JLabel("");
		for(int i=0;i<8;i++) {
			if(player1List[0][1].equalsIgnoreCase(footballers.get(i).getName())) {
				find3 = i;
				break;
			}
		}
		lbl3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(next1 %2 == 1) {
					JOptionPane.showMessageDialog(null, "Please pick a basketballer card!");
				} else {
				a = 3;
				player1.pickCard(usedList1,next1,player1List[0][1]);
				player2.pickCard(usedList2, next2, name);
				for(int i=0;i<8;i++) {
					if(usedList2.get(next2).equalsIgnoreCase(footballers.get(i).getName())) {
						findc3 = i;
						break;
					}
				}
				lbl3.setVisible(false);
				labelPick1.setIcon(new ImageIcon(back));
				labelPick1.setVisible(true);
				label1.setVisible(false);
				labelPick2.setIcon(new ImageIcon(back));
				labelPick2.setVisible(true);
				next1++; 
				next2++;
				}
			}
		});
		lbl3.setIcon(icons.get(find3));
		lbl3.setBounds(356, 613, 163, 249);
		frame.getContentPane().add(lbl3);
		
		lbl4 = new JLabel("");
		for(int i=0;i<8;i++) {
			if(player1List[1][1].equalsIgnoreCase(basketballers.get(i).getName())) {
				find4 = i+8;
				break;
			}
		}
		lbl4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(next1 %2 == 0) {
					JOptionPane.showMessageDialog(null, "Please pick a footballer card!");
				} else {
				a = 4;
				player1.pickCard(usedList1,next1,player1List[1][1]);
				player2.pickCard(usedList2, next2, name);
				for(int i=0;i<8;i++) {
					if(usedList2.get(next2).equalsIgnoreCase(basketballers.get(i).getName())) {
						findc4 = i;
						break;
					}
				}
				lbl4.setVisible(false);
				labelPick1.setIcon(new ImageIcon(back));
				labelPick1.setVisible(true);
				label6.setVisible(false);
				labelPick2.setIcon(new ImageIcon(back));
				labelPick2.setVisible(true);
				next1++; 
			    next2++;
				}
			}
		});
		lbl4.setIcon(icons.get(find4));
		lbl4.setBounds(529, 613, 163, 249);
		frame.getContentPane().add(lbl4);
		
		label1 = new JLabel("");
		label1.setIcon(new ImageIcon(back));
		label1.setBounds(10, 11, 163, 249);
		frame.getContentPane().add(label1);
		
		label2 = new JLabel("");
		label2.setIcon(new ImageIcon(back));
		label2.setBounds(183, 11, 163, 249);
		frame.getContentPane().add(label2);
		
		label3 = new JLabel("");
		label3.setIcon(new ImageIcon(back));
		label3.setBounds(356, 11, 163, 249);
		frame.getContentPane().add(label3);
		
		label4 = new JLabel("");
		label4.setIcon(new ImageIcon(back));
		label4.setBounds(529, 11, 163, 249);
		frame.getContentPane().add(label4);
		
		lbl5 = new JLabel("");
		for(int i=0;i<8;i++) {
			if(player1List[0][2].equalsIgnoreCase(footballers.get(i).getName())) {
				find5 = i;
				break;
			}
		}
		lbl5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(next1 %2 == 1) {
					JOptionPane.showMessageDialog(null, "Please pick a basketballer card!");
				} else {
				a = 5;
				player1.pickCard(usedList1,next1,player1List[0][2]);
				player2.pickCard(usedList2, next2, name);
				for(int i=0;i<8;i++) {
					if(usedList2.get(next2).equalsIgnoreCase(footballers.get(i).getName())) {
						findc5 = i;
						break;
					}
				}
				lbl5.setVisible(false);
				labelPick1.setIcon(new ImageIcon(back));
				labelPick1.setVisible(true);
				label2.setVisible(false);
				labelPick2.setIcon(new ImageIcon(back));
				labelPick2.setVisible(true);
				next1++;
				next2++;
				}
			}
		});
		lbl5.setIcon(icons.get(find5));
		lbl5.setBounds(702, 613, 163, 249);
		frame.getContentPane().add(lbl5);
		
		lbl6 = new JLabel("");
		for(int i=0;i<8;i++) {
			if(player1List[1][2].equalsIgnoreCase(basketballers.get(i).getName())) {
				find6 = i+8;
				break;
			}
		}
		lbl6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(next1 %2 == 0) {
					JOptionPane.showMessageDialog(null, "Please pick a footballer card!");
				} else {
				a = 6;
				player1.pickCard(usedList1,next1,player1List[1][2]);
				player2.pickCard(usedList2, next2, name);
				for(int i=0;i<8;i++) {
					if(usedList2.get(next2).equalsIgnoreCase(basketballers.get(i).getName())) {
						findc6 = i;
						break;
					}
				}
				lbl6.setVisible(false);
				labelPick1.setIcon(new ImageIcon(back));
				labelPick1.setVisible(true);
				label5.setVisible(false);
				labelPick2.setIcon(new ImageIcon(back));
				labelPick2.setVisible(true);
				next1++; 
				next2++;
				}
			}
		});
		lbl6.setIcon(icons.get(find6));
		lbl6.setBounds(875, 613, 163, 249);
		frame.getContentPane().add(lbl6);
		
		lbl7 = new JLabel("");
		for(int i=0;i<8;i++) {
			if(player1List[0][3].equalsIgnoreCase(footballers.get(i).getName())) {
				find7 = i;
				break;
			}
		}
		lbl7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(next1 %2 == 1) {
					JOptionPane.showMessageDialog(null, "Please pick a basketballer card!");
				} else {
				a = 7;
				player1.pickCard(usedList1,next1,player1List[0][3]);
				player2.pickCard(usedList2, next2, name);
				for(int i=0;i<8;i++) {
					if(usedList2.get(next2).equalsIgnoreCase(footballers.get(i).getName())) {
						findc7 = i;
						break;
					}
				}
				lbl7.setVisible(false);
				labelPick1.setIcon(new ImageIcon(back));
				labelPick1.setVisible(true);
				label8.setVisible(false);
				labelPick2.setIcon(new ImageIcon(back));
				labelPick2.setVisible(true);
				next1++;
				next2++;
				}
			}
		});
		lbl7.setIcon(icons.get(find7));
		lbl7.setBounds(1048, 613, 163, 249);
		frame.getContentPane().add(lbl7);
		
		lbl8 = new JLabel("");
		for(int i=0;i<8;i++) {
			if(player1List[1][3].equalsIgnoreCase(basketballers.get(i).getName())) {
				find8 = i+8;
				break;
			}
		}
		lbl8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(next1 %2 == 0) {
					JOptionPane.showMessageDialog(null, "Please pick a footballer card!");
				} else {
				a = 8;
				player1.pickCard(usedList1,next1,player1List[1][3]);
				player2.pickCard(usedList2, next2, name);
				for(int i=0;i<8;i++) {
					if(usedList2.get(next2).equalsIgnoreCase(basketballers.get(i).getName())) {
						findc8 = i;
						break;
					}
				}
				lbl8.setVisible(false);
				labelPick1.setIcon(new ImageIcon(back));
				labelPick1.setVisible(true);
				label3.setVisible(false);
				labelPick2.setIcon(new ImageIcon(back));
				labelPick2.setVisible(true);
				next1++;
				next2++;
				}
			}
		});
		lbl8.setIcon(icons.get(find8));
		lbl8.setBounds(1221, 613, 163, 249);
		frame.getContentPane().add(lbl8);
		
		label5 = new JLabel("");
		label5.setIcon(new ImageIcon(back));
		label5.setBounds(702, 11, 163, 249);
		frame.getContentPane().add(label5);
		
		label6 = new JLabel("");
		label6.setIcon(new ImageIcon(back));
		label6.setBounds(875, 11, 163, 249);
		frame.getContentPane().add(label6);
		
		label7 = new JLabel("");
		label7.setIcon(new ImageIcon(back));
		label7.setBounds(1048, 11, 163, 249);
		frame.getContentPane().add(label7);
		
		label8 = new JLabel("");
		label8.setIcon(new ImageIcon(back));
		label8.setBounds(1221, 11, 163, 249);
		frame.getContentPane().add(label8);
		
		labelPick1 = new JLabel("");
		labelPick1.setForeground(new Color(0, 0, 0));
		labelPick1.setBackground(new Color(0, 0, 0));
		labelPick1.setBounds(433, 316, 163, 249);
		frame.getContentPane().add(labelPick1);
		
		labelPick2 = new JLabel("");
		labelPick2.setBackground(new Color(0, 0, 0));
		labelPick2.setBounds(640, 316, 163, 249);
		frame.getContentPane().add(labelPick2);
		
		JButton btnNewButton = new JButton("Next Round");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(cardnum%2 == 0) {
					btnSkill1.setText("Two points");
					btnSkill2.setText("Three points");
					btnSkill3.setText("Free throw");
				} else if(cardnum %2 == 1) {
					btnSkill1.setText("Penalty");
					btnSkill2.setText("Freekick");
					btnSkill3.setText("One on Ones");
				}
				btnSkill1.setVisible(true);
				btnSkill2.setVisible(true);
				btnSkill3.setVisible(true);
				labelPick1.setVisible(false);
				labelPick2.setVisible(false);
				lblNewLabel_2.setText(Integer.toString(player2.getScore()));
				lblNewLabel_3.setText(Integer.toString(player1.getScore()));
				cardnum++;
				if(cardnum == 7) {
					btnNewButton.setText("Finish");
				}
				if(cardnum == 8) {
					if(player1.getScore() > player2.getScore()) {
						String s = "Game is over. "+player1.getName()+" won!";
						JOptionPane.showMessageDialog(null, s);
					} else if(player1.getScore() < player2.getScore()) {
						String s = "Game is over. "+player2.getName()+" won!";
						JOptionPane.showMessageDialog(null, s);
					} else {
						JOptionPane.showMessageDialog(null, "Draw!");
					}
				}
			}
		});
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(186, 85, 211));
		btnNewButton.setBounds(1355, 406, 132, 78);
		frame.getContentPane().add(btnNewButton);
		
		btnSkill1 = new JButton("");
		btnSkill1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pickedSkill = 0;
				btnSkill1.setVisible(false);
				btnSkill2.setVisible(false);
				btnSkill3.setVisible(false);
				
				if(a==1) {
						if(footballers.get(find1).getPenalty() > footballers.get(findc1).getPenalty()) {
							player1.setScore(10);
						}else if(footballers.get(find1).getPenalty() < footballers.get(findc1).getPenalty()) {
							player2.setScore(10);
						}else {
							System.out.println("Draw!");
						}
					labelPick1.setIcon(icons.get(find1));
					labelPick1.setVisible(true);
					labelPick2.setIcon(icons.get(findc1));
					labelPick2.setVisible(true);
				} else if(a==2) {
						if(basketballers.get(find2-8).getTwo() > basketballers.get(findc2).getTwo()) {
							player1.setScore(10);
						}else if(basketballers.get(find2-8).getTwo() < basketballers.get(findc2).getTwo()) {
							player2.setScore(10);
						}else {
							System.out.println("Draw!");
						}
					
					labelPick1.setIcon(icons.get(find2));
					labelPick1.setVisible(true);
					labelPick2.setIcon(icons.get(findc2+8));
					labelPick2.setVisible(true);
				} else if(a==3) {
					if(footballers.get(find3).getPenalty() > footballers.get(findc3).getPenalty()) {
						player1.setScore(10);
					}else if(footballers.get(find3).getPenalty() < footballers.get(findc3).getPenalty()) {
						player2.setScore(10);
					}else {
						System.out.println("Draw!");
					}
				labelPick1.setIcon(icons.get(find3));
				labelPick1.setVisible(true);
				labelPick2.setIcon(icons.get(findc3));
				labelPick2.setVisible(true);
				} else if(a==4) {
					if(basketballers.get(find4-8).getTwo() > basketballers.get(findc4).getTwo()) {
						player1.setScore(10);
					}else if(basketballers.get(find4-8).getTwo() < basketballers.get(findc4).getTwo()) {
						player2.setScore(10);
					}else {
						System.out.println("Draw!");
					}
				
				labelPick1.setIcon(icons.get(find4));
				labelPick1.setVisible(true);
				labelPick2.setIcon(icons.get(findc4+8));
				labelPick2.setVisible(true);
				} else if(a==5) {
					if(footballers.get(find5).getPenalty() > footballers.get(findc5).getPenalty()) {
						player1.setScore(10);
					}else if(footballers.get(find5).getPenalty() < footballers.get(findc5).getPenalty()) {
						player2.setScore(10);
					}else {
						System.out.println("Draw!");
					}
				labelPick1.setIcon(icons.get(find5));
				labelPick1.setVisible(true);
				labelPick2.setIcon(icons.get(findc5));
				labelPick2.setVisible(true);
				} else if(a==6) {
					if(basketballers.get(find6-8).getTwo() > basketballers.get(findc6).getTwo()) {
						player1.setScore(10);
					}else if(basketballers.get(find6-8).getTwo() < basketballers.get(findc6).getTwo()) {
						player2.setScore(10);
					}else {
						System.out.println("Draw!");
					}
				
				labelPick1.setIcon(icons.get(find6));
				labelPick1.setVisible(true);
				labelPick2.setIcon(icons.get(findc6+8));
				labelPick2.setVisible(true);
				} else if(a==7) {
					if(footballers.get(find7).getPenalty() > footballers.get(findc7).getPenalty()) {
						player1.setScore(10);
					}else if(footballers.get(find7).getPenalty() < footballers.get(findc7).getPenalty()) {
						player2.setScore(10);
					}else {
						System.out.println("Draw!");
					}
				labelPick1.setIcon(icons.get(find7));
				labelPick1.setVisible(true);
				labelPick2.setIcon(icons.get(findc7));
				labelPick2.setVisible(true);
				} else if(a==8) {
					if(basketballers.get(find8-8).getTwo() > basketballers.get(findc8).getTwo()) {
						player1.setScore(10);
					}else if(basketballers.get(find8-8).getTwo() < basketballers.get(findc8).getTwo()) {
						player2.setScore(10);
					}else {
						System.out.println("Draw!");
					}
				
				labelPick1.setIcon(icons.get(find8));
				labelPick1.setVisible(true);
				labelPick2.setIcon(icons.get(findc8+8));
				labelPick2.setVisible(true);
				}
				
			}
		});
		btnSkill1.setText("Penalty");
		btnSkill1.setBounds(864, 328, 140, 40);
		frame.getContentPane().add(btnSkill1);
		
		btnSkill2 = new JButton("");
		btnSkill2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pickedSkill = 1;
				btnSkill1.setVisible(false);
				btnSkill2.setVisible(false);
				btnSkill3.setVisible(false);
				if(a==1) {
					if(footballers.get(find1).getFreekick() > footballers.get(findc1).getFreekick()) {
						player1.setScore(10);
					}else if(footballers.get(find1).getFreekick() < footballers.get(findc1).getFreekick()) {
						player2.setScore(10);
					}else {
						System.out.println("Draw!");
					}
					labelPick1.setIcon(icons.get(find1));
					labelPick1.setVisible(true);
					labelPick2.setIcon(icons.get(findc1));
					labelPick2.setVisible(true);
				} else if(a==2) {
					if(basketballers.get(find2-8).getThree() > basketballers.get(findc2).getThree()) {
						player1.setScore(10);
					}else if(basketballers.get(find2-8).getThree() < basketballers.get(findc2).getThree()) {
						player2.setScore(10);
					}else {
						System.out.println("Draw!");
					}
					labelPick1.setIcon(icons.get(find2));
					labelPick1.setVisible(true);
					labelPick2.setIcon(icons.get(findc2+8));
					labelPick2.setVisible(true);
				} else if(a==3) {
					if(footballers.get(find3).getFreekick() > footballers.get(findc3).getFreekick()) {
						player1.setScore(10);
					}else if(footballers.get(find3).getFreekick() < footballers.get(findc3).getFreekick()) {
						player2.setScore(10);
					}else {
						System.out.println("Draw!");
					}
					labelPick1.setIcon(icons.get(find3));
					labelPick1.setVisible(true);
					labelPick2.setIcon(icons.get(findc3));
					labelPick2.setVisible(true);
				} else if(a==4) {
					if(basketballers.get(find4-8).getThree() > basketballers.get(findc4).getThree()) {
						player1.setScore(10);
					}else if(basketballers.get(find4-8).getThree() < basketballers.get(findc4).getThree()) {
						player2.setScore(10);
					}else {
						System.out.println("Draw!");
					}
					labelPick1.setIcon(icons.get(find4));
					labelPick1.setVisible(true);
					labelPick2.setIcon(icons.get(findc4+8));
					labelPick2.setVisible(true);
				} else if(a==5) {
					if(footballers.get(find5).getFreekick() > footballers.get(findc5).getFreekick()) {
						player1.setScore(10);
					}else if(footballers.get(find5).getFreekick() < footballers.get(findc5).getFreekick()) {
						player2.setScore(10);
					}else {
						System.out.println("Draw!");
					}
					labelPick1.setIcon(icons.get(find5));
					labelPick1.setVisible(true);
					labelPick2.setIcon(icons.get(findc5));
					labelPick2.setVisible(true);
				} else if(a==6) {
					if(basketballers.get(find6-8).getThree() > basketballers.get(findc6).getThree()) {
						player1.setScore(10);
					}else if(basketballers.get(find6-8).getThree() < basketballers.get(findc6).getThree()) {
						player2.setScore(10);
					}else {
						System.out.println("Draw!");
					}
					labelPick1.setIcon(icons.get(find6));
					labelPick1.setVisible(true);
					labelPick2.setIcon(icons.get(findc6+8));
					labelPick2.setVisible(true);
				} else if(a==7) {
					if(footballers.get(find7).getFreekick() > footballers.get(findc7).getFreekick()) {
						player1.setScore(10);
					}else if(footballers.get(find7).getFreekick() < footballers.get(findc7).getFreekick()) {
						player2.setScore(10);
					}else {
						System.out.println("Draw!");
					}
					labelPick1.setIcon(icons.get(find7));
					labelPick1.setVisible(true);
					labelPick2.setIcon(icons.get(findc7));
					labelPick2.setVisible(true);
				} else if(a==8) {
					if(basketballers.get(find8-8).getThree() > basketballers.get(findc8).getThree()) {
						player1.setScore(10);
					}else if(basketballers.get(find8-8).getThree() < basketballers.get(findc8).getThree()) {
						player2.setScore(10);
					}else {
						System.out.println("Draw!");
					}
					labelPick1.setIcon(icons.get(find8));
					labelPick1.setVisible(true);
					labelPick2.setIcon(icons.get(findc8+8));
					labelPick2.setVisible(true);
				}
			}
		});
		btnSkill2.setText("Freekick");
		btnSkill2.setBounds(864, 396, 140, 40);
		frame.getContentPane().add(btnSkill2);
		
		btnSkill3 = new JButton("");
		btnSkill3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pickedSkill = 2;
				btnSkill1.setVisible(false);
				btnSkill2.setVisible(false);
				btnSkill3.setVisible(false);
				if(a==1) {
					if(footballers.get(find1).getOne_on_ones() > footballers.get(findc1).getOne_on_ones()) {
						player1.setScore(10);
					}else if(footballers.get(find1).getOne_on_ones() < footballers.get(findc1).getOne_on_ones()) {
						player2.setScore(10);
					}else {
						System.out.println("Draw!");
					}
					labelPick1.setIcon(icons.get(find1));
					labelPick1.setVisible(true);
					labelPick2.setIcon(icons.get(findc1));
					labelPick2.setVisible(true);
				} else if(a==2) {
					if(basketballers.get(find2-8).getFreethrow() > basketballers.get(findc2).getFreethrow()) {
						player1.setScore(10);
					}else if(basketballers.get(find2-8).getFreethrow() < basketballers.get(findc2).getFreethrow()) {
						player2.setScore(10);
					}else {
						System.out.println("Draw!");
					}
					labelPick1.setIcon(icons.get(find2));
					labelPick1.setVisible(true);
					labelPick2.setIcon(icons.get(findc2+8));
					labelPick2.setVisible(true);
				} else if(a==3) {
					if(footballers.get(find3).getOne_on_ones() > footballers.get(findc3).getOne_on_ones()) {
						player1.setScore(10);
					}else if(footballers.get(find3).getOne_on_ones() < footballers.get(findc3).getOne_on_ones()) {
						player2.setScore(10);
					}else {
						System.out.println("Draw!");
					}
					labelPick1.setIcon(icons.get(find3));
					labelPick1.setVisible(true);
					labelPick2.setIcon(icons.get(findc3));
					labelPick2.setVisible(true);
				} else if(a==4) {
					if(basketballers.get(find4-8).getFreethrow() > basketballers.get(findc4).getFreethrow()) {
						player1.setScore(10);
					}else if(basketballers.get(find4-8).getFreethrow() < basketballers.get(findc4).getFreethrow()) {
						player2.setScore(10);
					}else {
						System.out.println("Draw!");
					}
					labelPick1.setIcon(icons.get(find4));
					labelPick1.setVisible(true);
					labelPick2.setIcon(icons.get(findc4+8));
					labelPick2.setVisible(true);
				} else if(a==5) {
					if(footballers.get(find5).getOne_on_ones() > footballers.get(findc5).getOne_on_ones()) {
						player1.setScore(10);
					}else if(footballers.get(find5).getOne_on_ones() < footballers.get(findc5).getOne_on_ones()) {
						player2.setScore(10);
					}else {
						System.out.println("Draw!");
					}
					labelPick1.setIcon(icons.get(find5));
					labelPick1.setVisible(true);
					labelPick2.setIcon(icons.get(findc5));
					labelPick2.setVisible(true);
				} else if(a==6) {
					if(basketballers.get(find6-8).getFreethrow() > basketballers.get(findc6).getFreethrow()) {
						player1.setScore(10);
					}else if(basketballers.get(find6-8).getFreethrow() < basketballers.get(findc6).getFreethrow()) {
						player2.setScore(10);
					}else {
						System.out.println("Draw!");
					}
					labelPick1.setIcon(icons.get(find6));
					labelPick1.setVisible(true);
					labelPick2.setIcon(icons.get(findc6+8));
					labelPick2.setVisible(true);
				} else if(a==7) {
					if(footballers.get(find7).getOne_on_ones() > footballers.get(findc7).getOne_on_ones()) {
						player1.setScore(10);
					}else if(footballers.get(find7).getOne_on_ones() < footballers.get(findc7).getOne_on_ones()) {
						player2.setScore(10);
					}else {
						System.out.println("Draw!");
					}
					labelPick1.setIcon(icons.get(find7));
					labelPick1.setVisible(true);
					labelPick2.setIcon(icons.get(findc7));
					labelPick2.setVisible(true);
				} else if(a==8) {
					if(basketballers.get(find8-8).getFreethrow() > basketballers.get(findc8).getFreethrow()) {
						player1.setScore(10);
					}else if(basketballers.get(find8-8).getFreethrow() < basketballers.get(findc8).getFreethrow()) {
						player2.setScore(10);
					}else {
						System.out.println("Draw!");
					}
					labelPick1.setIcon(icons.get(find8));
					labelPick1.setVisible(true);
					labelPick2.setIcon(icons.get(findc8+8));
					labelPick2.setVisible(true);
				}
			}
		});
		btnSkill3.setText("One on Ones");
		btnSkill3.setBounds(864, 464, 140, 40);
		frame.getContentPane().add(btnSkill3);
		
		playerName1 = new JLabel("");
		playerName1.setText(player2.getName());
		playerName1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));
		playerName1.setBounds(10, 283, 163, 48);
		frame.getContentPane().add(playerName1);
		
		playerName2 = new JLabel("");
		playerName2.setText(player1.getName());
		playerName2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));
		playerName2.setBounds(10, 479, 163, 48);
		frame.getContentPane().add(playerName2);
		
		JLabel lblNewLabel = new JLabel("SCORE : ");
		lblNewLabel.setBounds(10, 552, 57, 27);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("SCORE : ");
		lblNewLabel_1.setBounds(10, 356, 57, 27);
		frame.getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setText(Integer.toString(0));
		lblNewLabel_2.setBounds(66, 362, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setText(Integer.toString(0));
		lblNewLabel_3.setBounds(66, 558, 46, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
	}
}
