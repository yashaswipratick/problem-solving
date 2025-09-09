package stack.medium;

import java.util.LinkedList;

//problem link - https://takeuforward.org/plus/dsa/problems/implement-stack-using-arrays
public class ImplementStackUsingLinkedList {

    LinkedList<Integer> list;
    public ImplementStackUsingLinkedList() {
        list = new LinkedList<>();
    }

    public void push(int x) {
        list.addFirst(x);
    }

    public int pop() {
        return list.removeFirst();
    }

    public int top() {
        return list.getFirst();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
    public static void main(String[] args) {
        ImplementStackUsingLinkedList stack = new ImplementStackUsingLinkedList();

        /*stack.push(5);

        stack.push(10);

        System.out.println(stack.top()); // returns 10

        System.out.println(stack.pop()); // returns 10

        System.out.println(stack.isEmpty()); // returns false*/

        stack.push(1);

        System.out.println(stack.pop()); // returns 1

        System.out.println(stack.isEmpty()); // returns true
    }
}
