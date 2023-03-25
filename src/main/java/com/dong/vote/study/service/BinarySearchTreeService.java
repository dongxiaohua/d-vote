package com.dong.vote.study.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 二叉搜索树
 *
 * @author dongxiaohua
 */
@Service
public class BinarySearchTreeService {


  /**
   * 二叉树中序遍历
   *
   * @param root
   * @return
   */
  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<Integer>();
    inorder(root, res);
    return res;
  }

  public void inorder(TreeNode root, List<Integer> res) {
    if (root == null) {
      return;
    }
    inorder(root.left, res);
    res.add(root.val);
    inorder(root.right, res);
  }


  /**
   * 验证二叉搜索树
   * <p>
   * 节点的左子树只包含小于当前节点的数。
   * 节点的右子树只包含大于当前节点的数。
   * 所有左子树和右子树自身必须也是二叉搜索树。
   *
   * @param root
   * @return
   */
  long pre = Long.MIN_VALUE;

  public boolean isValidBST(TreeNode root) {
    if (root == null) {
      return true;
    }
    // 访问左子树
    if (!isValidBST(root.left)) {
      return false;
    }
    // 访问当前节点：如果当前节点小于等于中序遍历的前一个节点，说明不满足BST，返回 false；否则继续遍历。
    if (root.val <= pre) {
      return false;
    }
    pre = root.val;
    // 访问右子树
    return isValidBST(root.right);
  }


  /**
   * 找出二叉搜索树的最近公共祖先
   * <p>
   * 如果两个节点值都小于根节点，说明他们都在根节点的左子树上，我们往左子树上找
   * 如果两个节点值都大于根节点，说明他们都在根节点的右子树上，我们往右子树上找
   * 如果一个节点值大于根节点，一个节点值小于根节点，说明他们他们一个在根节点的左子树上一个在根节点的右子树上，那么根节点就是他们的最近公共祖先节点。
   *
   * @param root
   * @param p
   * @param q
   * @return
   */
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    //如果根节点和p,q的差相乘是正数，说明这两个差值要么都是正数要么都是负数，也就是说
    //他们肯定都位于根节点的同一侧，就继续往下找
    while ((root.val - p.val) * (root.val - q.val) > 0) {
      root = p.val < root.val ? root.left : root.right;
    }
    //如果相乘的结果是负数，说明p和q位于根节点的两侧，如果等于0，说明至少有一个就是根节点
    return root;
  }

  /**
   * 找出二叉树的最近公共祖先
   *
   * @param root
   * @param p
   * @param q
   * @return
   */
  public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
    // 先判断当前节点，为null或者等于当前查找阶段则直接返回当前节点
    if (root == null || root == p || root == q) {
      return root;
    }

    TreeNode left = lowestCommonAncestor2(root.left, p, q);
    TreeNode right = lowestCommonAncestor2(root.right, p, q);

    // 左右子树都有，说明p、q在根节点两边，则最近祖先为根节点
    if (left != null && right != null) {
      return root;
    }

    return left == null ? right : left;
  }


  /**
   * 已知一个搜索二叉树的后续遍历数组postArr，请根据postArr，重建出整棵树，返回头节点
   * [2,4,3,6,8,7,5]
   * <p>
   * 解析：
   * 1. 搜索二叉树：左子节点比头节点小，右子节点比头子节点大
   * 2. 后续遍历：先左，再右，再头
   * <p>
   * 拓展：
   * 1. 前序：头 -> 左 -> 右
   * 2. 后序：左 -> 右 -> 头
   * 3. 中序：左 -> 头 -> 右
   *
   * @param postArr
   * @return
   */
  public static TreeNode getNodeHead(int[] postArr) {
    return posArrNode(postArr, 0, postArr.length - 1);
  }

  /**
   * 1. 最大的头是最后一个元素
   * 2. 剩余数组，比最大头小的为左树部分，大的为右树部分
   * 3. 循环找出所有子树的头节点
   * 递归
   *
   * @param posArr
   * @param L
   * @param R
   * @return
   */
  private static TreeNode posArrNode(int[] posArr, int L, int R) {
    if (L > R) {
      return null;
    }
    TreeNode head = new TreeNode(posArr[R]);
    if (L == R) {
      return head;
    }
    // 定义M为子树头
    int M = L - 1;
    for (int i = L; i < R; i++) {
      if (posArr[i] < posArr[R]) {
        M = i;
      }
    }

    head.left = posArrNode(posArr, L, M);
    head.right = posArrNode(posArr, M + 1, R - 1);
    return head;
  }

  /**
   * 根据前序、中序数组重建二叉树
   * <p>
   * 给定节点数为 n 的二叉树的前序遍历和中序遍历结果，请重建出该二叉树并返回它的头结点。
   * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}
   * <p>
   * 解：
   * 1. 前序数组首元素为头结点
   * 2. 根据1可找出中序数组中头结点的位置index
   * 3. 左子树的前序数组：根据中序数组index位置长度，可判断相同长度的前序数组，但需要排除首节点（1 -- index）
   * 4. 左子树中序数组：中序数组中0 -- index则为中序数组
   * 5. 同理，右子树的前序数组：index+1 -- pre.length
   * 6. 右子树的中序数组：index+1 -- vin.length
   *
   * @param pre 前序数组
   * @param vin 中序数组
   * @return
   */
  public TreeNode reConstructBinaryTree(int[] pre, int[] vin) {

    // 定义跳出递归条件
    if (pre == null || pre.length == 0) {
      return null;
    }

    // 头结点
    TreeNode root = new TreeNode(pre[0]);
    // 确定头结点在中序数组中的位置
    int index = findIndex(pre, vin);

    // root.left = reConstructBinaryTree(左子树前序数组，左子树中序数组);
    root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, index + 1), Arrays.copyOfRange(vin, 0, index));
    // root.right = reConstructBinaryTree(右子树前序数组，右子树中序数组);
    root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, index + 1, pre.length), Arrays.copyOfRange(vin, index + 1, vin.length));

    return root;
  }

  private int findIndex(int[] pre, int[] vin) {
    for (int i = 0; i < vin.length; i++) {
      if (pre[0] == vin[i]) {
        return i;
      }
    }
    return 0;
  }

}
