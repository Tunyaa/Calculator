
package com.calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import static com.calculator.Calculation.calculation;

public class LineHandler {
    
    Scanner in = new Scanner(System.in);

    public LineHandler() {
        
        System.out.println("Введите выражение: 1.2+3.4-(5.6/7.8)*9.0");   
        lineHandler(lineCorrector(in.nextLine()));
        
        
    }
            
            
    public static void lineHandler(String[] str){
        
        ArrayList<String> s = new ArrayList<>(Arrays.asList(str));
        lineValidCheck(s);
        System.out.println(calculation(s));
    }
    
    private static String[] lineCorrector(String str){
        return str.replaceAll(" ", "")//Убрать пробелы
                .replaceAll("[а-яА-Яa-zA-Z=]", "")//Убрать буквы и знак =
                .split("(?=[*\\-+/()])|(?<=[*\\-+/()])");//Разделить по операторам
    }
    
    private static void lineValidCheck(ArrayList<String> str){
        if (str.size()==1){
            System.out.println(str.get(0));
            return ;
        }
        if (str.indexOf(")") < str.indexOf(")")||str.contains(")")& str.indexOf("(")==-1) //Удалить открывающую скобку, если она одна
                str.remove(str.indexOf(")"));
        if (str.contains("(")& str.indexOf(")")==-1) //Удалить закрывающую скобку, если она одна
                str.remove(str.indexOf("("));
        if(str.indexOf("(")== str.indexOf(")")-1){ //Удалить скобки, если внутри пусто
            str.remove(str.indexOf("("));
            str.remove(str.indexOf(")"));
        }
    }
}
