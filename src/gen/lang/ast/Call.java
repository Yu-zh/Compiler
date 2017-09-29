/* This file was generated with JastAdd2 (http://jastadd.org) version 2.2.3 */
package lang.ast;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;
import java.util.TreeSet;
/**
 * @ast node
 * @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk4/A2-MinimalAST/src/jastadd/lang.ast:33
 * @astdecl Call : Expr ::= Fun:IdUse Expr*;
 * @production Call : {@link Expr} ::= <span class="component">Fun:{@link IdUse}</span> <span class="component">{@link Expr}*</span>;

 */
public class Call extends Expr implements Cloneable {
  /**
   * @aspect PrettyPrint
   * @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk4/A2-MinimalAST/src/jastadd/PrettyPrint.jrag:122
   */
  public void prettyPrint(PrintStream out, String ind) {
        getFun().prettyPrint(out, ind);
        out.print("(");
        if (getNumExpr() > 0) {
            for( int i = 0; i < getNumExpr(); ++i) {
                getExpr(i).prettyPrint(out, ind);
                if (i + 1 < getNumExpr()){
                    out.print(", ");
                }
            }
        }
        out.print(")");
    }
  /**
   * @aspect Visitor
   * @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk4/A2-MinimalAST/src/jastadd/Visitor.jrag:106
   */
  public Object accept(Visitor visitor, Object data) {
    	return visitor.visit(this, data);
    }
  /**
   * @declaredat ASTNode:1
   */
  public Call() {
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
    children = new ASTNode[2];
    setChild(new List(), 1);
  }
  /**
   * @declaredat ASTNode:14
   */
  @ASTNodeAnnotation.Constructor(
    name = {"Fun", "Expr"},
    type = {"IdUse", "List<Expr>"},
    kind = {"Child", "List"}
  )
  public Call(IdUse p0, List<Expr> p1) {
    setChild(p0, 0);
    setChild(p1, 1);
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:24
   */
  protected int numChildren() {
    return 2;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:28
   */
  public void flushAttrCache() {
    super.flushAttrCache();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:32
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:36
   */
  public Call clone() throws CloneNotSupportedException {
    Call node = (Call) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:41
   */
  public Call copy() {
    try {
      Call node = (Call) clone();
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
   * @declaredat ASTNode:60
   */
  @Deprecated
  public Call fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:70
   */
  public Call treeCopyNoTransform() {
    Call tree = (Call) copy();
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
   * @declaredat ASTNode:90
   */
  public Call treeCopy() {
    Call tree = (Call) copy();
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
   * @declaredat ASTNode:104
   */
  protected boolean is$Equal(ASTNode node) {
    return super.is$Equal(node);    
  }
  /**
   * Replaces the Fun child.
   * @param node The new node to replace the Fun child.
   * @apilevel high-level
   */
  public void setFun(IdUse node) {
    setChild(node, 0);
  }
  /**
   * Retrieves the Fun child.
   * @return The current node used as the Fun child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="Fun")
  public IdUse getFun() {
    return (IdUse) getChild(0);
  }
  /**
   * Retrieves the Fun child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the Fun child.
   * @apilevel low-level
   */
  public IdUse getFunNoTransform() {
    return (IdUse) getChildNoTransform(0);
  }
  /**
   * Replaces the Expr list.
   * @param list The new list node to be used as the Expr list.
   * @apilevel high-level
   */
  public void setExprList(List<Expr> list) {
    setChild(list, 1);
  }
  /**
   * Retrieves the number of children in the Expr list.
   * @return Number of children in the Expr list.
   * @apilevel high-level
   */
  public int getNumExpr() {
    return getExprList().getNumChild();
  }
  /**
   * Retrieves the number of children in the Expr list.
   * Calling this method will not trigger rewrites.
   * @return Number of children in the Expr list.
   * @apilevel low-level
   */
  public int getNumExprNoTransform() {
    return getExprListNoTransform().getNumChildNoTransform();
  }
  /**
   * Retrieves the element at index {@code i} in the Expr list.
   * @param i Index of the element to return.
   * @return The element at position {@code i} in the Expr list.
   * @apilevel high-level
   */
  public Expr getExpr(int i) {
    return (Expr) getExprList().getChild(i);
  }
  /**
   * Check whether the Expr list has any children.
   * @return {@code true} if it has at least one child, {@code false} otherwise.
   * @apilevel high-level
   */
  public boolean hasExpr() {
    return getExprList().getNumChild() != 0;
  }
  /**
   * Append an element to the Expr list.
   * @param node The element to append to the Expr list.
   * @apilevel high-level
   */
  public void addExpr(Expr node) {
    List<Expr> list = (parent == null) ? getExprListNoTransform() : getExprList();
    list.addChild(node);
  }
  /** @apilevel low-level 
   */
  public void addExprNoTransform(Expr node) {
    List<Expr> list = getExprListNoTransform();
    list.addChild(node);
  }
  /**
   * Replaces the Expr list element at index {@code i} with the new node {@code node}.
   * @param node The new node to replace the old list element.
   * @param i The list index of the node to be replaced.
   * @apilevel high-level
   */
  public void setExpr(Expr node, int i) {
    List<Expr> list = getExprList();
    list.setChild(node, i);
  }
  /**
   * Retrieves the Expr list.
   * @return The node representing the Expr list.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.ListChild(name="Expr")
  public List<Expr> getExprList() {
    List<Expr> list = (List<Expr>) getChild(1);
    return list;
  }
  /**
   * Retrieves the Expr list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Expr list.
   * @apilevel low-level
   */
  public List<Expr> getExprListNoTransform() {
    return (List<Expr>) getChildNoTransform(1);
  }
  /**
   * @return the element at index {@code i} in the Expr list without
   * triggering rewrites.
   */
  public Expr getExprNoTransform(int i) {
    return (Expr) getExprListNoTransform().getChildNoTransform(i);
  }
  /**
   * Retrieves the Expr list.
   * @return The node representing the Expr list.
   * @apilevel high-level
   */
  public List<Expr> getExprs() {
    return getExprList();
  }
  /**
   * Retrieves the Expr list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Expr list.
   * @apilevel low-level
   */
  public List<Expr> getExprsNoTransform() {
    return getExprListNoTransform();
  }
/** @apilevel internal */
protected boolean type_visited = false;
  /**
   * @attribute syn
   * @aspect TypeCheck
   * @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk4/A2-MinimalAST/src/jastadd/TypeCheck.jrag:5
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="TypeCheck", declaredAt="/Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk4/A2-MinimalAST/src/jastadd/TypeCheck.jrag:5")
  public Type type() {
    if (type_visited) {
      throw new RuntimeException("Circular definition of attribute Expr.type().");
    }
    type_visited = true;
    Type type_value = getFun().decl().type();
    type_visited = false;
    return type_value;
  }
  /**
   * @attribute inh
   * @aspect NameAnalysis
   * @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk4/A2-MinimalAST/src/jastadd/NameAnalysis.jrag:83
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="NameAnalysis", declaredAt="/Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk4/A2-MinimalAST/src/jastadd/NameAnalysis.jrag:83")
  public IdDecl lookupFunc(String name) {
    Object _parameters = name;
    if (lookupFunc_String_visited == null) lookupFunc_String_visited = new java.util.HashSet(4);
    if (lookupFunc_String_visited.contains(_parameters)) {
      throw new RuntimeException("Circular definition of attribute Call.lookupFunc(String).");
    }
    lookupFunc_String_visited.add(_parameters);
    IdDecl lookupFunc_String_value = getParent().Define_lookupFunc(this, null, name);
    lookupFunc_String_visited.remove(_parameters);
    return lookupFunc_String_value;
  }
/** @apilevel internal */
protected java.util.Set lookupFunc_String_visited;
  /**
   * @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk4/A2-MinimalAST/src/jastadd/NameAnalysis.jrag:101
   * @apilevel internal
   */
  public IdDecl Define_lookup(ASTNode _callerNode, ASTNode _childNode, String name) {
    if (_callerNode == getFunNoTransform()) {
      // @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk4/A2-MinimalAST/src/jastadd/NameAnalysis.jrag:82
      return lookupFunc(name);
    }
    else {
      return getParent().Define_lookup(this, _callerNode, name);
    }
  }
  /**
   * @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk4/A2-MinimalAST/src/jastadd/NameAnalysis.jrag:101
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute lookup
   */
  protected boolean canDefine_lookup(ASTNode _callerNode, ASTNode _childNode, String name) {
    return true;
  }
  /**
   * @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk4/A2-MinimalAST/src/jastadd/ParaNum.jrag:6
   * @apilevel internal
   */
  public boolean Define_isNotMatch(ASTNode _callerNode, ASTNode _childNode) {
    if (_callerNode == getFunNoTransform()) {
      // @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk4/A2-MinimalAST/src/jastadd/ParaNum.jrag:7
      {
              if (getFun().decl().isUnknown()) {
                  return false;
              } else {
                  return getNumExpr() != getFun().decl().function();
              }
          }
    }
    else {
      return getParent().Define_isNotMatch(this, _callerNode);
    }
  }
  /**
   * @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk4/A2-MinimalAST/src/jastadd/ParaNum.jrag:6
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute isNotMatch
   */
  protected boolean canDefine_isNotMatch(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /** @apilevel internal */
  protected void collect_contributors_Program_errors(Program _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
    // @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk4/A2-MinimalAST/src/jastadd/Errors.jrag:58
    if (getFun().isNotMatch()) {
      {
        Program target = (Program) (program());
        java.util.Set<ASTNode> contributors = _map.get(target);
        if (contributors == null) {
          contributors = new java.util.LinkedHashSet<ASTNode>();
          _map.put((ASTNode) target, contributors);
        }
        contributors.add(this);
      }
    }
    super.collect_contributors_Program_errors(_root, _map);
  }
  /** @apilevel internal */
  protected void contributeTo_Program_errors(Set<ErrorMessage> collection) {
    super.contributeTo_Program_errors(collection);
    if (getFun().isNotMatch()) {
      collection.add(error("number of para error expected: " + Integer.toString(getFun().decl().function()) + " given: " + Integer.toString(getNumExpr())));
    }
  }
}
