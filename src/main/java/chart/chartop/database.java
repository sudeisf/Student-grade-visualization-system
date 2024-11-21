package chart.chartop;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class database {
    static String url = "jdbc:sqlite:student1.db";


    // Method to create the necessary database tables if they do not exist

    public static void createDatabase() {
        try (Connection con = DriverManager.getConnection(url)) {
            Statement state = con.createStatement();

            //create Department Table

            String createDepartmentTable = "CREATE TABLE IF NOT EXISTS Department (" +
                    "DepartmentID INTEGER PRIMARY KEY," +
                    "DepartmentName TEXT NOT NULL" +
                    ")";

            state.executeUpdate(createDepartmentTable);

            //create Students Table

            String createStudentsTable = "CREATE TABLE IF NOT EXISTS Students (" +
                    "StudentID INTEGER PRIMARY KEY," +
                    "FirstName TEXT NOT NULL," +
                    "LastName TEXT NOT NULL," +
                    "Sex TEXT," +
                    "DepartmentID INTEGER," +
                    " FOREIGN KEY (DepartmentID) REFERENCES Department(DepartmentID)" +
                    ")";
            state.executeUpdate(createStudentsTable);
            //create Semester Table

            String createSemesterTable = "CREATE TABLE IF NOT EXISTS Semester (" +
                    "SemesterID INTEGER PRIMARY KEY," +
                    "SemesterName TEXT" +
                    ")";

            state.executeUpdate(createSemesterTable);
            //create Courses Table


            String createCoursesTable = "CREATE TABLE IF NOT EXISTS Courses (" +
                    "CourseID INTEGER PRIMARY KEY," +
                    "CourseName TEXT NOT NULL," +
                    "Credits INTEGER," +
                    "SemesterID INTEGER," +
                    "StudentID INTEGER," +
                    "FOREIGN KEY (SemesterID) REFERENCES Semester(SemesterID)," +
                    "FOREIGN KEY (StudentID) REFERENCES Students(StudentID)" +
                    ")";

            state.executeUpdate(createCoursesTable);

            // create teachers table

            String createTeachersTable = "CREATE TABLE IF NOT EXISTS Teachers (" +
                    "TeacherID INTEGER PRIMARY KEY," +
                    "FirstName TEXT NOT NULL," +
                    "LastName TEXT NOT NULL," +
                    "Sex TEXT," +
                    "DepartmentID INTEGER," +
                    " FOREIGN KEY (DepartmentID) REFERENCES Department(DepartmentID)" +
                    ")";

            state.executeUpdate(createTeachersTable);
            //crete score table

            String createScoreTable = "CREATE TABLE IF NOT EXISTS Scores (" +
                    "StudentID INTEGER," +
                    "CourseName TEXT," +
                    "CourseID INTEGER," +
                    "StudentName TEXT," +
                    "Score FLOAT," +  // Assuming you want to store floating-point numbers for scores
                    "PRIMARY KEY (StudentID, CourseID)," +
                    "FOREIGN KEY (StudentID) REFERENCES Students(StudentID)," +
                    "FOREIGN KEY (CourseID) REFERENCES Courses(CourseID)" +
                    ")";

            state.executeUpdate(createScoreTable);


        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    private static void insertDepartmentData(Connection connection, int departmentID, String departmentName) {
        String insertDataSQL = "INSERT INTO Department (DepartmentID, DepartmentName) VALUES (?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertDataSQL)) {
            preparedStatement.setInt(1, departmentID);
            preparedStatement.setString(2, departmentName);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    // insert student data

    private static void insertStudentData(Connection connection, int studentID, String firstName, String lastName, String sex, int departmentID) {
        String insertDataSQL = "INSERT INTO Students (StudentID, FirstName, LastName, Sex, DepartmentID) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertDataSQL)) {
            preparedStatement.setInt(1, studentID);
            preparedStatement.setString(2, firstName);
            preparedStatement.setString(3, lastName);
            preparedStatement.setString(4, sex);
            preparedStatement.setInt(5, departmentID);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    // insert course data

    private static void insertCourseData(Connection connection, int courseID, String courseName, int credits, int SemesterID) {
        String insertDataSQL = "INSERT INTO Courses (CourseID, CourseName, Credits, SemesterID) VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertDataSQL)) {
            preparedStatement.setInt(1, courseID);
            preparedStatement.setString(2, courseName);
            preparedStatement.setInt(3, credits);
            preparedStatement.setInt(4, SemesterID);
            preparedStatement.executeUpdate();
        } catch (Exception e) {

            System.out.println(e.getLocalizedMessage());
        }
    }

    //insert teacher data

    private static void insertTeacherData(Connection connection, int teacherID, String firstName, String lastName, String sex, int departmentID) {
        String insertDataSQL = "INSERT INTO Teachers (TeacherID, FirstName, LastName, Sex, DepartmentID) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertDataSQL)) {
            preparedStatement.setInt(1, teacherID);
            preparedStatement.setString(2, firstName);
            preparedStatement.setString(3, lastName);
            preparedStatement.setString(4, sex);
            preparedStatement.setInt(5, departmentID);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    //insert semester data

    public static void insertSemesterData(Connection connection, int semesterID, String semesterName) {
        String insertDataSQL = "INSERT INTO Semester (SemesterID, SemesterName) VALUES (?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertDataSQL)) {
            preparedStatement.setInt(1, semesterID);
            preparedStatement.setString(2, semesterName);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    // insert score data

    public static void insertScoreData(Connection connection, int studentID, int courseId, String courseName, String studentName, Float score) {
        String insertScoreData = "INSERT INTO Scores (StudentID, CourseName,CourseID,StudentName, Score) VALUES (?, ?, ?, ?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertScoreData)) {
            preparedStatement.setInt(1, studentID);
            preparedStatement.setString(2, courseName);
            preparedStatement.setInt(3,courseId);
            preparedStatement.setString(4, studentName);
            preparedStatement.setFloat(5, score);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // main method

    public static void main(String[] args) {
        createDatabase();

        try {
            // Establish a database connection
            Connection con = DriverManager.getConnection(url);


            insertDepartmentData(con, 1, "Computer Science");
            insertDepartmentData(con, 2, "Mathematics");
            insertDepartmentData(con, 3, "Physics");

            // Insert sample data for Courses

            insertCourseData(con,100, "Introduction to Programming", 3, 1);
            insertCourseData(con,101 , "Calculus I", 4, 1);
            insertCourseData(con,102 , "Physics 101", 4, 1);
            insertCourseData(con,103 , "Data Structures", 3, 1);
            insertCourseData(con,104 , "Linear Algebra", 4, 1);
            insertCourseData(con, 105, "Electricity and Magnetism", 4, 1);

            insertCourseData(con,106 , "Algorithms", 3, 2);
            insertCourseData(con, 107, "Differential Equations", 4, 2);
            insertCourseData(con, 108, "Optics", 4, 2);
            insertCourseData(con, 109, "Database Management Systems", 3, 2);
            insertCourseData(con, 110, "Number Theory", 4, 2);
            insertCourseData(con, 111, "Mechanics", 4, 2);

            insertCourseData(con,112 , "Software Engineering", 3, 3);
            insertCourseData(con, 113, "Probability and Statistics", 4, 3);
            insertCourseData(con, 114, "Thermodynamics", 4, 3);
            insertCourseData(con,115 , "Computer Networks", 3, 3);
            insertCourseData(con,116 , "Graph Theory", 4, 3);
            insertCourseData(con,117 , "Quantum Mechanics", 4, 3);

            // Insert sample data for Teachers
            insertTeacherData(con, 1, "Professor", "Smith", "Male", 1);
            insertTeacherData(con, 2, "Professor", "Johnson", "Male", 2);
            insertTeacherData(con, 3, "Professor", "Brown", "Male", 3);
            insertTeacherData(con, 4, "Instructor", "windy", "Female", 3);
            // Insert sample data for Semesters
            insertSemesterData(con, 1, "Fall 2022");
            insertSemesterData(con, 2, "Spring 2023");
            insertSemesterData(con, 3, "Summer 2023");


            con.close();
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }


}


