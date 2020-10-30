package assessment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WebsitePagination {
    public static void main(String [] args) {
        List<List<String>> list = new ArrayList<>();
        list.add(Arrays.asList("item1", "10", "15"));
        list.add(Arrays.asList("item2", "3", "4"));
        list.add(Arrays.asList("item3", "17", "8"));

        System.out.println(fetchItemsToDisplay(list, 1, 0, 2, 0).toString());

    }

    static List<String> fetchItemsToDisplay(List<List<String>> items,
                                            int sortParameter,
                                            int sortOrder,
                                            int itemsPerPage,
                                            int pageNumber) {
        items.sort((a, b) -> myCompare(a, b, sortParameter, sortOrder));
        List<String> list = new ArrayList<>();
        for (int i = pageNumber * itemsPerPage; i < items.size() && i < (pageNumber + 1) * itemsPerPage; i++) {
            list.add(items.get(i).get(0));
        }

        return list;
    }

    static int myCompare(List<String> item1, List<String> item2, int by, int order) {

        if (by == 0) {
            if (order == 0) return item1.get(by).compareTo(item2.get(by));
            return item1.get(by).compareTo(item2.get(by));
        }
        if (order == 0)
            return Integer.parseInt(item1.get(by)) - Integer.parseInt(item2.get(by));

        return Integer.parseInt(item2.get(by)) - Integer.parseInt(item1.get(by));

    }
}
