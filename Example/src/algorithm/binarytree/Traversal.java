package algorithm.binarytree;

import bean.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author CHT
 */
public class Traversal {
    private static ArrayList<Integer> list = new ArrayList<>();
    /**
     * ǰ�����
     */
    public static void preorderTraverse(TreeNode treeNode){
        if (treeNode==null){
            return;
        }
        System.out.print(treeNode.val+" ");
        preorderTraverse(treeNode.left);
        preorderTraverse(treeNode.right);
    }
    /**
     * �������
     */
    public static void inorderTraverse(TreeNode treeNode){
        if (treeNode==null){
            return;
        }
        inorderTraverse(treeNode.left);
        System.out.print(treeNode.val+" ");
        inorderTraverse(treeNode.right);
    }
    /**
     * �������
     */
    public static void aftorderTraverse(TreeNode treeNode){
        if (treeNode==null){
            return;
        }
        aftorderTraverse(treeNode.left);
        aftorderTraverse(treeNode.right);
        System.out.print(treeNode.val+" ");
    }
    /**
     * ���������û��ͳ�Ʋ���
     */
    public static void levelTraversal(TreeNode treeNode){
        LinkedList<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.offerLast(treeNode);
        while (treeNodes.size()!=0){
            if (treeNodes.peekFirst().left!=null){
                treeNodes.offerLast(treeNodes.peekFirst().left);
            }
            if (treeNodes.peekFirst().right!=null){
                treeNodes.offerLast(treeNodes.peekFirst().right);
            }
            System.out.print(treeNodes.pollFirst().val+" ");
        }
    }
    /**
     * ���������ͳ�Ʋ���
     */
    public static void levelTraversa2(TreeNode treeNode){
        LinkedList<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.offerLast(treeNode);
        int layerNum = 1;
        //�ж���û�б�����
        while (treeNodes.size()!=0){
            System.out.print(layerNum++ +":");
            int size = treeNodes.size();
            //ÿ����б���
            while (size--!=0){
                if (treeNodes.peekFirst().left!=null){
                    treeNodes.offerLast(treeNodes.peekFirst().left);
                }
                if (treeNodes.peekFirst().right!=null){
                    treeNodes.offerLast(treeNodes.peekFirst().right);
                }
                System.out.print(treeNodes.pollFirst().val+" ");
            }
            System.out.println();
        }
    }
}
