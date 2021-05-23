package hust.soict.dsai.aims.screen;

import java.awt.BorderLayout;
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
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.store.Store;

public class AddBookToStoreScreen extends AddItemToStoreScreen {

	String authors;
	public AddBookToStoreScreen(Store store, Cart cart, JPanel storeScreenCenter) throws HeadlessException {
		super(store, cart, storeScreenCenter);
		JPanel authors = super.createSubPanel("Authors");
		JLabel mes = new JLabel("Please separate authors' names by ',' character!");
		super.centerPanel.add(mes, BorderLayout.CENTER);
		super.centerPanel.add(authors, BorderLayout.CENTER);

		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new btnListener());
		super.centerPanel.add(btnAdd, BorderLayout.SOUTH);
		super.setTitle("Add Book");
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
				if(tf.getName().equals("Authors")) {
					authors = tf.getText();
				}
			}
			Book book;
			try {
				book = new Book(title, category, cost, authors);
				if(store.addMedia(book)) {	
					StoreScreenCenter.add(new MediaStore(book, cart));
					StoreScreenCenter.repaint();
					StoreScreenCenter.revalidate();
				}
				else {
					JOptionPane.showMessageDialog(null, "This book is already in your store!");
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
