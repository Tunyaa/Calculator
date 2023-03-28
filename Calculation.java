
package com.calculator;

import java.util.ArrayList;
import static com.calculator.Operators.*;

public class Calculation {
    public static float calculation(ArrayList<String> str ){
        while(str.size()!=1){//Пока строка не будет состоять из одного элемента
            //Раскрытие скобок
            if (str.contains("(")) {
                
                bracketOppening(str);
                
                continue;
            }//Действия слева направо. Для соблюдения приорететности деления и умножения
            if (str.contains("*") && str.contains("/")) {
                if (str.indexOf("*") < str.indexOf("/")) {
                    mul(str);
                }else div(str);
                continue;
            }//Умножение
            if (str.contains("*")) {
                Operators.mul(str);
                continue;
            }//Деление 
            if (str.contains("/")) {
                div(str);
                continue;
            }//Сложение
            if (str.contains("+") && str.indexOf("+") == 1) {
                sum(str);
                continue;
            }//Вычитание
            if (str.contains("-") && str.indexOf("-") == 1) {
                sub(str);
                continue;
            }
 
        }
        
        return Float.parseFloat(str.get(0));
    }
    
}
