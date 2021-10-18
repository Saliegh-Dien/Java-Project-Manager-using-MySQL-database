import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
//the above are the imports required for this class
//======================================================================================================================
class editing_projects {
//this class is to edit/update information in existing projects

    public static void project_info_updater() {
        try {
            //this section is required code to get connection to a mysql database and to make mysql statements through
            // this IDE on Java
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/poisePMS?",
                    "root",
                    "Tepidrainbow909");
            Statement statement = connection.createStatement();
            Scanner input = new Scanner(System.in);
            int rowsAffected;

// = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
            //update book attributes
            String attribute_to_update = null;
            String where_condition_type;
            String where_condition_subject;
            String where_condition_key;
            String new_data = null;

// = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
            //menu display, taking input, assigning correct variable according to input
            System.out.println("""
                    Which field would you like to update?
                    '1 - update fee paid to date', '2 - update project deadline'
                    Enter->""");

            String update_menu = input.next();

            if (update_menu.equals("1")) {
                attribute_to_update = "paid";
            }
            else if (update_menu.equals("2")) {
            attribute_to_update =   "due_date";
            }
// = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
            //menu display, taking input, assigning correct variable according to input
            System.out.println("""
                    Enter where condition subject/variable:
                    project number - 1
                    project name - 2
                    building type - 3
                    address - 4
                    ERF - 5
                    fee - 6
                    paid - 7
                    due_date - 8
                    completion_status - 9
                    structural_engineer assigned - 10
                    project_manager assigned - 11
                    architect assigned - 12
                    customer assigned - 13
                    Enter number->""");
            where_condition_type = input.next();

            switch (where_condition_type) {
                default -> where_condition_subject = "proj_num";
                case "2" -> where_condition_subject = "proj_name";
                case "3" -> where_condition_subject = "type";
                case "4" -> where_condition_subject = "address";
                case "5" -> where_condition_subject = "ERF";
                case "6" -> where_condition_subject = "fee";
                case "7" -> where_condition_subject = "paid";
                case "8" -> where_condition_subject = "due_date";
                case "9" -> where_condition_subject = "completion_status";
                case "10" -> where_condition_subject = "structural_engineer_assigned";
                case "11" -> where_condition_subject = "project_manager_assigned";
                case "12" -> where_condition_subject = "architect_assigned";
                case "13" -> where_condition_subject = "customer_assigned";
            }
// = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =


            input.nextLine();
            //this line is a requirement so questions won't be skipped, required when using nextLine and nextInt

            //taking input, value inside variable earlier chosen
            System.out.println("Enter where condition's value: ");
            where_condition_key = input.nextLine();
            where_condition_key = "'" + where_condition_key + "'";

            //printing full where condition
            System.out.println("Where " + where_condition_subject + " = " + where_condition_key);

            //assigning correct variable according to input if not null
            if (attribute_to_update != null) {
                if (attribute_to_update.equals("paid")) {
                        System.out.println("Enter amount paid to date: ");
                        new_data = input.next();
                    }
                else {
                    System.out.println("Enter new project deadline: ");
                    new_data = input.nextLine();
                    new_data = "date'" + new_data + "'";
                    }
            }
// = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =

            rowsAffected = statement.executeUpdate("UPDATE poised_project_table SET " + attribute_to_update + "="
                    + new_data + " WHERE " + where_condition_subject + "=" + where_condition_key);
            //executes update on mysql

            System.out.println("Query complete, " + rowsAffected + " rows updated.\n");
            view.view_all_projects();
            //views all details of all projects so user can verify change in database

// = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
        }
        catch (SQLException e) {
            System.out.println("SQL-ERROR with updating book information");
        }//custom sql error
    }
}
