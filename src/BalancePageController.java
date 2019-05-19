import java.io.*;
import java.net.URL;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import static java.lang.String.valueOf;

public class BalancePageController implements Initializable {
    @FXML
    private TextField balanceinfo;
    @FXML
    private TextField TextFieldIDMaster;
    @FXML
    private TextField TextFiiillldlddd;
    @FXML
    private TextArea quotedisbp;
    @FXML
    private TextField withdrawamount;
    @FXML
    private TextField depositamount;

    String UserID;// это id мастера
    String BalanceS;



    @FXML
    private TextField Master;
    @FXML
    private TextField Master1;
    @FXML
    private TextField Master2;
    @FXML
    private TextField Master3;
    @FXML
    private TextField Master4;
    @FXML
    private TextField Master5;
    @FXML
    private TextField Master6;
    @FXML
    private TextField receiverid;
    @FXML
    private TextField KlientaMaster;
    @FXML
    private TextField KlientMachina;
    @FXML
    private TextField KlientGoda;
    @FXML
    private TextField KlientFFIIO;
    @FXML
    private TextField KlientNomerKyzova;
    @FXML
    private TextField KlientNomerrr;
    @FXML
    private TextField KlientKomstr;
//cusid
@FXML
private TextField cusid;


    @FXML
    private TextField ID_Klientr;

    @FXML
    private TextField trnasamount;
    @FXML
    private PasswordField retypepass;
    @FXML
    private Label dipositconf;
    @FXML
    private Label IDmasteraError;
    @FXML
    private Label KlientLOLL;
    @FXML
    private Label fokys;
    @FXML
    private Label ErrorrDelet;
    @FXML
    private Label ID_Master_Klient;
    @FXML
    private Label Goooddd;
    @FXML
    private Label withdrawinfo;
    @FXML
    private TextArea quotedisdp;
    @FXML
    private TextArea quotediswp;
    @FXML
    private Label transferconf;

    @FXML
    private Label quotedisbt;

    @FXML
    private TableView<klientData> customertableKlient;
    @FXML
    private TableColumn<klientData,Integer> klientId_mastera;
    @FXML
    private TableColumn<klientData,String> klientmachina;
    @FXML
    private TableColumn<klientData,String> KlientnomerKyzova;
    @FXML
    private TableColumn<klientData,Integer> klientnomer;
    @FXML
    private TableColumn<klientData,String> klientFIO;
    @FXML
    private TableColumn<klientData,String> klientKomentarii;
    @FXML
    private Label confirmation;
    @FXML
    private TableColumn<klientData,Integer> klientgood;
    private ObservableList<klientData> dataKlientt;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    private   static String name;
    private String nomerIdFokys;
    private  static   int fokyss;
    private static String  nameUsrIid;


    public String getNomerIdFokys() {
        return nomerIdFokys;
    }

    public void setNomerIdFokys(String nomerIdFokys) {
        this.nomerIdFokys = nomerIdFokys;
    }


    public void getUserID(String Id) {
        UserID = Id;
    }

  static   public int setFak(int x) {
        fokyss = x;
        return x;
    }
    static   public int getFak() {

        return fokyss;
    }

    public void SetBalance(String Bal) {
        BalanceS = Bal;
        balanceinfo.setText(BalanceS);
        Quotes qt = new Quotes();
        String quote = qt.returnQuotes();
        quotedisbp.setText(quote);
    }







