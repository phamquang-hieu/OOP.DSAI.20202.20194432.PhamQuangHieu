package hust.soict.dsai.aims.screen;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;

public class MediaStore extends JPanel {
	private Media media;
	private Cart cart;
	
	public MediaStore(Media media, Cart currentCart) {
		this.media = media;
		this.cart = currentCart; 
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		ButtonListener btnListener = new ButtonListener();
		
		JLabel title = new JLabel(media.getTitle());
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
		title.setAlignmentX(CENTER_ALIGNMENT);
		
		JLabel cost = new JLabel("" + media.getCost() + " $");
		cost.setAlignmentX(CENTER_ALIGNMENT);
		
		JPanel container = new JPanel();
		container.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		JButton addToCartButton = new JButton("Add to cart");
		container.add(addToCartButton);
		addToCartButton.addActionListener(btnListener);
		
		
		if(media instanceof Playable) {
			JButton playButton = new JButton("Play");
			container.add(playButton);
			playButton.addActionListener(btnListener);
		
		}
		this.add(Box.createVerticalGlue());
		this.add(title);
		this.add(cost);
		this.add(Box.createVerticalGlue());
		this.add(container);
		
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
	}
	
	private class ButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String button = e.getActionCommand();
			if(button.equals("Play")) {
				JFrame newFrame = new JFrame();
				JTextField tfDisplay = new JTextField();
				tfDisplay.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
				String content, title;
				if(media instanceof DigitalVideoDisc) {
					DigitalVideoDisc d = (DigitalVideoDisc) media;
					content = d.play().toString();
					title = d.getTitle();
				}
				else {
					CompactDisc d = (CompactDisc) media;
					content = d.play().toString();
					title = d.getTitle();
				}
				JDialog dl = new JDialog(newFrame, title);
				tfDisplay.setText(content);
				
				dl.add(tfDisplay);
				dl.setLayout(new FlowLayout());
				dl.setSize(300, 300);
				dl.setVisible(true);
				
			}
			if(button.equals("Add to cart")) {
				cart.addMedia(media);
			}
		}
	}
	
	
	
	
	
	

}
