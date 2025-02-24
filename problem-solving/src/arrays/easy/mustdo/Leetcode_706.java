package arrays.easy.mustdo;

import java.util.Arrays;

public class Leetcode_706 {

    int[] array;

    public Leetcode_706() {
        array = new int[1000001];
        Arrays.fill(array, -1);
    }

    public void put(int key, int value) {
        array[key] = value;
    }

    public int get(int key) {
        return array[key];
    }

    public void remove(int key) {
        array[key] = -1;
    }

    public static void main(String[] args) {
        Leetcode_706 myHashMap = new Leetcode_706();
        myHashMap.put(1, 1); // The map is now [[1,1]]
        myHashMap.put(2, 2); // The map is now [[1,1], [2,2]]
        System.out.println(myHashMap.get(1));    // return 1, The map is now [[1,1], [2,2]]
        System.out.println(myHashMap.get(3));    // return -1 (i.e., not found), The map is now [[1,1], [2,2]]
        myHashMap.put(2, 1); // The map is now [[1,1], [2,1]] (i.e., update the existing value)
        System.out.println(myHashMap.get(2));    // return 1, The map is now [[1,1], [2,1]]
        myHashMap.remove(2); // remove the mapping for 2, The map is now [[1,1]]
        System.out.println(myHashMap.get(2));    // return -1 (i.e., not found), The map is now [[1,1]]
    }
}
