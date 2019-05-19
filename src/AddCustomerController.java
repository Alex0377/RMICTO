import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.sql.ResultSet;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.*;
import javafx.stage.FileChooser;


public class AddCustomerController implements Initializable {
    @FXML
    private TextField cusid;
    @FXML
    private TextField cusname;
    @FXML
    private TextArea cusaddress;
    @FXML
    private TextField cusphone;
    @FXML
    private Label addcusconfirm;
    @FXML
    private TextField cusemail;
    @FXML
    private TextField balance;

    private File file;
    @FXML
    private ImageView userimage;
    @FXML
    private TextField cuspass;
    private FileInputStream fis;
    private  int cf;




    public void ChooseFile(ActionEvent event) {
        FileChooser fc = new FileChooser();
        file = fc.showOpenDialog(null);
        if (file != null) {
            Image image = new Image(file.toURI().toString());
            userimage.setImage(image);
            cf = 1;
        } else {
            cf = 0;
        }
    }


  private   int x=0;
    @FXML
    public void AddCustomer(ActionEvent event) throws SQLException, FileNotFoundException {
        try {



            PreparedStatement ps2 = JDBC.getConnection().prepareStatement("SELECT max (id) FROM users ");
            ResultSet rs2 = ps2.executeQuery();

            x++;
try {
    int y=Integer.parseInt(rs2.getString(x));

            y++;
            System.out.println(y);


                        PreparedStatement ps = JDBC.getConnection().prepareStatement("INSERT INTO users VALUES (?,?,?,?,?,?,?,'0')");
                        ps.setInt(1, y);
                        ps.setString(2, cuspass.getText());
                        ps.setString(3, cusname.getText());
                        ps.setString(4, cusaddress.getText());
                        ps.setString(5, cusemail.getText());
                        ps.setString(6, cusphone.getText());
                        ps.setString(7, balance.getText());

                        int i = ps.executeUpdate();
                        if (i > 0) {
                            cusid.setText("");
                            cuspass.setText("");
                            cusname.setText("");
                            cusaddress.setText("");
                            cusemail.setText("");
                            cusphone.setText("");
                            balance.setText("");
                            addcusconfirm.setText("New Customer Added Successfully");

                        } else {
                            addcusconfirm.setText("Failed To Add New Customer");
                        }
                        ps.close();
                      JDBC.closeConnection();

}
catch (Exception e)
{

    addcusconfirm.setText("Please Enter Everything Correctly");

}

        } catch (NumberFormatException e) {
            addcusconfirm.setText("Please Enter Everything Correctly");
        }
        cf = 0;

        userimage.setImage(null);
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
}
