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
 * @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk6/A2-MinimalAST/src/jastadd/lang.ast:4
 * @astdecl Para : ASTNode ::= Type IdDecl;
 * @production Para : {@link ASTNode} ::= <span class="component">{@link Type}</span> <span class="component">{@link IdDecl}</span>;

 */
public class Para extends ASTNode<ASTNode> implements Cloneable {
  /**
   * @aspect PrettyPrint
   * @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk6/A2-MinimalAST/src/jastadd/PrettyPrint.jrag:41
   */
  public void prettyPrint(PrintStream out, String ind) {
        getIdDecl().prettyPrint(out, ind);
    }
  /**
   * @aspect Visitor
   * @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk6/A2-MinimalAST/src/jastadd/Visitor.jrag:55
   */
  public Object accept(Visitor visitor, Object data) {
		return visitor.visit(this, data);
	}
  /**
   * @declaredat ASTNode:1
   */
  public Para() {
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
  }
  /**
   * @declaredat ASTNode:13
   */
  @ASTNodeAnnotation.Constructor(
    name = {"Type", "IdDecl"},
    type = {"Type", "IdDecl"},
    kind = {"Child", "Child"}
  )
  public Para(Type p0, IdDecl p1) {
    setChild(p0, 0);
    setChild(p1, 1);
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:23
   */
  protected int numChildren() {
    return 2;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:27
   */
  public void flushAttrCache() {
    super.flushAttrCache();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:31
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:35
   */
  public Para clone() throws CloneNotSupportedException {
    Para node = (Para) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:40
   */
  public Para copy() {
    try {
      Para node = (Para) clone();
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
   * @declaredat ASTNode:59
   */
  @Deprecated
  public Para fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:69
   */
  public Para treeCopyNoTransform() {
    Para tree = (Para) copy();
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
   * @declaredat ASTNode:89
   */
  public Para treeCopy() {
    Para tree = (Para) copy();
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
   * @declaredat ASTNode:103
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
   * @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk6/A2-MinimalAST/src/jastadd/Interpreter.jrag:207
   * @apilevel internal
   */
  public String Define_uniqueName(ASTNode _callerNode, ASTNode _childNode) {
    if (_callerNode == getIdDeclNoTransform()) {
      // @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk6/A2-MinimalAST/src/jastadd/Interpreter.jrag:214
      return getIdDecl().getID();
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
      // @declaredat /Users/zhangyu/Desktop/Workspace/Compilers@Lund/wk6/A2-MinimalAST/src/jastadd/TypeCheck.jrag:22
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
}
