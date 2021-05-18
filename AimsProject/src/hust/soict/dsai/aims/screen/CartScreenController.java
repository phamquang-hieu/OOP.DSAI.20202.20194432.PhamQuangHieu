package hust.soict.dsai.aims.screen;

import javax.swing.JOptionPane;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.store.Store;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.converter.NumberStringConverter;

public class CartScreenController {
	
	private Cart cart;
	private Store store;
	
	@FXML
	private TableView<Media> tblMedia;
	
	@FXML
	private TableColumn<Media, String> colMediaTitle;
	
	@FXML
	private TableColumn<Media, String> colMediaCategory;
	
	@FXML
	private TableColumn<Media, Float> colMediaCost;
	
    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;
    
    @FXML
    private Label totalCostLabel;
	
	public CartScreenController(Cart cart, Store store) {
		super();
		this.cart = cart;
		this.store = store;
	}
	
	@FXML
	private void initialize() {
		colMediaTitle.setCellValueFactory(
				new PropertyValueFactory<Media, String>("Title"));
		colMediaCategory.setCellValueFactory(
				new PropertyValueFactory<Media, String>("Category"));
		colMediaCost.setCellValueFactory(
				new PropertyValueFactory<Media, Float>("Cost"));
		tblMedia.setItems(this.cart.getItemsOrdered());
		totalCostLabel.setText(Float.toString(cart.totalCost()));
		
		
		btnPlay.setVisible(false);
		btnRemove.setVisible(false);
		
		tblMedia.getSelectionModel().selectedItemProperty().addListener(
				new ChangeListener<Media>() {
					@Override
					public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) 
					{
						if(newValue != null) {
								updateButtonBar(newValue);
							}
					}
				});
	}
	void updateButtonBar(Media media) {
		btnRemove.setVisible(true);
		if(media instanceof Playable) {
			btnPlay.setVisible(true);
		} else {
			btnPlay.setVisible(false);
		}
	}
	
	@FXML
	void btnRemovePressed(ActionEvent event) {
		Media media = tblMedia.getSelectionModel().getSelectedItem();
		cart.removeMedia(media);
		totalCostLabel.setText(Float.toString(cart.totalCost()));

	}
	
	@FXML
	void playButtonPressed(ActionEvent event) {
		Media media = tblMedia.getSelectionModel().getSelectedItem();
		if(media instanceof DigitalVideoDisc) {
			DigitalVideoDisc d = (DigitalVideoDisc) media;
			JOptionPane.showMessageDialog(null, d.play());
		}
		else if(media instanceof CompactDisc) {
			CompactDisc c = (CompactDisc) media;
			JOptionPane.showMessageDialog(null, c.play());
		}
	}
	
	@FXML
	void btnPlaceOrderPressed(ActionEvent event) {
		this.cart.placeOrder();
		totalCostLabel.setText(Float.toString(cart.totalCost()));
		JOptionPane.showMessageDialog(null, "An order has been placed");
	}
	
	@FXML
	void cartMenuViewStore(ActionEvent event) {
		new StoreScreen(store, cart);
	}

}
