package data;

import java.util.ArrayList;
import java.util.List;

import src.Item;

public class Storage<T> {
    private List<T> items;

    public void add(T item) {
        items.add(item);
    }

    public List<T> getAll() {
        return items;
    }

    public List<String[]> getStrings() { // Prep recipies for storage
        List<String[]> data = new ArrayList<>();
        for (T item : this.items) {
            data.add(((Item) item).getArr());
        }
        return data;
    }
}
