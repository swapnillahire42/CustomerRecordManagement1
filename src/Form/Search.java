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
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;

public class Search extends Application {

    private TableView table = new TableView();//For displaying the data from database the object of TableView class is needed.
    TableColumn nameCol;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(final Stage stage) {
        /*
         * This contains implementation for Search record from where
         * we can view records from the database in table view and can update or delete records
         */
        Scene scene = new Scene(new Group());
        scene.getStylesheets().add(Search.class.getResource("HomeScreen.css").toExternalForm());
        stage.setTitle("Search Record");
        stage.setWidth(950);
        stage.setHeight(700);
        final Text scenetitle = new Text("Customer Database ");
        scenetitle.setId("cust-record");
        final Label label = new Label("Search by");
        label.setFont(new Font("Arial", 20));
        final ComboBox searchComboBox = new ComboBox();
        searchComboBox.getItems().addAll(
                "Name",
                "Email",
                "Phone"
        );
        searchComboBox.setValue("select");
        final TextField txtsearch = new TextField();

        Button btn = new Button("Search");

        Button btn2 = new Button("Home");

        table.autosize();
        table.setEditable(false);

        //Fields of the table
        nameCol = new TableColumn("Name");
        nameCol.setMinWidth(100);
        nameCol.setCellValueFactory(
                new PropertyValueFactory<Form.CustPOJO, String>("cuName"));
        nameCol.setCellFactory(TextFieldTableCell.forTableColumn());

        TableColumn emailCol = new TableColumn("Email");
        emailCol.setMinWidth(200);
        emailCol.setCellValueFactory(
                new PropertyValueFactory<Form.CustPOJO, String>("cuEmail"));
        emailCol.setCellFactory(TextFieldTableCell.forTableColumn());

        TableColumn phonelCol = new TableColumn("Phone");
        phonelCol.setMinWidth(100);
        phonelCol.setCellValueFactory(
                new PropertyValueFactory<Form.CustPOJO, String>("cuPhone"));
        phonelCol.setCellFactory(TextFieldTableCell.forTableColumn());

        TableColumn addressCol = new TableColumn("Address");
        addressCol.setMinWidth(100);
        addressCol.setCellValueFactory(
                new PropertyValueFactory<Form.CustPOJO, String>("cuAddress"));
        addressCol.setCellFactory(TextFieldTableCell.forTableColumn());

        TableColumn citylCol = new TableColumn("City");
        citylCol.setMinWidth(100);
        citylCol.setCellValueFactory(
                new PropertyValueFactory<Form.CustPOJO, String>("cuCity"));
        citylCol.setCellFactory(TextFieldTableCell.forTableColumn());

        TableColumn statelCol = new TableColumn("State");
        statelCol.setMinWidth(100);
        statelCol.setCellValueFactory(
                new PropertyValueFactory<Form.CustPOJO, String>("cuState"));
        statelCol.setCellFactory(TextFieldTableCell.forTableColumn());

        TableColumn pincodeCol = new TableColumn("Pincode");
        pincodeCol.setMinWidth(50);
        pincodeCol.setCellValueFactory(
                new PropertyValueFactory<Form.CustPOJO, String>("cuPincode"));
        pincodeCol.setCellFactory(TextFieldTableCell.forTableColumn());

        TableColumn countryCol = new TableColumn("Country");
        countryCol.setMinWidth(100);
        countryCol.setCellValueFactory(
                new PropertyValueFactory<Form.CustPOJO, String>("cuCountry"));
        countryCol.setCellFactory(TextFieldTableCell.forTableColumn());

        table.getColumns().addAll(nameCol, emailCol, phonelCol, addressCol, citylCol, statelCol, pincodeCol, countryCol);

        final VBox vbox = new VBox();
        vbox.setSpacing(10);
        vbox.setPadding(new Insets(25, 25, 25, 25)); //10 25 0 10
        vbox.getChildren().addAll(scenetitle, btn2, label, searchComboBox, txtsearch, btn, table);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        btn.setOnAction(new EventHandler<ActionEvent>() {
            /*
             * This implements search mechanism
             * By Firing select query data is fetched according to option selected in the combobox
             * Here table view is used for representing the data
             */
            @Override
            public void handle(ActionEvent e) {

                String s = searchComboBox.getValue().toString();
                String name = "Name";
                String email = "Email";
                String phone = "Phone";
                boolean b = s.equals(name);
                //Implentation of logic on selecting option Name from the ComboBox 
                if (searchComboBox.getValue().equals(name)) {                                  
                    try {
                        Connect connectInstance = new Connect(); //Instantiating the Connect class
                        String sql = "select * from customertable where name=?";// select query for searching the record name wise
                        connectInstance.st = connectInstance.conn.prepareStatement(sql);
                        connectInstance.st.setString(1,txtsearch.getText());
                        ResultSet rs = connectInstance.st.executeQuery(); //executeQuery() returns resultset

                        ObservableList<CustPOJO> row = FXCollections.observableArrayList();
                        while (rs.next())//iterating the Result Set,next() points to next row in ResultSet
                        {
                            row.add(new CustPOJO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8)));
                            table.setItems(row);
                        }
                        connectInstance.closeconn(); //calls the closeconn() which closes the connection
                    } catch (ClassNotFoundException | SQLException ex) {
                        Logger.getLogger(Search.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } //Implentation of logic on selecting option Email from the ComboBox 
                else if (searchComboBox.getValue().equals(email)) {                                                       
                    try {
                        Connect connectInstance = new Connect(); //Instantiating the Connect class
                        String sql = "select * from customertable where email=?";// select query for searching the record email wise
                        connectInstance.st = connectInstance.conn.prepareStatement(sql);
                        connectInstance.st.setString(1, txtsearch.getText());
                        ResultSet rs = connectInstance.st.executeQuery(); //executeQuery() returns resultset
                        ObservableList<CustPOJO> row = FXCollections.observableArrayList();
                        while (rs.next()) { //Iterating the resultset, next() points to the next row of resultset
                            row.add(new CustPOJO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8)));
                            table.setItems(row);                
                        }
                        connectInstance.closeconn(); //Calling the closeconn method which closes the connection
                    } catch (ClassNotFoundException | SQLException ex) { //handling SQLException
                        Logger.getLogger(Search.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } //Implentation of logic on selecting option Phone from the ComboBox 
                else if (searchComboBox.getValue().equals(phone)) {                                                            
                    try {
                        Connect connectInstance = new Connect();    //Instantiating the Connect class
                        String sql = "select * from customertable where phone=?"; // select query for searching the record phone wise
                        connectInstance.st = connectInstance.conn.prepareStatement(sql);
                        connectInstance.st.setString(1, txtsearch.getText());
                        ResultSet rs = connectInstance.st.executeQuery();  //executeQuery() returns resultset
                        ObservableList<CustPOJO> row = FXCollections.observableArrayList();
                        while (rs.next()) { //iterating the Result Set,next() points to next row in ResultSet
                            //adds record to the table
                            row.add(new CustPOJO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8)));
                            table.setItems(row);
                        }
                        connectInstance.closeconn(); //calls the closeconn() which closes the connection
                    } catch (ClassNotFoundException | SQLException ex) { //handling Class Not Found Exception or SQLException
                        Logger.getLogger(Search.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } //Implentation of logic on when no option is selected and default value is select in the ComboBox 
                else {
                    try {
                        Connect connectInstance = new Connect(); //Instantiating  the connect class
                        String sql = "select * from customertable";
                        connectInstance.st = connectInstance.conn.prepareStatement(sql);
                        ResultSet rs = connectInstance.st.executeQuery(); //executeQuery() returns resultset
                        ObservableList<CustPOJO> row = FXCollections.observableArrayList();
                        while (rs.next()) { //iterating the Result Set,next() points to next row in ResultSet
                            row.add(new CustPOJO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8)));
                            table.setItems(row);                           
                        }
                        connectInstance.closeconn();//calls the closeconn method which close the connection 
                    } catch (ClassNotFoundException | SQLException ex) { //handling Class Not Found Exception
                        Logger.getLogger(Search.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });

        btn2.setOnAction(new EventHandler<ActionEvent>() {

            /*
             * When clicked on Home button this Event Handler works
             * which takes to the Home Screen Form 
             */
            @Override
            public void handle(ActionEvent e) {
                //actiontarget.setId("actiontarget");                
                HomeScreen h = new HomeScreen();
                h.start(stage);
            }
        });

        //Implementaion login for Right Click Mouse Event
        table.setRowFactory(new Callback<TableView<CustPOJO>, TableRow<CustPOJO>>() {

            @Override
            public TableRow<CustPOJO> call(TableView<CustPOJO> tableView) {
                final TableRow<CustPOJO> row = new TableRow<>();
                final ContextMenu contextMenu = new ContextMenu();
                final MenuItem removeMenuItem = new MenuItem("Delete");
                final MenuItem editMenuItem = new MenuItem("Edit");
                removeMenuItem.setOnAction(new EventHandler<ActionEvent>() {
                    /*
                     * When Right clicked and selected Delete on any row this Event Handler works
                     * which Removes Record by fire delete query and remove item from table   
                     */
                    @Override
                    public void handle(ActionEvent event) {
                        table.getItems().remove(row.getItem());
                        try {
                            Connect connectInstance = new Connect(); //Instantiating  the connect class
                            CustPOJO pojoInstance = row.getItem();
                            String name = pojoInstance.getCuEmail();
                            String sql = "delete customertable where email=?";
                            connectInstance.st = connectInstance.conn.prepareStatement(sql);
                            connectInstance.st.setString(1, name);
                            int i = connectInstance.st.executeUpdate();
                        } catch (ClassNotFoundException | SQLException ex) {
                            Logger.getLogger(Search.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
                /*
                 * When Right clicked and selected Edit on any row this Event Handler works
                 * which takes us to Update Record form where we can edit fields and fire update query   
                 */
                editMenuItem.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        CustPOJO custPojoInstance = row.getItem();
                        String name = custPojoInstance.getCuName();
                        UpdateCustomer updateCust = new UpdateCustomer();
                        updateCust.setSname(name); //here we pass the name of selected row in the variable name 
                        try {
                            updateCust.start(stage);
                        } catch (ClassNotFoundException | SQLException ex) {
                            Logger.getLogger(Search.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
                contextMenu.getItems().addAll(removeMenuItem, editMenuItem);
// Set context menu on row, but use a binding to make it only show for non-empty rows:
                row.contextMenuProperty().bind(
                        Bindings.when(row.emptyProperty())
                        .then((ContextMenu) null)
                        .otherwise(contextMenu)
                );
                return row;
            }
        });
        stage.setScene(scene);
        scene.getStylesheets().add(Search.class.getResource("HomeScreen.css").toExternalForm());
        stage.show();
    }
}
