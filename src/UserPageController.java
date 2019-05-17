
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class UserPageController implements Initializable {

    @FXML
    private Label welcome;
    @FXML
    private TextArea quotedis;
    String UserID, UserName;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    public void GetUserID(String id, String Name) throws SQLException {
        welcome.setText(Name);
        UserID = id;
        UserName = Name;
        Quotes qt = new Quotes();
        String quote = qt.returnQuotes();
        quotedis.setText(quote);
    }
    public void CheckBalance(ActionEvent event) throws SQLException, IOException {
        PreparedStatement ps = null;
        ResultSet rs = null;
     //   SELECT COUNT(поле) FROM имя_таблицы WHERE условие
        ps = JDBC.getConnection().prepareStatement("SELECT COUNT(nomer) FROM klient WHERE id_mastera = ?");
        ps.setString(1, UserID);
        rs = ps.executeQuery();
        while (rs.next()) {
            String Balance = Integer.toString(rs.getInt(1));
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("BalancePage.fxml"));
            loader.load();
            Parent root = loader.getRoot();
            BalancePageController bpc = loader.getController();
            bpc.SetBalance(Balance);
            Scene scene = new Scene(root);

            stage.setResizable(false);
            stage.sizeToScene();
            stage.setTitle("Balance Page");
            stage.setScene(scene);
            stage.show();
        }
        ps.close();
        rs.close();
    }

    @FXML
    public void Withdraw(ActionEvent event) throws IOException, SQLException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("WithdrawPage.fxml"));
        loader.load();
        Parent root = loader.getRoot();
        BalancePageController bpc = loader.getController();
        bpc.getUserID(UserID);// получаем айди мастера
bpc.LoadKlientDataStart();// выводит таблицу
        Scene scene = new Scene(root);
        stage.setResizable(false);
        stage.sizeToScene();
        stage.setTitle("Withdraw Page");
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    void ChangePassword(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("ChangePassword.fxml"));
        loader.load();
        Parent root = loader.getRoot();
        AccountInfoController aic = loader.getController();
        aic.getUserID(UserID);
        aic.StqPasswordChangePage();
        Scene scene = new Scene(root);

        stage.setResizable(false);
        stage.sizeToScene();
        stage.setTitle("Change Password");
        stage.setScene(scene);
        stage.show();
    }

}







