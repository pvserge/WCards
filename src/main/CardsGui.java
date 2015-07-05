package main;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.*;

public class CardsGui {
	
	private String labelText = "Please click to start";
	JFrame frame;
	JLabel label;
	int clickCounter = 0;
	Loader loader = new Loader();
	
	public void setLabelText(String text){
		labelText = text;
	}
	
	public String getLabelText(){
		return labelText;
	}
	
	public void go(){
		loader.init();
		
		frame = new JFrame();
		label = new JLabel();
		Color color = new Color(0, 102, 51);
		
		label = new JLabel(labelText);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Serif", Font.PLAIN, 22));
		label.setForeground(Color.WHITE);
		label.addMouseListener(new LabelListener());
		frame.addWindowListener(new WndListener());
		
		frame.getContentPane().add(BorderLayout.CENTER, label);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 300);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.getContentPane().setBackground(color);
	}


	class WndListener implements WindowListener{
		
		@Override
		public void windowOpened(WindowEvent e) {
		}

		@Override
		public void windowDeactivated(WindowEvent e) {
		}

		@Override
		public void windowClosed(WindowEvent e) {
		}
		
		@Override
		public void windowClosing(WindowEvent e) {
			loader.getWordsDeck().saveDeckToFile(loader.getDataFile());
		}

		@Override
		public void windowIconified(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowDeiconified(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowActivated(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	
	class LabelListener implements MouseListener{
		
		@Override
		public void mouseClicked(MouseEvent e) {
			if(clickCounter >= loader.getCards().size()){
				clickCounter = 0;
			}
			int number = clickCounter;
			if(loader.getCards().get(number).checkState(0)){
				label.setText(loader.getCards().get(number).getWord());
				loader.getCards().get(number).reverseCard();
			}else{
				label.setText(loader.getCards().get(number).getTranslation());
				loader.getCards().get(number).reverseCard();
				loader.getWordsDeck().putCardToBottom(loader.getCards().get(number));			
				clickCounter ++;
			}
		}	
		
		@Override
		public void mousePressed(MouseEvent e) {
		    // TODO Auto-generated method stub
	
		}
	
		@Override
		public void mouseReleased(MouseEvent e) {
		    // TODO Auto-generated method stub
	
		}
	
		@Override
		public void mouseEntered(MouseEvent e) {
		    // TODO Auto-generated method stub
	
		}
	
		@Override
		public void mouseExited(MouseEvent e) {
		    // TODO Auto-generated method stub
	
		}
	}

}