    @FXML
    public void LoadKlientData(ActionEvent event) throws SQLException{



        try {

            PreparedStatement ps4 = JDBC.getConnection().prepareStatement("Select * from klient where id_mastera = ?");

            ps4.setString(1,"0");
            ResultSet rs4 = ps4.executeQuery();
            KlientLOLL.setText("");
            int x=0;
            while (rs4.next()) {
                x++;

            }
            KlientLOLL.setText(valueOf(x));
            ps4.close();
            JDBC.closeConnection();
        } catch ( NumberFormatException | SQLException e) {
            //    confirmation.setText("заполните все формы");
        }

        Goooddd.setText("");
        ErrorrDelet.setText("");
            dataKlientt = FXCollections.observableArrayList();
            PreparedStatement ps = JDBC.getConnection().prepareStatement("SELECT * FROM klient");
            ResultSet rs = ps.executeQuery();




         fokys.setText(UserID);
        nameUsrIid=  fokys.getText();
            while (rs.next()) {
                dataKlientt.add(new klientData(rs.getInt("id_mastera"), rs.getString("mahina"), rs.getInt("god"), rs.getString("FIO"), rs.getString("nomer"), rs.getString("komentarii"), rs.getString("nomerKyzova")));
             //   klientId_mastera.setStyle("-fx-background-color:lightgreen");
            }

            klientId_mastera.setCellValueFactory(new PropertyValueFactory<klientData,Integer>("klientId_mastera"));
            klientKomentarii.setCellValueFactory(new PropertyValueFactory<klientData,String>("klientKomentarii"));
            klientgood.setCellValueFactory(new PropertyValueFactory<klientData,Integer>("klientgood"));
            klientFIO.setCellValueFactory(new PropertyValueFactory<klientData,String>("klientFIO"));
            klientnomer.setCellValueFactory(new PropertyValueFactory<klientData,Integer>("klientnomer"));
            klientmachina.setCellValueFactory(new PropertyValueFactory<klientData,String>("klientmachina"));
            KlientnomerKyzova.setCellValueFactory(new PropertyValueFactory<klientData,String>("KlientnomerKyzova"));
            customertableKlient.setItems(null);
            customertableKlient.setItems(dataKlientt);
            ps.close();
            rs.close();
        JDBC.closeConnection();
    }




    public void LoadKlientDataStart() throws SQLException{

    //    name=fokys.getText();
    //    nameUsrIid=  fokys.getText();
        //KlientLOLL
        try {

            PreparedStatement ps4 = JDBC.getConnection().prepareStatement("Select * from klient where id_mastera = ?");


            ps4.setString(1,"0");

            ResultSet rs4 = ps4.executeQuery();
            KlientLOLL.setText("");
            int x=0;
            while (rs4.next()) {
                x++;



            }
            KlientLOLL.setText(valueOf(x));
            ps4.close();
            JDBC.closeConnection();
        } catch ( NumberFormatException | SQLException e) {
            //    confirmation.setText("заполните все формы");
        }




        dataKlientt = FXCollections.observableArrayList();
        PreparedStatement ps = JDBC.getConnection().prepareStatement("SELECT * FROM klient");
        ResultSet rs = ps.executeQuery();

        fokys.setText(UserID);
        while (rs.next()) {
            dataKlientt.add(new klientData(rs.getInt("id_mastera"), rs.getString("mahina"), rs.getInt("god"), rs.getString("FIO"), rs.getString("nomer"), rs.getString("komentarii"), rs.getString("nomerKyzova")));
        }
        klientId_mastera.setStyle("-fx-selection-bar: red; -fx-selection-bar-non-focused: salmon;");
       // customertableKlient.
          //      setStyle("-fx-selection-bar: red; -fx-selection-bar-non-focused: salmon;");

        klientId_mastera.setCellValueFactory(new PropertyValueFactory<klientData,Integer>("klientId_mastera"));
        klientKomentarii.setCellValueFactory(new PropertyValueFactory<klientData,String>("klientKomentarii"));
        klientgood.setCellValueFactory(new PropertyValueFactory<klientData,Integer>("klientgood"));
        klientFIO.setCellValueFactory(new PropertyValueFactory<klientData,String>("klientFIO"));
        klientnomer.setCellValueFactory(new PropertyValueFactory<klientData,Integer>("klientnomer"));
        klientmachina.setCellValueFactory(new PropertyValueFactory<klientData,String>("klientmachina"));
        KlientnomerKyzova.setCellValueFactory(new PropertyValueFactory<klientData,String>("KlientnomerKyzova"));
        customertableKlient.setItems(null);
        customertableKlient.setItems(dataKlientt);
        ps.close();
        rs.close();
        JDBC.closeConnection();
    }






