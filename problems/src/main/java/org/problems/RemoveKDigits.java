package org.problems;

import java.util.LinkedList;

public class RemoveKDigits {
    public static void main(String[] args) {
        System.out.println(removeKdigits("1432219", 3));
    }

    public static String removeKdigits(String s, int k) {
        LinkedList<Character> stack = new LinkedList<>();

        for(char num : s.toCharArray()){
            while(!stack.isEmpty() && k > 0 && stack.peekLast() > num){
                stack.removeLast();
                k-=1;
            }
            stack.addLast(num);
        }

        for(int i=0;i<k;i++){
            stack.removeLast();
        }

        StringBuilder stringBuilder = new StringBuilder();
        for(char digit : stack){
            stringBuilder.append(digit);
        }
        if(stringBuilder.length() == 0){
            return "0";
        }
        return stringBuilder.toString();
    }
}
