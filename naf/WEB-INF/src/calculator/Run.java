package calculator;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class Run {
    public static void main(String[] args) throws Exception {
    	InputStream is = new ByteArrayInputStream("pi*1+1+1.04^9".getBytes());
    	
        //ANTLRInputStream input = new ANTLRInputStream(System.in);
    	ANTLRInputStream input = new ANTLRInputStream(is);
        
        CalculatorLexer lexer = new CalculatorLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CalculatorParser parser = new CalculatorParser(tokens);
        ParseTree tree = parser.input();

        CalculatorBaseVisitorImpl calcVisitor = new CalculatorBaseVisitorImpl();
        Double result = calcVisitor.visit(tree);
        System.out.println("Result: " + result);
    }
}
