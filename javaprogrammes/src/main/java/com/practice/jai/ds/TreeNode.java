package com.practice.jai.ds;

public class TreeNode
{
    private Integer data;
    private TreeNode leftNode;
    private TreeNode rightNode;

    public void setData(Integer data) {
        this.data = data;
    }

    public TreeNode(Integer data)

    {
        this.data = data;
    }

    public Integer getData()
    {
        return data;
    }

    public TreeNode getLeftNode()
    {
        return leftNode;
    }

    public void setLeftNode(TreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public TreeNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(TreeNode rightNode) {
        this.rightNode = rightNode;
    }


    public void insertNode(Integer value)
    {
        if(data == value)
        {
            return;
        }

        if(value < data)
        {
            if(leftNode == null)
            {
                leftNode = new TreeNode(value);
            }
            else
            {
                leftNode.insertNode(value);
            }
        }
        if(value > data)
        {
            if (rightNode == null)
            {
                rightNode = new TreeNode(value);
            }
            else
            {
                rightNode.insertNode(value);
            }
        }

    }

    public void traverseInOrder()
    {
        if(leftNode != null)
        {
            leftNode.traverseInOrder();
        }

        System.out.print(data + ", ");
        if(rightNode != null)
        {
            rightNode.traverseInOrder();
        }
    }

    public void traversePreOrder()
    {
        System.out.print(data + ", ");

        if(leftNode != null)
        {
            leftNode.traversePreOrder();
        }

        if(rightNode != null)
        {
            rightNode.traversePreOrder();
        }
    }


    public void traversePostOrder()
    {
        if(leftNode != null)
        {
            leftNode.traversePostOrder();
        }

        if(rightNode != null)
        {
            rightNode.traversePostOrder();
        }
        System.out.print(data + ", ");
    }

    public TreeNode findNode(int value)
    {
        if(data == value)
        {
            return this;
        }

        if(value < data)
        {
            if(leftNode != null)
            {
                return leftNode.findNode(value);
            }
        }
        else
        {
            if (rightNode != null)
            {
                return rightNode.findNode(value);
            }
        }

        return null;
    }

    public int min()
    {
        if(leftNode!=null)
        {
            data = leftNode.min();
        }
       return data;
    }

    public int max()
    {

        if(rightNode != null)
        {
            data = rightNode.max();
        }
        return data;
    }

    @Override
    public String toString() {
        return "Data:- "+ data;
    }
}
