package LINKEDLIST;

import java.util.Stack;

public class ReverseArray {
    public static void reverse(char[] arr) {
        Stack<Character> s = new Stack<>();
        for (char c : arr) {
            s.push(c);
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = s.pop();
        }
    }public static void main(String[] args) {
        char[]arr={'a','b','c','d'};
        reverse(arr);
        for (char c : arr) {
            System.out.print(c);
        }
    }
}
