package hust.soict.dsai.aims.screen;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddItemToStoreScreen extends JFrame {
	JPanel centerPanel;

	public AddItemToStoreScreen() throws HeadlessException {
		Container cp = getContentPane();
		this.setSize(512, 384);
		this.add(cp);
		
		cp.setLayout(new BorderLayout());
		this.centerPanel = createCenter();
		cp.add(createCenter(), BorderLayout.CENTER);
		this.setVisible(true);
	}
	protected JPanel getCenterPanel() {
		return this.centerPanel;
	}
	
	protected JPanel createSubPanel(String text) {
		JPanel subContainer = new JPanel(new FlowLayout());
		JTextField tf = new JTextField(50);
		tf.addActionListener(new tfListener());
		JLabel lb = new JLabel(text);
		subContainer.add(lb, tf);
		return subContainer;
		
	}
	
	JPanel createCenter() {
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(10, 1, 5, 5));
		JPanel title = createSubPanel("Title");
		JPanel cost = createSubPanel("Cost");
		JPanel category = createSubPanel("Category");
		
		
		center.add(title);
		center.add(cost);
		center.add(category);
		
		return center;
	}
	
	private class tfListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JTextField tf = (JTextField) e.getSource();
			
			
		}
		
	}

}
