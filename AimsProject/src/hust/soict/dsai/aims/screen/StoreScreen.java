package hust.soict.dsai.aims.screen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store;

public class StoreScreen extends JFrame {
	private Store store;
	private Cart cart;
	
	public StoreScreen(Store store, Cart currentCart) throws HeadlessException {
		this.store = store;
		this.cart = currentCart;
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		
		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(createCenter(), BorderLayout.CENTER);
		
		setVisible(true);
		setTitle("Store");
		setSize(1024, 768);
	}

	JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		return north;
	}
	
	JMenuBar createMenuBar() {
		JMenu menu = new JMenu("Options");
		
		JMenu smUpdateStore = new JMenu("Update Store"); // sm = sub-menu
		JMenuItem addBookMenu = new JMenuItem("Add Book");
		JMenuItem addCDMenu = new JMenuItem("Add CD");
		JMenuItem addDVDMenu = new JMenuItem("Add DVD");
		smUpdateStore.add(addBookMenu);
		smUpdateStore.add(addCDMenu);
		smUpdateStore.add(addDVDMenu);
		addBookMenu.addActionListener(new btnListener());
		addDVDMenu.addActionListener(new btnListener());
		addCDMenu.addActionListener(new btnListener());
		
		menu.add(smUpdateStore);
		JMenuItem viewStoreMenu = new JMenuItem("View Store");
		JMenuItem viewCartMenu = new JMenuItem("View Cart");
		menu.add(viewStoreMenu);
		menu.add(viewCartMenu);
		viewStoreMenu.addActionListener(new btnListener());
		viewStoreMenu.addActionListener(new btnListener());
		
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(menu);

		return menuBar;
	}
	
	JPanel createHeader() {
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
		
		JLabel title = new JLabel("AIMS");
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
		title.setForeground(Color.CYAN);
		
		JButton cart = new JButton("View Cart");
		cart.addActionListener(new btnListener());
		
		cart.setPreferredSize(new Dimension(100, 50));
		cart.setMaximumSize(new Dimension(100, 50));
		
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		header.add(title);
		header.add(Box.createHorizontalGlue());
		header.add(cart); // add the cart button
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		
		return header;
	}
	
	JPanel createCenter() {
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(3, 3, 2, 2));
		
		ArrayList<Media> mediaInStore = store.getItemsInStore();
		// MediaStore is a GUI class which represents media in a cell.
		for(int i = 0; i< store.getItemInStock(); i++) {
			MediaStore cell = new MediaStore(mediaInStore.get(i), cart);
			center.add(cell);
		}
		
		return center;
	}
	
	private class btnListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();
			if(command.equals("View Cart")) {
				new CartScreen(cart, store);
				dispose();
			}
			if(command.equals("View Store")) {
				new StoreScreen(store, cart);
				dispose();
			}
		}
		
		
	}

}
