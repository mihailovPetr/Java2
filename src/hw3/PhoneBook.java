package hw3;

import java.util.*;

public class PhoneBook {

    private Map<String, HashSet<Long>> phoneBook = new HashMap<>();

    public boolean add(String surname, long phoneNumber) {

        HashSet<Long> phones = phoneBook.get(surname);

        if (phones == null) {
            phoneBook.put(surname, new HashSet<Long>(Arrays.asList((Long) phoneNumber)));
            return true;
        }

        return phones.add(phoneNumber);
    }

    public Set<Long> get(String surname) {
        return phoneBook.get(surname);
    }

}
