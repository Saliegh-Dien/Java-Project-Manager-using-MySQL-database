import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
//the above are the imports required for this class

//======================================================================================================================
//this class is to edit/update information in existing projects
class finalizer {

    public static void generate_invoice() {
        try {
            //this section is required code to get connection to a mysql database and to make mysql statements through
            // this IDE on Java
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/poisePMS?",
                    "root",
                    "Tepidrainbow909");
            Statement statement = connection.createStatement();
            Scanner input = new Scanner(System.in);
            int rowsAffected;
            ResultSet results;

// = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
            //initializing later needed variables
            int selected_proj_num;
            int fee = 0;
            int paid = 0;
            int total;

// = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
            //today's date, needed for date marked as completed
            Date current_date = new Date();

            //format for date stored into variable
            SimpleDateFormat date_form = new SimpleDateFormat("yyyy/MM/dd");

            //new value for completion status is now 'finalized' with the date marked finalized
            String date = date_form.format(current_date);
            String completion_status = "Finalized [" + date + "] ";

// = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
            //views names and numbers of projects for user to se and select 1
            view.view_all_project_num_and_name();
            System.out.println("Which project would you like to finalize?\nEnter the project number: ");
            selected_proj_num = input.nextInt();

// = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =

            rowsAffected = statement.executeUpdate("UPDATE poised_project_table SET completion_status='"
                    + completion_status + "' " + "WHERE proj_num=" + selected_proj_num);
            //above executes mysql update
            System.out.println("Query complete, " + rowsAffected + " rows updated.\n");

// = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =

            results = statement.executeQuery("SELECT * FROM poised_project_table WHERE proj_num="
                    + selected_proj_num);//executes query on mysql

            while (results.next()) {
                //this loops results in order for us to pull the values from the table in database
                //using results.get""("")
                System.out.println("Finalized Project's information" + "\nProject number: "
                        + results.getInt("proj_num") + "\nProject name: "
                        + results.getString("proj_name") + "\nProject status: "
                        + results.getString("completion_status") + "\n");

                fee = results.getInt("fee");
                paid = results.getInt("paid");
            }
            results.close();
            //closes Result set

// = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
            //total is to amount customer still owes and will only print invoice if money is still owed
            total = fee - paid;
            if (total > 0) {
                results = statement.executeQuery("SELECT * FROM customers " +
                        "WHERE project_assigned_num=" + selected_proj_num);
                //executes query on mysql

                while (results.next()) {
                    //this loops results in order for us to pull the values from the table in database
                    //using results.get""("")
                    System.out.println("Customer details:"
                            + "\nName: " + results.getString("name")
                            + "\nTelephone: " + results.getString("tele_num")
                            + "\nEmail: " + results.getString("email")
                            + "\naddress: " + results.getString("address")
                            + "\nAmount owed: R" + total);
                }
            }
        }
// = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
        catch (SQLException e) {
            System.out.println("SQL-ERROR with finalizing the project in the database");
        }//custom sql error
    }
}
