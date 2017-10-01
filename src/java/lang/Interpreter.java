package lang;

import java.io.*;
import java.lang.*;
import java.lang.Compiler;

import beaver.Parser.Exception;

import lang.ast.*;

/**
 * Created by zhangyu on 30/09/2017.
 */
public class Interpreter {
    public static Object DrAST_root_node; //Enable debugging with DrAST
    public static void main(String[] args) {
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
            DrAST_root_node = program; //Enable debugging with DrAST
            if (actual.equals("")) {
                program.eval();
            }
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
