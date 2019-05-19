import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;



public class AdminPageController implements Initializable {

     @FXML
    private TableView<CustomerData> customertable;
    @FXML
    private TableColumn<CustomerData,Integer> cusid;
    @FXML
    private TableColumn<CustomerData,String> cusname;
    @FXML
    private TableColumn<CustomerData,String> cusaddress;
    @FXML
    private TableColumn<CustomerData,String> cusemail;
    @FXML
    private TableColumn<CustomerData,String> cusphone;
    @FXML
    private TableColumn<CustomerData,Integer> cusbalance;
    private ObservableList<CustomerData>data;

    String AdminID;



    public void GetAdminID(String id) throws SQLException, FileNotFoundException, IOException{
        AdminID = id;

        PreparedStatement ps = JDBC.getConnection().prepareStatement("SELECT * FROM admins WHERE id = ?");
        ps.setString(1, id);
        ResultSet rs = ps.executeQuery();
        ps.close();
        rs.close();
        JDBC.closeConnection();
    }

    @FXML
    public void LoadCustomerData(ActionEvent event) throws SQLException{
    data = FXCollections.observableArrayList();
    PreparedStatement ps = JDBC.getConnection().prepareStatement("SELECT * FROM users");
    ResultSet rs = ps.executeQuery();
    while(rs.next()){
    data.add(new CustomerData(rs.getInt("id"),rs.getString("name"),rs.getString("address"),rs.getString("email"),rs.getString("Phone"),rs.getInt("balance")));
    }
            cusid.setCellValueFactory(new PropertyValueFactory<CustomerData,Integer>("CustomerId"));
            cusname.setCellValueFactory(new PropertyValueFactory<CustomerData,String>("CustomerName"));
            cusaddress.setCellValueFactory(new PropertyValueFactory<CustomerData,String>("CustomerAddress"));
            cusemail.setCellValueFactory(new PropertyValueFactory<CustomerData,String>("CustomerEmail"));
            cusphone.setCellValueFactory(new PropertyValueFactory<CustomerData,String>("CustomerPhone"));
            cusbalance.setCellValueFactory(new PropertyValueFactory<CustomerData,Integer>("CustomerBalance"));
            customertable.setItems(null);
            customertable.setItems(data);
            ps.close();
            rs.close();
        JDBC.closeConnection();
    }



    public void LoadCustomerDataStart() throws SQLException{

        data = FXCollections.observableArrayList();

        PreparedStatement ps = JDBC.getConnection().prepareStatement("SELECT * FROM users");
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            data.add(new CustomerData(rs.getInt("id"),rs.getString("name"),rs.getString("address"),rs.getString("email"),rs.getString("Phone"),rs.getInt("balance")));
        }
        cusid.setCellValueFactory(new PropertyValueFactory<CustomerData,Integer>("CustomerId"));
        cusname.setCellValueFactory(new PropertyValueFactory<CustomerData,String>("CustomerName"));
        cusaddress.setCellValueFactory(new PropertyValueFactory<CustomerData,String>("CustomerAddress"));
        cusemail.setCellValueFactory(new PropertyValueFactory<CustomerData,String>("CustomerEmail"));
        cusphone.setCellValueFactory(new PropertyValueFactory<CustomerData,String>("CustomerPhone"));
        cusbalance.setCellValueFactory(new PropertyValueFactory<CustomerData,Integer>("CustomerBalance"));
        customertable.setItems(null);
        customertable.setItems(data);
        ps.close();
        rs.close();
        JDBC.closeConnection();
    }


     @FXML
    public void AddCustomerData(ActionEvent event) throws IOException{
    Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("AddCustomer.fxml"));
        loader.load();
        Parent root = loader.getRoot();
        Scene scene = new Scene(root);


        stage.setResizable(false);
        stage.sizeToScene();
        stage.setTitle("Add Customer Page");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void EditCustomerData(ActionEvent event) throws IOException{
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("EditCustomer.fxml"));
        loader.load();
        Parent root = loader.getRoot();
        Scene scene = new Scene(root);
        stage.setResizable(false);
        stage.sizeToScene();
        stage.setTitle("Edit Customer Page");
        stage.setScene(scene);
        stage.show();

    }


    @FXML
    public void DeleteCustomerData(ActionEvent event) throws IOException{
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("DeleteCustomer.fxml"));
        loader.load();
        Parent root = loader.getRoot();
        Scene scene = new Scene(root);


        stage.setResizable(false);
        stage.sizeToScene();
        stage.setTitle("Delete Customer Page");
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    public void ResetPassword(ActionEvent event) throws IOException{
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("PasswordReset.fxml"));
        loader.load();
        Parent root = loader.getRoot();
        Scene scene = new Scene(root);


        stage.setResizable(false);
        stage.sizeToScene();
        stage.setTitle("Passwor Reset Page");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
}
