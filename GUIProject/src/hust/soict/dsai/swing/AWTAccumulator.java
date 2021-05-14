package hust.soict.dsai.swing;

import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Label;
import java.awt.TextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class AWTAccumulator extends Frame {
	private TextField tfInput;
	private TextField tfOutput;
	private int sum = 0;
	
	public AWTAccumulator() throws HeadlessException {
		setLayout(new GridLayout(2, 2));
		add(new Label("Enter an integer: "));
		
		tfInput = new TextField(10);
		add(tfInput);
		tfInput.addActionListener(new TFInputListener());

		add(new Label("The Accumulater Sum is: "));
		
		tfOutput = new TextField(10);
		add(tfOutput);
		
		setTitle("AWT Accumulator");
		setSize(350, 120);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new AWTAccumulator();
	}
	
	private class TFInputListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent evt) {
			int numberIn = Integer.parseInt(tfInput.getText());
			sum+= numberIn;
			tfInput.setText("");
			tfOutput.setText(sum + "");
		}
	}
	
	
	
	public AWTAccumulator(GraphicsConfiguration gc) {
		super(gc);
		// TODO Auto-generated constructor stub
	}

	public AWTAccumulator(String title) throws HeadlessException {
		super(title);
		// TODO Auto-generated constructor stub
	}

	public AWTAccumulator(String title, GraphicsConfiguration gc) {
		super(title, gc);
		// TODO Auto-generated constructor stub
	}

}
