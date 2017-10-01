package lang.ast;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;
import java.util.TreeSet;
import java.util.*;
/**
 * @ast interface
 * @aspect Visitor
 * @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk5/A2-MinimalAST/src/jastadd/Visitor.jrag:2
 */
public interface Visitor {

		 
		public Object visit(List node, Object data);

		 
		public Object visit(Opt node, Object data);

		 
		public Object visit(Program node, Object data);

		 
		public Object visit(Numeral node, Object data);

		 
		public Object visit(IdDecl node, Object data);

		 
		public Object visit(IdUse node, Object data);

		 
		public Object visit(Func node, Object data);

		 
		public Object visit(Para node, Object data);

		 
		public Object visit(VarDecl node, Object data);

		 
		public Object visit(Assign node, Object data);

		 
		public Object visit(Return node, Object data);

		 
		public Object visit(IfStmt node, Object data);

		 
		public Object visit(WhileStmt node, Object data);

         
        public Object visit(FuncCallStmt node, Object data);

		 
		public Object visit(Add node, Object data);

		 
		public Object visit(Mul node, Object data);

		 
		public Object visit(Div node, Object data);

		 
		public Object visit(Min node, Object data);

		 
		public Object visit(Mod node, Object data);

		 
		public Object visit(Le node, Object data);

		 
		public Object visit(Ge node, Object data);

		 
		public Object visit(Lt node, Object data);

		 
		public Object visit(Gt node, Object data);

		 
		public Object visit(Eq node, Object data);

		 
		public Object visit(Neq node, Object data);

		 
		public Object visit(Call node, Object data);
}