    static String getStatikKlientnomer;
    static String getStatikKlientFIO;
    static String getStatikKomentarii;
    static String getStatikKlientmachina;
    static int getStatikKlientgood;
    static String getStatikKlientnomerKyzova;



    @FXML
public  void perehod()throws IOException, SQLException{
    ErrorrDelet.setText("");
    name=fokys.getText();
    Stage stage = new Stage();
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource("SetMasterKlient.fxml"));
    loader.load();
    Parent root = loader.getRoot();
    BalancePageController bpc = loader.getController();
    bpc.setFak(customertableKlient.getSelectionModel().getFocusedIndex());


    TableView.TableViewSelectionModel<klientData> selectionModel = customertableKlient.getSelectionModel();
    getStatikKlientnomer =selectionModel.selectedItemProperty().get().getKlientnomer();
    getStatikKlientFIO=selectionModel.selectedItemProperty().get().getKlientFIO();
    getStatikKomentarii=selectionModel.selectedItemProperty().get().getKlientKomentarii();
    getStatikKlientmachina=selectionModel.selectedItemProperty().get().getKlientmachina();
    getStatikKlientgood=selectionModel.selectedItemProperty().get().getKlientgood();
    getStatikKlientnomerKyzova=selectionModel.selectedItemProperty().get().getKlientnomerKyzova();

