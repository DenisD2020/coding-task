package leetcode.string;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * https://leetcode.com/problems/display-table-of-food-orders-in-a-restaurant/description/
 */
public class DisplayTableofFoodOrdersinaRestaurant {

    public static void main(String[] args) {

    }

    public List<List<String>> displayTable(List<List<String>> orders) {
        List<List<String>> res = new ArrayList<>();
        TreeMap<String,String> header= new TreeMap(); // for sorted order
        TreeMap<String,TreeMap<String, String>> tables = new TreeMap<>((o1, o2) -> Integer.valueOf(o1).compareTo(Integer.valueOf(o2))); //  default is lex compare, change to int

        for(List<String> order : orders) {
            header.put(order.get(2), "0");
        }

        for(List<String> order : orders) {
            tables.put(order.get(1), new TreeMap(header));
        }


        for(List<String> order: orders) {
            TreeMap<String, String> items = tables.get(order.get(1));
            String item = String.valueOf(Integer.parseInt(items.get(order.get(2))) + 1);
            items.put(order.get(2),item);
            tables.put(order.get(1), items);
        }


        List<String> resHeader = new ArrayList(header.keySet());
        resHeader.add(0, "Table");
        res.add(resHeader);

        for(String table:tables.keySet()) {
            List<String> itemsRow = new ArrayList();
            for(String item:tables.get(table).keySet()) {
                itemsRow.add(tables.get(table).get(item));
            }
            itemsRow.add(0,table);
            res.add(itemsRow);
        }


        return res;
    }
}
