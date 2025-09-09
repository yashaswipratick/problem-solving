package stack.medium;

import java.util.Arrays;
import java.util.LinkedList;

// Problem link - https://www.geeksforgeeks.org/problems/implement-stack-using-array/1
public class ImplementStackUsingArray {

    int[] array;
    //initialize the array with a length of 1 but also set size = 1, which causes logic errors.
    //so keep size at first 0
    int size = 0;
    public ImplementStackUsingArray() {
        array = new int[1]; //  keep array length 1 and allow the first push.
    }

    public void push(int x) {
       if (array.length == size) {
           increaseSize(); //
       }
       array[size++] = x;//once first push is applied then use array increase size method.
    }

    public int pop() {
        if (isEmpty()) throw new RuntimeException("Stack is empty!");
        int popped = array[--size];
        array[size] = -1;
        return popped;
    }

    public int top() {
        if (isEmpty()) throw new RuntimeException("Stack is empty!");
        return array[size-1];
    }

    public boolean isEmpty() {
       return size == 0;
    }

    private void increaseSize() {
        int newCapacity = array.length * 2;
        array = Arrays.copyOf(array, newCapacity);
    }

    public static void main(String[] args) {
        ImplementStackUsingArray stack = new ImplementStackUsingArray();
        stack.push(5);

        stack.push(10);

        System.out.println(stack.top()); // returns 10

        System.out.println(stack.pop()); // returns 10

        System.out.println(stack.isEmpty());
    }

    // Time Complexity - Best case - O(1) Worst case - O(n)
}
