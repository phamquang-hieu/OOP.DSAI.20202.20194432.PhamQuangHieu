package hust.soict.dsai.aims.screen;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
/*from w w  w .j  a  va  2 s  . c  o m*/
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TestScreen extends JFrame{
	JPanel mainPanel;
	 public TestScreen() {
		 this.setLayout(new BorderLayout());
		 this.setSize(600, 500);
		 this.add(getPanel(), BorderLayout.CENTER);
		 this.setTitle("Add Items");
		 setVisible(true);
	}
	 public JPanel getMainPanel() {
		 return this.mainPanel;
	 }
	
	 private JPanel getPanel() {
		mainPanel = new JPanel(new GridLayout(10, 1, 0, 0));
	    for(int i = 0; i< 5; i++) {
	    	JPanel container = new JPanel();
	    	container.setLayout(new FlowLayout());
	    	container.add(new JLabel("Your Name"));
	    	container.add(new JTextField(50));
	    	container.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
	    	mainPanel.add(container);
	    }
	  
	    return mainPanel;
	 }
	
	 public static void main(String[] args) {
	   new TestScreen();
	 }
}
