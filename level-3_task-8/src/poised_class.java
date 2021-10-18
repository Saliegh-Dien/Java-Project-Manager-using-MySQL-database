import java.util.*;
//the above are the imports required for this class

//======================================================================================================================
//main class is to call other methods in classes to execute according to user input
class poised_class {
    public static void poised(){

        //the following will display a user-friendly menu
        System.out.println("""
                MAIN MENU
                a - To add new project
                s - To search for a project
                i - To view incomplete projects
                f - To finalise a project/mark as complete
                v - To view all projects
                o - To view overdue projects only
                e - To edit projects
                """);

        Scanner input = new Scanner(System.in);
        String main_input = input.next();
        //the above takes the user's input

//======================================================================================================================
        switch (main_input) {
            case "a" -> add_new_project.project_add();
            case "s" -> search.search_project();
            case "i" -> incomplete.incomplete_projects();
            case "f" -> finalizer.generate_invoice();
            case "v" -> view.view_all_projects();
            case "o" -> dates.overdue_projects();
            case "e" -> editing_projects.project_info_updater();
            //calls said method within proper class according to user's input from main menu
        }
    }
}
