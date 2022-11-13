package data;

// External Utilities
import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

//import com.opencsv.CSVReader;
//import com.opencsv.CSVWriter;

public class CSV {

    public List<String[]> ImportData(String file) {
        List<String[]> items = new ArrayList<>();
        try {
            FileReader fr = new FileReader("file");
            BufferedReader br = new BufferedReader(fr);

            String line = br.readLine(); // Skip first line
            while ((line = br.readLine()) != null) {
                items.add(GetLine(line));
            }
            br.close();
        } catch (Exception e) {
            System.out.println("ERROR: Couldnt read input file");
        }

        return items;
    }

    private String[] GetLine(String line) {
        Character delimiter = ',';
        int last = 0;
        int endOfLine = line.length();
        List<String> info = new ArrayList<>();
        for (int i = 0; i < endOfLine; i++) // checking for substrings that contain commas
        {
            if (line.charAt(i) == delimiter || i == endOfLine - 1) // end of column
            {
                info.add(line.substring(last + 1, i)); // add substring to list
                last = i; // save newest coma - helps identify substring start
            } else if (line.charAt(i) == '\"') // found sub string
            {
                int end = line.indexOf("\"", i + 1); // finding the last part of the pair
                if (end != -1) // -1 meaning pair was not found
                    i = end; // update i so that it doesnt void the string
            }
        }
        // Convert list to array
        String[] strInfo = new String[info.size()];
        return info.toArray(strInfo);
    }

    public void Save(List<String[]> newData, String outFile) {
        // auto joine elements with ','
        // auto writes all String arrays to outfile
        /*
         * try (CSVWriter writer = new CSVWriter(new FileWriter(outFile))) {
         * writer.writeAll(newData);
         * } catch (Exception e) {
         * e.printStackTrace();
         * }
         */
    }
}