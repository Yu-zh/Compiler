/* This file was generated with JastAdd2 (http://jastadd.org) version 2.2.3 */
package lang.ast;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;
import java.util.TreeSet;
import java.util.*;
/**
 * @ast node
 * @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk5/A2-MinimalAST/src/jastadd/lang.ast:10
 * @astdecl IfStmt : Stmt ::= Cond:Expr Body:Stmt* Else:Stmt*;
 * @production IfStmt : {@link Stmt} ::= <span class="component">Cond:{@link Expr}</span> <span class="component">Body:{@link Stmt}*</span> <span class="component">Else:{@link Stmt}*</span>;

 */
public class IfStmt extends Stmt implements Cloneable {
  /**
   * @aspect Interpreter
   * @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk5/A2-MinimalAST/src/jastadd/Interpreter.jrag:43
   */
  public void eval(ActivationRecord actrec) throws ReturnException{
        int cond = getCond().eval(actrec);
        if (cond == 1) {
            for (Stmt s : getBodyList()) {
                s.eval(actrec);
            }
        } else if (cond == 0) {
            for (Stmt s : getElseList()) {
                s.eval(actrec);
            }
        } else {
            throw new RuntimeException("if stmt cond is not boolean!");
        }
    }
  /**
   * @aspect PrettyPrint
   * @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk5/A2-MinimalAST/src/jastadd/PrettyPrint.jrag:65
   */
  public void prettyPrint(PrintStream out, String ind) {
        out.print("if ");
        out.print("(");
        getCond().prettyPrint(out, ind);
        out.print(") ");
        out.print("{");
        out.println();
        if (getNumBody() > 0) {
            for (int i = 0; i < getNumBody(); ++i) {
                out.print(ind+" ");
                getBody(i).prettyPrint(out, ind+"   ");
                if (!(getBody(i) instanceof IfStmt) && !(getBody(i) instanceof WhileStmt)) {
                    out.print(";");
                }
                out.println();
            }
        }
        out.print(ind);
        out.print("}");
        if (getNumElse() > 0) {
            out.print(" else {");
            out.println();
            for (int i = 0; i < getNumElse(); ++i) {
                out.print(ind+" ");
                getElse(i).prettyPrint(out, ind+"   ");
                if (!(getElse(i) instanceof IfStmt) && !(getElse(i) instanceof WhileStmt)) {
                    out.print(";");
                }
                out.println();
            }
            out.print(ind);
            out.print("}");
        }

    }
  /**
   * @aspect Visitor
   * @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk5/A2-MinimalAST/src/jastadd/Visitor.jrag:67
   */
  public Object accept(Visitor visitor, Object data) {
    	return visitor.visit(this, data);
    }
  /**
   * @declaredat ASTNode:1
   */
  public IfStmt() {
    super();
  }
  /**
   * Initializes the child array to the correct size.
   * Initializes List and Opt nta children.
   * @apilevel internal
   * @ast method
   * @declaredat ASTNode:10
   */
  public void init$Children() {
    children = new ASTNode[3];
    setChild(new List(), 1);
    setChild(new List(), 2);
  }
  /**
   * @declaredat ASTNode:15
   */
  @ASTNodeAnnotation.Constructor(
    name = {"Cond", "Body", "Else"},
    type = {"Expr", "List<Stmt>", "List<Stmt>"},
    kind = {"Child", "List", "List"}
  )
  public IfStmt(Expr p0, List<Stmt> p1, List<Stmt> p2) {
    setChild(p0, 0);
    setChild(p1, 1);
    setChild(p2, 2);
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:26
   */
  protected int numChildren() {
    return 3;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:30
   */
  public void flushAttrCache() {
    super.flushAttrCache();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:34
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:38
   */
  public IfStmt clone() throws CloneNotSupportedException {
    IfStmt node = (IfStmt) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:43
   */
  public IfStmt copy() {
    try {
      IfStmt node = (IfStmt) clone();
      node.parent = null;
      if (children != null) {
        node.children = (ASTNode[]) children.clone();
      }
      return node;
    } catch (CloneNotSupportedException e) {
      throw new Error("Error: clone not supported for " + getClass().getName());
    }
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @deprecated Please use treeCopy or treeCopyNoTransform instead
   * @declaredat ASTNode:62
   */
  @Deprecated
  public IfStmt fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:72
   */
  public IfStmt treeCopyNoTransform() {
    IfStmt tree = (IfStmt) copy();
    if (children != null) {
      for (int i = 0; i < children.length; ++i) {
        ASTNode child = (ASTNode) children[i];
        if (child != null) {
          child = child.treeCopyNoTransform();
          tree.setChild(child, i);
        }
      }
    }
    return tree;
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The subtree of this node is traversed to trigger rewrites before copy.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:92
   */
  public IfStmt treeCopy() {
    IfStmt tree = (IfStmt) copy();
    if (children != null) {
      for (int i = 0; i < children.length; ++i) {
        ASTNode child = (ASTNode) getChild(i);
        if (child != null) {
          child = child.treeCopy();
          tree.setChild(child, i);
        }
      }
    }
    return tree;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:106
   */
  protected boolean is$Equal(ASTNode node) {
    return super.is$Equal(node);    
  }
  /**
   * Replaces the Cond child.
   * @param node The new node to replace the Cond child.
   * @apilevel high-level
   */
  public void setCond(Expr node) {
    setChild(node, 0);
  }
  /**
   * Retrieves the Cond child.
   * @return The current node used as the Cond child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="Cond")
  public Expr getCond() {
    return (Expr) getChild(0);
  }
  /**
   * Retrieves the Cond child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the Cond child.
   * @apilevel low-level
   */
  public Expr getCondNoTransform() {
    return (Expr) getChildNoTransform(0);
  }
  /**
   * Replaces the Body list.
   * @param list The new list node to be used as the Body list.
   * @apilevel high-level
   */
  public void setBodyList(List<Stmt> list) {
    setChild(list, 1);
  }
  /**
   * Retrieves the number of children in the Body list.
   * @return Number of children in the Body list.
   * @apilevel high-level
   */
  public int getNumBody() {
    return getBodyList().getNumChild();
  }
  /**
   * Retrieves the number of children in the Body list.
   * Calling this method will not trigger rewrites.
   * @return Number of children in the Body list.
   * @apilevel low-level
   */
  public int getNumBodyNoTransform() {
    return getBodyListNoTransform().getNumChildNoTransform();
  }
  /**
   * Retrieves the element at index {@code i} in the Body list.
   * @param i Index of the element to return.
   * @return The element at position {@code i} in the Body list.
   * @apilevel high-level
   */
  public Stmt getBody(int i) {
    return (Stmt) getBodyList().getChild(i);
  }
  /**
   * Check whether the Body list has any children.
   * @return {@code true} if it has at least one child, {@code false} otherwise.
   * @apilevel high-level
   */
  public boolean hasBody() {
    return getBodyList().getNumChild() != 0;
  }
  /**
   * Append an element to the Body list.
   * @param node The element to append to the Body list.
   * @apilevel high-level
   */
  public void addBody(Stmt node) {
    List<Stmt> list = (parent == null) ? getBodyListNoTransform() : getBodyList();
    list.addChild(node);
  }
  /** @apilevel low-level 
   */
  public void addBodyNoTransform(Stmt node) {
    List<Stmt> list = getBodyListNoTransform();
    list.addChild(node);
  }
  /**
   * Replaces the Body list element at index {@code i} with the new node {@code node}.
   * @param node The new node to replace the old list element.
   * @param i The list index of the node to be replaced.
   * @apilevel high-level
   */
  public void setBody(Stmt node, int i) {
    List<Stmt> list = getBodyList();
    list.setChild(node, i);
  }
  /**
   * Retrieves the Body list.
   * @return The node representing the Body list.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.ListChild(name="Body")
  public List<Stmt> getBodyList() {
    List<Stmt> list = (List<Stmt>) getChild(1);
    return list;
  }
  /**
   * Retrieves the Body list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Body list.
   * @apilevel low-level
   */
  public List<Stmt> getBodyListNoTransform() {
    return (List<Stmt>) getChildNoTransform(1);
  }
  /**
   * @return the element at index {@code i} in the Body list without
   * triggering rewrites.
   */
  public Stmt getBodyNoTransform(int i) {
    return (Stmt) getBodyListNoTransform().getChildNoTransform(i);
  }
  /**
   * Retrieves the Body list.
   * @return The node representing the Body list.
   * @apilevel high-level
   */
  public List<Stmt> getBodys() {
    return getBodyList();
  }
  /**
   * Retrieves the Body list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Body list.
   * @apilevel low-level
   */
  public List<Stmt> getBodysNoTransform() {
    return getBodyListNoTransform();
  }
  /**
   * Replaces the Else list.
   * @param list The new list node to be used as the Else list.
   * @apilevel high-level
   */
  public void setElseList(List<Stmt> list) {
    setChild(list, 2);
  }
  /**
   * Retrieves the number of children in the Else list.
   * @return Number of children in the Else list.
   * @apilevel high-level
   */
  public int getNumElse() {
    return getElseList().getNumChild();
  }
  /**
   * Retrieves the number of children in the Else list.
   * Calling this method will not trigger rewrites.
   * @return Number of children in the Else list.
   * @apilevel low-level
   */
  public int getNumElseNoTransform() {
    return getElseListNoTransform().getNumChildNoTransform();
  }
  /**
   * Retrieves the element at index {@code i} in the Else list.
   * @param i Index of the element to return.
   * @return The element at position {@code i} in the Else list.
   * @apilevel high-level
   */
  public Stmt getElse(int i) {
    return (Stmt) getElseList().getChild(i);
  }
  /**
   * Check whether the Else list has any children.
   * @return {@code true} if it has at least one child, {@code false} otherwise.
   * @apilevel high-level
   */
  public boolean hasElse() {
    return getElseList().getNumChild() != 0;
  }
  /**
   * Append an element to the Else list.
   * @param node The element to append to the Else list.
   * @apilevel high-level
   */
  public void addElse(Stmt node) {
    List<Stmt> list = (parent == null) ? getElseListNoTransform() : getElseList();
    list.addChild(node);
  }
  /** @apilevel low-level 
   */
  public void addElseNoTransform(Stmt node) {
    List<Stmt> list = getElseListNoTransform();
    list.addChild(node);
  }
  /**
   * Replaces the Else list element at index {@code i} with the new node {@code node}.
   * @param node The new node to replace the old list element.
   * @param i The list index of the node to be replaced.
   * @apilevel high-level
   */
  public void setElse(Stmt node, int i) {
    List<Stmt> list = getElseList();
    list.setChild(node, i);
  }
  /**
   * Retrieves the Else list.
   * @return The node representing the Else list.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.ListChild(name="Else")
  public List<Stmt> getElseList() {
    List<Stmt> list = (List<Stmt>) getChild(2);
    return list;
  }
  /**
   * Retrieves the Else list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Else list.
   * @apilevel low-level
   */
  public List<Stmt> getElseListNoTransform() {
    return (List<Stmt>) getChildNoTransform(2);
  }
  /**
   * @return the element at index {@code i} in the Else list without
   * triggering rewrites.
   */
  public Stmt getElseNoTransform(int i) {
    return (Stmt) getElseListNoTransform().getChildNoTransform(i);
  }
  /**
   * Retrieves the Else list.
   * @return The node representing the Else list.
   * @apilevel high-level
   */
  public List<Stmt> getElses() {
    return getElseList();
  }
  /**
   * Retrieves the Else list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Else list.
   * @apilevel low-level
   */
  public List<Stmt> getElsesNoTransform() {
    return getElseListNoTransform();
  }
/** @apilevel internal */
protected java.util.Set localLookup_String_int_int_visited;
  /**
   * @attribute syn
   * @aspect NameAnalysis
   * @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk5/A2-MinimalAST/src/jastadd/NameAnalysis.jrag:37
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="NameAnalysis", declaredAt="/Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk5/A2-MinimalAST/src/jastadd/NameAnalysis.jrag:37")
  public IdDecl localLookup(String name, int until, int flag) {
    java.util.List _parameters = new java.util.ArrayList(3);
    _parameters.add(name);
    _parameters.add(until);
    _parameters.add(flag);
    if (localLookup_String_int_int_visited == null) localLookup_String_int_int_visited = new java.util.HashSet(4);
    if (localLookup_String_int_int_visited.contains(_parameters)) {
      throw new RuntimeException("Circular definition of attribute IfStmt.localLookup(String,int,int).");
    }
    localLookup_String_int_int_visited.add(_parameters);
    try {
            if (flag==0) {
                for (int i = 0; i <= until; i++) {
                    if ((getBody(i) instanceof VarDecl)) {
                        VarDecl varDecl = (VarDecl) getBody(i);
                        if (varDecl.getIdDecl().getID().equals(name)) {
                            return varDecl.getIdDecl();
                        }
                    }
                }
            }
            else if (flag==1) {
                for (int i = 0; i <= until; i++) {
                     if ((getElse(i) instanceof VarDecl)) {
                          VarDecl varDecl = (VarDecl) getElse(i);
                          if (varDecl.getIdDecl().getID().equals(name)) {
                              return varDecl.getIdDecl();
                          }
                     }
                }
            }
            else {
                System.out.println("IfStmt gives error flag");
            }
            return unknownDecl();
        }
    finally {
      localLookup_String_int_int_visited.remove(_parameters);
    }
  }
/** @apilevel internal */
protected boolean typeNotCheck_visited = false;
  /**
   * @attribute syn
   * @aspect TypeCheck
   * @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk5/A2-MinimalAST/src/jastadd/TypeCheck.jrag:32
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="TypeCheck", declaredAt="/Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk5/A2-MinimalAST/src/jastadd/TypeCheck.jrag:32")
  public boolean typeNotCheck() {
    if (typeNotCheck_visited) {
      throw new RuntimeException("Circular definition of attribute IfStmt.typeNotCheck().");
    }
    typeNotCheck_visited = true;
    boolean typeNotCheck_value = !getCond().expectedType().isCompatible(getCond().type());
    typeNotCheck_visited = false;
    return typeNotCheck_value;
  }
  /**
   * @attribute inh
   * @aspect NameAnalysis
   * @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk5/A2-MinimalAST/src/jastadd/NameAnalysis.jrag:63
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="NameAnalysis", declaredAt="/Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk5/A2-MinimalAST/src/jastadd/NameAnalysis.jrag:63")
  public IdDecl lookup(String name) {
    Object _parameters = name;
    if (lookup_String_visited == null) lookup_String_visited = new java.util.HashSet(4);
    if (lookup_String_visited.contains(_parameters)) {
      throw new RuntimeException("Circular definition of attribute IfStmt.lookup(String).");
    }
    lookup_String_visited.add(_parameters);
    IdDecl lookup_String_value = getParent().Define_lookup(this, null, name);
    lookup_String_visited.remove(_parameters);
    return lookup_String_value;
  }
/** @apilevel internal */
protected java.util.Set lookup_String_visited;
  /**
   * @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk5/A2-MinimalAST/src/jastadd/Interpreter.jrag:202
   * @apilevel internal
   */
  public String Define_index(ASTNode _callerNode, ASTNode _childNode) {
    if (_callerNode == getElseListNoTransform()) {
      // @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk5/A2-MinimalAST/src/jastadd/Interpreter.jrag:205
      int i = _callerNode.getIndexOfChild(_childNode);
      return Integer.toString(i) + "_" + index();
    }
    else if (_callerNode == getBodyListNoTransform()) {
      // @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk5/A2-MinimalAST/src/jastadd/Interpreter.jrag:204
      int i = _callerNode.getIndexOfChild(_childNode);
      return Integer.toString(i) + "_" + index();
    }
    else {
      return getParent().Define_index(this, _callerNode);
    }
  }
  /**
   * @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk5/A2-MinimalAST/src/jastadd/Interpreter.jrag:202
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute index
   */
  protected boolean canDefine_index(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk5/A2-MinimalAST/src/jastadd/NameAnalysis.jrag:101
   * @apilevel internal
   */
  public IdDecl Define_lookup(ASTNode _callerNode, ASTNode _childNode, String name) {
    if (_callerNode == getElseListNoTransform()) {
      // @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk5/A2-MinimalAST/src/jastadd/NameAnalysis.jrag:33
      int index = _callerNode.getIndexOfChild(_childNode);
      {
              IdDecl decl = localLookup(name, index, 1);
              return !decl.isUnknown() ? decl : lookup(name);
          }
    }
    else if (_callerNode == getBodyListNoTransform()) {
      // @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk5/A2-MinimalAST/src/jastadd/NameAnalysis.jrag:29
      int index = _callerNode.getIndexOfChild(_childNode);
      {
              IdDecl decl = localLookup(name, index, 0);
              return !decl.isUnknown() ? decl : lookup(name);
          }
    }
    else {
      return getParent().Define_lookup(this, _callerNode, name);
    }
  }
  /**
   * @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk5/A2-MinimalAST/src/jastadd/NameAnalysis.jrag:101
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute lookup
   */
  protected boolean canDefine_lookup(ASTNode _callerNode, ASTNode _childNode, String name) {
    return true;
  }
  /**
   * @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk5/A2-MinimalAST/src/jastadd/TypeCheck.jrag:25
   * @apilevel internal
   */
  public Type Define_expectedType(ASTNode _callerNode, ASTNode _childNode) {
    if (_callerNode == getCondNoTransform()) {
      // @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk5/A2-MinimalAST/src/jastadd/TypeCheck.jrag:27
      return new BoolType();
    }
    else {
      return getParent().Define_expectedType(this, _callerNode);
    }
  }
  /**
   * @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk5/A2-MinimalAST/src/jastadd/TypeCheck.jrag:25
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute expectedType
   */
  protected boolean canDefine_expectedType(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
}
