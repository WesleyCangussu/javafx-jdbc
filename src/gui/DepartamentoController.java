package gui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.entities.Departamento;
import model.services.DepartamentoService;

public class DepartamentoController implements Initializable {
	
	private DepartamentoService service;

	@FXML
	private Button btNovo;
	@FXML
	private TableView<Departamento> tableViewDepartamento;
	@FXML
	private TableColumn<Departamento, Integer> tableColumnId;
	@FXML
	private TableColumn<Departamento, String> tableColumnNome;
	
	private ObservableList<Departamento> obsList;
	
	@FXML
	public void onBtNovoAction() {
		System.out.println("teste");
	}
	
	
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initializeNodes();
	}

	public void SetDepartamentoService(DepartamentoService service) {
		this.service = service;
	}

	private void initializeNodes() {

		tableColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
		tableColumnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		
		Stage stage = (Stage) Main.getMainScene().getWindow();
		tableViewDepartamento.prefHeightProperty().bind(stage.heightProperty());
	}
	
	public void UpdateTableView() {
		if (service == null) {
			throw new IllegalStateException("Service está nulo");
		}
		List<Departamento> list = service.findAll();
		obsList = FXCollections.observableList(list);
		tableViewDepartamento.setItems(obsList);
	}

}
