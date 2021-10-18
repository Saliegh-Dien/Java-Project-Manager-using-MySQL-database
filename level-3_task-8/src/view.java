import java.sql.*;

class view{
    public static void view_all_projects() {
        try {
            //this section is required code to get connection to a mysql database and to make mysql statements through
            // this IDE on Java
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/poisePMS?",
                    "root",
                    "Tepidrainbow909");
            Statement statement = connection.createStatement();
            ResultSet results;

//======================================================================================================================

            results = statement.executeQuery("SELECT * FROM poised_project_table");
            //executes query on mysql

            while (results.next()) {
                //this loops results in order for us to pull the values from the table in database
                //using results.get""("")
                System.out.println("Project number: " + results.getInt("proj_num")
                        + "\nProject name: " + results.getString("proj_name")
                        + "\nBuilding type: " + results.getString("type")
                        + "\nAddress: " + results.getString("address")
                        + "\nERF number: " + results.getInt("ERF")
                        + "\nTotal fee: " + results.getInt("fee")
                        + "\nPaid to date: " + results.getInt("paid")
                        + "\nProject deadline: " + results.getDate("due_date")
                        + "\nProject completion status: " + results.getString("completion_status")
                        + "\nProject structural_engineer: " + results.getString("structural_engineer_assigned")
                        + "\nProject project_manager: " + results.getString("project_manager_assigned")
                        + "\nProject architect: " + results.getString("architect_assigned")
                        + "\nProject customer: " + results.getString("customer_assigned")
                        + "\n");
            }
            results.close();
            //closes Result set
        }
        catch(SQLException e){
            System.out.println("SQL-ERROR with viewing all projects");
            e.printStackTrace();
        }//custom sql error
    }
//======================================================================================================================
    public static void view_all_project_num_and_name(){
        try {
            //this section is required code to get connection to a mysql database and to make mysql statements through
            // this IDE on Java
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/poisePMS?",
                    "root",
                    "Tepidrainbow909");
            Statement statement = connection.createStatement();
            ResultSet results;

            results = statement.executeQuery("SELECT * FROM poised_project_table");
            //executes query on mysql

            while (results.next()) {
                //this loops results in order for us to pull the values from the table in database
                //using results.get""("")
                System.out.println("Project number: " + results.getInt("proj_num")
                        + "\nProject name: " + results.getString("proj_name")
                        + "\n");
            }
            results.close();
            //closes Result set
        }
        catch(SQLException e){
            System.out.println("SQL-ERROR with viewing all projects");
            e.printStackTrace();
        }//custom sql error
    }
}
