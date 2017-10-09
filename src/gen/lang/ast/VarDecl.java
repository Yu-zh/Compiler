/* This file was generated with JastAdd2 (http://jastadd.org) version 2.2.3 */
package lang.ast;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;
import java.util.TreeSet;
import java.util.HashSet;
import java.util.*;
/**
 * @ast node
 * @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk6/A2-MinimalAST/src/jastadd/lang.ast:7
 * @astdecl VarDecl : Stmt ::= Type IdDecl [Expr];
 * @production VarDecl : {@link Stmt} ::= <span class="component">{@link Type}</span> <span class="component">{@link IdDecl}</span> <span class="component">[{@link Expr}]</span>;

 */
public class VarDecl extends Stmt implements Cloneable {
  /**
   * @aspect CodeGen
   * @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk6/A2-MinimalAST/src/jastadd/CodeGen.jrag:181
   */
  public void genCode(PrintStream out) {
        if (hasExpr()) {
            getExpr().genEval(out);
            out.println("       movq %rax, " + getIdDecl().addr());
        }
    }
  /**
   * @aspect Interpreter
   * @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk6/A2-MinimalAST/src/jastadd/Interpreter.jrag:28
   */
  public void eval(ActivationRecord actrec) {
        if (hasExpr()) {
            int e = getExpr().eval(actrec);
            actrec.setRecValue(getIdDecl().uniqueName(), e);
        } else {
            actrec.setRecValue(getIdDecl().uniqueName(), 0);
        }
    }
  /**
   * @aspect PrettyPrint
   * @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk6/A2-MinimalAST/src/jastadd/PrettyPrint.jrag:45
   */
  public void prettyPrint(PrintStream out, String ind) {
        out.print("int ");
        getIdDecl().prettyPrint(out, ind);
        if (hasExpr()) {
            out.print(" = ");
            getExpr().prettyPrint(out, ind);
        }
    }
  /**
   * @aspect Visitor
   * @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk6/A2-MinimalAST/src/jastadd/Visitor.jrag:58
   */
  public Object accept(Visitor visitor, Object data) {
		return visitor.visit(this, data);
	}
  /**
   * @declaredat ASTNode:1
   */
  public VarDecl() {
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
    setChild(new Opt(), 2);
  }
  /**
   * @declaredat ASTNode:14
   */
  @ASTNodeAnnotation.Constructor(
    name = {"Type", "IdDecl", "Expr"},
    type = {"Type", "IdDecl", "Opt<Expr>"},
    kind = {"Child", "Child", "Opt"}
  )
  public VarDecl(Type p0, IdDecl p1, Opt<Expr> p2) {
    setChild(p0, 0);
    setChild(p1, 1);
    setChild(p2, 2);
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:25
   */
  protected int numChildren() {
    return 3;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:29
   */
  public void flushAttrCache() {
    super.flushAttrCache();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:33
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:37
   */
  public VarDecl clone() throws CloneNotSupportedException {
    VarDecl node = (VarDecl) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:42
   */
  public VarDecl copy() {
    try {
      VarDecl node = (VarDecl) clone();
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
   * @declaredat ASTNode:61
   */
  @Deprecated
  public VarDecl fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:71
   */
  public VarDecl treeCopyNoTransform() {
    VarDecl tree = (VarDecl) copy();
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
   * @declaredat ASTNode:91
   */
  public VarDecl treeCopy() {
    VarDecl tree = (VarDecl) copy();
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
   * @declaredat ASTNode:105
   */
  protected boolean is$Equal(ASTNode node) {
    return super.is$Equal(node);    
  }
  /**
   * Replaces the Type child.
   * @param node The new node to replace the Type child.
   * @apilevel high-level
   */
  public void setType(Type node) {
    setChild(node, 0);
  }
  /**
   * Retrieves the Type child.
   * @return The current node used as the Type child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="Type")
  public Type getType() {
    return (Type) getChild(0);
  }
  /**
   * Retrieves the Type child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the Type child.
   * @apilevel low-level
   */
  public Type getTypeNoTransform() {
    return (Type) getChildNoTransform(0);
  }
  /**
   * Replaces the IdDecl child.
   * @param node The new node to replace the IdDecl child.
   * @apilevel high-level
   */
  public void setIdDecl(IdDecl node) {
    setChild(node, 1);
  }
  /**
   * Retrieves the IdDecl child.
   * @return The current node used as the IdDecl child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="IdDecl")
  public IdDecl getIdDecl() {
    return (IdDecl) getChild(1);
  }
  /**
   * Retrieves the IdDecl child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the IdDecl child.
   * @apilevel low-level
   */
  public IdDecl getIdDeclNoTransform() {
    return (IdDecl) getChildNoTransform(1);
  }
  /**
   * Replaces the optional node for the Expr child. This is the <code>Opt</code>
   * node containing the child Expr, not the actual child!
   * @param opt The new node to be used as the optional node for the Expr child.
   * @apilevel low-level
   */
  public void setExprOpt(Opt<Expr> opt) {
    setChild(opt, 2);
  }
  /**
   * Replaces the (optional) Expr child.
   * @param node The new node to be used as the Expr child.
   * @apilevel high-level
   */
  public void setExpr(Expr node) {
    getExprOpt().setChild(node, 0);
  }
  /**
   * Check whether the optional Expr child exists.
   * @return {@code true} if the optional Expr child exists, {@code false} if it does not.
   * @apilevel high-level
   */
  public boolean hasExpr() {
    return getExprOpt().getNumChild() != 0;
  }
  /**
   * Retrieves the (optional) Expr child.
   * @return The Expr child, if it exists. Returns {@code null} otherwise.
   * @apilevel low-level
   */
  public Expr getExpr() {
    return (Expr) getExprOpt().getChild(0);
  }
  /**
   * Retrieves the optional node for the Expr child. This is the <code>Opt</code> node containing the child Expr, not the actual child!
   * @return The optional node for child the Expr child.
   * @apilevel low-level
   */
  @ASTNodeAnnotation.OptChild(name="Expr")
  public Opt<Expr> getExprOpt() {
    return (Opt<Expr>) getChild(2);
  }
  /**
   * Retrieves the optional node for child Expr. This is the <code>Opt</code> node containing the child Expr, not the actual child!
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The optional node for child Expr.
   * @apilevel low-level
   */
  public Opt<Expr> getExprOptNoTransform() {
    return (Opt<Expr>) getChildNoTransform(2);
  }
/** @apilevel internal */
protected boolean typeNotCheck_visited = false;
  /**
   * @attribute syn
   * @aspect TypeCheck
   * @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk6/A2-MinimalAST/src/jastadd/TypeCheck.jrag:34
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="TypeCheck", declaredAt="/Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk6/A2-MinimalAST/src/jastadd/TypeCheck.jrag:34")
  public boolean typeNotCheck() {
    if (typeNotCheck_visited) {
      throw new RuntimeException("Circular definition of attribute VarDecl.typeNotCheck().");
    }
    typeNotCheck_visited = true;
    try {
            if (hasExpr()) {
                return !getExpr().expectedType().isCompatible(getExpr().type());
            } else {
                return false;
            }
        }
    finally {
      typeNotCheck_visited = false;
    }
  }
  /**
   * @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk6/A2-MinimalAST/src/jastadd/Interpreter.jrag:207
   * @apilevel internal
   */
  public String Define_uniqueName(ASTNode _callerNode, ASTNode _childNode) {
    if (_callerNode == getIdDeclNoTransform()) {
      // @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk6/A2-MinimalAST/src/jastadd/Interpreter.jrag:213
      return index() + getIdDecl().getID();
    }
    else {
      return getParent().Define_uniqueName(this, _callerNode);
    }
  }
  /**
   * @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk6/A2-MinimalAST/src/jastadd/Interpreter.jrag:207
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute uniqueName
   */
  protected boolean canDefine_uniqueName(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk6/A2-MinimalAST/src/jastadd/TypeCheck.jrag:19
   * @apilevel internal
   */
  public Type Define_type(ASTNode _callerNode, ASTNode _childNode) {
    if (_callerNode == getIdDeclNoTransform()) {
      // @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk6/A2-MinimalAST/src/jastadd/TypeCheck.jrag:20
      return getType();
    }
    else {
      return getParent().Define_type(this, _callerNode);
    }
  }
  /**
   * @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk6/A2-MinimalAST/src/jastadd/TypeCheck.jrag:19
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute type
   */
  protected boolean canDefine_type(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk6/A2-MinimalAST/src/jastadd/TypeCheck.jrag:25
   * @apilevel internal
   */
  public Type Define_expectedType(ASTNode _callerNode, ASTNode _childNode) {
    if (_callerNode == getExprOptNoTransform()) {
      // @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk6/A2-MinimalAST/src/jastadd/TypeCheck.jrag:29
      return getIdDecl().type();
    }
    else {
      return getParent().Define_expectedType(this, _callerNode);
    }
  }
  /**
   * @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk6/A2-MinimalAST/src/jastadd/TypeCheck.jrag:25
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute expectedType
   */
  protected boolean canDefine_expectedType(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
}
