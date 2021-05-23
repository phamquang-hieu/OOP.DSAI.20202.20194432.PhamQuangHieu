package hust.soict.dsai.aims.screen;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.soict.dsai.aims.exception.NegativeNumberException;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.Track;

public class AddTrackToCDScreen extends JFrame {
	ArrayList<JTextField> textFields = new ArrayList<JTextField>();
	CompactDisc cd;
	String name, length;
	public AddTrackToCDScreen(CompactDisc cd) throws HeadlessException {
		this.cd = cd;
		this.setLayout(new BorderLayout());
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(4, 1, 5, 5));
		
		this.setSize(600, 450);
		this.setTitle("Add Track To CD");
		this.add(new JLabel("Please continuosly add tracks to CD by input and press 'Add' button"), BorderLayout.NORTH );
		centerPanel.add(createSubPanel("Track's name"));
		centerPanel.add(createSubPanel("Track's length"));
		this.add(centerPanel);
		
		JPanel buttonBar = new JPanel(new FlowLayout());		
		JButton add = new JButton("Add");
		JButton exit = new JButton("Exit");
		add.addActionListener(new btnListener());
		exit.addActionListener(new btnListener());
		buttonBar.add(add);
		buttonBar.add(exit);
		this.add(buttonBar, BorderLayout.SOUTH);
		
		this.setVisible(true);
		
	}
	
	private JPanel createSubPanel(String text) {
		JPanel subPanel = new JPanel();
		subPanel.setLayout(new FlowLayout());
		JLabel lb = new JLabel(text);
		JTextField txt = new JTextField(50);
		subPanel.add(lb);
		subPanel.add(txt);
		textFields.add(txt);
		subPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		return subPanel;
	}
	
	private class btnListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals("Add")) {
				name = textFields.get(0).getText();
				length = textFields.get(1).getText();

				Track newTrack;
				try {
					newTrack = new Track(name, length);
					if(!cd.addTrack(newTrack)) {
						JOptionPane.showMessageDialog(null, "This track is already in your CD!");
					}else {
						JOptionPane.showMessageDialog(null, "Your track has been added");
					}
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
					e1.printStackTrace();
				} catch (NullPointerException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
					e1.printStackTrace();
				} catch (NegativeNumberException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
					e1.printStackTrace();
				}
				
			}
			if(e.getActionCommand().equals("Exit")) {
				dispose();
			}
			
		}
		
	}
	
	

}
