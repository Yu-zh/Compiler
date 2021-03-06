package lang;

import java.io.*;

import beaver.Parser.Exception;

import lang.ast.ErrorMessage;
import lang.ast.Program;
import lang.ast.LangParser;
import lang.ast.LangScanner;
import lang.MSNVisitor;
/**
 * Dumps the parsed Abstract Syntax Tree of a Calc program.
 */
public class Compiler {
	/**
	 * Entry point
	 * @param args
	 */
    
    public static Object DrAST_root_node; //Enable debugging with DrAST
    
	public static void compile(String[] args) {
		try {
			if (args.length != 1) {
				System.err.println(
						"You must specify a source file on the command line!");
				System.exit(1);
				return;
			}

			String filename = args[0];
			LangScanner scanner = new LangScanner(new FileReader(filename));
			LangParser parser = new LangParser();
            ByteArrayOutputStream bytes = new ByteArrayOutputStream();
            PrintStream outStream = new PrintStream(bytes);
			Program program = (Program) parser.parse(scanner);
			StringBuilder sb = new StringBuilder();
			for (ErrorMessage m : program.errors()) {
				sb.append(m).append("\n");
			}
			String actual = sb.toString();
			System.out.print(actual);

//            System.out.println(MSNVisitor.result(program));
            DrAST_root_node = program; //Enable debugging with DrAST
//			System.out.println(program.dumpTree());
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
			System.exit(1);
		} catch (IOException e) {
			e.printStackTrace(System.err);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

