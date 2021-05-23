package hust.soict.dsai.aims.screen;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.NegativeNumberException;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {

	String director;
	String length;
	public AddDigitalVideoDiscToStoreScreen(Store store, Cart cart, JPanel storeScreenCenter) throws HeadlessException {
		super(store, cart, storeScreenCenter);
		JPanel dirP = super.createSubPanel("Director");
		JPanel lenP = super.createSubPanel("Length");
		super.getCenterPanel().add(dirP, BorderLayout.CENTER);
		super.getCenterPanel().add(lenP, BorderLayout.CENTER);
		JButton btn = new JButton("Add");
		btn.addActionListener(new btnListener());
		super.getCenterPanel().add(btn, BorderLayout.SOUTH);
		super.setTitle("add DVD");
	}
	
	private class btnListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			for(JTextField tf: textFields) {
				if(tf.getName().equals("Title")) {
					title = tf.getText();
				}
				if(tf.getName().equals("Cost")) {
					cost = tf.getText();
				}
				if(tf.getName().equals("Category")) {
					category = tf.getText();
				}
				if(tf.getName().equals("Director")) {
					System.out.println(tf.getText());
					director = tf.getText();
				}
				if(tf.getName().equals("Length")) {
					length = tf.getText();
				}	
			}
			
			DigitalVideoDisc dvd;
			try {
				dvd = new DigitalVideoDisc(title, category, cost, director, length);
				if(store.addMedia(dvd)) {
					StoreScreenCenter.add(new MediaStore(dvd, cart));
					StoreScreenCenter.repaint();
					StoreScreenCenter.revalidate();
				}else {
					JOptionPane.showMessageDialog(centerPanel, "This DVD is already in your store!");
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
		
		
	}

}
