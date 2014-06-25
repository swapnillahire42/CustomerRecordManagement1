/*
 * The CutomerRecordManagement program implements an application that
 * stores and maintains Customer Records and displays the records
 * @author: Swapnil Lahire
 * @since: 23-06-2014  
 */
package Form;

import java.sql.SQLException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AddCustomer extends Application {
    /*
     * This contains code for Add record from where
     * we can add records to the database and can also navigate back to Homescreen
     */

    TextField nameTextField, emailTextField, phoneTextField, addressTextField, cityTextField,
            stateTextField, pincodeTextField, countryTextField;

    ;    
    @Override
    public void start(final Stage primaryStage) {

        primaryStage.setTitle("Add Records");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.BASELINE_LEFT);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        Text scenetitle = new Text("Customer Database ");
        scenetitle.setId("cust-record");
        grid.add(scenetitle, 0, 0, 3, 1);

        Label name = new Label("Name:");
        grid.add(name, 0, 1);

        nameTextField = new TextField();
        grid.add(nameTextField, 1, 1);

        Label email = new Label("Email:");
        grid.add(email, 0, 2);

        emailTextField = new TextField();
        grid.add(emailTextField, 1, 2);

        Label phone = new Label("Phone:");
        grid.add(phone, 0, 3);

        phoneTextField = new TextField();
        grid.add(phoneTextField, 1, 3);

        Label address = new Label("Address:");
        grid.add(address, 0, 4);

        addressTextField = new TextField();
        grid.add(addressTextField, 1, 4);

        Label city = new Label("City:");
        grid.add(city, 0, 5);

        cityTextField = new TextField();
        grid.add(cityTextField, 1, 5);

        Label state = new Label("State:");
        grid.add(state, 0, 6);

        stateTextField = new TextField();
        grid.add(stateTextField, 1, 6);

        Label pincode = new Label("Pincode:");
        grid.add(pincode, 0, 7);

        pincodeTextField = new TextField();
        grid.add(pincodeTextField, 1, 7);

        Label country = new Label("Country:");
        grid.add(country, 0, 8);

        countryTextField = new TextField();
        grid.add(countryTextField, 1, 8);

        Button btn = new Button("Add Record");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 9);
        Button btn2 = new Button("Home");
        HBox hbBtn2 = new HBox(10);
        hbBtn2.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn2.getChildren().add(btn2);
        grid.add(hbBtn2, 10, 0);

        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 10);

        btn.setOnAction(new EventHandler<ActionEvent>() {
            /*
             * This implements data entry mechanism
             * Here object of Connect class is made and method of connect i.e. insert is called where 
             * mechanism for inserting data into database by firing a insert query is written
             */

            @Override
            public void handle(ActionEvent e) {
                actiontarget.setId("actiontarget");
                try {
                    String cuName = nameTextField.getText();
                    String cuEmail = emailTextField.getText();
                    String cuPhone = phoneTextField.getText();
                    String cuAddress = addressTextField.getText();
                    String cuCity = cityTextField.getText();
                    String cuState = stateTextField.getText();
                    String cuPincode = pincodeTextField.getText();
                    String cuCountry = countryTextField.getText();
                    /*if(cuName.equals(null)){
                        
                     }*/
                    Connect connectInstance = new Connect();//Instantiating  the connect class
                    connectInstance.insertrow(cuName, cuEmail, cuPhone, cuAddress, cuCity, cuState, cuPincode, cuCountry);//calls the insert row method of connnect class
                    connectInstance.closeconn();//calls the closeconn method which close the connection 
                    actiontarget.setText("Record Added");

                } catch (ClassNotFoundException ex) //handling Class Not Found Exception 
                {
                    System.out.println("Class not found");
                } catch (SQLException ex)//handling SQL Exception 
                {
                    System.out.println("sql exception");
                }
            }
        });
        btn2.setOnAction(new EventHandler<ActionEvent>() {
            /*
             * This implements logic of Home button
             * which takes us to the Home Screen 
             */
            @Override
            public void handle(ActionEvent e) { 
                actiontarget.setId("actiontarget");
                HomeScreen h = new HomeScreen();
                h.start(primaryStage);
            }
        });

        Scene scene = new Scene(grid, 800, 600);
        primaryStage.setScene(scene);
        scene.getStylesheets().add(AddCustomer.class.getResource("HomeScreen.css").toExternalForm());
        primaryStage.show();
    }

}

/* public static void main(String[] args) {
        
 launch(args);
       
 }
    
 }*/
