import java.sql.*;
import java.util.Scanner;
//required imports

//======================================================================================================================
//this class is to search for a specific project
public class search {
    public static void search_project() {
        try {
            //this section is required code to get connection to a mysql database and to make mysql statements through
            // this IDE on Java
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/poisePMS?",
                    "root",
                    "Tepidrainbow909");
            Statement statement = connection.createStatement();
            ResultSet results;

//======================================================================================================================
            //section creates scanner and initializing later needed variables
            Scanner user_input = new Scanner(System.in);
            String proj_num;
            String proj_name;

//======================================================================================================================
            //section for user input
            System.out.println("To search for project number Enter 1 \nTo search for project name Enter 2: ");
            String input = user_input.next();

//======================================================================================================================
            //case 1 of switch cases is for user to search by project number
            switch (input) {
                case "1" -> {
                    System.out.println("Enter project number: ");
                    proj_num = user_input.next();

                    results = statement.executeQuery("SELECT * FROM poised_project_table WHERE proj_num=" + proj_num);
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
//======================================================================================================================
                //case 2 of switch cases is for user to search by project name
                case "2" -> {
                    System.out.println("Enter project name: ");
                    proj_name = user_input.next();

                    results = statement.executeQuery("SELECT * FROM poised_project_table WHERE proj_name=" + proj_name);
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
            }
//======================================================================================================================
        }
        catch (SQLException e) {
            System.out.println("SQL-ERROR with viewing all projects");
            e.printStackTrace();
        }//custom sql error
    }
}
