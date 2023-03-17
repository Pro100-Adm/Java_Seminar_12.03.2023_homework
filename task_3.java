/**
 Реализовать простой калькулятор (+ - / *) с логированием и отменой последней операции
 */
import java.util.Scanner;
import java.util.Stack;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;
import java.io.IOException;

 public class task_3 {

    public static void main(String[] args) {
        Stack<Object> calc_Stack = new Stack<Object>();
        while (true) calc(calc_Stack);
    }

    public static void calc(Stack<Object> calc_Stack){
        int operand_1, operand_2;
        Logger myLogger = Logger.getLogger(task_1.class.getName());
        try {   
            FileHandler fh = new FileHandler("CalcLogFile.log");  
            myLogger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();  
            fh.setFormatter(formatter);  
        } catch (SecurityException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  

        String state = "Enter operand 1";
        if (state.equals("Enter operand 1"))
        {
            Object input = operandUserInput();
            if (!input.equals("cancel")) calc_Stack.push(input);
            state = "Enter operand 2";
        }
        if (calc_Stack.get(calc_Stack.size()-1).toString().toLowerCase().equals("stop")){
            System.out.println("Program End!");
            System.exit(0);   
        }
        if (state.equals("Enter operand 2"))
        {
            Object input = operandUserInput();
            if (!input.equals("cancel")) calc_Stack.push(input);
            state = "Enter operator";
        }
        if (calc_Stack.get(calc_Stack.size()-1).toString().toLowerCase().equals("stop")){
            System.out.println("Program End!");
            System.exit(0);   
        }
        if (state.equals("Enter operator"))
        {
            Object input = operatorUserInput();
            if (!input.equals("cancel")) calc_Stack.push(input);
            state = "Calculate";
        }
        if (calc_Stack.get(calc_Stack.size()-1).toString().toLowerCase().equals("stop")){
            System.out.println("Program End!");
            System.exit(0);   
        }
        if (state.equals("Calculate")){
            myLogger.log(Level.INFO, "operator is " + calc_Stack.get(calc_Stack.size()-1));
            myLogger.log(Level.INFO, "operand 1 is " + calc_Stack.get(calc_Stack.size()-2).toString());
            myLogger.log(Level.INFO, "operand 2 is " + calc_Stack.get(calc_Stack.size()-3).toString());
            System.out.println(calc_Stack);
            switch (calc_Stack.pop().toString().charAt(0)){
                case ('+'):
                operand_2 = Integer.parseInt(calc_Stack.pop().toString());
                operand_1 = Integer.parseInt(calc_Stack.pop().toString());
                calc_Stack.push(operand_1+operand_2);
                break;
                case ('-'):
                operand_2 = Integer.parseInt(calc_Stack.pop().toString());
                operand_1 = Integer.parseInt(calc_Stack.pop().toString());
                calc_Stack.push(operand_1-operand_2);
                break;
                case ('*'):
                operand_2 = Integer.parseInt(calc_Stack.pop().toString());
                operand_1 = Integer.parseInt(calc_Stack.pop().toString());
                calc_Stack.push(operand_1*operand_2);
                break;
                case ('/'):
                try {
                    operand_2 = Integer.parseInt(calc_Stack.pop().toString());
                    operand_1 = Integer.parseInt(calc_Stack.pop().toString());
                    calc_Stack.push((float) operand_1/ (float) operand_2);              
                } catch (Exception e) {
                    System.out.println("Division error!");
                    myLogger.log(Level.WARNING, "Division error!"); 
                    calc(calc_Stack);
                }
                break;
            }
            myLogger.log(Level.INFO, "result is " + calc_Stack.get(calc_Stack.size()-1).toString());
            calc(calc_Stack);
        }
            if (state=="cancel"){
                calc_Stack.remove(calc_Stack.size()-1);
                calc_Stack.remove(calc_Stack.size()-1);
                calc_Stack.remove(calc_Stack.size()-1);
                calc_Stack.remove(calc_Stack.size()-1);
                state = "Enter operand 2";
            }
            if (calc_Stack.pop().toString().toLowerCase().equals("cancel")){
                state = "cancel";   
            }
    }

    public static Object operandUserInput(){
        Scanner operandInput = new Scanner(System.in);
        System.out.print("Enter operand: ");
        String operand = operandInput.nextLine();
        if (operand.toLowerCase().equals("cancel")|operand.toLowerCase().equals("stop")) return operand.toLowerCase();
        try {
            int number = Integer.parseInt(operand);
            return number;
        } catch (Exception e) {
            System.out.println("Wrong operand!");
            return operandUserInput();
        } 
    }
    
    public static Object operatorUserInput(){
        Scanner operatorInput = new Scanner(System.in);
        System.out.print("Enter operator: ");
        String input = operatorInput.nextLine();
        char operator = input.charAt(0);
        if (input.toLowerCase().equals("cancel")|input.toLowerCase().equals("stop")) return input.toLowerCase();
        else{
        try {
            if(operator=='+' | operator=='-' | operator=='*' | operator=='/'){
                return operator;
            }
            else {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println(" Wrong operator!");
            return operatorUserInput();
        }
    }
    }    
}
