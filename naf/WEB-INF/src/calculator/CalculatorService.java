package calculator;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class CalculatorService {

	public double calc(String expr) throws IOException {
		
		InputStream is = new ByteArrayInputStream(expr.getBytes());

		// ANTLRInputStream input = new ANTLRInputStream(System.in);
		ANTLRInputStream input = new ANTLRInputStream(is);

		CalculatorLexer lexer = new CalculatorLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		CalculatorParser parser = new CalculatorParser(tokens);
		ParseTree tree = parser.input();

		CalculatorBaseVisitorImpl calcVisitor = new CalculatorBaseVisitorImpl();
		Double result = calcVisitor.visit(tree);
		return result;

	}

	public static void main(String[] args) throws Exception {
		InputStream is = new ByteArrayInputStream("pi*1+1+1.04^9".getBytes());

		// ANTLRInputStream input = new ANTLRInputStream(System.in);
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
