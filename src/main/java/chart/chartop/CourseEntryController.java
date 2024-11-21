package chart.chartop;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


public class CourseEntryController implements Initializable {

        // This variable store the score entered by user
        public static float introToPro;
        public static float CalculusText;
        public static float PhysicsText;
        public static float dsaText;
        public static float linearAlgebraText;
        public static float magnetismText;

        public static float AlgorithmText;
        public static float EquationText;
        public static float opticsText;
        public static float dataBText;
        public static float numTheoryText;
        public static float mechanicsText;

        public static float SWEText;
        public static float statisticsText;
        public static float thermodynamicsTexr;
        public static float NetworkText;
        public static float GthoryText;
        public static float QmechanicsText;

        public static int studId;
        public static int department_feild;

        public static String StringCheck[] = new String[21];
        public static boolean check = false;
        public static boolean check2 = true;

        public static ObservableList<User2> list = FXCollections.observableArrayList();   
        public static ObservableList<User3> list2 = FXCollections.observableArrayList();
        public static ObservableList<User4> list3 = FXCollections.observableArrayList();


    @FXML
    private TextField lastname;
    @FXML
    private TextField Firstname;
    @FXML
    private TextField department;
    @FXML
    private TextField gender;
    @FXML
    private TextField studentID;


    @FXML
    private TextField AlgorithmTextField;

    @FXML
    private Label Algorithms;

    @FXML
    private Label Calculus;

    @FXML
    private TextField CalculusTextFeIld;

    @FXML
    private Label ComputerNewtorks;

    @FXML
    private Label Database_management;

    @FXML
    private Label Deferential_Equations;

    @FXML
    private TextField EquationTextFeild;

    @FXML
    private Label Graph_theory;

    @FXML
    private TextField GthoryTextFeild;

    @FXML
    private TextField IntroToProgrammingTextField;

    @FXML
    private Label Mechanics;

    @FXML
    private TextField NetworkTextFeild;

    @FXML
    private Label Number_theory;

    @FXML
    private Label Optics;

    @FXML
    private Label Physics;

    @FXML
    private TextField PhysicsTextFeild;

    @FXML
    private TextField QmechanicsTextFeild;

    @FXML
    private Label Quantum_mechanics;

    @FXML
    private Label Software_engineering;

    @FXML
    private TextField SweTextFeild;

    @FXML
    private Label Thermodynamics;

    @FXML
    private TextField dataBTextFeild;

    @FXML
    private Label dsa;

    @FXML
    private TextField dsaTextFeild;

    @FXML
    private Label linearAlgebra;

    @FXML
    private TextField linearAlgebraTextFeild;

    @FXML
    private Label magnetism;

    @FXML
    private TextField magnetismTextFeild;

    @FXML
    private TextField mechanicsTextFeild;

    @FXML
    private TextField numTheoryTextFeild;

    @FXML
    private TextField opticsTextFeild;

    @FXML
    private Label programming;

    @FXML
    private Button saveButton;

    @FXML
    private Label semLabel;

    @FXML
    private Label semLabel1;

    @FXML
    private Label semLabel2;

    @FXML
    private Label statistics;

    @FXML
    private TextField statisticsTextFeild;

    @FXML
    private TableView<User2> tableView1;

    @FXML
    private TableColumn<User2, String> tableView1col1;

    @FXML
    private TableColumn<User2, Integer> tableView1col2;

    @FXML
    private TableView<User3> tableView2;

    @FXML
    private TableColumn<User3, String> tableView2col1;

    @FXML
    private TableColumn<User3, Integer> tableView2col2;

    @FXML
    private TableView<User4> tableView3;

    @FXML
    private TableColumn<User4, String> tableView3col1;

    @FXML
    private TableColumn<User4, Integer> tableView3col2;

    @FXML
    private TextField thermodynamicsTexrFeild;

