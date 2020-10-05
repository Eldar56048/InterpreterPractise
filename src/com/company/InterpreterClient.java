package com.company;

public class InterpreterClient {

        public InterpreterContext interpreterContext;

        public InterpreterClient(InterpreterContext interpreterContext){
            this.interpreterContext=interpreterContext;
        }

        public String interpret(String str){
            Expression exp;
            if(str.contains("Hexadecimal")){
                exp=new IntToHexExpression(Integer.parseInt(str.substring(0,str.indexOf(" "))));
            }else if(str.contains("Binary")){
                exp=new IntToBinaryExpression(Integer.parseInt(str.substring(0,str.indexOf(" "))));
            }
            else{
                return str;
            }
            return exp.interpret(interpreterContext);
        }

    public static void main(String[] args) {
            String ex1 = "138 Binary";
            String ex2 = "138 Hexadecimal";
	        InterpreterClient interpreterClient = new InterpreterClient(new InterpreterContext());
            System.out.println(ex1+" to Binary "+interpreterClient.interpret(ex1));
            System.out.println(ex2+" to Hexadecimal "+interpreterClient.interpret(ex2));
    }
}
