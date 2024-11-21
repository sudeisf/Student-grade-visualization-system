package chart.chartop;

//The User class represents a student with their course, score, grade, and grade value.

public class User {

    // Instance variables to store course, score, grade, and grade value
    private final String course2;
    private final int score2;

    public User(String course, int score) {
        this.course2 = String.valueOf(course);
        this.score2 = Integer.parseInt(String.valueOf(score));
    }


    public String getCourse() {
        return course2;
    }

    public int getScore() {
        return score2;
    }


}
