import java.util.HashMap;
import java.util.Map;

public class Traversal {
  public static void main(String[] args) {
    TreeNode<Integer> root = new TreeNode<Integer>( 10, null, null);
    root.left = new TreeNode<Integer>(9, null, null);
    root.left.left = new TreeNode<Integer>( 5, null, null);
    root.left.right = new TreeNode<Integer>( 2, null, null);

    root.right = new TreeNode<Integer>(15, null, null);
    root.right.left = new TreeNode<Integer>( -3, null,null);
    root.right.right = new TreeNode<Integer>( 5, null,null);
    root.right.right.right = new TreeNode<Integer>(22, null, null);

    TreeNode<String> stringRoot = new TreeNode<String>("hello", null, null);
    stringRoot.left = new TreeNode<String>("how", null, null);
    stringRoot.left.left = new TreeNode<String>( "hello ", null, null);
    stringRoot.left.right = new TreeNode<String>( "you", null, null);

    stringRoot.right = new TreeNode<String>("great", null, null);
    stringRoot.right.left = new TreeNode<String>( "awesome", null,null);
    stringRoot.right.right = new TreeNode<String>( "how", null,null);
    stringRoot.right.right.right = new TreeNode<String>("cool", null, null);

    //preorder(root);
    //postorder(root);
    //inorder(root);
    //inorder(stringRoot);
    //printGreater(root, 100);

    //System.out.println(countNodes(root));
    System.out.println(toMap(stringRoot));
  }

  public static <T> Map<T, Integer> toMap(TreeNode<T> node){
    Map<T, Integer> counts = new HashMap<>();
    toMap(node, counts);
    return counts;
  }

  private static <T> void toMap(TreeNode<T> node, Map<T, Integer> counts){
    if(node ==  null){
      return;
    }
    counts.put(node.value, counts.getOrDefault(node.value, 0) + 1);
    toMap(node.left, counts);
    toMap(node.right, counts);
  }

  public static int  countNodes(TreeNode<?> node){
    return node == null ? 0 : 1 + countNodes(node.left) + countNodes(node.right);
    //if(node == null) return 0;
    //return countNodes(node.left) + countNodes(node.right) + 1;
    // int leftCount = countNodes(node.left);
    // int rightCount = countNodes(node.right);
    // int overallCount = leftCount + rightCount + 1;
    // return overallCount;
  }

  public static void printGreater(TreeNode<Integer> node, int threshold){
    if(node == null) return;
    if(node.value > threshold){
      System.out.println(node.value);
    }
    printGreater(node.left, threshold);
    printGreater(node.right, threshold);
  }

  //print tree rooted at the given node in preorder
  public static void preorder(TreeNode<?> node) {
    if(node == null){
      return;
    }
    System.out.println(node.value);
    preorder(node.left);
    preorder(node.right);

  }

  public static <T> void postorder(TreeNode<T> node){
    if(node == null){
      return;
    }

    postorder(node.left);
    postorder(node.right);

    System.out.println(node.value);
    }

  public static <E> void inorder(TreeNode<E> node) {
    if(node == null){
      return;
    }

    inorder(node.left);
    System.out.println(node.value);
    inorder(node.right);

  }




}
