// 1. Реализуйте структуру телефонной книги с помощью HashMap, 
// учитывая, что один человек может иметь несколько телефонов.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class task_1 {
    
    public static void addNumber(String key, int value, Map<String, ArrayList<Integer>> map){
        if (map.containsKey(key)) {
            map.get(key).add(value);
        } else {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(value);
            map.put(key, list);
        }
    }

    public static void printBook(Map<String, ArrayList<Integer>> map){
        for (var item : map.entrySet()) {
            String phones = "";
            for(int el: item.getValue()){
                phones = phones + el + ", ";
            }
            System.out.printf("%s: %s \n", item.getKey(), phones);
        }
    }

    public static void main(String[] args) {
        Map<String, ArrayList<Integer>> bookPhone = new HashMap<>();
        addNumber("Ivanko", 89150001221, bookPhone);
        addNumber("Ivanko", 89160690011, bookPhone);
        addNumber("Oskina", 89243241223, bookPhone);
        addNumber("Vlasenkova", 89566764545, bookPhone);
        addNumber("Krimov", 87650987654, bookPhone);
        addNumber("Zaytsev", 85673438998, bookPhone);
        addNumber("Zaytsev", 85673433443, bookPhone);
        printBook(bookPhone);
}
}