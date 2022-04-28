import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class TicTacToe implements ActionListener{

	Random random = new Random();
	JFrame frame = new JFrame();
	JPanel title_panel =new JPanel();
	JPanel button_panel =new JPanel();
	JLabel textField = new JLabel();
	JButton buttons[] = new JButton[9];
	boolean player1_turn;
	
	
	TicTacToe(){
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 800);
		frame.getContentPane().setBackground(new Color(50,50,50));
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		
		textField.setBackground(new Color(25,225,0));
		textField.setForeground(new Color(25,25,25));
		textField.setFont(new Font("Ink free",Font.BOLD,75));
		textField.setHorizontalAlignment(JLabel.CENTER);
		textField.setText("Tic-Tac-Toe");
		textField.setOpaque(true);
		
		title_panel.setLayout(new BorderLayout());
		title_panel.setBounds(0, 0, 800, 100);
		
		button_panel.setLayout(new GridLayout(3,3));
		button_panel.setBackground(new Color(150,150,150));
		
		for(int i =0 ; i < 9 ;i++){
			buttons[i] = new JButton();
			button_panel.add(buttons[i]);
			buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(this);
			
		}
		title_panel.add(textField);
		frame.add(title_panel,BorderLayout.NORTH);
		frame.add(button_panel);
		
		firstTurn();
	}
	
	private void firstTurn() {
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(random.nextInt(2) == 0){
			player1_turn = true;
			textField.setText("X Turn");
		}
		else{
			player1_turn = false;
			textField.setText("O Turn");
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(int i = 0 ; i < 9 ; i++){
			if(e.getSource() == buttons[i]){
				if(player1_turn){
					if(buttons[i].getText() == ""){
							buttons[i].setForeground(new Color(225,0,0));
							buttons[i].setText("X");
							player1_turn = false;
							textField.setText("O Turn");
							
							check();
					}
				}
				else{
					if(buttons[i].getText() == ""){
						buttons[i].setForeground(new Color(0,0,225));
						buttons[i].setText("O");
						player1_turn = true;
						textField.setText("X  Turn");
						
						check();
				    }
				}
			}
		}
		
	}

	public void check(){
		
		if(buttons[0].getText() == "X" && buttons[1].getText() == "X" && buttons[2].getText() == "X"){
			xWin(0,1,2);
		}
		if(buttons[3].getText() == "X" && buttons[4].getText() == "X" && buttons[5].getText() == "X"){
			xWin(3,4,5);
		}
		if(buttons[6].getText() == "X" && buttons[7].getText() == "X" && buttons[8].getText() == "X"){
			xWin(6,7,8);
		}
		if(buttons[0].getText() == "X" && buttons[3].getText() == "X" && buttons[6].getText() == "X"){
			xWin(0,3,6);
		}
		if(buttons[1].getText() == "X" && buttons[4].getText() == "X" && buttons[7].getText() == "X"){
			xWin(1,4,7);
		}
		if(buttons[2].getText() == "X" && buttons[5].getText() == "X" && buttons[8].getText() == "X"){
			xWin(2,5,8);
		}
		if(buttons[0].getText() == "X" && buttons[4].getText() == "X" && buttons[8].getText() == "X"){
			xWin(0,4,8);
		}
		if(buttons[2].getText() == "X" && buttons[4].getText() == "X" && buttons[6].getText() == "X"){
			xWin(2,4,6);
		}
		
		
		if(buttons[0].getText() == "O" && buttons[1].getText() == "O" && buttons[2].getText() == "O"){
			oWin(0,1,2);
		}
		if(buttons[3].getText() == "O" && buttons[4].getText() == "O" && buttons[5].getText() == "O"){
			oWin(3,4,5);
		}
		if(buttons[6].getText() == "O" && buttons[7].getText() == "O" && buttons[8].getText() == "O"){
			oWin(6,7,8);
		}
		if(buttons[0].getText() == "O" && buttons[3].getText() == "O" && buttons[6].getText() == "O"){
			oWin(0,3,6);
		}
		if(buttons[1].getText() == "O" && buttons[4].getText() == "O" && buttons[7].getText() == "O"){
			oWin(1,4,7);
		}
		if(buttons[2].getText() == "O" && buttons[5].getText() == "O" && buttons[8].getText() == "O"){
			oWin(2,5,8);
		}
		if(buttons[0].getText() == "O" && buttons[4].getText() == "O" && buttons[8].getText() == "O"){
			oWin(0,4,8);
		}
		if(buttons[2].getText() == "O" && buttons[4].getText() == "O" && buttons[6].getText() == "O"){
			oWin(2,4,6);
		}
		
	}
	
    public void xWin(int a , int b , int c){
		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);
		
		for(int i = 0 ; i < 9 ; i++){
			buttons[i].setEnabled(false);
		}
		
		textField.setText("X Win");
		
	}
    
    public void oWin(int a , int b , int c){
		
    	buttons[a].setBackground(Color.ORANGE);
		buttons[b].setBackground(Color.ORANGE);
		buttons[c].setBackground(Color.ORANGE);
		
		for(int i = 0 ; i < 9 ; i++){
			buttons[i].setEnabled(false);
		}
		
		textField.setText("O Win");
	}  
	
}