  //This is button function that close the current page and update the new one
    @FXML
    void nextToLog(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Scene Scene2 = opticsTextFeild.getScene();
        Stage currentStage = (Stage) Scene2.getWindow();
        currentStage.close();
        LoginApp log =new LoginApp();
        log.start(stage);


    }
    // This function saves data in to the database and show case the values inside the tables in gui 
    @FXML
    public void nextToLogin(ActionEvent event) throws SQLException {

        try  {
            introToPro = Float.parseFloat(IntroToProgrammingTextField.getText());
            CalculusText = Float.parseFloat(CalculusTextFeIld.getText());
            PhysicsText = Float.parseFloat(PhysicsTextFeild.getText());
            dsaText = Float.parseFloat(dsaTextFeild.getText());
            linearAlgebraText = Float.parseFloat(linearAlgebraTextFeild.getText());
            magnetismText = Float.parseFloat(magnetismTextFeild.getText());
   
           AlgorithmText = Float.parseFloat(AlgorithmTextField.getText());
            EquationText = Float.parseFloat(EquationTextFeild.getText());
           opticsText = Float.parseFloat(opticsTextFeild.getText());
           dataBText = Float.parseFloat(dataBTextFeild.getText());
           numTheoryText = Float.parseFloat(numTheoryTextFeild.getText());
           mechanicsText = Float.parseFloat(mechanicsTextFeild.getText());
   
           SWEText = Float.parseFloat(SweTextFeild.getText());
           statisticsText = Float.parseFloat(statisticsTextFeild.getText());
           thermodynamicsTexr = Float.parseFloat(thermodynamicsTexrFeild.getText());
           NetworkText = Float.parseFloat(NetworkTextFeild.getText());
           GthoryText = Float.parseFloat(GthoryTextFeild.getText());
            QmechanicsText = Float.parseFloat(QmechanicsTextFeild.getText());
   
           studId = Integer.parseInt(studentID.getText());
           department_feild = Integer.parseInt(department.getText());
           check = true;
           } catch (Exception e) {  // Showing the error message when there is exception
               Alert alert = new Alert(AlertType.INFORMATION);
               alert.setTitle("Information Dialog");
               alert.setHeaderText(null);
               alert.setContentText("ERROR!! You entered invalid input Please try again");
               alert.showAndWait();
           }
          
          if (check){   // check if the correct is entered
           String programingLabel = programming.getText();
           StringCheck[0] = programingLabel;
           String calculusLabel = Calculus.getText();
           StringCheck[1] = calculusLabel;
           String physics = Physics.getText();
           StringCheck[2] = physics;
           String Dsa = dsa.getText();
           StringCheck[3] = Dsa;
           String linearAlgeb = linearAlgebra.getText();
           StringCheck[4] = linearAlgeb;
           String magnet = magnetism.getText();
           StringCheck[5] = magnet;
   
           String algorithm = Algorithms.getText();
           StringCheck[6] = algorithm;
           String Dequations = Deferential_Equations.getText();
           StringCheck[7] = Dequations;
           String opticslabel = Optics.getText();
           StringCheck[8] = opticslabel;
           String database_manament_label = Database_management.getText();
           StringCheck[9] = database_manament_label;
           String number_theory_label = Number_theory.getText();
           StringCheck[10] = number_theory_label;
           String mechanicslabel = Mechanics.getText();
           StringCheck[11] = mechanicslabel;

           //semester 3 label getter
           String swelabel = Software_engineering.getText();
           StringCheck[12] = swelabel;
           String statisticslabel = statistics.getText();
           StringCheck[13] = statisticslabel;
           String thermolabel = Thermodynamics.getText();
           StringCheck[14] = thermolabel;
           String network = ComputerNewtorks.getText();
           StringCheck[15] = network;
           String g_thorylabel = Graph_theory.getText();
           StringCheck[16] = g_thorylabel;
           String Qmechanicslabel = Quantum_mechanics.getText();
           StringCheck[17] = Qmechanicslabel;
   
           //course entry
           String firstname = Firstname.getText();
           StringCheck[18] = firstname;
           String lastN = lastname.getText();
           StringCheck[19] = lastN;
           String Gender = gender.getText();
           StringCheck[20] = Gender;

           if(isInteger(StringCheck)){  // showing the error message the entered for string variable is integer
               Alert alert = new Alert(AlertType.INFORMATION);
               alert.setTitle("Information Dialog");
               alert.setHeaderText(null);
               alert.setContentText("ERROR!! You entered invalid input Please try again");
               alert.showAndWait();
               check2 = false;
           }

           if (check2){   // check if the correct data is entered 
            
            // Add the data to the User2 list nop
           list.addAll(
                     new User2("Introduction to Programming",introToPro),
                     new User2("Calculus I",CalculusText),
                     new User2("data structure",PhysicsText),
                     new User2("Physics 101",dsaText),
                     new User2("Linear Algebra",linearAlgebraText),
                     new User2("Electricity and Magnetism",magnetismText)
             );
             list2.addAll(
                     new User3("Algorithms",AlgorithmText),
                     new User3("Deferential Equations",EquationText),
                     new User3("Optics",opticsText),
                     new User3("Database management",dataBText),
                     new User3("Number theory",numTheoryText),
                     new User3("Mechanics",mechanicsText)
             );
             list3.addAll(
                     new User4("Software engineering",SWEText),
                     new User4("probablity and statistics",statisticsText),
                     new User4("Thermodynamics",thermodynamicsTexr),
                     new User4("Computer networks",NetworkText),
                     new User4("Graph theory",GthoryText),
                     new User4("Quantum mechanics",QmechanicsText)
             );
             Connection conn = DriverManager.getConnection("jdbc:sqlite:student1.db");
           // first semester to data base
               database.insertScoreData(conn,studId,100,programingLabel,firstname,introToPro);
               database.insertScoreData(conn,studId, 101, calculusLabel,firstname,CalculusText);
               database.insertScoreData(conn,studId, 102, physics,firstname,PhysicsText);
               database.insertScoreData(conn,studId, 103, Dsa,firstname,dsaText);
               database.insertScoreData(conn,studId, 104, linearAlgeb,firstname,linearAlgebraText);
               database.insertScoreData(conn,studId, 105, magnet,firstname,magnetismText);
           // second semester
               database.insertScoreData(conn,studId, 106, algorithm,firstname,AlgorithmText);
               database.insertScoreData(conn,studId, 107, Dequations,firstname,EquationText);
               database.insertScoreData(conn,studId, 108, opticslabel,firstname,opticsText);
               database.insertScoreData(conn,studId, 109, database_manament_label,firstname,dataBText);
               database.insertScoreData(conn,studId, 110, number_theory_label,firstname,numTheoryText);
               database.insertScoreData(conn,studId, 111, mechanicslabel,firstname,mechanicsText);
            //third semester
               database.insertScoreData(conn,studId, 112, swelabel,firstname,SWEText);
               database.insertScoreData(conn,studId, 113, statisticslabel,firstname,statisticsText);
               database.insertScoreData(conn,studId, 114, thermolabel,firstname,thermodynamicsTexr);
               database.insertScoreData(conn,studId, 115, network,firstname,NetworkText);
               database.insertScoreData(conn,studId, 116, g_thorylabel,firstname,GthoryText);
               database.insertScoreData(conn,studId, 117, Qmechanicslabel,firstname,QmechanicsText);
   
   
           if (firstname == null || lastname == null || department == null ||  Gender == null) {
               System.err.println("Error: One or more TextField is null.");
               return;
           }
   
   
           String url = "jdbc:sqlite:student1.db";
           // updating the student class
           try (Connection connection = DriverManager.getConnection(url);
                PreparedStatement statement = connection.prepareStatement(
                        "INSERT INTO Students (StudentID, FirstName, LastName, Sex, DepartmentID) VALUES (?,?,?,?,?)")) {
   
               statement.setInt(1, studId);
               statement.setString(2, firstname);
               statement.setString(3, lastN);
               statement.setString(4, Gender);
               statement.setInt(5, department_feild);
   
               statement.executeUpdate();
   
           } catch (SQLException e) {
               System.out.println(e.getLocalizedMessage());
           }
   
   
           // Update the TableView
           tableView1.setItems(list);
           tableView2.setItems(list2);
           tableView3.setItems(list3);
          }
        }   

       
           }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        tableView1col1.setCellValueFactory(new PropertyValueFactory<User2, String>("tableView1col1"));
        tableView1col2.setCellValueFactory(new PropertyValueFactory<User2, Integer>("tableView1col2"));

        tableView2col1.setCellValueFactory(new PropertyValueFactory<User3, String>("tableView2col1"));
        tableView2col2.setCellValueFactory(new PropertyValueFactory<User3, Integer>("tableView2col2"));

        tableView3col1.setCellValueFactory(new PropertyValueFactory<User4, String>("tableView3col1"));
        tableView3col2.setCellValueFactory(new PropertyValueFactory<User4, Integer>("tableView3col2"));

        tableView1.setItems(list);
        tableView2.setItems(list2);
        tableView3.setItems(list3);
    }

//    public static boolean isInteger(String[] input) { // A method that take array of string variable and handle exception
//        int i =0;
//        int j = 0;
//        while(i<=20){
//             try {
//            Integer.parseInt(input[i]);
//        } catch (NumberFormatException e) {
//            j++;
//        }
//        i++;
//        }
//        if (j == 20){
//            return false;
//        } else {
//            return true;
//        }
//
//    }
    public static boolean isInteger(String[] input) {
        for (int i = 0; i < input.length; i++) {
            try {
                Integer.parseInt(input[i]);
            } catch (NumberFormatException e) {
                return false; // If any element fails to parse, return false immediately
            }
        }
        return true; // If all elements parse successfully, return true
    }


}
