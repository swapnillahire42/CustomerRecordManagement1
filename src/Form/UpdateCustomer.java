/*
 * The CutomerRecordManagement program implements an application that
 * stores and maintains Customer Records and displays the records
 * @author: Swapnil Lahire
 * @since: 23-06-2014  
 */
package Form;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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

public class UpdateCustomer extends Application {
    /*
     * This implements code for Updating the record from where
     * we can update records to the database and can also navigate back to Homescreen
     */

    public String sname;
    TextField nameTextField, emailTextField, phoneTextField, addressTextField, cityTextField, stateTextField, pincodeTextField, countryTextField;

    ;    
    public void setSname(String sname) {
        this.sname = sname;
    }

    @Override
    public void start(final Stage primaryStage) throws ClassNotFoundException, SQLException {
        primaryStage.setTitle("Update records");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
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

        Button btn1 = new Button("Home");
        HBox hbBtn1 = new HBox(10);
        hbBtn1.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn1.getChildren().add(btn1);
        grid.add(hbBtn1, 2, 1);
        final Text actiontarget2 = new Text();
        grid.add(actiontarget2, 1, 9);
        btn1.setOnAction(new EventHandler<ActionEvent>() {
            /*
             * This contains code for Home button from where
             * we can navigate back to Homescreen
             */
            @Override
            public void handle(ActionEvent e) {
                actiontarget2.setId("actiontarget2");

                HomeScreen h = new HomeScreen();
                h.start(primaryStage);

            }
        });

        Button btn = new Button("Update Record");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 10);

        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 11);

        btn.setOnAction(new EventHandler<ActionEvent>() {
            /**
             * this implements update mechanism by firing update query on
             * customer table
             */
            @Override
            public void handle(ActionEvent e) {
                actiontarget.setId("actiontarget");
                try {
                    Connect connectInstance = new Connect(); //Instantiating  the connect class
                    String s = nameTextField.getText();                
                    String sql = "update customertable set name=?,email=?,phone=?,address=?,city=?,state=?,pincode=?,country=? where name=?";
                    connectInstance.st = connectInstance.conn.prepareStatement(sql);
                    connectInstance.st.setString(9, sname);
                    connectInstance.st.setString(1, nameTextField.getText());
                    connectInstance.st.setString(2, emailTextField.getText());
                    connectInstance.st.setString(3, phoneTextField.getText());
                    connectInstance.st.setString(4, addressTextField.getText());
                    connectInstance.st.setString(5, cityTextField.getText());
                    connectInstance.st.setString(6, stateTextField.getText());
                    connectInstance.st.setInt(7, Integer.parseInt(pincodeTextField.getText()));
                    connectInstance.st.setString(8, countryTextField.getText());
                    int i =0;
                            i= connectInstance.st.executeUpdate(); //returns the counter
                    if(i==1)
                        actiontarget.setText( " " +i+ "  Record Updated");
                    
                } catch (ClassNotFoundException | SQLException ex) { //handling Exception
                    Logger.getLogger(UpdateCustomer.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

        Scene scene = new Scene(grid, 800, 600);
        primaryStage.setScene(scene);
        scene.getStylesheets().add(UpdateCustomer.class.getResource("HomeScreen.css").toExternalForm());
        primaryStage.show();
        Connect connectInstance = new Connect();//Instantiating  the connect class
        String sql = "select * from customertable where name=?";
        connectInstance.st = connectInstance.conn.prepareStatement(sql);
        connectInstance.st.setString(1, sname);
        ResultSet rs = connectInstance.st.executeQuery(); //executeQuery() returns resultset
        if (rs.next()) {
            nameTextField.setText(rs.getString(1));
            emailTextField.setText(rs.getString(2));
            phoneTextField.setText(rs.getString(3));
            addressTextField.setText(rs.getString(4));
            cityTextField.setText(rs.getString(5));
            stateTextField.setText(rs.getString(6));
            pincodeTextField.setText(rs.getString(7));
            countryTextField.setText(rs.getString(8));

        }
        connectInstance.closeconn(); //calls the closeconn method which closes the connection
    }

    public static void main(String[] args) {
        launch(args);
    }
}
