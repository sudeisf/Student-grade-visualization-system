package chart.chartop;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;


public class chartController implements Initializable {
  static String url1 = "jdbc:sqlite:student1.db";
  public static String coursename1[] =  new String [6];
  public static String coursename2[] = new String[6];
  public static String coursename3[] = new String[6];
  public static int scorevalue1[] = new int [6];
  public static int scorevalue2[] = new int [6];
  public static int scorevalue3[] = new int[6];

  
    @FXML
    public BarChart<String,Integer> ChartBox;

      @FXML
    public Label Mean;
       @FXML
    public Label Median;

    @FXML
    public TableView<User> table1;

    @FXML
    private TableView<person> table2;

    @FXML
    private TableView<person2> table3;

    public TableColumn<User,String> course;
    @FXML
    public TableColumn<User,Integer> score;
    @FXML
    public TableColumn<User,String> gradeColumn;
    @FXML
    public TableColumn<User,Integer> gradeValueColumn;

    @FXML
    private TableColumn<person, String> course2;
    @FXML
    private TableColumn<person, Integer> score2;

    public TableColumn<User,String> gradeColumn2;
    @FXML
    public TableColumn<User,Integer> gradeValueColumn2;
    @FXML
    private TableColumn<person2, String> course3;

    @FXML
    private TableColumn<person2, Integer> score3;
    @FXML
    public TableColumn<User,String> gradeColumn3;
    @FXML
    public TableColumn<User,Integer> gradeValueColum3;

    @FXML
    private Label studentid;

    @FXML
    private Label studentname;

    @FXML
    private Label DepartmentID;

    @FXML
    private void handleMouseClicked(MouseEvent event) {
        // Clear existing data in the chart
        ChartBox.getData().clear();
        // Number of course the student take
        final int  numcourse = 6;
        // variable for storing the sum
        int sum = 0;
        // Array to store the score of all course
        int[] sort = new int[numcourse];
        int i = 0;
      
        // Iterate through all rows in the table
        for (User user : table1.getItems()) {
            // Create a series for each user
            XYChart.Series<String, Integer> series = new XYChart.Series<>();
            series.setName(user.getCourse());
            series.getData().add(new XYChart.Data<>(user.getCourse(), user.getScore()));
            
            // Add the series to the chart
            ChartBox.getData().add(series);

            // Adding the score
            sum = sum + user.getScore();

            // Appending the score into the array
            sort[i] = user.getScore();
            i++;

        }
        Arrays.sort(sort);
        // Variable to store the median
        float median = (float)((sort[sort.length/2-1]) + (sort[sort.length/2]))/2;


        // variable for storing the mean
        int mean_value = sum/numcourse;

        // Displaying the Mean and Median
        Mean.setText(Integer.toString(mean_value));
        Median.setText(Float.toString(median));


        // Set the bar and category gaps
        ChartBox.setBarGap(2.0);
        ChartBox.setCategoryGap(2.0);
    }

