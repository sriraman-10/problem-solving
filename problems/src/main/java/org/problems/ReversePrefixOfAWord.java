package org.problems;

public class ReversePrefixOfAWord {

    public String reversePrefix(String word, char ch){
        char[] result = word.toCharArray();

        int left = 0;

        for(int right = 0 ;right < word.length() ;right++){

            if(result[right] == ch){
                while(left < right){
                    char temp = result[left];
                    result[left] = result[right];
                    result[right] = temp;
                    left++;
                    right--;
                }
                return new String(result);
            }
        }
        return word;
    }

    public static void main(String[] args) {
        System.out.println(new ReversePrefixOfAWord().reversePrefix("abcdefd", 'd'));
    }
}
