package hw3;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        //1-е задание
        String[] strings = {"яблоко", "тыква", "банан", "яблоко",
                "мандарин", "мандарин", "яблоко", "тыква",
                "яблоко", "грейпфрут", "банан"};

        Map<String, Integer> hm = new HashMap<>();

        for (int i = 0; i < strings.length; i++) {
            Integer count = hm.getOrDefault(strings[i],0);
            hm.put(strings[i], count + 1);
        }
        System.out.println(hm.keySet());
        System.out.println(hm);


        //2-е задание
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Алексеев", 954752698425l);
        phoneBook.add("Валентинов", 797527825278l);
        phoneBook.add("Гудкова", 55785868686l);
        phoneBook.add("Алексеев", 897868767866786l);

        System.out.println(phoneBook.get("Алексеев"));

    }


}
