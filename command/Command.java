package command;

import view.PTUI;
import database.Library;

import java.io.IOException;
import java.util.Scanner;

public class Command {
 
    private PTUI ptui;

    /**
     * @param ptui: the plain text user interface
     * create the constrcutor
     */
    public Command(PTUI ptui){
        this.ptui = ptui;
    }

    /**
     * @throws IOException
     * the user log in and is recording in the txt file
     */
    public void logIn() throws IOException{
        Library lib = PTUI.library;
        System.out.println("Enter username:");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        lib.add(name);
        System.out.println("\n-----------------------------------------------------------");
        System.out.println("Logged in as: " + name);
        ptui.display_menu();
        ptui.menu();
        exit();
        scanner.close();
    }

    /**
     * @throws IOException
     * the user workout
     */
    public void workout() throws IOException {
        System.out.println("workout text");
        exit();
    }

    /**
     * @throws IOException
     * the user history
     */
    public void history() throws IOException {
        System.out.println("history text");
        exit();
    }

    /**
     * @throws IOException
     * the user goal
     */
    public void goal() throws IOException {
        System.out.println("goal text");
        exit();
    }

    /**
     * @throws IOException
     * the user log out
     */
    public void logOut() throws IOException {
        System.out.println("logout text");
        exit();
    }

    /**
     * exit the application 
     */
    public void exit(){
        ptui.updateRunning();
    }

}
