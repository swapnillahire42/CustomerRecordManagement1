/*
 * The CutomerRecordManagement program implements an application that
 * stores and maintains Customer Records and displays the records
 * @author: Swapnil Lahire
 * @since: 23-06-2014  
 */
package Form;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HomeScreen extends Application {
    /*
     * This is Our MainScreen code i.e. Home Screen Code  from where
     * we can navigate to Add Records and Search Records form
     */

    TextField nameTextField, emailTextField, phoneTextField, addressTextField,
            cityTextField, stateTextField, pincodeTextField, countryTextField;

    @Override
    public void start(final Stage primaryStage) {

        primaryStage.setTitle("Customer Record Management");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        Text scenetitle = new Text("Customer Database ");
        scenetitle.setId("cust-record");
        grid.add(scenetitle, 0, 0, 3, 1);

        Button btn = new Button("  Add Record ");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.CENTER_LEFT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 4);

        Button btn1 = new Button("Search Record");
        HBox hbBtn1 = new HBox(10);
        hbBtn1.setAlignment(Pos.CENTER);
        hbBtn1.getChildren().add(btn1);
        grid.add(hbBtn1, 2, 4);

        final Text actiontarget1 = new Text();
        grid.add(actiontarget1, 1, 6);

        btn1.setOnAction(new EventHandler<ActionEvent>() {
            /*
             * When clicked on Search Record this Event Handler works
             * which takes to the Search Form 
             */
            @Override
            public void handle(ActionEvent e) {
                actiontarget1.setId("actiontarget");
                {
                    Search t = new Search();
                    t.start(primaryStage);
                }

            }
        });

        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);

        btn.setOnAction(new EventHandler<ActionEvent>() {
            /*
             * When clicked on Add Record this Event Handler works
             * which takes to the Add Records Form 
             */
            @Override
            public void handle(ActionEvent e) {
                actiontarget.setId("actiontarget");
                {
                    AddCustomer h = new AddCustomer();
                    h.start(primaryStage);
                }
            }
        });

        Scene scene = new Scene(grid, 800, 600);
        primaryStage.setScene(scene);
        scene.getStylesheets().add(HomeScreen.class.getResource("HomeScreen.css").toExternalForm());
        primaryStage.show();
    }

    public static void main(String[] args) {

       // HomeScreen a =new HomeScreen();        
    }

}
