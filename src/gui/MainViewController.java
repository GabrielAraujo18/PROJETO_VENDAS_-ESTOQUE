package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import model.entities.Product;
import model.service.ProductService;

public class MainViewController implements Initializable {

	@FXML
	private MenuItem menuItemProduto;

	@FXML
	private MenuItem menuItemVenda;

	@FXML
	private MenuItem menuItemAbout;

	@FXML
	public void onMenuItemProdutoAction() {
		loadView2("/gui/ProductList.fxml");

	}

	@FXML
	public void onMenuItemVendaAction() {
		System.out.println("onMenuItemVendaAction");

	}

	@FXML
	public void onMenuItemAboutAction() {
		loadView("/gui/About.fxml");

	}

	@Override
	public void initialize(URL uri, ResourceBundle rb) {

	}

	private synchronized void loadView(String absoluteName) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			VBox newVBox = loader.load();

			Scene mainScene = Main.getmainScene();
			VBox mainVBox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent();

			Node mainMenu = mainVBox.getChildren().get(0);
			mainVBox.getChildren().clear();
			mainVBox.getChildren().add(mainMenu);
			mainVBox.getChildren().addAll(newVBox.getChildren());

		} catch (IOException e) {
			Alerts.showAlert("IO exception", "Error loading view", e.getMessage(), AlertType.ERROR);
		}
	}
	private synchronized void loadView2(String absoluteName) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			VBox newVBox = loader.load();

			Scene mainScene = Main.getmainScene();
			VBox mainVBox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent();

			Node mainMenu = mainVBox.getChildren().get(0);
			mainVBox.getChildren().clear();
			mainVBox.getChildren().add(mainMenu);
			mainVBox.getChildren().addAll(newVBox.getChildren());
			
			
			
			ProductListController controller = loader.getController();
			controller.setProductService(new ProductService());
			controller.updateTableView();
			
		} catch (IOException e) {
			Alerts.showAlert("IO exception", "Error loading view", e.getMessage(), AlertType.ERROR);
		}
	}
}
