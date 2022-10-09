package command;

import java.io.IOException;
import java.util.Scanner;

import model.database.Library;
import view.PTUI;

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
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        lib.add(name);
        exit();
        scanner.close();
    }


    /**
     * exit the application 
     */
    public void exit(){
        ptui.updateRunning();
    }

}