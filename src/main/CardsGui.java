package main;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.*;

public class CardsGui {
	
	// sting field that represents initial text value of the label
	private String labelText = "Please click to start";
	// JFrame object 
	JFrame frame;
	// JLable object
	JLabel label;
	// integer field that represent initial value of mouse click counter 
	int clickCounter = 0;
	// Loader object
	Loader loader = new Loader();
	
	// setter method to set new value of label's text
	// gets sting as text
	// set appropriate text as label value
	// returns nothing
	public void setLabelText(String text){
		labelText = text;
	}
	
	// method to get label's text
	// gets nothing
	// returns label text value
	public String getLabelText(){
		return labelText;
	}
	
	// methods to initialize all staff and UI
	// gets nothing
	// returns nothing
	public void go(){
		loader.init();
		
		// initialize frame
		frame = new JFrame();
		// initialize label
		label = new JLabel();
		// initialize background color
		Color color = new Color(0, 102, 51);
		
		// initialize label with default parameters (text, alignments, font, colors, listeners etc.)
		label = new JLabel(labelText);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Serif", Font.PLAIN, 22));
		label.setForeground(Color.WHITE);	
		label.addMouseListener(new LabelListener());
		
		// initialize frame with default parameters (text, alignments, size, colors, listeners etc.)		
		frame.addWindowListener(new WndListener());
		frame.getContentPane().add(BorderLayout.CENTER, label);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 300);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.getContentPane().setBackground(color);
	}


	// internal class to implements windows events listener
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
		
		// save deck to file on exit
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
	
	// internal class to implements mouse events listener
	class LabelListener implements MouseListener{
		
		// show cards depends on amount of click
		// if amount of click more then deck size - start from begin
		// put shown card to bottom of deck
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
