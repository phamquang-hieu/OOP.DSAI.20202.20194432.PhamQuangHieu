package hust.soict.dsai.aims.screen;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SubTestScreen extends TestScreen {
	Container layout;
	public SubTestScreen() {
		super();
		JLabel authorLabel = new JLabel("Pham Quang Hieu");
		authorLabel.setAlignmentY(CENTER_ALIGNMENT);
		//super.add(authorLabel, BorderLayout.SOUTH);
		
		JPanel container = new JPanel();
    	container.setLayout(new FlowLayout());
    	container.add(new JLabel("Your Name"));
    	container.add(new JTextField(50));
    	container.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
    	super.getMainPanel().add(container, BorderLayout.CENTER);
	}
	public static void main(String[] args) {
		new SubTestScreen();
	}
}
