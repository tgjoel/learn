package coding.slidingwindow.problems;

import java.util.HashMap;
import java.util.Map;/*
2024. Maximize the Confusion of an Exam

A teacher is writing a test with n true/false questions, with 'T' denoting true and 'F' denoting false. He wants to confuse the students by maximizing the number of consecutive questions with the same answer (multiple trues or multiple falses in a row).
You are given a string answerKey, where answerKey[i] is the original answer to the ith question. In addition, you are given an integer k, the maximum number of times you may perform the following operation:
Change the answer key for any question to 'T' or 'F' (i.e., set answerKey[i] to 'T' or 'F').
Return the maximum number of consecutive 'T's or 'F's in the answer key after performing the operation at most k times.


Example 1:

Input: answerKey = "TTFF", k = 2
Output: 4
Explanation: We can replace both the 'F's with 'T's to make answerKey = "TTTT".
There are four consecutive 'T's.
 */

public class MaximizeConfusionExam {
    public static void main( String[] args ) {
//        String answerKey = "TTFF";
//        int k = 2;
        String answerKey = "FFFTTFTTFT";
        int k = 3;
        System.out.println("The maximized confusion exam is :" + maxConsecutiveAnswers(answerKey, k));
        System.out.println("The maximized confusion exam 1 is :" + maxConsecutiveAnswers1(answerKey, k));
    }

    public static int maxConsecutiveAnswers( String answerKey, int k ) {
        Map<Character, Integer> answerMap = new HashMap<>();
        answerMap.put('T', 0);
        answerMap.put('F', 0);
        int i = 0, j = 0, maxLength = Integer.MIN_VALUE;

        while (j < answerKey.length()) {
            char currentChar = answerKey.charAt(j);
            answerMap.put(currentChar, answerMap.get(currentChar) + 1);

            int minor = Math.min(answerMap.get('T'), answerMap.get('F'));
            if (minor <= k) {
                maxLength = Math.max(maxLength, j - i + 1);
                j++;
            } else if (minor > k) {
                while (minor > k) {
                    char startChar = answerKey.charAt(i);
                    answerMap.put(startChar, answerMap.get(startChar) - 1);
                    minor = Math.min(answerMap.get('T'), answerMap.get('F'));
                    i++;
                    if (minor == k) {
                        maxLength = Math.max(maxLength, j - i + 1);
                    }
                }
                j++;
            }
        }
        return maxLength;
    }

    public static int maxConsecutiveAnswers1( String answerKey, int k ) {
        int[] charArray = new int[2];
        int i = 0, j = 0, maxLength = Integer.MIN_VALUE;

        while (j < answerKey.length()) {
            if(answerKey.charAt(j) == 'T') {
                charArray[1]++; // 0 - F and 1 - T in the array
            } else {
                charArray[0]++;
            }

            int minor = Math.min(charArray[1],charArray[0]);
            if (minor <= k) {
                maxLength = Math.max(maxLength, j - i + 1);
                j++;
            } else if (minor > k) {
                while (minor > k) {
                    if(answerKey.charAt(i) == 'T') {
                        charArray[1]--;
                    } else {
                        charArray[0]--;
                    }
                    minor =Math.min(charArray[1],charArray[0]);
                    i++;
                    if (minor == k) {
                        maxLength = Math.max(maxLength, j - i + 1);
                    }
                }
                j++;
            }
        }
        return maxLength;
    }
}