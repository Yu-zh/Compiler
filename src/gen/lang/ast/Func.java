/* This file was generated with JastAdd2 (http://jastadd.org) version 2.2.3 */
package lang.ast;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;
import java.util.TreeSet;
/**
 * @ast node
 * @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk4/A2-MinimalAST/src/jastadd/lang.ast:3
 * @astdecl Func : ASTNode ::= Type IdDecl Para* Stmt*;
 * @production Func : {@link ASTNode} ::= <span class="component">{@link Type}</span> <span class="component">{@link IdDecl}</span> <span class="component">{@link Para}*</span> <span class="component">{@link Stmt}*</span>;

 */
public class Func extends ASTNode<ASTNode> implements Cloneable {
  /**
   * @aspect PrettyPrint
   * @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk4/A2-MinimalAST/src/jastadd/PrettyPrint.jrag:15
   */
  public void prettyPrint(PrintStream out, String ind) {
        out.print("int ");
        getIdDecl().prettyPrint(out, ind);
        out.print("(");
        for (int i = 0; i < getNumPara(); ++i) {
            out.print("int ");
            getPara(i).prettyPrint(out, ind);
            if (i+1 < getNumPara()) {
                out.print(", ");
            }
        }
        out.print(")");
        out.print(" {");
        out.println();
        for (int i = 0; i < getNumStmt(); ++i) {
            out.print(ind+" ");
            getStmt(i).prettyPrint(out, ind+"   ");
            if (!(getStmt(i) instanceof IfStmt) && !(getStmt(i) instanceof WhileStmt)) {
                out.print(";");
            }
            out.println();
        }
        out.print("}");
        out.println();
    }
  /**
   * @aspect Visitor
   * @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk4/A2-MinimalAST/src/jastadd/Visitor.jrag:52
   */
  public Object accept(Visitor visitor, Object data) {
		return visitor.visit(this, data);
	}
  /**
   * @declaredat ASTNode:1
   */
  public Func() {
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
    children = new ASTNode[4];
    setChild(new List(), 2);
    setChild(new List(), 3);
  }
  /**
   * @declaredat ASTNode:15
   */
  @ASTNodeAnnotation.Constructor(
    name = {"Type", "IdDecl", "Para", "Stmt"},
    type = {"Type", "IdDecl", "List<Para>", "List<Stmt>"},
    kind = {"Child", "Child", "List", "List"}
  )
  public Func(Type p0, IdDecl p1, List<Para> p2, List<Stmt> p3) {
    setChild(p0, 0);
    setChild(p1, 1);
    setChild(p2, 2);
    setChild(p3, 3);
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:27
   */
  protected int numChildren() {
    return 4;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:31
   */
  public void flushAttrCache() {
    super.flushAttrCache();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:35
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:39
   */
  public Func clone() throws CloneNotSupportedException {
    Func node = (Func) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:44
   */
  public Func copy() {
    try {
      Func node = (Func) clone();
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
   * @declaredat ASTNode:63
   */
  @Deprecated
  public Func fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:73
   */
  public Func treeCopyNoTransform() {
    Func tree = (Func) copy();
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
   * @declaredat ASTNode:93
   */
  public Func treeCopy() {
    Func tree = (Func) copy();
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
   * @declaredat ASTNode:107
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
   * Replaces the Para list.
   * @param list The new list node to be used as the Para list.
   * @apilevel high-level
   */
  public void setParaList(List<Para> list) {
    setChild(list, 2);
  }
  /**
   * Retrieves the number of children in the Para list.
   * @return Number of children in the Para list.
   * @apilevel high-level
   */
  public int getNumPara() {
    return getParaList().getNumChild();
  }
  /**
   * Retrieves the number of children in the Para list.
   * Calling this method will not trigger rewrites.
   * @return Number of children in the Para list.
   * @apilevel low-level
   */
  public int getNumParaNoTransform() {
    return getParaListNoTransform().getNumChildNoTransform();
  }
  /**
   * Retrieves the element at index {@code i} in the Para list.
   * @param i Index of the element to return.
   * @return The element at position {@code i} in the Para list.
   * @apilevel high-level
   */
  public Para getPara(int i) {
    return (Para) getParaList().getChild(i);
  }
  /**
   * Check whether the Para list has any children.
   * @return {@code true} if it has at least one child, {@code false} otherwise.
   * @apilevel high-level
   */
  public boolean hasPara() {
    return getParaList().getNumChild() != 0;
  }
  /**
   * Append an element to the Para list.
   * @param node The element to append to the Para list.
   * @apilevel high-level
   */
  public void addPara(Para node) {
    List<Para> list = (parent == null) ? getParaListNoTransform() : getParaList();
    list.addChild(node);
  }
  /** @apilevel low-level 
   */
  public void addParaNoTransform(Para node) {
    List<Para> list = getParaListNoTransform();
    list.addChild(node);
  }
  /**
   * Replaces the Para list element at index {@code i} with the new node {@code node}.
   * @param node The new node to replace the old list element.
   * @param i The list index of the node to be replaced.
   * @apilevel high-level
   */
  public void setPara(Para node, int i) {
    List<Para> list = getParaList();
    list.setChild(node, i);
  }
  /**
   * Retrieves the Para list.
   * @return The node representing the Para list.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.ListChild(name="Para")
  public List<Para> getParaList() {
    List<Para> list = (List<Para>) getChild(2);
    return list;
  }
  /**
   * Retrieves the Para list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Para list.
   * @apilevel low-level
   */
  public List<Para> getParaListNoTransform() {
    return (List<Para>) getChildNoTransform(2);
  }
  /**
   * @return the element at index {@code i} in the Para list without
   * triggering rewrites.
   */
  public Para getParaNoTransform(int i) {
    return (Para) getParaListNoTransform().getChildNoTransform(i);
  }
  /**
   * Retrieves the Para list.
   * @return The node representing the Para list.
   * @apilevel high-level
   */
  public List<Para> getParas() {
    return getParaList();
  }
  /**
   * Retrieves the Para list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Para list.
   * @apilevel low-level
   */
  public List<Para> getParasNoTransform() {
    return getParaListNoTransform();
  }
  /**
   * Replaces the Stmt list.
   * @param list The new list node to be used as the Stmt list.
   * @apilevel high-level
   */
  public void setStmtList(List<Stmt> list) {
    setChild(list, 3);
  }
  /**
   * Retrieves the number of children in the Stmt list.
   * @return Number of children in the Stmt list.
   * @apilevel high-level
   */
  public int getNumStmt() {
    return getStmtList().getNumChild();
  }
  /**
   * Retrieves the number of children in the Stmt list.
   * Calling this method will not trigger rewrites.
   * @return Number of children in the Stmt list.
   * @apilevel low-level
   */
  public int getNumStmtNoTransform() {
    return getStmtListNoTransform().getNumChildNoTransform();
  }
  /**
   * Retrieves the element at index {@code i} in the Stmt list.
   * @param i Index of the element to return.
   * @return The element at position {@code i} in the Stmt list.
   * @apilevel high-level
   */
  public Stmt getStmt(int i) {
    return (Stmt) getStmtList().getChild(i);
  }
  /**
   * Check whether the Stmt list has any children.
   * @return {@code true} if it has at least one child, {@code false} otherwise.
   * @apilevel high-level
   */
  public boolean hasStmt() {
    return getStmtList().getNumChild() != 0;
  }
  /**
   * Append an element to the Stmt list.
   * @param node The element to append to the Stmt list.
   * @apilevel high-level
   */
  public void addStmt(Stmt node) {
    List<Stmt> list = (parent == null) ? getStmtListNoTransform() : getStmtList();
    list.addChild(node);
  }
  /** @apilevel low-level 
   */
  public void addStmtNoTransform(Stmt node) {
    List<Stmt> list = getStmtListNoTransform();
    list.addChild(node);
  }
  /**
   * Replaces the Stmt list element at index {@code i} with the new node {@code node}.
   * @param node The new node to replace the old list element.
   * @param i The list index of the node to be replaced.
   * @apilevel high-level
   */
  public void setStmt(Stmt node, int i) {
    List<Stmt> list = getStmtList();
    list.setChild(node, i);
  }
  /**
   * Retrieves the Stmt list.
   * @return The node representing the Stmt list.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.ListChild(name="Stmt")
  public List<Stmt> getStmtList() {
    List<Stmt> list = (List<Stmt>) getChild(3);
    return list;
  }
  /**
   * Retrieves the Stmt list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Stmt list.
   * @apilevel low-level
   */
  public List<Stmt> getStmtListNoTransform() {
    return (List<Stmt>) getChildNoTransform(3);
  }
  /**
   * @return the element at index {@code i} in the Stmt list without
   * triggering rewrites.
   */
  public Stmt getStmtNoTransform(int i) {
    return (Stmt) getStmtListNoTransform().getChildNoTransform(i);
  }
  /**
   * Retrieves the Stmt list.
   * @return The node representing the Stmt list.
   * @apilevel high-level
   */
  public List<Stmt> getStmts() {
    return getStmtList();
  }
  /**
   * Retrieves the Stmt list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Stmt list.
   * @apilevel low-level
   */
  public List<Stmt> getStmtsNoTransform() {
    return getStmtListNoTransform();
  }
/** @apilevel internal */
protected java.util.Set localLookup_String_int_visited;
  /**
   * @attribute syn
   * @aspect NameAnalysis
   * @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk4/A2-MinimalAST/src/jastadd/NameAnalysis.jrag:12
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="NameAnalysis", declaredAt="/Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk4/A2-MinimalAST/src/jastadd/NameAnalysis.jrag:12")
  public IdDecl localLookup(String name, int until) {
    java.util.List _parameters = new java.util.ArrayList(2);
    _parameters.add(name);
    _parameters.add(until);
    if (localLookup_String_int_visited == null) localLookup_String_int_visited = new java.util.HashSet(4);
    if (localLookup_String_int_visited.contains(_parameters)) {
      throw new RuntimeException("Circular definition of attribute Func.localLookup(String,int).");
    }
    localLookup_String_int_visited.add(_parameters);
    try {
            for (int i = 0; i < getNumPara(); i++) {
                if (getPara(i).getIdDecl().getID().equals(name)) {
                    return getPara(i).getIdDecl();
                }
            }
            for (int i = 0; i <= until; i++) {
                if ((getStmt(i) instanceof VarDecl)) {
                    VarDecl varDecl = (VarDecl) getStmt(i);
                    if (varDecl.getIdDecl().getID().equals(name)) {
                        return varDecl.getIdDecl();
                    }
                }
            }
            return unknownDecl();
        }
    finally {
      localLookup_String_int_visited.remove(_parameters);
    }
  }
  /**
   * @attribute inh
   * @aspect NameAnalysis
   * @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk4/A2-MinimalAST/src/jastadd/NameAnalysis.jrag:11
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="NameAnalysis", declaredAt="/Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk4/A2-MinimalAST/src/jastadd/NameAnalysis.jrag:11")
  public IdDecl lookup(String name) {
    Object _parameters = name;
    if (lookup_String_visited == null) lookup_String_visited = new java.util.HashSet(4);
    if (lookup_String_visited.contains(_parameters)) {
      throw new RuntimeException("Circular definition of attribute Func.lookup(String).");
    }
    lookup_String_visited.add(_parameters);
    IdDecl lookup_String_value = getParent().Define_lookup(this, null, name);
    lookup_String_visited.remove(_parameters);
    return lookup_String_value;
  }
/** @apilevel internal */
protected java.util.Set lookup_String_visited;
  /**
   * @attribute inh
   * @aspect NameAnalysis
   * @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk4/A2-MinimalAST/src/jastadd/NameAnalysis.jrag:110
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="NameAnalysis", declaredAt="/Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk4/A2-MinimalAST/src/jastadd/NameAnalysis.jrag:110")
  public IdDecl lookupFunc(String name) {
    Object _parameters = name;
    if (lookupFunc_String_visited == null) lookupFunc_String_visited = new java.util.HashSet(4);
    if (lookupFunc_String_visited.contains(_parameters)) {
      throw new RuntimeException("Circular definition of attribute Func.lookupFunc(String).");
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
    if (_callerNode == getParaListNoTransform()) {
      // @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk4/A2-MinimalAST/src/jastadd/NameAnalysis.jrag:112
      int index = _callerNode.getIndexOfChild(_childNode);
      {
              for (int i = 0; i < index; i++) {
                  if (getPara(i).getIdDecl().getID().equals(name)) {
                      return getPara(i).getIdDecl();
                  }
              }
              return getPara(index).getIdDecl();
          }
    }
    else if (_callerNode == getIdDeclNoTransform()) {
      // @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk4/A2-MinimalAST/src/jastadd/NameAnalysis.jrag:109
      return lookupFunc(name);
    }
    else if (_callerNode == getStmtListNoTransform()) {
      // @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk4/A2-MinimalAST/src/jastadd/NameAnalysis.jrag:7
      int index = _callerNode.getIndexOfChild(_childNode);
      {
              IdDecl decl = localLookup(name, index);
              return !decl.isUnknown() ? decl : lookup(name);
          }
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
   * @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk4/A2-MinimalAST/src/jastadd/ParaNum.jrag:2
   * @apilevel internal
   */
  public int Define_function(ASTNode _callerNode, ASTNode _childNode) {
    if (_callerNode == getIdDeclNoTransform()) {
      // @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk4/A2-MinimalAST/src/jastadd/ParaNum.jrag:4
      return getNumPara();
    }
    else {
      return getParent().Define_function(this, _callerNode);
    }
  }
  /**
   * @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk4/A2-MinimalAST/src/jastadd/ParaNum.jrag:2
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute function
   */
  protected boolean canDefine_function(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk4/A2-MinimalAST/src/jastadd/TypeCheck.jrag:19
   * @apilevel internal
   */
  public Type Define_type(ASTNode _callerNode, ASTNode _childNode) {
    if (_callerNode == getIdDeclNoTransform()) {
      // @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk4/A2-MinimalAST/src/jastadd/TypeCheck.jrag:21
      return getType();
    }
    else {
      return getParent().Define_type(this, _callerNode);
    }
  }
  /**
   * @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk4/A2-MinimalAST/src/jastadd/TypeCheck.jrag:19
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute type
   */
  protected boolean canDefine_type(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
}
