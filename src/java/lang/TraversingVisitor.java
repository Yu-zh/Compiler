package lang;

import lang.ast.*;
/**
 * Created by zhangyu on 20/09/2017.
 */
public abstract class TraversingVisitor implements lang.ast.Visitor{
    protected Object visitChildren(ASTNode node, Object data){
        for (int i = 0; i < node.getNumChild(); ++i) {
    //        System.out.println(node.getClass());
            node.getChild(i).accept(this, data);
        }
        return data;
    }

    public Object visit(List node, Object data) { return visitChildren(node, data); }
    public Object visit(Opt node, Object data) { return visitChildren(node, data); }
    public Object visit(Program node, Object data) { return visitChildren(node, data); }
    public Object visit(Numeral node, Object data) { return visitChildren(node, data); }
    public Object visit(IdDecl node, Object data) { return visitChildren(node, data); }
    public Object visit(IdUse node, Object data) { return visitChildren(node, data); }
    public Object visit(Func node, Object data) { return visitChildren(node, data); }
    public Object visit(Para node, Object data) { return visitChildren(node, data); }
    public Object visit(VarDecl node, Object data) { return visitChildren(node, data); }
    public Object visit(Assign node, Object data) { return visitChildren(node, data); }
    public Object visit(Return node, Object data) { return visitChildren(node, data); }
    public Object visit(IfStmt node, Object data) { return visitChildren(node, data); }
    public Object visit(WhileStmt node, Object data) { return visitChildren(node, data); }
    public Object visit(Print node, Object data) { return visitChildren(node, data); }
    public Object visit(Add node, Object data) { return visitChildren(node, data); }
    public Object visit(Mul node, Object data) { return visitChildren(node, data); }
    public Object visit(Div node, Object data) { return visitChildren(node, data); }
    public Object visit(Min node, Object data) { return visitChildren(node, data); }
    public Object visit(Mod node, Object data) { return visitChildren(node, data); }
    public Object visit(Le node, Object data) { return visitChildren(node, data); }
    public Object visit(Ge node, Object data) { return visitChildren(node, data); }
    public Object visit(Lt node, Object data) { return visitChildren(node, data); }
    public Object visit(Gt node, Object data) { return visitChildren(node, data); }
    public Object visit(Eq node, Object data) { return visitChildren(node, data); }
    public Object visit(Neq node, Object data) { return visitChildren(node, data); }
    public Object visit(Call node, Object data) { return visitChildren(node, data); }
    public Object visit(PassParas node, Object data) { return visitChildren(node, data); }
    public Object visit(Read node, Object data) { return visitChildren(node, data); }
}
