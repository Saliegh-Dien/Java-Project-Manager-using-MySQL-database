import java.sql.*;
import java.util.Date;
//the above are the imports required for this class

//======================================================================================================================
//this class is to check if a project is overdue

class dates {
    public static void overdue_projects() {
        try {
            //this section is required code to get connection to a mysql database and to make mysql statements through
            // this IDE on Java
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/poisePMS?",
                    "root",
                    "Tepidrainbow909");
            Statement statement = connection.createStatement();
            ResultSet results;

            int overdue_projects_counter = 0;
            //counter for overdue projects

//======================================================================================================================
            Date current_date = new Date();
            //above gets the current date into variable

            results = statement.executeQuery("SELECT * FROM poised_project_table");
            //executes query on mysql

            while (results.next()) {
                //this loops results in order for us to pull the values from the table in database
                //using results.get""("")

                results.getString("proj_num");
                results.getString("proj_name");

                Date due_date = results.getDate("due_date");
                String completion_status = results.getString("completion_status");

                //below states that if the project is incomplete and due date is has already passed current date
                //then display the project and +1 to overdue projects counter
                if (due_date.before(current_date) && completion_status.equals("incomplete")) {
                    System.out.println("Project number: " + results.getString("proj_num"));
                    System.out.println("Project name: " + results.getString("proj_name"));
                    System.out.println("Status: OVERDUE ["+due_date+"]\n");
                    overdue_projects_counter++;
                }
            }
            results.close();
            //closes Result set

            System.out.println("\nOverdue projects count: " + overdue_projects_counter);
            //prints amount of projects overdue
        }
        catch (SQLException e) {
            System.out.println("SQL-ERROR with viewing overdue projects");
            e.printStackTrace();
        }//custom sql error
    }
}
