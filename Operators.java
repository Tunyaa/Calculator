
package com.calculator;

import static com.calculator.Calculation.calculation;
import java.util.ArrayList;


public class Operators {
    
    public static void bracketOppening(ArrayList<String> str){ //Раскрытие скобок
        
                int openBracketCount = 1;
                int closeBracketCount = 0;
                int closeBracketIndex = 0;
                //Поиск закрывающей скобки для соответствующей ей открывающей скобки
                for (int i = str.indexOf("(")+1; i!=str.size(); i++) {
                    
                    if(str.get(i).equals("(")) openBracketCount++;
                    if(str.get(i).equals(")")) closeBracketCount++;
                    if(openBracketCount == closeBracketCount){
                        
                        closeBracketIndex = i;
                        
                        break;
                    }
                }
                //Создание новой строки из содержимого внутри скобок
                ArrayList<String> substr = new ArrayList<>(str.subList(str.indexOf("(")+1, closeBracketIndex));
                int subStrSize = substr.size();
                
                //Вернуть результат вычисления в строку
                str.add(str.indexOf("("), String.valueOf(calculation(substr)));
                //Удалить из строки посчтинанную часть
                int sim1 = str.indexOf("(");
                for (int i = 0; i < subStrSize+2; i++) {
                    str.remove(sim1);
                }
              
    }
    //Сложение
    public static void sum(ArrayList<String> str){
       int i = str.indexOf("+");
       str.add(i-1, String.valueOf(Float.valueOf(str.get(i-1)) + Float.valueOf(str.get(i+1))));
       for(int j = 0; j != 3; j++) str.remove(i);
    }
    //Вычитание
    public static void sub(ArrayList<String> str){
       int i = str.indexOf("-");
       str.add(i-1, String.valueOf(Float.valueOf(str.get(i-1)) - Float.valueOf(str.get(i+1))));
       for(int j = 0; j != 3; j++) str.remove(i);
    }
    //Деление
    public static void div(ArrayList<String> str){
       int i = str.indexOf("/"); 
       float f = Float.valueOf(str.get(i-1)) * Float.valueOf(str.get(i+1));
       str.add(i-1, String.valueOf(f));
       for(int j = 0; j != 3; j++) str.remove(i);
    }
    //Умножение
    public static void mul(ArrayList<String> str){
       int i = str.indexOf("*");
       str.add(i-1, String.valueOf(Float.valueOf(str.get(i-1)) * Float.valueOf(str.get(i+1))));
       for(int j = 0; j != 3; j++) str.remove(i);
    }
    
}
