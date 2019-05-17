import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.rmi.shared.BillingService;
import com.rmi.shared.СustomerCard;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import static java.lang.String.valueOf;
import static java.lang.Thread.sleep;
import static javafx.application.Application.launch;

/**
 * класс старта сервера
 * и описание интерфейса  методы которые вызыввет клиент
 */
public class BillingServiceImpl extends UnicastRemoteObject implements BillingService
{

	public static ObservableList<klientData> dataKlientt;
	public static int da=0;// счетчик приема данных
	public static int net=0;// счетчик приема данных
	public static String namestatic;
	public static String godstatic;
	public  static String FIOstatic;
	public static String machinastatic;
	public static String Emailstatic;
	public static String komentariistatic;
	public static String nomerkyzovastatic;
	public static final long serialVersionUID = 1L;
	@FXML
	private TextField FioTEXT;
	@FXML
	private TextField FioTEXT1;
	@FXML
	private TextField FioTEXT2;
	@FXML
	private TextField FioTEXT3;
	@FXML
	private TextField FioTEXT4;
	@FXML
	private TextField FioTEXT5;
	@FXML
	private TextField FioTEXT6;


	private String name;
	private String god;
	private String FIO;
	private String machina;
	private String Email;
	private String komentarii;
	private String nomerkyzova;


	@FXML
	public void AddCustomer(ActionEvent event) throws SQLException, FileNotFoundException {


			FioTEXT.setText(namestatic);
			FioTEXT1.setText(godstatic);
			FioTEXT2.setText(FIOstatic);
			FioTEXT3.setText(machinastatic);
			FioTEXT4.setText(Emailstatic);
			FioTEXT5.setText(komentariistatic);
			FioTEXT6.setText(nomerkyzovastatic);

	}



	public BillingServiceImpl() throws RemoteException
	{
		super();
	}


	@Override
	public void addNewCostomer(СustomerCard card) throws RemoteException//вызываемый клиентом метод1
	{
		namestatic = card.getName();
			godstatic = card.getGod();
			FIOstatic = card.getFIO();
			machinastatic = card.getMachina();
			Emailstatic = card.getEmail();
			komentariistatic = card.getKomentarii();
			nomerkyzovastatic = card.getNomerkyzova();


	}




	@Override
public void addinfoCostomer(СustomerCard card) throws RemoteException//вызываемый клиентом метод2
{

	BalancePageController balancePageController=new BalancePageController();
try {
	balancePageController.AddCustomerrRMI(namestatic,machinastatic,FIOstatic,komentariistatic,godstatic);
}
catch (Exception e)
{}
}



	public void startt() {
		try {
			HostInfo hostInfo=new HostInfo();
			System.setProperty(hostInfo.getRMI_HOSTNAME(),hostInfo.getLocalhost());
			BillingService service = new BillingServiceImpl();
			String serviceName = BillingService.class.getSimpleName();
			Registry registry = LocateRegistry.createRegistry(1099);
			registry.rebind(serviceName, service);
			System.out.println("Start " + serviceName);
		} catch (RemoteException e) {
			System.err.println("RemoteException : " + e.getMessage());
			System.exit(1);
		} catch (Exception e) {
			System.err.println("Exception : " + e.getMessage());
			System.exit(2);
		}
	}
}
