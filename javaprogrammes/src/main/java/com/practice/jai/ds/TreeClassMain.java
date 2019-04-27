package com.practice.jai.ds;

public class TreeClassMain
{
    public static void main(String[] args)
    {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insertNode(25);
        binarySearchTree.insertNode(20);
        binarySearchTree.insertNode(15);
        binarySearchTree.insertNode(27);
        binarySearchTree.insertNode(30);
        binarySearchTree.insertNode(29);
        binarySearchTree.insertNode(26);
        binarySearchTree.insertNode(22);
        binarySearchTree.insertNode(32);
        binarySearchTree.insertNode(17);

        //System.out.println(binarySearchTree.findNode(30));
        binarySearchTree.traverseInOrder();
        //binarySearchTree.traversePreOrder();
        //binarySearchTree.traversePostOrder();

        ///binarySearchTree.delete(17);
        //System.out.println("");
        //binarySearchTree.traverseInOrder();
        /*System.out.println("");
        System.out.println("Min Element:- "+binarySearchTree.min());
        System.out.println("Max Element:- "+binarySearchTree.max());*/

    }
}
