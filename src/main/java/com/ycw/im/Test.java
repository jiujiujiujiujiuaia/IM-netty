package com.ycw.im;

/**
 * @Author yuchunwei
 */
public class Test {

    public static void main(String[] args) {
        String a = "dasdasdsadasdas,dasdas,";
        char[] bytes = a.toCharArray();
        bytes[bytes.length-1] = ' ';
        System.out.println(new String(bytes));


    }
}   
