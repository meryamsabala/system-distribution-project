import java.rmi.Naming;
import java.util.*;
import com.opendevup.entities.Ordre;
import com.opendevup.rmi.BourseRmiRemote;
import javafx.application.Application;
import javafx.collections.*;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
public class SearchFX extends Application{
	    VBox root=new VBox();
	    Label codeSociete = new Label("Code Societe:");
	    TextField textField = new TextField();
	    Button btn = new Button("Chercher Ordres");
	    TableView<Ordre> table = new TableView<Ordre>();
	@Override
	public void start(Stage stage) throws Exception {
		try{
			btn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
			try{
				BourseRmiRemote proxy = (BourseRmiRemote) Naming.lookup("rmi://localhost:1099/BK");
		        String code=textField.getText();
				List<Ordre> lo=proxy.ToutOrdres(code);
				ObservableList<Ordre> data=FXCollections.observableArrayList();
				data.addAll(lo);
				table.getItems().addAll(data);
				}
				catch(Exception e){
				e.getMessage();
				}  }
				});
			}catch(Exception e){
				System.out.println(e.getMessage());}
	        Scene scene = new Scene(root, 600, 600, Color.PERU);
		    scene.getStylesheets().add("monStyle.css");
	        TableColumn<Ordre,Long> numéro = new TableColumn<>("Numéro");
	        numéro.setMinWidth(150);
	        numéro.setCellValueFactory(new PropertyValueFactory<>("numero"));
	        TableColumn<Ordre,Integer> nbrAction = new TableColumn<>("Nombre Action");
	        nbrAction.setMinWidth(150);
	        nbrAction.setCellValueFactory(new PropertyValueFactory<>("NombreAction"));
	        TableColumn<Ordre,Date> date = new TableColumn<>("Date Ordre");
	        date.setMinWidth(150);
	        date.setCellValueFactory(new PropertyValueFactory<>("dateOrdre"));
	        TableColumn<Ordre,Double>prix = new TableColumn<>("Prix Action");
	        prix.setMinWidth(150);
	        prix.setCellValueFactory(new PropertyValueFactory<>("prixAction"));
	        table.getColumns().addAll(numéro, nbrAction, date,prix);
	        root.getChildren().add(codeSociete);
	        root.getChildren().add(textField);
	        root.getChildren().add(btn);
	        root.getChildren().add(table);
		stage.setScene(scene);
		 stage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}


}
