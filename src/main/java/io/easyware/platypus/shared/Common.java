package io.easyware.platypus.shared;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Common {

    // Function to get ArrayList from Stream
    public static <T> ArrayList<T> toArrayList(Stream<T> stream)
    {
        // Convert the Stream to List
        List<T> list = stream.collect(Collectors.toList());

        // Create an ArrayList of the List
        ArrayList<T> arrayList = new ArrayList<T>(list);

        // Return the ArrayList
        return arrayList;
    }
}
