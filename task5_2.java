// 2. Пусть дан список сотрудников: Иван, Пётр, Антон и так далее. 
// Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
// Отсортировать по убыванию популярности.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class task_2 {

    public static ArrayList<String> getName(String [] list){
        ArrayList<String> listName = new ArrayList<>();
        for (String el : list) {
            String [] elList = el.split(" ");
            listName.add(elList[0]);
        }
        return listName;
    }

    public static Map<String, Integer> getMap(ArrayList<String> name) {
        Map<String, Integer> mapName = new HashMap<>();
        for (int i = 0; i < name.size(); i++) {
            int count = 1;
            for (int j = i + 1; j < name.size(); j++){
                if (name.get(i).equals(name.get(j))) count += 1;
            }
            if (mapName.containsKey(name.get(i)) == false) mapName.put(name.get(i), count);
        }
        return mapName;
    }

    public static void nameRepeat(Map<String, Integer> map){
        for(var item: map.entrySet()){
            if (item.getValue() > 1) System.out.printf("%s: %d \n", item.getKey(), item.getValue());
        }
    }

    public static void sortName(Map<String, Integer> map){
        Map<Integer, ArrayList<String>> sortMap = new HashMap<>();
        ArrayList<Integer> listCount = new ArrayList<>();
        for(var item: map.entrySet()) {
            if (listCount.contains(item.getValue()) == false) listCount.add(item.getValue());
        }
        listCount.sort(null);
        for (int i = listCount.size()-1; i > -1; i--){
            for (var item: map.entrySet()){
                if (listCount.get(i) == item.getValue()) System.out.printf("%s : %d \n", item.getKey(), item.getValue());
            }
        }
    }

    public static void main(String[] args) {
        String[] emploees = new String[] {"Кирилл Моськин", "Антон Иванов", "Никита Терелов", "Сергей Жук", "Евгений Ильф", "Оксана Оськина", "Мария Хуторная", "Олег Васильев"};
        ArrayList<String> emploeesName = getName(emploees);
        Map<String, Integer> mapName =  getMap(emploeesName);
        System.out.println("Повторы: ");
        nameRepeat(mapName);
        System.out.println("Имена по убыванию популярности: ");
        sortName(mapName);
    }
}