import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
//the above are the imports required for this class
//======================================================================================================================

//this class is to add a new project in  a line in text file
class add_new_project {
    //method to add project
    public static void project_add() {
       try {
            //this section is required code to get connection to a mysql database and to make mysql statements through
            // this IDE on Java
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/poisePMS?",
                    "root",
                    "Tepidrainbow909");
            Statement statement = connection.createStatement();
            int rowsAffected;

            Scanner input_scanner = new Scanner(System.in);

// = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =

            //initializing variables for later use
            int proj_num;
            String proj_name;
            String type;
            String address;
            int ERF;
            double fee;
            double paid;
            String due_date;
            String completion_status;
            String structural_engineer;
            String project_manager;
            String architect;
            String customer;


// = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
            //this section asks user to input required data to fill a row/add a book

            System.out.println("Enter project number: ");
            proj_num = input_scanner.nextInt();

            input_scanner.nextLine();
            //this line is a requirement so questions won't be skipped, required when using nextLine and nextInt

            System.out.println("Enter project name: ");
            proj_name = input_scanner.nextLine();

            System.out.println("Enter building type: ");
            type = input_scanner.nextLine();

            System.out.println("Enter address: ");
            address = input_scanner.nextLine();

            System.out.println("Enter ERF number: ");
            ERF = input_scanner.nextInt();

            System.out.println("Enter Total fee: ");
            fee = input_scanner.nextInt();

            System.out.println("Enter fee paid to date: ");
            paid = input_scanner.nextInt();

            System.out.println("Enter project deadline: ");
            due_date = input_scanner.next();

            completion_status = "incomplete";

//======================================================================================================================

            input_scanner.nextLine();
            //this line is a requirement so questions won't be skipped, required when using nextLine and nextInt

            System.out.println("Enter structural_engineer name: ");
            structural_engineer = input_scanner.nextLine();
            //structural_engineer = "'" + structural_engineer + "'";

            System.out.println("Enter structural_engineer telephone number: ");
            String structural_engineer_tele_num = input_scanner.next();
            //structural_engineer_tele_num = "'" + structural_engineer_tele_num + "'";

            System.out.println("Enter structural_engineer email address: ");
            String structural_engineer_email = input_scanner.next();
            //structural_engineer_email = "'" + structural_engineer_email + "'";

            System.out.println("Enter structural_engineer address: ");
            String structural_engineer_address = input_scanner.nextLine();
            //structural_engineer_address = "'" + structural_engineer_address + "'";

            project_manager structural_engineer_a = new project_manager(structural_engineer, structural_engineer_tele_num,
                    structural_engineer_email, structural_engineer_address);
            //above line creates the object using given data from user

//======================================================================================================================

            input_scanner.nextLine();
            //this line is a requirement so questions won't be skipped, required when using nextLine and nextInt

            System.out.println("Enter project_manager: ");
            project_manager = input_scanner.nextLine();
            //project_manager = "'" + project_manager + "'";

            System.out.println("Enter project_manager telephone number: ");
            String project_manager_tele_num = input_scanner.next();
            //project_manager_tele_num = "'" + project_manager_tele_num + "'";

            System.out.println("Enter project_manager email address: ");
            String project_manager_email = input_scanner.next();
            //project_manager_email = "'" + project_manager_email + "'";

            System.out.println("Enter project_manager address: ");
            String project_manager_address = input_scanner.nextLine();
            //project_manager_address = "'" + project_manager_address + "'";

            project_manager project_manager_a = new project_manager(project_manager, project_manager_tele_num,
                    project_manager_email, project_manager_address);
            //above line creates the object using given data from user

//======================================================================================================================

            input_scanner.nextLine();
            //this line is a requirement so questions won't be skipped, required when using nextLine and nextInt

            System.out.println("Enter architect name: ");
            architect = input_scanner.nextLine();
            //architect = "'" + architect + "'";

            System.out.println("Enter architect telephone number: ");
            String architect_tele_num = input_scanner.next();
            //architect_tele_num = "'" + architect_tele_num + "'";

            System.out.println("Enter architect email address: ");
            String architect_email = input_scanner.next();
            //architect_email = "'" + architect_email + "'";

            System.out.println("Enter architect address: ");
            String architect_address = input_scanner.nextLine();
            //architect_address = "'" + architect_address + "'";

            architect architect_a = new architect(architect, architect_tele_num, architect_email, architect_address);
            //above line creates the object using given data from user

//======================================================================================================================

            input_scanner.nextLine();
            //this line is a requirement so questions won't be skipped, required when using nextLine and nextInt

            System.out.println("Enter customer name: ");
            customer = input_scanner.nextLine();
            //customer = "'" + customer + "'";

            System.out.println("Enter customer telephone number: ");
            String customer_tele_num = input_scanner.next();
            //customer_tele_num = "'" + customer_tele_num + "'";

            System.out.println("Enter customer email address: ");
            String customer_email = input_scanner.next();
            //customer_email = "'" + customer_email + "'";

            input_scanner.nextLine();

            System.out.println("Enter customer address: ");
            String customer_address = input_scanner.nextLine();
            //customer_address = "'" + customer_address + "'";

            customer customer_a = new customer(customer, customer_tele_num, customer_email, customer_address);
            //above line creates the object using given data from user

// = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =

            try {
                 rowsAffected = statement.executeUpdate("INSERT INTO poised_project_table VALUES (" + proj_num + ",'"
                         + proj_name + "','" + type + "', '" + address + "', " + ERF + ", " + fee + ", " + paid + ", date'"
                         + due_date + "', '" + completion_status + "', '" + structural_engineer + "', '" + project_manager
                         + "', '" + architect + "', '" + customer + "')");
                 //executes update on mysql

                 System.out.println("Query complete, " + rowsAffected + " rows added.\n");
                 //user to see if task was successful, should say 1 row added, if zero then task was unsuccessful
                 view.view_all_projects();
                 //prints everything so user can see changes
            }
            catch (SQLException e){
                 System.out.println("error when inserting to project data table");
                 e.printStackTrace();
            }//custom sql error
// = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =

            try {
                 rowsAffected = statement.executeUpdate("INSERT INTO structural_engineers VALUES ('" + structural_engineer
                         + "', '" + structural_engineer_tele_num + "', '" + structural_engineer_email + "', '"
                         + structural_engineer_address + "', '" + proj_num + "')");
                 //executes update on mysql

                 System.out.println("Query complete, " + rowsAffected + " rows added.\n");
                 //user to see if task was successful, should say 1 row added, if zero then task was unsuccessful
            }
            catch(SQLException e){
                 System.out.println("error with inserting to structural engineers table");
                 e.printStackTrace();
            }//custom sql error
// = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =

            try {
                 rowsAffected = statement.executeUpdate("INSERT INTO project_managers VALUES ('" + project_manager + "', '"
                         + project_manager_tele_num + "', '" + project_manager_email + "', '" + project_manager_address
                         + "', '" + proj_num + "')");
                 //executes update on mysql

                 System.out.println("Query complete, " + rowsAffected + " rows added.\n");
                 //user to see if task was successful, should say 1 row added, if zero then task was unsuccessful
            }
            catch(SQLException e){
                 System.out.println("error with inserting to project_managers table");
                 e.printStackTrace();
            }//custom sql error
// = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =

            try {
                 rowsAffected = statement.executeUpdate("INSERT INTO architects VALUES ('" + architect+ "', '"
                         + architect_tele_num + "', '" + architect_email + "', '" + architect_address + "', '"
                         + proj_num + "')");
                 //executes update on mysql

                 System.out.println("Query complete, " + rowsAffected + " rows added.\n");
                 //user to see if task was successful, should say 1 row added, if zero then task was unsuccessful
            }
            catch(SQLException e){
                 System.out.println("error with inserting to architects table");
                 e.printStackTrace();
            }//custom sql error
// = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =

            try {
                 rowsAffected = statement.executeUpdate("INSERT INTO customers VALUES ('" + customer + "', '"
                         +customer_tele_num+"', '"+customer_email+"', '"+customer_address+"', '"+proj_num+"')");
                 //executes update on mysql

                 System.out.println("Query complete, " + rowsAffected + " rows added.\n");
                 //user to see if task was successful, should say 1 row added, if zero then task was unsuccessful
            }
            catch(SQLException e){
                 System.out.println("error with inserting to customers table");
                 e.printStackTrace();
            }//custom sql error
// = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
        }
        catch (SQLException e) {
            System.out.println("""
                SQL-ERROR with adding new project
                [Ensure inputted project number does not already exist]""");
       }//custom sql error
    }
}
