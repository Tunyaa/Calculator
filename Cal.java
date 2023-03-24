

package com.mycompany.cal;

import java.util.ArrayList;
import java.util.Scanner;



public class Cal {

    public static void main(String[] args) {
        while (true) {            
            System.out.println("Введите выражение: 0-9 +-/*()   /q - Выход");
        Scanner in = new Scanner(System.in);
        String[] str = new String[1];
        str[0] = in.nextLine();
            if (str[0].equals("/q")) {
                break;
            }else
                LineHandler.lineHandler(str);
        
        }
    }
}

 class LineHandler {
    
    public static float lineHandler(String[] str){
        
        str[0] = str[0].replaceAll(" ", "");
        str = str[0].split("(?=[*\\-+/()])|(?<=[*\\-+/()])");
        
        ArrayList<String> s = new ArrayList<>();
        for (int i = 0; i != str.length; i++) {
            s.add(str[i]);
        }
        System.out.println(calculation(s));
        return 0;
    }
    
    private static float calculation(ArrayList<String> str ){
        while(str.size()!=1){
           
            
            if (str.contains("(")) {
                
                int openBracketCount = 1;
                int closeBracketCount = 0;
                int closeBracketIndex = 0;
                
                for (int i = str.indexOf("(")+1; i!=str.size(); i++) {
                    
                    if(str.get(i).equals("(")) openBracketCount++;
                    if(str.get(i).equals(")")) closeBracketCount++;
                    if(openBracketCount == closeBracketCount){
                        
                        closeBracketIndex = i;
                        
                        break;
                    }
                }
                
                ArrayList<String> substr = new ArrayList<>(str.subList(str.indexOf("(")+1, closeBracketIndex));
                int subStrSize = substr.size();
                str.add(str.indexOf("("), String.valueOf(calculation(substr)));
                
                int sim1 = str.indexOf("(");
                for (int i = 0; i < subStrSize+2; i++) {
                    str.remove(sim1);
                }
                
                continue;
            }
            if (str.contains("*") && str.contains("/")) {
                if (str.indexOf("*") < str.indexOf("/")) {
                    operator("*", str);
                }else operator("/", str);
                continue;
            }
            if (str.contains("*")) {
                operator("*", str);
                continue;
            }
            if (str.contains("/")) {
                operator("/", str);
                continue;
            }
            if (str.contains("+") && str.indexOf("+") == 1) {
                operator("+", str);
                continue;
            }
            if (str.contains("-") && str.indexOf("-") == 1) {
                operator("-", str);
                continue;
            }
 
        }
        return Float.valueOf(str.get(0));
    }
    
    private static void operator(String operator, ArrayList<String> str){
        int i = str.indexOf(operator);
        if (operator.equals("*")) str.add(i-1, String.valueOf(Float.valueOf(str.get(i-1)) * Float.valueOf(str.get(i+1))));
        if (operator.equals("/")) str.add(i-1, String.valueOf(Float.valueOf(str.get(i-1)) / Float.valueOf(str.get(i+1))));
        if (operator.equals("+")) str.add(i-1, String.valueOf(Float.valueOf(str.get(i-1)) + Float.valueOf(str.get(i+1))));
        if (operator.equals("-")) str.add(i-1, String.valueOf(Float.valueOf(str.get(i-1)) - Float.valueOf(str.get(i+1))));
        for(int j = 0; j != 3; j++) str.remove(i);
    }
}