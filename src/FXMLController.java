import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class FXMLController implements Initializable {
    @FXML
    private TextField useridtf;
    @FXML
    private Label mssg;
    @FXML
    private Button loginb;
    @FXML
    private PasswordField passwordtf;
    @FXML
    private RadioButton userrb;
    @FXML
    private ToggleGroup UserOrAdmin;
    @FXML
    private RadioButton adminrb;



    @FXML
    private void Login(ActionEvent event) throws SQLException, IOException {


        PreparedStatement ps = null;
        ResultSet rs = null;
        if (userrb.isSelected()) {
            ps = JDBC.getConnection().prepareStatement("SELECT * FROM users WHERE id = ? and password = ?");
            ps.setString(1, useridtf.getText());
            ps.setString(2, passwordtf.getText());
            rs = ps.executeQuery();
            if (rs.next()) {
                Stage stage = new Stage();
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("UserPage.fxml"));
                loader.load();
                Parent root = loader.getRoot();
                UserPageController upc = loader.getController();
                upc.GetUserID(useridtf.getText(), rs.getString("name"));
                stage.setTitle("User Page");
                stage.setMinHeight(710);
                stage.setMinWidth(1345);
                stage.setMaximized(true);
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
                mssg.setText("");
            }
            else{
            mssg.setText("Wrong Password Or UserID");
            }
            ps.close();
            rs.close();
            JDBC.closeConnection();
        } else if (adminrb.isSelected()) {
            ps = JDBC.getConnection().prepareStatement("SELECT * FROM admins WHERE id = ? and password = ?");
            ps.setString(1, useridtf.getText());
            ps.setString(2, passwordtf.getText());
            rs = ps.executeQuery();
            if(rs.next()) {
                Stage stage = new Stage();
                FXMLLoader loader = new FXMLLoader();

                loader.setLocation(getClass().getResource("AdminPage.fxml"));
                loader.load();
                Parent root = loader.getRoot();
                AdminPageController apc = loader.getController();
                apc.LoadCustomerDataStart();
                apc.GetAdminID( useridtf.getText());
                stage.setTitle("Admin Page");
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
                mssg.setText("");

            }
            else{
            mssg.setText("Wrong Password Or AdminID");
            }
            ps.close();
            rs.close();
        }
        JDBC.closeConnection();
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
}
