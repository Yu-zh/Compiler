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
 * @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk6/A2-MinimalAST/src/jastadd/lang.ast:3
 * @astdecl Func : ASTNode ::= Type IdDecl Para* Stmt*;
 * @production Func : {@link ASTNode} ::= <span class="component">{@link Type}</span> <span class="component">{@link IdDecl}</span> <span class="component">{@link Para}*</span> <span class="component">{@link Stmt}*</span>;

 */
public class Func extends ASTNode<ASTNode> implements Cloneable {
  /**
   * @aspect CodeGen
   * @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk6/A2-MinimalAST/src/jastadd/CodeGen.jrag:127
   */
  public void genCode(PrintStream out) {
        out.println("       pushq %rbp");
        out.println("       movq %rsp, %rbp");
        // func body
        out.println("       subq $" + Integer.toString(8*(numLocals()-getNumPara()-1)) + ", %rsp");
        for (Stmt s : getStmtList()) {
            s.genCode(out);
        }
        out.println(getIdDecl().getID() + "return:");
        out.println("       addq $" + Integer.toString(8*(numLocals()-getNumPara()-1)) + ", %rsp");
        out.println("       movq %rbp, %rsp");
        out.println("       popq %rbp");
    }
  /**
   * @aspect Interpreter
   * @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk6/A2-MinimalAST/src/jastadd/Interpreter.jrag:19
   */
  public int eval(ActivationRecord actrec) throws ReturnException{
        for (Stmt s : getStmtList()) {
            s.eval(actrec);
        }
        return 0;
    }
  /**
   * @aspect PrettyPrint
   * @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk6/A2-MinimalAST/src/jastadd/PrettyPrint.jrag:15
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
   * @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk6/A2-MinimalAST/src/jastadd/Visitor.jrag:52
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
    reachable_reset();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:36
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();
    Func_calls_visited = false;
    Func_calls_computed = false;
    
    Func_calls_value = null;
    contributorMap_Func_calls = null;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:45
   */
  public Func clone() throws CloneNotSupportedException {
    Func node = (Func) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:50
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
   * @declaredat ASTNode:69
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
   * @declaredat ASTNode:79
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
   * @declaredat ASTNode:99
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
   * @declaredat ASTNode:113
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
  /**
   * @aspect <NoAspect>
   * @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk6/A2-MinimalAST/src/jastadd/FunctionCall.jrag:5
   */
  /** @apilevel internal */
protected java.util.Map<ASTNode, java.util.Set<ASTNode>> contributorMap_Func_calls = null;

  /** @apilevel internal */
  protected void survey_Func_calls() {
    if (contributorMap_Func_calls == null) {
      contributorMap_Func_calls = new java.util.IdentityHashMap<ASTNode, java.util.Set<ASTNode>>();
      collect_contributors_Func_calls(this, contributorMap_Func_calls);
    }
  }

/** @apilevel internal */
protected java.util.Set localLookup_String_int_visited;
  /**
   * @attribute syn
   * @aspect NameAnalysis
   * @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk6/A2-MinimalAST/src/jastadd/NameAnalysis.jrag:12
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="NameAnalysis", declaredAt="/Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk6/A2-MinimalAST/src/jastadd/NameAnalysis.jrag:12")
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
/** @apilevel internal */
protected ASTState.Cycle reachable_cycle = null;
  /** @apilevel internal */
  private void reachable_reset() {
    reachable_computed = false;
    reachable_initialized = false;
    reachable_value = null;
    reachable_cycle = null;
  }
  /** @apilevel internal */
  protected boolean reachable_computed = false;

  /** @apilevel internal */
  protected HashSet<IdDecl> reachable_value;
  /** @apilevel internal */
  protected boolean reachable_initialized = false;
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isCircular=true)
  @ASTNodeAnnotation.Source(aspect="Reachable", declaredAt="/Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk6/A2-MinimalAST/src/jastadd/Reachable.jrag:5")
  public HashSet<IdDecl> reachable() {
    if (reachable_computed) {
      return reachable_value;
    }
    ASTState state = state();
    if (!reachable_initialized) {
      reachable_initialized = true;
      reachable_value = new HashSet<IdDecl>();
    }
    if (!state.inCircle() || state.calledByLazyAttribute()) {
      state.enterCircle();
      do {
        reachable_cycle = state.nextCycle();
        HashSet<IdDecl> new_reachable_value = reachable_compute();
        if ((new_reachable_value == null && reachable_value != null) || (new_reachable_value != null && !new_reachable_value.equals(reachable_value))) {
          state.setChangeInCycle();
        }
        reachable_value = new_reachable_value;
      } while (state.testAndClearChangeInCycle());
      reachable_computed = true;
      state.startLastCycle();
      HashSet<IdDecl> $tmp = reachable_compute();

      state.leaveCircle();
    } else if (reachable_cycle != state.cycle()) {
      reachable_cycle = state.cycle();
      if (state.lastCycle()) {
        reachable_computed = true;
        HashSet<IdDecl> new_reachable_value = reachable_compute();
        return new_reachable_value;
      }
      HashSet<IdDecl> new_reachable_value = reachable_compute();
      if ((new_reachable_value == null && reachable_value != null) || (new_reachable_value != null && !new_reachable_value.equals(reachable_value))) {
        state.setChangeInCycle();
      }
      reachable_value = new_reachable_value;
    } else {
    }
    return reachable_value;
  }
  /** @apilevel internal */
  private HashSet<IdDecl> reachable_compute() {
          HashSet<IdDecl> result = new HashSet<IdDecl>();
          for(IdDecl d : calls()) {
              result.add(d);
              for(Func f : getFuncList()) {
                  if(f.getIdDecl().getID().equals(d.getID())) {
                      result.addAll(f.reachable());
                  }
              }
          }
          return result;
      }
  /**
   * @attribute inh
   * @aspect NameAnalysis
   * @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk6/A2-MinimalAST/src/jastadd/NameAnalysis.jrag:11
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="NameAnalysis", declaredAt="/Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk6/A2-MinimalAST/src/jastadd/NameAnalysis.jrag:11")
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
   * @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk6/A2-MinimalAST/src/jastadd/NameAnalysis.jrag:110
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="NameAnalysis", declaredAt="/Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk6/A2-MinimalAST/src/jastadd/NameAnalysis.jrag:110")
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
   * @attribute inh
   * @aspect Reachable
   * @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk6/A2-MinimalAST/src/jastadd/Reachable.jrag:18
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="Reachable", declaredAt="/Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk6/A2-MinimalAST/src/jastadd/Reachable.jrag:18")
  public List<Func> getFuncList() {
    if (getFuncList_visited) {
      throw new RuntimeException("Circular definition of attribute Func.getFuncList().");
    }
    getFuncList_visited = true;
    List<Func> getFuncList_value = getParent().Define_getFuncList(this, null);
    getFuncList_visited = false;
    return getFuncList_value;
  }
/** @apilevel internal */
protected boolean getFuncList_visited = false;
  /**
   * @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk6/A2-MinimalAST/src/jastadd/CodeGen.jrag:150
   * @apilevel internal
   */
  public String Define_funName(ASTNode _callerNode, ASTNode _childNode) {
    if (_callerNode == getStmtListNoTransform()) {
      // @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk6/A2-MinimalAST/src/jastadd/CodeGen.jrag:151
      int childIndex = _callerNode.getIndexOfChild(_childNode);
      return getIdDecl().getID();
    }
    else {
      return getParent().Define_funName(this, _callerNode);
    }
  }
  /**
   * @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk6/A2-MinimalAST/src/jastadd/CodeGen.jrag:150
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute funName
   */
  protected boolean canDefine_funName(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk6/A2-MinimalAST/src/jastadd/CodeGen.jrag:312
   * @apilevel internal
   */
  public boolean Define_isPara(ASTNode _callerNode, ASTNode _childNode) {
    if (_callerNode == getParaListNoTransform()) {
      // @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk6/A2-MinimalAST/src/jastadd/CodeGen.jrag:314
      int childIndex = _callerNode.getIndexOfChild(_childNode);
      return true;
    }
    else if (_callerNode == getStmtListNoTransform()) {
      // @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk6/A2-MinimalAST/src/jastadd/CodeGen.jrag:313
      int childIndex = _callerNode.getIndexOfChild(_childNode);
      return false;
    }
    else {
      return getParent().Define_isPara(this, _callerNode);
    }
  }
  /**
   * @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk6/A2-MinimalAST/src/jastadd/CodeGen.jrag:312
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute isPara
   */
  protected boolean canDefine_isPara(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk6/A2-MinimalAST/src/jastadd/CodeGen.jrag:310
   * @apilevel internal
   */
  public int Define_paraIndex(ASTNode _callerNode, ASTNode _childNode) {
    if (_callerNode == getParaListNoTransform()) {
      // @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk6/A2-MinimalAST/src/jastadd/CodeGen.jrag:315
      int i = _callerNode.getIndexOfChild(_childNode);
      return i;
    }
    else {
      return getParent().Define_paraIndex(this, _callerNode);
    }
  }
  /**
   * @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk6/A2-MinimalAST/src/jastadd/CodeGen.jrag:310
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute paraIndex
   */
  protected boolean canDefine_paraIndex(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk6/A2-MinimalAST/src/jastadd/CodeGen.jrag:317
   * @apilevel internal
   */
  public int Define_funIndex(ASTNode _callerNode, ASTNode _childNode) {
    if (_callerNode == getStmtListNoTransform()) {
      // @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk6/A2-MinimalAST/src/jastadd/CodeGen.jrag:319
      int childIndex = _callerNode.getIndexOfChild(_childNode);
      return localIndex();
    }
    else {
      return getParent().Define_funIndex(this, _callerNode);
    }
  }
  /**
   * @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk6/A2-MinimalAST/src/jastadd/CodeGen.jrag:317
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute funIndex
   */
  protected boolean canDefine_funIndex(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk6/A2-MinimalAST/src/jastadd/CodeGen.jrag:318
   * @apilevel internal
   */
  public int Define_numPara(ASTNode _callerNode, ASTNode _childNode) {
    if (_callerNode == getStmtListNoTransform()) {
      // @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk6/A2-MinimalAST/src/jastadd/CodeGen.jrag:320
      int childIndex = _callerNode.getIndexOfChild(_childNode);
      return getNumPara();
    }
    else {
      return getParent().Define_numPara(this, _callerNode);
    }
  }
  /**
   * @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk6/A2-MinimalAST/src/jastadd/CodeGen.jrag:318
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute numPara
   */
  protected boolean canDefine_numPara(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk6/A2-MinimalAST/src/jastadd/Interpreter.jrag:208
   * @apilevel internal
   */
  public String Define_index(ASTNode _callerNode, ASTNode _childNode) {
    if (_callerNode == getStmtListNoTransform()) {
      // @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk6/A2-MinimalAST/src/jastadd/Interpreter.jrag:209
      int i = _callerNode.getIndexOfChild(_childNode);
      return getIdDecl().getID() + Integer.toString(i);
    }
    else {
      return getParent().Define_index(this, _callerNode);
    }
  }
  /**
   * @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk6/A2-MinimalAST/src/jastadd/Interpreter.jrag:208
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute index
   */
  protected boolean canDefine_index(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk6/A2-MinimalAST/src/jastadd/NameAnalysis.jrag:101
   * @apilevel internal
   */
  public IdDecl Define_lookup(ASTNode _callerNode, ASTNode _childNode, String name) {
    if (_callerNode == getParaListNoTransform()) {
      // @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk6/A2-MinimalAST/src/jastadd/NameAnalysis.jrag:112
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
      // @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk6/A2-MinimalAST/src/jastadd/NameAnalysis.jrag:109
      return lookupFunc(name);
    }
    else if (_callerNode == getStmtListNoTransform()) {
      // @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk6/A2-MinimalAST/src/jastadd/NameAnalysis.jrag:7
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
   * @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk6/A2-MinimalAST/src/jastadd/NameAnalysis.jrag:101
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute lookup
   */
  protected boolean canDefine_lookup(ASTNode _callerNode, ASTNode _childNode, String name) {
    return true;
  }
  /**
   * @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk6/A2-MinimalAST/src/jastadd/ParaNum.jrag:2
   * @apilevel internal
   */
  public int Define_function(ASTNode _callerNode, ASTNode _childNode) {
    if (_callerNode == getIdDeclNoTransform()) {
      // @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk6/A2-MinimalAST/src/jastadd/ParaNum.jrag:4
      return getNumPara();
    }
    else {
      return getParent().Define_function(this, _callerNode);
    }
  }
  /**
   * @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk6/A2-MinimalAST/src/jastadd/ParaNum.jrag:2
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute function
   */
  protected boolean canDefine_function(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk6/A2-MinimalAST/src/jastadd/TypeCheck.jrag:19
   * @apilevel internal
   */
  public Type Define_type(ASTNode _callerNode, ASTNode _childNode) {
    if (_callerNode == getIdDeclNoTransform()) {
      // @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk6/A2-MinimalAST/src/jastadd/TypeCheck.jrag:21
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
/** @apilevel internal */
protected boolean Func_calls_visited = false;
  /**
   * @attribute coll
   * @aspect FunctionCall
   * @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk6/A2-MinimalAST/src/jastadd/FunctionCall.jrag:5
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.COLL)
  @ASTNodeAnnotation.Source(aspect="FunctionCall", declaredAt="/Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk6/A2-MinimalAST/src/jastadd/FunctionCall.jrag:5")
  public Set<IdDecl> calls() {
    ASTState state = state();
    if (Func_calls_computed) {
      return Func_calls_value;
    }
    if (Func_calls_visited) {
      throw new RuntimeException("Circular definition of attribute Func.calls().");
    }
    Func_calls_visited = true;
    state().enterLazyAttribute();
    Func_calls_value = calls_compute();
    Func_calls_computed = true;
    state().leaveLazyAttribute();
    Func_calls_visited = false;
    return Func_calls_value;
  }
  /** @apilevel internal */
  private Set<IdDecl> calls_compute() {
    ASTNode node = this;
    while (node != null && !(node instanceof Func)) {
      node = node.getParent();
    }
    Func root = (Func) node;
    root.survey_Func_calls();
    Set<IdDecl> _computedValue = new HashSet<IdDecl>();
    if (root.contributorMap_Func_calls.containsKey(this)) {
      for (ASTNode contributor : root.contributorMap_Func_calls.get(this)) {
        contributor.contributeTo_Func_calls(_computedValue);
      }
    }
    return _computedValue;
  }
  /** @apilevel internal */
  protected boolean Func_calls_computed = false;

  /** @apilevel internal */
  protected Set<IdDecl> Func_calls_value;

}
