package View;

import command.Command;
import command.Create;
import command.Exit;
import command.Goal;
import command.History;
import command.LogIn;
import command.LogOut;
import command.Meal;
import command.Menu;
import command.NewDay;
import command.Recipe;
import command.UserInfo;
import command.Workout;
import command.NewDay;
import database.Library;
import src.User;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class PTUI{

    public boolean running = true;
    public static Library library;
    public Command commands;
    public String input;
    public Menu menu;
    public HashMap<User, String> user = new HashMap<>();
    public User currentUser;

    PTUI(){
        library = new Library();
        commands = new Command(this);
        menu = new Menu(new Create(commands), new Exit(commands), new Goal(commands), 
                        new History(commands), new LogIn(commands), 
                        new LogOut(commands), new Meal(commands), 
                        new Recipe(commands), new Workout(commands), new UserInfo(commands)
                        new NewDay(commands));
    }

    
    /**
     * @throws IOException
     * make the PTUI run
     */
    public void run() throws IOException, ClassNotFoundException{
        display();
        library.init();

        Scanner scanner = new Scanner(System.in);
        while(running){
            input = scanner.nextLine();
//            if(input.equals("log in")){
//                commands.logIn();
//                scanner.close();
//            }
//            else if(input.equals("exit")){
//                scanner.close();
//                commands.exit();
//            }
//            else {
//                display();
//            }
            if (menu.invoke(input)) {
                continue;
            }
            else {
                display();
            }
        }
    }

    /**
     *  update the file running.
     */
    public void updateRunning(){
        this.running = false;
    }


    /**
     * display the requirements of beginning PTUI
     */
    private void display(){
        System.out.println("-----------------------------------------------------------");
        System.out.println("Welcome to the nutriApp");
        System.out.println("You are automatically start as guest. You can browse the stock of ingredients, meals, recipes, but can not change it. You can also create new account and login as a registered user.");
        // need to make the guest can browse the stock later.
        System.out.println("create -- create new account");
        System.out.println("log in -- log in the user, assume we only have one user");
        System.out.println("exit -- end the application");
        System.out.println("-----------------------------------------------------------");
    }

    /**
     * display the requirements of menu PTUI
     */
    public void display_menu() {
        System.out.println("\nworkout -- start a new workout");
        System.out.println("history -- get history for previous workouts");
        System.out.println("goal -- set a new goal");
        System.out.println("meal -- create a new meal");
        System.out.println("recipe -- create a new recipe");
        System.out.println("log out -- log out the user");
        System.out.println("exit -- end the application");
        System.out.println("user info -- display current user info");
        System.out.println("new day -- ends the current day and starts a new one");
        System.out.println("-----------------------------------------------------------");
    }

    /**
     * @throws IOException
     * menu for user
     */
    public void menu() throws IOException, ClassNotFoundException {
        display_menu();
        while(running) {
            System.out.print("Menu Choice: ");
            Scanner scanner = new Scanner(System.in);
            String _input = scanner.nextLine();

//            if(_input.equals("workout")) {
//                commands.workout();
//            }
//            else if(_input.equals("history")) {
//                commands.history();
//            }
//            else if(_input.equals("goal")) {
//                commands.goal();
//            }
//            else if(_input.equals("meal")) {
//                commands.meal();
//            }
//            else if(_input.equals("recipe")) {
//                commands.recipe();
//            }
//            else if(_input.equals("log out")) {
//                commands.logOut();
//            }
//            else if(_input.equals("exit")) {
//                scanner.close();
//                commands.exit();
//            }
//            else {
//                display_menu();
//            }

            if (menu.invoke(_input)) {
                continue;
            }
            else {
                display_menu();
            }

        }
    }


    public static void main(String args[]) throws IOException, ClassNotFoundException {
        File lib = new File("./model/lib.txt");
        if(!lib.exists()) lib.createNewFile();
        if(lib.exists()) System.out.println("we have imported the data.");

        PTUI ptui = new PTUI();
        ptui.run();
    }

}
