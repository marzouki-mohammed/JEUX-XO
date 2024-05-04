
import java.awt.Color;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Tic_Tac_Toe extends JFrame {
	
	JPanel monPanel ;
	JButton [][]button =new JButton[3][3];
	String playreX ="X";
	String playreO ="O";
	boolean  geme =false ;
	String currentPlayer=playreX;
	JLabel textlabel;
	int turns =1;
	public Tic_Tac_Toe() {
		super(" Tic Tac Toe !");
		this.setSize(506, 509);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		textlabel=new JLabel();
		textlabel.setBackground(Color.darkGray);
		textlabel.setForeground(Color.white);
		textlabel.setFont(new Font("Arial", Font.BOLD,50));
		textlabel.setHorizontalAlignment(JLabel.CENTER);
		textlabel.setText("Tic-Tac-Toe");
		textlabel.setOpaque(true);
		JPanel textPanel = new JPanel();
		textPanel.setLayout(new BorderLayout());
		textPanel.add(textlabel);
		this.add(textPanel,BorderLayout.NORTH);
		
		
		monPanel =new JPanel() ;
		monPanel.setLayout(new GridLayout(3,3));
		monPanel.setBackground(Color.black);
		this.add(monPanel);
		
		for(int i=0 ;i<3; i++) {
			for(int j=0 ;j<3;j++) {
				JButton tile =new JButton();
				button[i][j]=tile;
				monPanel.add(tile);
				tile.setBackground(Color.black);
				tile.setForeground(Color.white);
				tile.setFont(new Font("Arial", Font.BOLD,120));
				tile.setFocusable(false);
				//tile.setText(currentPlayer);
				tile.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						if(geme)return;
						JButton tile  =(JButton) e.getSource() ;
						if(tile.getText()=="") {
						tile.setText(currentPlayer);
						checkwiner();
						if(!geme) {
							turns++;
						if(currentPlayer==playreX) {
							currentPlayer=playreO;
						}
						else {
							currentPlayer=playreX;
						}
						textlabel.setText(currentPlayer + "'s turn.");
						}
						}
					}

					
				});
				
			}
		}
		
		
		
		
	}
	public  void checkwiner() {
		//horizontal 
		for(int i=0 ; i< 3 ; i++) {
			//if( )
			if(button[i][0].getText()==button[i][1].getText() && button[i][1].getText()==button[i][2].getText()
					&& button[i][2].getText()!="") {
				for(int j=0 ; j<3 ; j++) {
					mise(button[i][j]);
				}
				
				geme=true;
				return ;
			}
		}
		//verticle 
		for (int c =0 ;c<3 ;c++) {
			if(button[0][c].getText()==button[1][c].getText() &&
					button[1][c].getText()==button[2][c].getText() &&
					button[2][c].getText()!="") {
				for(int j=0 ;j<3 ;j++) {
					mise(button[j][c]);
				}
				
				geme=true;
				return;
				
			}
		}
		
		
		if(button[0][0].getText()==button[1][1].getText() && 
				button[1][1].getText()==button[2][2].getText()&&
				button[2][2].getText()!="") {
			for(int i=0 ;i<3 ;i++) {
				mise(button[i][i]);
			}
			
			geme=true;
			return;
		}
		
		
		if(button[0][2].getText()==button[1][1].getText() && 
				button[1][1].getText()==button[2][0].getText()&&
				button[2][0].getText()!="") {
			mise(button[0][2]);
			mise(button[1][1]);
			mise(button[2][0]);
			
			geme=true;
			return;
		}
		if(turns==9) {
			for ( int i=0 ;i<3 ;i++) {
				for(int j=0 ;j<3;j++) {
					button[i][j].setBackground(Color.gray);
					button[i][j].setForeground(Color.orange);
					textlabel.setText(" Til !");
					
				}
			}
			geme=true;
			return;
		}
		
		
		
		
		
	}

	private void mise(JButton jButton) {
		
		jButton.setBackground(Color.gray);
		jButton.setForeground(Color.green);
		textlabel.setText(currentPlayer + " is the winner !");
	}
	public static void main(String[] args) {
		Tic_Tac_Toe tic=new Tic_Tac_Toe();
		tic.setVisible(true);
		

	}

}
