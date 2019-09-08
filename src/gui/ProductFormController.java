package gui;

import java.net.URL;
import java.util.ResourceBundle;

import gui.util.Constraints;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.entities.Product;

public class ProductFormController implements Initializable {

	private Product entity;

	@FXML
	private TextField txtId;

	@FXML
	private TextField txtName;

	@FXML
	private TextField txtPreco;

	@FXML
	private TextField txtQuantidade;

	@FXML
	private Label labelErrorName;

	@FXML
	private Button btSave;

	@FXML
	private Button btCancel;

	public void setProduct(Product entity) {
		this.entity = entity;
	}

	@FXML
	public void onBtSaveAction() {
		System.out.println("onBtSaveAction");
	}

	@FXML
	public void onBtCancelAction() {
		System.out.println("onBtCancelAction");
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		initializeNodes();
	}

	private void initializeNodes() {
		Constraints.setTextFieldInteger(txtId);
		Constraints.setTextFieldMaxLength(txtName, 60);
		Constraints.setTextFieldDouble(txtPreco);
		Constraints.setTextFieldInteger(txtQuantidade);
	}

	public void updateFormData() {
		if (entity == null) {
			throw new IllegalStateException("Entity was null");

		}

		txtId.setText(String.valueOf(entity.getId()));
		txtName.setText(entity.getName());

	}
}