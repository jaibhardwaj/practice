package com.practice.jai.ds;

public class BinarySearchTree
{
    private TreeNode root;

    public void insertNode(Integer data)
    {
        if(root == null)
        {
            root = new TreeNode(data);
        }
        else
        {
            root.insertNode(data);
        }
    }

    public TreeNode findNode(int data)
    {
        if(root == null)
        {
            return null;
        }
        else
        {
            return root.findNode(data);
        }
    }

    public void traverseInOrder()
    {
        if(root != null)
        {
            root.traverseInOrder();
        }
    }

    public void traversePreOrder()
    {
        if(root != null)
        {
            root.traversePreOrder();
        }
    }

    public void traversePostOrder()
    {
        if(root != null)
        {
            root.traversePostOrder();
        }
    }

    public int min()
    {
        if(root != null)
        {
            return root.min();
        }

        return Integer.MIN_VALUE;
    }

    public int max()
    {
        if(root != null)
        {
            return root.max();
        }

        return Integer.MAX_VALUE;
    }

    public void delete(int data)
    {
        if(root != null)
        {
            root = delete(root, data);
        }
    }

    public TreeNode delete(TreeNode subTreeRoot, int value)
    {
        if(subTreeRoot == null)
        {
            return null;
        }

        if(value < subTreeRoot.getData())
        {
            subTreeRoot.setLeftNode( delete(subTreeRoot.getLeftNode(), value) );

        } else if(value > subTreeRoot.getData())
        {
            subTreeRoot.setRightNode( delete(subTreeRoot.getRightNode(), value) );
        }
        else
        {
            // Cases 1 and 2: node to delete has 0 or 1 child(ren)
            if(subTreeRoot.getLeftNode() == null)
            {
                return subTreeRoot.getRightNode();
            }
            if(subTreeRoot.getRightNode() == null)
            {
                return subTreeRoot.getLeftNode();
            }

            // Case 3: node to delete has 2 children

            // Replace the value in the subtreeRoot node with the smallest value
            // from the right subtree
            subTreeRoot.setData(subTreeRoot.getRightNode().min());

            // Delete the node that has the smallest value in the right subtree
            subTreeRoot.setRightNode(delete(subTreeRoot.getRightNode(), subTreeRoot.getData()));
        }

        return subTreeRoot;
    }
}