    @FXML
    private void Table2MouseClicked(MouseEvent event) {
        // Clear existing data in the chart
        ChartBox.getData().clear();

        // Number of course the student take
        final int  numcourse = 6;
        // variable for storing the sum
        int sum = 0;
        // Array to store the score of all course
        int[] sort = new int[numcourse];
        int i = 0;

        // Iterate through all rows in the table
        for (person person : table2.getItems()) {
            // Create a series for each user
            XYChart.Series<String, Integer> series = new XYChart.Series<>();
            series.setName(person.getCourse());
            series.getData().add(new XYChart.Data<>(person.getCourse(), person.getScore()));

            // Add the series to the chart
            ChartBox.getData().add(series);

            // Adding the score
            sum = sum + person.getScore();

            // Appending the score into the array
            sort[i] = person.getScore();
            i++;
        }
        Arrays.sort(sort);
        // Variable to store the median
        float median = (float)((sort[sort.length/2-1]) + (sort[sort.length/2]))/2;


        // variable for storing the mean
        int mean_value = sum/numcourse;

        // Displaying the Mean and Median
        Mean.setText(Integer.toString(mean_value));
        Median.setText(Float.toString(median));


        // Set the bar and category gaps
        ChartBox.setBarGap(2.0);
        ChartBox.setCategoryGap(2.0);
    }
   @FXML
    private void Table3MouseClicked(MouseEvent event) {
        // Clear existing data in the chart
        ChartBox.getData().clear();

        // Number of course the student take
        final int  numcourse = 6;
        // variable for storing the sum
        int sum = 0;
        // Array to store the score of all course
        int[] sort = new int[numcourse];
        int i = 0;

        // Iterate through all rows in the table
        for (person2 person2 : table3.getItems()) {
            // Create a series for each user
            XYChart.Series<String, Integer> series = new XYChart.Series<>();
            series.setName(person2.getCourse());
            series.getData().add(new XYChart.Data<>(person2.getCourse(), person2.getScore()));

            // Add the series to the chart
            ChartBox.getData().add(series);

            // Adding the score
            sum = sum + person2.getScore();

            // Appending the score into the array
            sort[i] = person2.getScore();
            i++;
        }
        Arrays.sort(sort);
        // Variable to store the median
        float median = (float)((sort[sort.length/2-1]) + (sort[sort.length/2]))/2;


        // variable for storing the mean
        int mean_value = sum/numcourse;

        // Displaying the Mean and Median
        Mean.setText(Integer.toString(mean_value));
        Median.setText(Float.toString(median));


        // Set the bar and category gaps
        ChartBox.setBarGap(2.0);
        ChartBox.setCategoryGap(2.0);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
      try (Connection connection = DriverManager.getConnection(url1)){

       String query2 = "Select CourseName From Courses ORDER BY CourseID ";
       
       // The below code helps to fetch the course from the database store it into array
       try (PreparedStatement preparedStatements = connection.prepareStatement(query2)) {
       int i = 0;
       int j = 0;
       int k = 0;
       try (ResultSet resultSets = preparedStatements.executeQuery()) {
        while (resultSets.next()){
          if (i <= 17){
             if ((i < 6) && (i >= 0)){
            coursename1[i] = resultSets.getString("CourseName");
            i++;
          }

          else if ((i >= 6) && (i < 12)){
            coursename2[j] = resultSets.getString("CourseName");
            j++;
            i++;
          }

          else {
            coursename3[k] = resultSets.getString("CourseName");
            k++;
            i++;
          }
          }
         
        }
       }

       }
      } catch (SQLException e) {
        e.printStackTrace();
    }
        
        // This code fetch the score from database and store it into array 
        try (Connection connection = DriverManager.getConnection(url1)){
            String query3 = "SELECT Score FROM Scores WHERE StudentID " +" = "+ logincontroller.user_i+ " ORDER BY CourseId";

            try (PreparedStatement preparedStatements = connection.prepareStatement(query3)) {
                int a = 0;
                int b = 0;
                int c = 0;
                try (ResultSet resultSets = preparedStatements.executeQuery()) {
                    while (resultSets.next()) {
                        System.out.println('a');
                        if (a <= 17) {
                            if ((a >= 0) && (a < 6)) {
                                scorevalue1[a] = resultSets.getInt("Score");
                                System.out.println(scorevalue1[a]); // Fix array indexing issue
                                a++;
                            } else if ((a >= 6) && (a < 12)) {
                                scorevalue2[b] = resultSets.getInt("Score");
                                b++;
                                a++;
                            } else {
                                scorevalue3[c] = resultSets.getInt("Score");
                                c++;
                                a++;
                            }
                        }
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        course.setCellValueFactory(new PropertyValueFactory<User,String>("course"));
        score.setCellValueFactory(new PropertyValueFactory<User, Integer>("score"));

        ObservableList<User> list = FXCollections.observableArrayList(
            new User(coursename1[0],scorevalue1[0]),
            new User(coursename1[1],scorevalue1[1]),
            new User(coursename1[2],scorevalue1[2]),
            new User(coursename1[3],scorevalue1[3]),
            new User(coursename1[4],scorevalue1[4]),
            new User(coursename1[5],scorevalue1[5])

     );
      
      course2.setCellValueFactory(new PropertyValueFactory<person,String>("course"));
      score2.setCellValueFactory(new PropertyValueFactory<person, Integer>("score"));
       
        ObservableList<person> list2 = FXCollections.observableArrayList(
            new person(coursename2[0],scorevalue2[0]),
            new person(coursename2[1],scorevalue2[1]),
            new person(coursename2[2],scorevalue2[2]),
            new person(coursename2[3],scorevalue2[3]),
            new person(coursename2[4],scorevalue2[4]),
            new person(coursename2[5],scorevalue2[5])

      );
      
      course3.setCellValueFactory(new PropertyValueFactory<person2,String>("course"));
      score3.setCellValueFactory(new PropertyValueFactory<person2, Integer>("score"));
        

        ObservableList<person2> list3;
        list3 = FXCollections.observableArrayList(
             new person2(coursename3[0],scorevalue3[0]),
             new person2(coursename3[1],scorevalue3[1]),
             new  person2(coursename3[2],scorevalue3[2]),
             new person2(coursename3[3],scorevalue3[3]),
             new person2(coursename3[4],scorevalue3[4]),
             new person2(coursename3[5],scorevalue3[5])

       );
    
      // putting the data into table of the scene builder
      table1.setItems(list);
      table3.setItems(list3);
      table2.setItems(list2);
      studentname.setText(logincontroller.user);
      studentid.setText(Integer.toString(logincontroller.user_i));
      DepartmentID.setText(logincontroller.deptname);
      

    }
}