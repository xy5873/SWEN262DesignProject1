package view;

import command.Command;
import database.Library;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class PTUI{
    

    
    public boolean running = true;
    public static Library library;
    public Command commands;
    public String input;

    PTUI(){
        library = new Library();
        commands = new Command(this);
    }

    
    /**
     * @throws IOException
     * make the PTUI run
     */
    private void run() throws IOException{
        display();
        library.init();

        Scanner scanner = new Scanner(System.in);
        while(running){
            input = scanner.nextLine();
            if(input.equals("log in")){
                commands.logIn();
                scanner.close();
            }
            else if(input.equals("exit")){
                scanner.close();
                commands.exit();
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
        System.out.println("log in -- log in the user, assume we only have one user");
        System.out.println("exit -- end the application");
        System.out.println("-----------------------------------------------------------");
    }


    public static void main(String args[]) throws IOException {
        File lib = new File("./model/lib.txt");
        if(!lib.exists()) lib.createNewFile();
        if(lib.exists()) System.out.println("we have imported the data.");

        PTUI ptui = new PTUI();
        ptui.run();
    }

}
