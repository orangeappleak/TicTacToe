package ticTacToe;

import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;

public class layout2 extends Frame implements ActionListener{
	/**
	 * this is a test to push onto github.
	 * 
	 * 
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int steps=1;
	JButton[][] b=new JButton[10][10];
	JButton reset = new JButton("RESET");
	JLabel j1=new JLabel("Player 1s chance"),j2=new JLabel(""),j3=new JLabel("");
	JLabel j4=new JLabel("created by : AK&T");
	JLabel j5 = new JLabel("");
	int i;
	int chance = 0;
	layout2(){
		i=0;
		add(j1);
		add(j2);
		j2.setBounds(100,100,30,30);
		j2.setText("TIC TAC TOE");
		j2.setHorizontalAlignment(JLabel.CENTER);
		add(j3);
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				b[i][j]=new JButton();
				b[i][j].addActionListener(this);
				add(b[i][j]);
			}
		}
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		setLayout(new GridLayout(5,3,3,3));
		add(j4);
		setTitle("TicTacToe");
		add(reset);
		add(j5);
		reset.addActionListener(this);
		Image i = Toolkit.getDefaultToolkit().getImage("C:/Users/programmer/Desktop/download.png");
		setIconImage(i);
		j1.setHorizontalAlignment(JLabel.CENTER);
		j3.setHorizontalAlignment(JLabel.CENTER);
		j4.setHorizontalAlignment(JLabel.CENTER);
		j5.setHorizontalAlignment(JLabel.CENTER);
		setSize(350,450);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	public void actionPerformed(@SuppressWarnings("exports") ActionEvent e) {
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(chance%2==0) {
					if(e.getSource()==b[i][j]) {
						b[i][j].setText("X");
						b[i][j].setEnabled(false);
						j1.setText("");
						j3.setText("Player 2s chance");
						chance++;
					}
				}
				else if(chance%2!=0) {
					if(e.getSource()==b[i][j]) {
						b[i][j].setText("O");
						b[i][j].setEnabled(false);
						j3.setText("");
						j1.setText("Player 1s chance");
						chance++;
					}
				}
			}
		}
		CheckRandC();
		CheckDiagonals();
		draw();
		if(e.getSource()==reset) {
			for(int i=0;i<3;i++) {
				for(int j=0;j<3;j++) {
					b[i][j].setEnabled(true);
				}
			}
			reset();
		}
		if(j2.getText()=="Player 1 wins"||j2.getText()=="Player 2 wins") {
			for(int i=0;i<3;i++) {
				for(int j=0;j<3;j++) {
					b[i][j].setEnabled(false);
				}
			}
			j3.setText("");
			j1.setText("");
		}
		steps++;
	}
	void CheckRandC() {
		int count =0,count1=0;
		for(int i=0;i<3;i++) {
			count=count1=0;
			for(int k=0;k<3;k++) {
				if(b[k][i].getText()=="X") {
					count++;
					if(count == 3) {
						j2.setText("Player 1 wins");
						j5.setText("completed in:"+(steps));
					}
				}
				else if(b[k][i].getText()=="O") {
					count1++;
					if(count1==3) {
						j2.setText("Player 2 wins");
						j5.setText("completed in:"+(steps));
					}
				}
			}
			count=0;count1=0;
			for(int j=0;j<3;j++) {
				if(b[i][j].getText()=="X") {
					count++;
					if(count == 3) {
						j2.setText("Player 1 wins");
						j5.setText("completed in:"+(steps));
					}
				}
				else if(b[i][j].getText()=="O") {
					count1++;
					if(count1==3) {
						j2.setText("Player 2 wins");
						j5.setText("completed in:"+(steps));
					}
				}
			}
		}
	}
	void CheckDiagonals() {
		int i=0,j=0,count=0,count1=0,count2=0,count3=0,k=2;
		while(i<3&&j<3) {
			if(b[i][j].getText()=="X") {
				count++;
				if(count==3) {
					j2.setText("Player 1 wins");
					j5.setText("completed in:"+(steps));
				}
			}
			else if(b[i][j].getText()=="O") {
				count1++;
				if(count1==3) {
					j2.setText("Player 2 wins");
					j5.setText("completed in:"+(steps));
				}
			}
			if(b[i][k].getText()=="X") {
				count2++;
				if(count2==3) {
					j2.setText("Player 1 wins");
					j5.setText("completed in:"+(steps));
				}
			}
			else if(b[i][k].getText()=="O") {
				count3++;
				if(count3==3) {
					j2.setText("Player 2 wins");
					j5.setText("completed in:"+(steps));
				}
			}
			i++;
			j++;
			k--;
		}
	}
	public void reset() {
		steps=0;
		j5.setText("");
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				b[i][j].setText("");
				j1.setText("PLayer 1s chance");
				j3.setText("");
				j2.setText("TIC TAC TOE");
			}
		}
		chance = 0;
		}
}
 
