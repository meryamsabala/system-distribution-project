import java.rmi.Naming;
import java.rmi.RemoteException;
import com.opendevup.entities.Societe;
import com.opendevup.rmi.BourseRmiRemote;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
public class SocieteFX extends Application{
	    VBox root=new VBox();
	    Label codeSociete = new Label("Code Societe:");
	    TextField codeField = new TextField();
	    Label NomSociete = new Label("Nom Societe:");
	    TextField nomField = new TextField();
	    Button btn = new Button("Ajouter Societe");
	@Override
	public void start(Stage stage) throws Exception {
		try{
			BourseRmiRemote proxy=(BourseRmiRemote) Naming.lookup("rmi://localhost:1099/BK");
			  btn.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent arg0) {
						String code=codeField.getText();
						String nom=nomField.getText();
						try 
						{
							proxy.ajouterSocieter(new Societe(code, nom));
						} 
						catch (RemoteException e) { e.printStackTrace(); }
					}
				});
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
	        Scene scene = new Scene(root, 600, 600, Color.PERU);
		    scene.getStylesheets().add("monStyle.css");
	        root.getChildren().add(codeSociete);
	        root.getChildren().add(codeField);
	        root.getChildren().add(NomSociete);
	        root.getChildren().add(nomField);
	        root.getChildren().add(btn);
	      

		stage.setScene(scene);
		 stage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}

}
