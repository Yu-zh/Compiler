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
 * @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk6/A2-MinimalAST/src/jastadd/lang.ast:39
 * @astdecl IdDecl : ASTNode ::= <ID:String>;
 * @production IdDecl : {@link ASTNode} ::= <span class="component">&lt;ID:String&gt;</span>;

 */
public class IdDecl extends ASTNode<ASTNode> implements Cloneable {
  /**
   * @aspect PrettyPrint
   * @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk6/A2-MinimalAST/src/jastadd/PrettyPrint.jrag:210
   */
  public void prettyPrint(PrintStream out, String ind) {
		out.print(getID());
	}
  /**
   * @aspect Visitor
   * @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk6/A2-MinimalAST/src/jastadd/Visitor.jrag:46
   */
  public Object accept(Visitor visitor, Object data) {
		return visitor.visit(this, data);
	}
  /**
   * @declaredat ASTNode:1
   */
  public IdDecl() {
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
  }
  /**
   * @declaredat ASTNode:12
   */
  @ASTNodeAnnotation.Constructor(
    name = {"ID"},
    type = {"String"},
    kind = {"Token"}
  )
  public IdDecl(String p0) {
    setID(p0);
  }
  /**
   * @declaredat ASTNode:20
   */
  public IdDecl(beaver.Symbol p0) {
    setID(p0);
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:24
   */
  protected int numChildren() {
    return 0;
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
  public IdDecl clone() throws CloneNotSupportedException {
    IdDecl node = (IdDecl) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:41
   */
  public IdDecl copy() {
    try {
      IdDecl node = (IdDecl) clone();
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
  public IdDecl fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:70
   */
  public IdDecl treeCopyNoTransform() {
    IdDecl tree = (IdDecl) copy();
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
  public IdDecl treeCopy() {
    IdDecl tree = (IdDecl) copy();
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
    return super.is$Equal(node) && (tokenString_ID == ((IdDecl) node).tokenString_ID);    
  }
  /**
   * Replaces the lexeme ID.
   * @param value The new value for the lexeme ID.
   * @apilevel high-level
   */
  public void setID(String value) {
    tokenString_ID = value;
  }
  /** @apilevel internal 
   */
  protected String tokenString_ID;
  /**
   */
  public int IDstart;
  /**
   */
  public int IDend;
  /**
   * JastAdd-internal setter for lexeme ID using the Beaver parser.
   * @param symbol Symbol containing the new value for the lexeme ID
   * @apilevel internal
   */
  public void setID(beaver.Symbol symbol) {
    if (symbol.value != null && !(symbol.value instanceof String))
    throw new UnsupportedOperationException("setID is only valid for String lexemes");
    tokenString_ID = (String)symbol.value;
    IDstart = symbol.getStart();
    IDend = symbol.getEnd();
  }
  /**
   * Retrieves the value for the lexeme ID.
   * @return The value for the lexeme ID.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Token(name="ID")
  public String getID() {
    return tokenString_ID != null ? tokenString_ID : "";
  }
/** @apilevel internal */
protected boolean addr_visited = false;
  /**
   * @attribute syn
   * @aspect CodeGen
   * @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk6/A2-MinimalAST/src/jastadd/CodeGen.jrag:322
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="CodeGen", declaredAt="/Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk6/A2-MinimalAST/src/jastadd/CodeGen.jrag:322")
  public String addr() {
    if (addr_visited) {
      throw new RuntimeException("Circular definition of attribute IdDecl.addr().");
    }
    addr_visited = true;
    try {
    	    if (isPara()) {
    	        return Integer.toString(8*(paraIndex()+2)) + "(%rbp)";
    	    }
    	    return "-" + Integer.toString(8*(localIndex()-funIndex()-numPara())) + "(%rbp)";
    	}
    finally {
      addr_visited = false;
    }
  }
/** @apilevel internal */
protected boolean localIndex_visited = false;
  /**
   * @attribute syn
   * @aspect CodeGen
   * @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk6/A2-MinimalAST/src/jastadd/CodeGen.jrag:331
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="CodeGen", declaredAt="/Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk6/A2-MinimalAST/src/jastadd/CodeGen.jrag:331")
  public int localIndex() {
    if (localIndex_visited) {
      throw new RuntimeException("Circular definition of attribute ASTNode.localIndex().");
    }
    localIndex_visited = true;
    int localIndex_value = prevNode().localIndex() + 1;
    localIndex_visited = false;
    return localIndex_value;
  }
/** @apilevel internal */
protected boolean isMultiDeclared_visited = false;
  /**
   * @attribute syn
   * @aspect NameAnalysis
   * @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk6/A2-MinimalAST/src/jastadd/NameAnalysis.jrag:103
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="NameAnalysis", declaredAt="/Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk6/A2-MinimalAST/src/jastadd/NameAnalysis.jrag:103")
  public boolean isMultiDeclared() {
    if (isMultiDeclared_visited) {
      throw new RuntimeException("Circular definition of attribute IdDecl.isMultiDeclared().");
    }
    isMultiDeclared_visited = true;
    try {
    //        System.out.println(this.type());
    //        System.out.println(this.getID());
            return lookup(getID()) != this;
        }
    finally {
      isMultiDeclared_visited = false;
    }
  }
/** @apilevel internal */
protected boolean isUnknown_visited = false;
  /**
   * @attribute syn
   * @aspect UnknownDecl
   * @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk6/A2-MinimalAST/src/jastadd/UnknownDecl.jrag:7
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="UnknownDecl", declaredAt="/Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk6/A2-MinimalAST/src/jastadd/UnknownDecl.jrag:7")
  public boolean isUnknown() {
    if (isUnknown_visited) {
      throw new RuntimeException("Circular definition of attribute IdDecl.isUnknown().");
    }
    isUnknown_visited = true;
    boolean isUnknown_value = false;
    isUnknown_visited = false;
    return isUnknown_value;
  }
  /**
   * @attribute inh
   * @aspect CodeGen
   * @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk6/A2-MinimalAST/src/jastadd/CodeGen.jrag:310
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="CodeGen", declaredAt="/Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk6/A2-MinimalAST/src/jastadd/CodeGen.jrag:310")
  public int paraIndex() {
    if (paraIndex_visited) {
      throw new RuntimeException("Circular definition of attribute IdDecl.paraIndex().");
    }
    paraIndex_visited = true;
    int paraIndex_value = getParent().Define_paraIndex(this, null);
    paraIndex_visited = false;
    return paraIndex_value;
  }
/** @apilevel internal */
protected boolean paraIndex_visited = false;
  /**
   * @attribute inh
   * @aspect CodeGen
   * @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk6/A2-MinimalAST/src/jastadd/CodeGen.jrag:312
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="CodeGen", declaredAt="/Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk6/A2-MinimalAST/src/jastadd/CodeGen.jrag:312")
  public boolean isPara() {
    if (isPara_visited) {
      throw new RuntimeException("Circular definition of attribute IdDecl.isPara().");
    }
    isPara_visited = true;
    boolean isPara_value = getParent().Define_isPara(this, null);
    isPara_visited = false;
    return isPara_value;
  }
/** @apilevel internal */
protected boolean isPara_visited = false;
  /**
   * @attribute inh
   * @aspect CodeGen
   * @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk6/A2-MinimalAST/src/jastadd/CodeGen.jrag:317
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="CodeGen", declaredAt="/Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk6/A2-MinimalAST/src/jastadd/CodeGen.jrag:317")
  public int funIndex() {
    if (funIndex_visited) {
      throw new RuntimeException("Circular definition of attribute IdDecl.funIndex().");
    }
    funIndex_visited = true;
    int funIndex_value = getParent().Define_funIndex(this, null);
    funIndex_visited = false;
    return funIndex_value;
  }
/** @apilevel internal */
protected boolean funIndex_visited = false;
  /**
   * @attribute inh
   * @aspect CodeGen
   * @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk6/A2-MinimalAST/src/jastadd/CodeGen.jrag:318
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="CodeGen", declaredAt="/Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk6/A2-MinimalAST/src/jastadd/CodeGen.jrag:318")
  public int numPara() {
    if (numPara_visited) {
      throw new RuntimeException("Circular definition of attribute IdDecl.numPara().");
    }
    numPara_visited = true;
    int numPara_value = getParent().Define_numPara(this, null);
    numPara_visited = false;
    return numPara_value;
  }
/** @apilevel internal */
protected boolean numPara_visited = false;
  /**
   * @attribute inh
   * @aspect Interpreter
   * @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk6/A2-MinimalAST/src/jastadd/Interpreter.jrag:207
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="Interpreter", declaredAt="/Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk6/A2-MinimalAST/src/jastadd/Interpreter.jrag:207")
  public String uniqueName() {
    if (uniqueName_visited) {
      throw new RuntimeException("Circular definition of attribute IdDecl.uniqueName().");
    }
    uniqueName_visited = true;
    String uniqueName_value = getParent().Define_uniqueName(this, null);
    uniqueName_visited = false;
    return uniqueName_value;
  }
/** @apilevel internal */
protected boolean uniqueName_visited = false;
  /**
   * @attribute inh
   * @aspect NameAnalysis
   * @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk6/A2-MinimalAST/src/jastadd/NameAnalysis.jrag:101
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="NameAnalysis", declaredAt="/Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk6/A2-MinimalAST/src/jastadd/NameAnalysis.jrag:101")
  public IdDecl lookup(String name) {
    Object _parameters = name;
    if (lookup_String_visited == null) lookup_String_visited = new java.util.HashSet(4);
    if (lookup_String_visited.contains(_parameters)) {
      throw new RuntimeException("Circular definition of attribute IdDecl.lookup(String).");
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
   * @aspect ParaNum
   * @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk6/A2-MinimalAST/src/jastadd/ParaNum.jrag:2
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="ParaNum", declaredAt="/Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk6/A2-MinimalAST/src/jastadd/ParaNum.jrag:2")
  public int function() {
    if (function_visited) {
      throw new RuntimeException("Circular definition of attribute IdDecl.function().");
    }
    function_visited = true;
    int function_value = getParent().Define_function(this, null);
    function_visited = false;
    return function_value;
  }
/** @apilevel internal */
protected boolean function_visited = false;
  /**
   * @attribute inh
   * @aspect TypeCheck
   * @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk6/A2-MinimalAST/src/jastadd/TypeCheck.jrag:19
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="TypeCheck", declaredAt="/Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk6/A2-MinimalAST/src/jastadd/TypeCheck.jrag:19")
  public Type type() {
    if (type_visited) {
      throw new RuntimeException("Circular definition of attribute IdDecl.type().");
    }
    type_visited = true;
    Type type_value = getParent().Define_type(this, null);
    type_visited = false;
    return type_value;
  }
/** @apilevel internal */
protected boolean type_visited = false;
  /** @apilevel internal */
  protected void collect_contributors_Program_errors(Program _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
    // @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk6/A2-MinimalAST/src/jastadd/Errors.jrag:38
    if (isMultiDeclared()) {
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
    if (isMultiDeclared()) {
      collection.add(error("symbol '" + getID() + "' is already declared!"));
    }
  }
}
