package chart.chartop;

// Used in the ObservableList<User3> to display data in the TableView for Semester 2.

public class User3 {
    private final String tableView2col1;


    private final float tableView2col2;

    public User3(String tableView2col1, float tableView2col2) {
        this.tableView2col1 = tableView2col1;
        this.tableView2col2 = tableView2col2;
    }

    public String getTableView2col1() {
        return tableView2col1;
    }

    public float getTableView2col2() {
        return tableView2col2;
    }
}
