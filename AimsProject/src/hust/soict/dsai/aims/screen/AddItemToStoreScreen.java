package hust.soict.dsai.aims.screen;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.store.Store;

public abstract class AddItemToStoreScreen extends JFrame {
	JPanel centerPanel;
	JPanel StoreScreenCenter;
	Store store; 
	Cart cart;
	String title, category, cost;

	ArrayList<JTextField> textFields = new ArrayList<JTextField>(); 

	public AddItemToStoreScreen(Store store, Cart cart, JPanel storeScreenCenter) throws HeadlessException {
		this.store = store;
		this.cart = cart;
		this.StoreScreenCenter = storeScreenCenter;
		this.setSize(700, 400);
		
		this.setLayout(new BorderLayout());
		this.add(createCenter(), BorderLayout.CENTER);
		this.setVisible(true);
	}
	protected JPanel getCenterPanel() {
		return this.centerPanel;
	}
	
	protected JPanel createSubPanel(String text) {
		JPanel subContainer = new JPanel(new FlowLayout());
		JTextField tf = new JTextField(50);
		tf.setName(text);
		textFields.add(tf);
		JLabel lb = new JLabel(text);
		subContainer.add(lb);
		subContainer.add(tf);
		subContainer.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		return subContainer;
		
	}
	JPanel createCenter() {
		centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(10, 1, 5, 5));
		
		JPanel titleP = createSubPanel("Title");
		JPanel costP = createSubPanel("Cost");
		JPanel categoryP = createSubPanel("Category");
		
		centerPanel.add(titleP);
		centerPanel.add(costP);
		centerPanel.add(categoryP);
		
		return centerPanel;
	}

}