    bpc.setNomerIdFokys(selectionModel.selectedItemProperty().get().getKlientnomer());//устанавливем id для дальнейшей работы;
    bpc.LoadMasterInfoKlientMasterStartNomer();
    Scene scene = new Scene(root);
    stage.setResizable(false);
    stage.sizeToScene();
    stage.setTitle("Page");
    stage.setScene(scene);
    stage.show();
}

  private   int operationsCounter=0;
    @FXML
    public void AddCustomerrRMI(String name,String name1,String name2,String name3,String name4) throws SQLException, FileNotFoundException {//функция вызывается клиентом


        try {
            dataKlientt = FXCollections.observableArrayList();
            PreparedStatement ps = JDBC.getConnection().prepareStatement("SELECT max (nomer) FROM klient ");
            ResultSet rs = ps.executeQuery();


            operationsCounter++;

            int y=Integer.parseInt(rs.getString(operationsCounter));
            y++;
      //      System.out.println(y);
            PreparedStatement ps2 = JDBC.getConnection().prepareStatement("INSERT INTO klient  VALUES (?,?,?,?,?,?,?)");
            try {
                ps2.setInt(1,0);
                ps2.setString(2, name);
                ps2.setString(3,name1);
                ps2.setString(4, name2);
                ps2.setString(5, valueOf(y));
                ps2.setString(6,name3);
                ps2.setString(7, name4);

            }
            catch (Exception ee)
            {

                IDmasteraError.setText("неверный тип данных");
            }

            int i = ps2.executeUpdate();

            rs.close();
            ps2.close();
            JDBC.closeConnection();
            JDBC.closeConnection();
            ps.close();
            rs.close();




        } catch (NumberFormatException e) {
            confirmation.setText("AddCustomer Please Enter Everything Correctly");
            IDmasteraError.setText("неверный тп данных");
        }

    }




    @FXML
    public void AddKlientMaster(ActionEvent event) throws SQLException, FileNotFoundException {
            PreparedStatement ps6 = JDBC.getConnection().prepareStatement("SELECT * FROM klient WHERE nomer = ? and id_mastera=? ");

           ps6.setString(1, getStatikKlientnomer);//getStatikKlientnomer- номер клиента (id-его)
        ps6.setString(2, "0");
           ResultSet rs6 = ps6.executeQuery();
          if (rs6.next()) {


              try {



                  PreparedStatement ps = JDBC.getConnection().prepareStatement("UPDATE klient SET id_mastera = ? ,mahina = ? ,god = ? , FIO = ?,komentarii=?,nomerKyzova=? WHERE nomer = ?");



                  ps.setString(1, name);
                  ps.setString(2, getStatikKlientmachina);
                  ps.setInt(3, getStatikKlientgood);
                  ps.setString(4, getStatikKlientFIO);
                  ps.setString(5, getStatikKomentarii);
                  ps.setString(6, getStatikKlientnomerKyzova);
                  ps.setString(7, getStatikKlientnomer);



                  int i = ps.executeUpdate();
                  if (i > 0) {
                      Master.setText("");
                      Master1.setText("");
                      Master2.setText("");
                      Master3.setText("");
                      Master4.setText("");
                      Master5.setText("");

                      confirmation.setText("Операция прошла успешно");
                  } else {
                      ps.close();
                      JDBC.closeConnection();
                  }
                  JDBC.closeConnection();

              } catch (NumberFormatException | SQLException e) {
                  confirmation.setText("Пожалуйста проверти данные");
              }
          }
          else {

              confirmation.setText("клиент занят");

          }
rs6.close();
          ps6.close();
}

    int x=0;



    @FXML
    public void AddCustomer(ActionEvent event) throws SQLException, FileNotFoundException {

        if(KlientaMaster.getText().isEmpty()||KlientMachina.getText().isEmpty()||KlientGoda.getText().isEmpty()||KlientFFIIO.getText().isEmpty()||KlientKomstr.getText().isEmpty()||KlientNomerKyzova.getText().isEmpty()) {

                IDmasteraError.setText("Заполните все поля");
            }

        else {
            try {
                if (Integer.parseInt(KlientaMaster.getText())<100000000){
                    try {
                        PreparedStatement ps6 = JDBC.getConnection().prepareStatement("SELECT * FROM users WHERE id = ? ");
                          ps6.setString(1, KlientaMaster.getText());
                        ResultSet       rs6 = ps6.executeQuery();
                        if(rs6.next()) {
                        dataKlientt = FXCollections.observableArrayList();
                        PreparedStatement ps = JDBC.getConnection().prepareStatement("SELECT max (nomer) FROM klient ");
                        ResultSet rs = ps.executeQuery();
                        x++;
                        int y = Integer.parseInt(rs.getString(x));
                        y++;
                     //   System.out.println(y);
                        PreparedStatement ps2 = JDBC.getConnection().prepareStatement("INSERT INTO klient  VALUES (?,?,?,?,?,?,?)");
                        try {
                            ps2.setInt(1, Integer.parseInt(KlientaMaster.getText()));
                            ps2.setString(2, KlientMachina.getText());
                            ps2.setString(3, KlientGoda.getText());
                            ps2.setString(4, KlientFFIIO.getText());
                            ps2.setString(5, valueOf(y));
                            ps2.setString(6, KlientKomstr.getText());
                            ps2.setString(7, KlientNomerKyzova.getText());

                        } catch (Exception ee) {

                            IDmasteraError.setText("неверный тип данных");
                        }
                        int i = ps2.executeUpdate();
                        if (i > 0) {
                            KlientaMaster.setText("");
                            KlientMachina.setText("");
                            KlientGoda.setText("");
                            KlientFFIIO.setText("");
                            KlientNomerrr.setText("");
                            KlientKomstr.setText("");
                            KlientNomerKyzova.setText("");
                            confirmation.setText("New Customer Added Successfully");
                            IDmasteraError.setText("");
                        } else {
                            confirmation.setText("Failed To Add New Customer");
                        }
                        rs6.close();
                        rs.close();
                        ps2.close();
                            ps6.close();
                        JDBC.closeConnection();
                        JDBC.closeConnection();
                        ps.close();
                        rs.close();

                    }
                        else {
                            IDmasteraError.setText("неверный ID мастера");

                        }
                    } catch (NumberFormatException e) {
                        confirmation.setText("AddCustomer Please Enter Everything Correctly");
                        IDmasteraError.setText("неверный тп данных");
                    }
                }
            }
            catch (Exception e)
            {
                IDmasteraError.setText("Неверный тип данных");

            }

            }

    }


    int summ=0;


    @FXML
    public void AddCustomerkLITNT(ActionEvent event) throws SQLException, FileNotFoundException {

        if(KlientaMaster.getText().isEmpty()||KlientMachina.getText().isEmpty()||KlientGoda.getText().isEmpty()||KlientFFIIO.getText().isEmpty()||KlientKomstr.getText().isEmpty()||KlientNomerKyzova.getText().isEmpty()) {

            IDmasteraError.setText("Заполните все поля");
        }

        else {
            try {
                if (Integer.parseInt(KlientaMaster.getText())<100000000){

                    try {
                        /////

                        PreparedStatement ps6 = JDBC.getConnection().prepareStatement("SELECT * FROM users WHERE id = ? ");
                        ps6.setString(1, KlientaMaster.getText());
                        ResultSet       rs6 = ps6.executeQuery();
                        if(rs6.next()) {




                            dataKlientt = FXCollections.observableArrayList();
                            PreparedStatement ps = JDBC.getConnection().prepareStatement("SELECT max (nomer) FROM klient ");
                            ResultSet rs = ps.executeQuery();
                            summ++;

                            int y = Integer.parseInt(rs.getString(summ));
                            y++;
                      //      System.out.println(y);
                            PreparedStatement ps2 = JDBC.getConnection().prepareStatement("INSERT INTO klient  VALUES (?,?,?,?,?,?,?)");
                            try {
                                ps2.setInt(1, Integer.parseInt(KlientaMaster.getText()));
                                ps2.setString(2, KlientMachina.getText());
                                ps2.setString(3, KlientGoda.getText());
                                ps2.setString(4, KlientFFIIO.getText());
                                ps2.setString(5, valueOf(y));
                                ps2.setString(6, KlientKomstr.getText());
                                ps2.setString(7, KlientNomerKyzova.getText());

                            } catch (Exception ee) {

                                IDmasteraError.setText("неверный тип данных");
                            }
                            int i = ps2.executeUpdate();
                            if (i > 0) {
                                KlientaMaster.setText("");
                                KlientMachina.setText("");
                                KlientGoda.setText("");
                                KlientFFIIO.setText("");
                                KlientNomerrr.setText("");
                                KlientKomstr.setText("");
                                KlientNomerKyzova.setText("");
                                confirmation.setText("New Customer Added Successfully");
                                IDmasteraError.setText("");
                            } else {
                                confirmation.setText("Failed To Add New Customer");
                            }
                            rs6.close();
                            rs.close();
                            ps2.close();
                            ps6.close();
                            JDBC.closeConnection();
                            JDBC.closeConnection();
                            ps.close();
                            rs.close();

                        }
                        else {
                            IDmasteraError.setText("неверный ID мастера");

                        }
                    } catch (NumberFormatException e) {
                        confirmation.setText("AddCustomer Please Enter Everything Correctly");
                        IDmasteraError.setText("неверный тп данных");
                    }
                }
            }
            catch (Exception e)
            {
                IDmasteraError.setText("Неверный тип данных");

            }

        }

    }


    @FXML
    public  void AddCustomer1(ActionEvent event)  throws RemoteException {
//.println("ацуауцацуацуа");
        BillingServiceImpl.Emailstatic.toString();
                KlientaMaster.setText( BillingServiceImpl.Emailstatic.toString());
                KlientMachina.setText( BillingServiceImpl.Emailstatic.toString());
                KlientGoda.setText( BillingServiceImpl.Emailstatic.toString());
                KlientFFIIO.setText( BillingServiceImpl.Emailstatic.toString());
                KlientNomerrr.setText( BillingServiceImpl.Emailstatic.toString());
                KlientKomstr.setText( BillingServiceImpl.Emailstatic.toString());
                KlientNomerKyzova.setText( BillingServiceImpl.Emailstatic.toString());
    }


    @FXML
    public void EditCusInfo(ActionEvent event) throws SQLException, FileNotFoundException {
        try {

                    PreparedStatement ps = JDBC.getConnection().prepareStatement("UPDATE users SET name = ? ,address = ? ,email = ? , phone = ?,balance = ? , image = ? WHERE id = '" + Integer.parseInt(cusid.getText()) + "'");
                    ps.setString(1, TextFiiillldlddd.getText());
                    ps.close();
                    JDBC.closeConnection();

        } catch ( NumberFormatException | SQLException e) {
            confirmation.setText("Please Enter Everything Correctly");
        }
    }





    @FXML
    public void AddKlient(ActionEvent event) throws SQLException, FileNotFoundException {



        try {
            if (KlientaMaster.getText().isEmpty() || KlientFFIIO.getText().isEmpty() || KlientKomstr.getText().isEmpty() || KlientNomerKyzova.getText().isEmpty() || KlientMachina.getText().isEmpty() || KlientGoda.getText().isEmpty()) {
                confirmation.setText("Пожалуйста заполните все формы");




            } else {

                    PreparedStatement ps2 = JDBC.getConnection().prepareStatement("INSERT INTO klient  VALUES (?,?,?,?,?,?,?)");
                ps2.setInt(1,1);
                ps2.setString(2, KlientMachina.getText());
                ps2.setInt(3,Integer.parseInt(KlientGoda.getText()));
                ps2.setString(4, KlientFFIIO.getText());
                ps2.setString(5,  "12");
                ps2.setString(6, KlientKomstr.getText());
                ps2.setString(7, KlientNomerKyzova.getText());
                    int i = ps2.executeUpdate();
                    if (i > 0) {
                        KlientaMaster.setText("");
                        KlientMachina.setText("");
                        KlientGoda.setText("");
                        KlientFFIIO.setText("");
                        KlientNomerrr.setText("");
                        KlientKomstr.setText("");
                        KlientNomerKyzova.setText("");
                        confirmation.setText("New Customer Added Successfully");
                    } else {
                        confirmation.setText("Failed To Add New Customer");
                    }
                    ps2.close();
                    JDBC.closeConnection();


            }
        } catch (NumberFormatException e) {
            confirmation.setText("Please Enter Everything Correctly");
        }

    }
