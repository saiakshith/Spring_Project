package com.nen.controller;

/*

	Pre-requisite to solve this problem:
	In this question, we have to find sum of all even numbers till n. To take sum of all the even numbers, we have to take a variable and initialize it to zero. Let us name this variable as sum.
	Following code is used to add 2 to sum variable and update it to the same sum variable:
	sum = sum + 2

	Hint to solve this problem: We will have to loop on even numbers only and add the even numbers to the same sum variable, described above.
*/
import java.lang.Integer;
import java.util.Scanner;

public class Solution {

  public Integer sumOfEvenNumbers(Integer N) {

    Integer sum = 0;

    if (N % 2 == 0) {
      for (int i = 1; i <= N; i++) {
        if (i % 2 == 0) {
          sum += i;
        } else {
//          return 0;
        }
      }
      return sum;
    }else {
      return 0;
    }
    }

  public static void main(String[] args) {

    /* Your class should be named Solution.
     * Read input as specified in the question.
     * Print output as specified in the question.
     */
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter a character :");
    String s = scanner.nextLine();

    Solution solution = new Solution();
    System.out.println(solution.sumOfEvenNumbers(8));
  }

}

