import java.util.*;
//import to take user input

//======================================================================================================================
public class Main {
    public static void main(String[] args) {

        boolean run_program = true;
        //boolean used to restart or exit program

        while (run_program) {
            //program will restart if boolean is true, will exit if boolean is false

            Scanner user_input = new Scanner(System.in);
            //scanner for user input

            System.out.println("""
                                    
                    Run Program - 1
                    Exit - 2
                    """);
            //text block displaying an option to restart or exit

            String to_restart = user_input.next();
            //storing user input

            if (to_restart.equals("1")) {
                poised_class.poised();
                //recalls method if user opted to restart
            } else {
                run_program = false;
                //false boolean means the method cannot be recalled, allowing exit
                System.out.println("Goodbye");
            }
        }
    }
}
