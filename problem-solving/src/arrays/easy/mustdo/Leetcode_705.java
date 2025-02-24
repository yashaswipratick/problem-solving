package arrays.easy.mustdo;

public class Leetcode_705 {

    boolean[] list;
    public Leetcode_705() {
        int size = (int) Math.pow(10, 7); // 10^6
        list = new boolean[1000001];
    }

    public void add(int key) {
        list[key] = true;
    }

    public void remove(int key) {
        list[key] = false;
    }

    public boolean contains(int key) {
        if(Boolean.TRUE.equals(list[key])) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Leetcode_705 myHashSet = new Leetcode_705();
        myHashSet.add(1);      // set = [1]
        myHashSet.add(2);      // set = [1, 2]
        System.out.println(myHashSet.contains(1)); // return True
        System.out.println(myHashSet.contains(3)); // return False, (not found)
        myHashSet.add(2);      // set = [1, 2]
        System.out.println(myHashSet.contains(2)); // return True
        myHashSet.remove(2);   // set = [1]
        System.out.println(myHashSet.contains(2)); // return False, (already removed)
    }
}
//["MyHashSet","add","add","contains","contains","add","contains","remove","contains","add","contains"]
//[[],[1],[2],[1],[3],[2],[2],[2],[2],[1000000],[1000000]]
//[null,null,null,true,false,null,true,null,false,null,true]