package com.nen.controller;

import java.util.Arrays;

public class Test {
  public static void main(String[] args) {

    Test test = new Test();

    String [] arr = {"aksith", "kuscbi", "makajaja"};
    arr[0] = "aksithkjdkfad;sjfakd";
    System.out.println(Arrays.toString(arr));

    System.out.println("hello world!");
  }
}
