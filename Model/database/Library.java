package database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Library {
    
    public static final String LIBRARY_PATH = "model/lib.txt";

    private File lib = new File(LIBRARY_PATH);


    /**
     * constructor
     */
    public Library(){
    }


    /**
     * @throws IOException
     * initialize the file  
     */
    public void init() throws IOException{
        BufferedReader read = new BufferedReader(new FileReader(lib));
        String line;

        while((line = read.readLine()) != null){
            add(line);
        }
        read.close();
    }


    /**
     * @param name the username that is added.
     * @throws IOException
     * add the username into txt file
     */
    public void add(String name) throws IOException{
        FileWriter writer = new FileWriter(lib);
        writer.write(name);
        writer.close();
    }


}
