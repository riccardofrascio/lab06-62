package it.unibo.collections;

import java.util.List;
import java.util.LinkedList;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {

    //private static Integer remove;
    private static final int ELEMS = 100_000;

    private UseListsAndMaps() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        ArrayList<Integer> al = new ArrayList<>();
        for(int i = 1000; i<2000; i++) {
            al.add(i);
        }
        /* 
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        LinkedList<Integer> li= new LinkedList<>();
        li.addAll(li);

        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        for(int i=0; i<al.size()/2; i++){
            int last = al.get(al.size()-i-1);
            int first = al.get(i);
            al.set(al.size()-i-1,first);
            al.set(i, last);
        }
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        for(var i : al){
            System.out.println(i + " ");
        }
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        long time = System.nanoTime();

        for (int i = 1; i <= ELEMS; i++) {
            al.add(0,1);
        }
        time = System.nanoTime() - time;
        var millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(millis+ " ms to add 100.000 elems in a ArrayList");


        time = System.nanoTime();
        for (int i = 1; i <= ELEMS; i++) {
            li.add(0,1);
        }
        time = System.nanoTime() - time;
        millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(millis+ " ms to add 100.000 elems in a LinkedList");

        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example PerfTest.java.
         */
        time = System.nanoTime();
        for (int i = 1; i <= 1000; i++) {
            al.get(al.size()/2);
        }
        time = System.nanoTime() - time;
        millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(millis+ " ms to read 1.000 elems in a ArrayList");


        time = System.nanoTime();
        for (int i = 1; i <= 1000; i++) {
            li.get(li.size()/2);
        }
        time = System.nanoTime() - time;
        millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(millis+ " ms to read 1.000 elems in a LinkedList");
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */
        Map<String, Long> world = new HashMap<>();
        world.put("Africa", 1_110_635_000l);
        world.put("Americas", 972_005_000l);
        world.put("Antartica", 0l);
        world.put("Asia", 4_298_723_000l);
        world.put("Europe", 742_452_000l);
        world.put("Oceania", 38_304_000l);
        /*
         * 8) Compute the population of the world
         */
        long worldPopulation = 0;
        for(var i : world.values()){
            worldPopulation+=i;
        }
        System.out.println(worldPopulation);
    }
}