//PreparedStatement ps6 = JDBC.getConnection().prepareStatement("SELECT * FROM klient WHERE nomer = ? and id_mastera=? ");
//
//           ps6.setString(1, getStatikKlientnomer);//getStatikKlientnomer- номер клиента (id-его)
//        ps6.setString(2, "0");
//    ResultSet rs6 = ps6.executeQuery();
//          if (rs6.next()) {
//        try {



    @FXML
    public void DeleteCusInfo(ActionEvent event) throws SQLException {
        name = fokys.getText();

        try {


            if (cusid.getText() != "" || Integer.parseInt(cusid.getText()) < 10000) {
                PreparedStatement ps6 = JDBC.getConnection().prepareStatement("SELECT * FROM klient WHERE nomer = ? and id_mastera=? ");
                ps6.setInt(1, Integer.parseInt(cusid.getText()));
                ps6.setString(2, name);
                ResultSet rs6 = ps6.executeQuery();
                if (rs6.next()) {
                    ErrorrDelet.setText("");
                    try {
                        JDBC.getConnection();
                        if (cusid.getText() != "") {


                            PreparedStatement ps = JDBC.getConnection().prepareStatement("DELETE FROM klient WHERE nomer = ?");

                            ps.setInt(1, Integer.parseInt(cusid.getText()));
                            int k = ps.executeUpdate();
                            ps.close();
                            JDBC.closeConnection();

                            PrintСheck fxPrintExample2 =new PrintСheck();
                            fxPrintExample2.start(getStatikKlientFIO);












                            Goooddd.setText("Клиент отправлен");
                            ErrorrDelet.setText("");
                       //     LoadKlientData


                            //       PreparedStatement ps8 = JDBC.getConnection().prepareStatement("UPDATE users SET balance +50 WHERE id = '" + Integer.parseInt(name) + "'");

                            //       ps8.close();


                        } else {
                            ErrorrDelet.setText("Введите номер клиента");
                        }
                    } catch (NumberFormatException | SQLException e) {
                        Goooddd.setText("");
                        ErrorrDelet.setText("Введите номер клиента");

                    }
                } else {

                    ErrorrDelet.setText("Клиент не ваш");

                }
            } else {
                ErrorrDelet.setText("Введите номер клиента");
            }


        }
        catch (Exception E)
        {
            ErrorrDelet.setText("Проверьте данные");
        }

    }


    public  void LoadMasterInfoKlientMasterStartNomer() throws IOException, SQLException{//метод для вывода при фокусировке на таблицу
        try {
            PreparedStatement ps4 = JDBC.getConnection().prepareStatement("Select * from klient where nomer = ?");
            BalancePageController balancePageController =new BalancePageController();
            balancePageController.getNomerIdFokys();
       //     System.out.println(getStatikKlientnomer);
            ps4.setString(1,valueOf(getStatikKlientnomer));
            ResultSet rs4 = ps4.executeQuery();
            if (rs4.next())
            {

                Master.setText(rs4.getString( "id_mastera"));
                Master1.setText(rs4.getString("FIO"));//
                Master2.setText(rs4.getString("mahina"));
                Master3.setText(rs4.getString("nomerKyzova"));//nomer
                Master4.setText(rs4.getString("god"));//
                Master5.setText(rs4.getString("komentarii"));//komentarii
                //     confirmation.setText("");
            } else {
                //   confirmation.setText("заполните все формы");
            }
            ps4.close();
            rs4.close();
            JDBC.closeConnection();
            //    confirmation.setText("");
        } catch ( NumberFormatException | SQLException e) {
            //    confirmation.setText("заполните все формы");
        }
    }




    @FXML
    public  void LoadMasterInfo() throws IOException, SQLException{
        try {
            PreparedStatement ps4 = JDBC.getConnection().prepareStatement("Select * from klient where nomer = ?");

            ps4.setString(1,valueOf(BalancePageController.getFak()+1));
            ResultSet rs4 = ps4.executeQuery();
            if (rs4.next())
             {
                KlientaMaster.setText(rs4.getString( "id_mastera"));
               KlientFFIIO.setText(rs4.getString("FIO"));//
              KlientKomstr.setText(rs4.getString("komentarii"));
              KlientNomerKyzova.setText(rs4.getString("nomerKyzova"));//
              KlientMachina.setText(rs4.getString("mahina"));//
                KlientGoda.setText(rs4.getString("god"));
               KlientNomerrr.setText(rs4.getString("nomer"));//
                 confirmation.setText("");
            } else {
                confirmation.setText("заполните все формы");
            }
            ps4.close();
            rs4.close();
            JDBC.closeConnection();
            confirmation.setText("");
        } catch ( NumberFormatException | SQLException e) {
            confirmation.setText("заполните все формы");
        }
    }





    @FXML
    public void Deposit(ActionEvent event) throws SQLException {
        try {
            if (depositamount.getText().isEmpty() || Integer.parseInt(depositamount.getText()) < 0) {
                dipositconf.setText("Please Enter A Valid Amount");
            } else {
                Connection con = JDBC.getConnection();
                PreparedStatement ps = null;
                ResultSet rs = null;
                ps = con.prepareStatement("SELECT * FROM users WHERE id = ?");
                ps.setString(1, UserID);
                rs = ps.executeQuery();
                while (rs.next()) {
                    int NewBalance = (rs.getInt("balance") + Integer.parseInt(depositamount.getText()));
                    ps = con.prepareStatement("UPDATE users SET balance =? WHERE id = '" + UserID + "'");
                    ps.setInt(1, NewBalance);
                    ps.executeUpdate();
                }
                dipositconf.setText("Cash Has Been Deposited");
                ps.close();
                rs.close();
                con.close();
            }
        } catch (NumberFormatException | SQLException e) {
            dipositconf.setText("Invalid Database Or Number Format");
        }
        depositamount.setText("");
    }


    @FXML
    public void TransferMoney(ActionEvent event) throws SQLException {
        try {
            if (trnasamount.getText().isEmpty() || Integer.parseInt(trnasamount.getText()) < 0 || retypepass.getText().isEmpty() || receiverid.getText().isEmpty()) {
                transferconf.setText("Please Fill Up Everything Correctly.");
            } else {
                Connection con = JDBC.getConnection();
                PreparedStatement ps = con.prepareStatement("SELECT * FROM users WHERE id = ? and password = ? ");
                receiverid.setStyle("-fx-border-color: #e65100;-fx-border-width:2;-fx-border-radius:20;-fx-background-radius:22;");
                ps.setString(1, UserID);
                ps.setString(2, retypepass.getText());
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    retypepass.setStyle("-fx-border-color: #e65100;-fx-border-width:2;-fx-border-radius:20;-fx-background-radius:22;");
                    int newbalance = rs.getInt("balance") - Integer.parseInt(trnasamount.getText());
                    if (newbalance < 0) {
                        transferconf.setText("You Dont Have Enough Money To Transfer.");
                        trnasamount.setText("");
                        ps.close();
                        rs.close();
                    } else {
                        ps = con.prepareStatement("UPDATE users SET balance = ? WHERE id = '" + UserID + "' ");
                        ps.setInt(1, newbalance);
                        ps.executeUpdate();
                        ps.close();
                        rs.close();
                        PreparedStatement ps2 = con.prepareStatement("SELECT * FROM users WHERE id =?");
                        ps2.setString(1, receiverid.getText());
                        ResultSet rs2 = ps2.executeQuery();
                        if (rs2.next()) {
                            int receivernewbalance = rs2.getInt("balance") + Integer.parseInt(trnasamount.getText());
                            ps2 = con.prepareStatement("UPDATE users SET balance =? WHERE id = '" + receiverid.getText() + "' ");
                            ps2.setInt(1, receivernewbalance);
                            ps2.executeUpdate();
                            ps2.close();
                            rs2.close();
                            transferconf.setText("Transfer Successfull");
                            receiverid.setText("");
                            trnasamount.setText("");
                            retypepass.setText("");
                        } else {
                            transferconf.setText("UserID Invalid , Failed To Transfer.");
                            receiverid.setText("");
                            receiverid.setStyle("-fx-border-color:red;-fx-border-width:2;-fx-border-radius:20;-fx-background-radius:22;");
                            PreparedStatement pss = con.prepareStatement("SELECT * FROM users WHERE id =?");
                            pss.setString(1, UserID);
                            ResultSet rss = pss.executeQuery();
                            while (rss.next()) {
                                int addbalance = rss.getInt("Balance") + Integer.parseInt(trnasamount.getText());
                                pss = con.prepareStatement("UPDATE users SET balance = ? WHERE id = '" + UserID + "'");
                                pss.setInt(1, addbalance);
                                pss.executeUpdate();
                            }
                            pss.close();
                            rss.close();
                        }
                    }
                } else {
                    transferconf.setText("Wrong Password Transaction Failed.");
                    retypepass.setStyle("-fx-border-color:red;-fx-border-width:2;-fx-border-radius:20;-fx-background-radius:22;");
                }
                con.close();
                JDBC.closeConnection();
            }
        } catch (NumberFormatException | SQLException e) {
            transferconf.setText("Invalid Database Or Number Format");
        }
    }
}
