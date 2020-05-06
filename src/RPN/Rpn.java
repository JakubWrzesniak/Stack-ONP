package RPN;

import Stack.ListStack;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public abstract class Rpn {

    public static Double valueOfDataFromConsol(boolean isRpn) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double result;
        if(isRpn) {
            System.out.println("RPN Expression :");
            result = value(br).get(0);
        }
        else {
            System.out.println("No RPN Expression :");
            String s = br.readLine();
            result = value(new StringReader(stringDataToRPN(s))).get(0);
        }
        br.close();
        return result;
    }

    public static ArrayList<Double> value(Reader br) throws IOException{

            ListStack<Double> stack = new ListStack<>();
            ArrayList<Double> results = new ArrayList<>();

            StreamTokenizer st = new StreamTokenizer(br);

            st.ordinaryChar('/');
            st.ordinaryChar('+');
            st.ordinaryChar('-');
            st.ordinaryChar('*');

            st.eolIsSignificant(true);

            int token = st.nextToken();

            while (st.ttype != st.TT_EOF && st.ttype != st.TT_EOL){
                while (st.ttype != st.TT_EOL && st.ttype != st.TT_EOF ){
                    if(st.ttype == st.TT_NUMBER) {
                        stack.push(st.nval);
                    } else{
                        double num1 = stack.pop();
                        double num2 = stack.pop();
                        switch ((char)token){
                            case'+':
                                stack.push(num2+num1);
                                break;
                            case'-':
                                stack.push(num2-num1);
                                break;
                            case'*':
                                stack.push(num2*num1);
                                break;
                            case'/':
                                stack.push(num2/num1);
                                break;
                        }
                    }
                    token = st.nextToken();
                }
                token = st.nextToken();
                results.add(stack.pop());
                stack.clear();
            }
        return results;
    }

    public static ArrayList<Double>  valueOfDataFromFile(String data,boolean isRpn){

        ArrayList<Double> results = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(new File(data)))){

            if(!isRpn)
                results = value(fileDataToRPN(br));
            else
                results = value(br);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return results;
    }

    public static StringReader fileDataToRPN(BufferedReader br) throws IOException {
        String line = "";
        StringBuffer result = new StringBuffer();
        try {
            while (line!=null) {
                line = br.readLine();
                if(line!=null)
                    result.append(stringDataToRPN(line));
            }
        }catch (EOFException e){}
        return new StringReader(result.toString());
    }

    public static String stringDataToRPN(String line){

        StringBuffer result = new StringBuffer();
        StringTokenizer st = new StringTokenizer(line);
        ListStack<String> stack = new ListStack<>();
        String token;

        while (st.hasMoreElements()) {
            token = st.nextToken();
            if (!token.equals("+") && !token.equals("-") && !token.equals("*") && !token.equals("/") && !token.equals("(") && !token.equals(")")){
                result.append(token+" ");
            }else{
                switch (token){
                    case"(":
                        stack.push(token);
                        break;
                    case")":
                        while (!stack.peek().equals("("))
                            result.append(stack.pop()+" ");
                        stack.pop();
                        break;
                    case "+":
                    case "-":
                        while (!stack.isEmpty() && !stack.peek().equals("("))
                            result.append(stack.pop() + " ");
                        stack.push(token);
                        break;
                    case "*":
                    case "/":
                        while (!stack.isEmpty() &&(stack.peek().equals("*") || stack.peek().equals("/")))
                            result.append(stack.pop()+" ");
                        stack.push(token);
                        break;
                }
            }
        }
        while (stack.size()>0)
            result.append(stack.pop());
        result.append("\n");
        return result.toString();
    }
}
