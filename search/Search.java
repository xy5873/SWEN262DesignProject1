package search;

// Local utilities

// External Utilities
import java.util.List;
import java.util.ArrayList;

public class Search {

    // be able to searh history and ingredient in ingredient list
    public List<String[]> Find(String[] keyWords, List<String[]> dataSet) {
        List<String[]> found = new ArrayList<String[]>();
        for (String[] items : dataSet) // Go through all items
        {
            for (String item : items) // withinin the items
            {
                for (String word : keyWords)
                    if (item.contains(word)) // check for the key word
                        found.add(items);
            }
        }
        return found;
    }

    public List<String[]> Find(String keyWord, List<String[]> dataSet) {
        List<String[]> found = new ArrayList<String[]>();
        for (String[] items : dataSet) // Go through all items
        {
            for (String item : items) // withinin the items
            {
                if (item.contains(keyWord)) // check for the key word
                    found.add(items);
            }
        }
        return found;
    }

}