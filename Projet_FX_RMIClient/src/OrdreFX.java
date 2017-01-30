import java.rmi.Naming;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.opendevup.entities.*;
import com.opendevup.rmi.BourseRmiRemote;
import javafx.application.Application;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
public class OrdreFX extends Application{
	    VBox root=new VBox();
	    Label nbrAction = new Label("Nombre Action:");
	    TextField nbrField = new TextField();
	    Label dateOrdre = new Label("Date Ordre:");
	    TextField dd=new TextField();
	    Label prixAction = new Label("Prix Action:");
	    TextField prixField = new TextField();
	    Label Societe = new Label("Societe:");
	    TextField societeField = new TextField();
	    RadioButton Achat = new RadioButton("Achat");
	    RadioButton Vente = new RadioButton("Vente");
	    Button btn = new Button("Ajouter Ordre");
	@Override
	public void start(Stage stage) throws Exception {
		try{
			BourseRmiRemote proxy=(BourseRmiRemote) Naming.lookup("rmi://localhost:1099/BK");
			  btn.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent arg0) {
						try {
							int nbrAction=Integer.parseInt(nbrField.getText());
							DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
							Date date = formatter.parse(dd.getText());
							double prixAction=Double.parseDouble(prixField.getText());
							String societe=societeField.getText();
							if(Achat.isSelected())
							{
								Achat ach=new Achat(date, nbrAction, prixAction, new Societe(societe));
								proxy.ajouterOrdre(ach);	
							}
							else
							{
								Vente v=new Vente(date, nbrAction, prixAction, new Societe(societe));
								proxy.AjouterVente(v);
							}} catch (Exception e) {e.printStackTrace();
						}}});
			}catch(Exception e){System.out.println(e.getMessage()); }
	        Scene scene = new Scene(root, 700, 700, Color.PERU);
		    scene.getStylesheets().add("monStyle2.css");
			ToggleGroup tg = new ToggleGroup();
	        Achat.setToggleGroup(tg);
	        Vente.setToggleGroup(tg);
	        root.getChildren().add(nbrAction);
	        root.getChildren().add(nbrField);
	        root.getChildren().add(dateOrdre);
	        root.getChildren().add(dd);
	        root.getChildren().add(prixAction);
	        root.getChildren().add(prixField);
	        root.getChildren().add(Societe);
	        root.getChildren().add(societeField);
	        root.getChildren().add(Achat);
	        root.getChildren().add(Vente);
	        root.getChildren().add(btn);

		stage.setScene(scene);
		 stage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}

}
