package database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Scanner;

import src.User;

public class Library {
    
    public static final String LIBRARY_PATH = "model/users.csv";

    //private File lib = new File(LIBRARY_PATH);


    /**
     * constructor
     */
    public Library(){ }


    /**
     * @throws IOException
     * initialize the file  
     */
    public void init() throws IOException{
        // BufferedReader read = new BufferedReader(new FileReader(lib));
        // String line;

        // while((line = read.readLine()) != null){
        //     add(line);
        // }
        // read.close();
    }


    /**
     * @param name the username that is added.
     * @throws IOException
     * add the username into txt file
     */
    public void addUser(User user) throws IOException{
        String userInfo = toCSVFormat(user);
        FileWriter writer = new FileWriter(LIBRARY_PATH, true);
        writer.write(userInfo);
        writer.close();

        // FileOutputStream fos = new FileOutputStream(LIBRARY_PATH);
        // ObjectOutputStream oos = new ObjectOutputStream(fos);
        // oos.writeObject(user);
        // oos.flush();
        // oos.close();
    }

    /**
     * @param name the username that is added.
     * @throws IOException
     * update a user in csv file
     */
    public void updateUser(User oldUser, String newPassword) throws IOException{
      Scanner sc = new Scanner(new BufferedReader(new FileReader(LIBRARY_PATH)));
      StringBuffer buffer = new StringBuffer();
      while (sc.hasNextLine()) {
         buffer.append(sc.nextLine()+System.lineSeparator());
      }
      String fileContents = buffer.toString();
      sc.close();
      String oldLine = oldUser.getUsername() + "," + oldUser.getPassword() + "," + oldUser.getName() + "," + 
                        oldUser.getHeight() + "," + oldUser.getWeight() + "," + oldUser.getBirthDate();
      String newLine = oldUser.getUsername() + "," + newPassword + "," + oldUser.getName() + "," + 
                        oldUser.getHeight() + "," + oldUser.getWeight() + "," + oldUser.getBirthDate();
      fileContents = fileContents.replaceAll(oldLine, newLine);
      FileWriter writer = new FileWriter(LIBRARY_PATH);
      writer.append(fileContents);
      writer.flush();
      writer.close();
    }

    /**
     *
     * converts user to csv format
     */
    public String toCSVFormat(User user) throws IOException{
        String userInfo = user.getUsername() + "," + user.getPassword() + "," + user.getName() + "," + 
                            user.getHeight() + "," + user.getWeight() + "," + user.getBirthDate() + "\n";
        return userInfo;

        // FileOutputStream fos = new FileOutputStream(LIBRARY_PATH);
        // ObjectOutputStream oos = new ObjectOutputStream(fos);
        // oos.writeObject(user);
        // oos.flush();
        // oos.close();
    }

}
