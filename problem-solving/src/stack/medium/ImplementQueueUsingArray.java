package stack.medium;

//Problem statement - https://takeuforward.org/plus/dsa/problems/implement-queue-using-arrays
public class ImplementQueueUsingArray {

    int[] array;
    int size = 0;
    int peek = 0;
    public ImplementQueueUsingArray() {
        array = new int[1];
    }

    public void push(int x) {
        if (array.length == size) {
            increaseSize();
        }
        array[size++] = x;
    }

    public int pop() {
        if (isEmpty()) {
            return -1;
        }
        return array[peek++];
    }

    public int peek() {
        if (isEmpty()) {
            return -1;
        }
        return array[peek];
    }

    public boolean isEmpty() {
        return size == peek;
    }

    private void increaseSize() {
        // Number of valid elements
        int validLength = size - peek;

        int[] newArray = new int[array.length * 2];
        System.arraycopy(array, peek, newArray, 0, validLength);
        array = newArray;

        // After shifting, front becomes 0 and rear becomes validLength
        size = validLength;
        peek = 0;
    }

    public static void main(String[] args) {
        ImplementQueueUsingArray queue = new ImplementQueueUsingArray();

        queue.push(5);

        queue.push(10);

        System.out.println(queue.peek()); // returns 5

        System.out.println(queue.pop()); // returns 5

        System.out.println(queue.isEmpty()); // returns false
    }
}
