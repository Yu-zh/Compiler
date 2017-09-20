package lang;

import lang.ast.*;
/**
 * Created by zhangyu on 20/09/2017.
 */
public class MSNVisitor extends TraversingVisitor{
    public static int result(ASTNode n) {
        MSNVisitor v = new MSNVisitor();
        n.accept(v, 1);
        return v.maxStmtNesting;
    }

    private int maxStmtNesting = 1;

    public Object visit(IfStmt node, Object data) {
        int i = (Integer) data + 1;
        if (maxStmtNesting < i) {
            maxStmtNesting = i;
        }
        return visitChildren(node, i);
    }

    public Object visit(WhileStmt node, Object data) {
        int i = (Integer) data + 1;
        if (maxStmtNesting < i) {
            maxStmtNesting = i;
        }
        return visitChildren(node, i);
    }

}
