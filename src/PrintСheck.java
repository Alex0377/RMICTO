
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import java.util.Date;
import java.util.Random;


public class PrintСheck
{
    private Label jobStatus = new Label();


    public void start( String name)
    {

        final Random random = new Random();
        Stage newWindow = new Stage();
        newWindow.setTitle("ewrfwefweffew");
        // Create the VBox
        final VBox root = new VBox(5);

        // Create the Text Label
        Label textLabel = new Label("Введите информацию о заказе:");

        // Create the TextArea
        final TextArea textArea = new TextArea();

        // Create the Buttons
        Button printTextButton = new Button("печать чек");
       Button printSceneButton = new Button("вставить данные");

        // Create the Event-Handlers for the Buttons
        printTextButton.setOnAction(new EventHandler <ActionEvent>()
        {

            public void handle(ActionEvent event)
            {



                print(textArea);
            }
        });

       printSceneButton.setOnAction(new EventHandler <ActionEvent>()
        {

            public void handle(ActionEvent event)
            {
                Date date = new Date();


                textArea.appendText(" АКТ  № "  + String.valueOf(random.nextInt(1000))    +"  от "+ date.toString()+" \n" +
                        "на выполнение работ(услуг)\n" +
                        "Работа с клиентом оконченна "+name+" цена работы- " +
                        " коментарии- Вышеперечисленные работы выполнены в \nполном объеме, с надлежащим качеством и в установленные \nсроки. Стороны претензий друг к другу не имеют.");

            }
        });

        // Create the Status Box
        HBox jobStatusBox = new HBox(5, new Label("Статус: "), jobStatus);
        // Create the Button Box
        HBox buttonBox = new HBox(5, printTextButton,printSceneButton);//, printSceneButton

        // Add the Children to the VBox
        root.getChildren().addAll(textLabel, textArea, buttonBox, jobStatusBox);
        // Set the Size of the VBox
        root.setPrefSize(700, 500);

        // Set the Style-properties of the VBox
        root.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");

        // Create the Scene
        Scene scene = new Scene(root);
        // Add the scene to the Stage
        newWindow.setScene(scene);
        // Set the title of the Stage
        newWindow.setTitle("Чек");
        // Display the Stage
        newWindow.show();
    }



    private void print(Node node)
    {
        // Define the Job Status Message
        jobStatus.textProperty().unbind();
        jobStatus.setText("Creating a printer job...");

        // Create a printer job for the default printer
        PrinterJob job = PrinterJob.createPrinterJob();

        if (job != null)
        {
            // Show the printer job status
            jobStatus.textProperty().bind(job.jobStatusProperty().asString());

            // Print the node
            boolean printed = job.printPage(node);

            if (printed)
            {
                // End the printer job
                job.endJob();
            }
            else
            {
                // Write Error Message
                jobStatus.textProperty().unbind();
                jobStatus.setText("Printing failed.");
            }
        }
        else
        {
            // Write Error Message
            jobStatus.setText("Could not create a printer job.");
        }
    }

}
