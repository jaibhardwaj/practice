package com.practice.jai.ds;

public class DoubleEndedNode
{
    private int data;
    private DoubleEndedNode nextNode;
    private DoubleEndedNode previousNode;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public DoubleEndedNode getNextNode() {
        return nextNode;
    }

    public void setNextNode(DoubleEndedNode nextNode) {
        this.nextNode = nextNode;
    }

    public DoubleEndedNode getPreviousNode() {
        return previousNode;
    }

    public void setPreviousNode(DoubleEndedNode previousNode) {
        this.previousNode = previousNode;
    }
}
