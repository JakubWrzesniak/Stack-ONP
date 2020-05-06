package RPN;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<Double> results = Rpn.valueOfDataFromFile("DataRPN.txt",false);
        Double results2 = Rpn.valueOfDataFromConsol(false);
        System.out.println("Results : ");
        for(Double d : results)
            System.out.println(d);
        System.out.println(results2);
    }
}
