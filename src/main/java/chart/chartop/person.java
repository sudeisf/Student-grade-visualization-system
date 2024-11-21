package chart.chartop;

// used to structure of observable list that are used to display data on tableview
public class person {
    private final String course3;
    private final int score3;


    public person(String course, int score) {
        this.course3 = course;
        this.score3 = score;

    }



    public String getCourse() {
        return course3;
    }

    public int getScore() {
        return score3;
    }



}