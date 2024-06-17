package com.keyin;

public class Main {
    public static void main(String[] args) {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.insertDLL(1, 0);
        doubleLinkedList.insertDLL(2, 1);
        doubleLinkedList.insertDLL(3, 2);

        // Implications of required methods
        doubleLinkedList.traverseDLL();
        doubleLinkedList.reverseTraverseDLL();
        doubleLinkedList.searchNode(2);
        doubleLinkedList.searchNode(3);
        doubleLinkedList.searchNode(4);
        doubleLinkedList.deleteNode(2);
        doubleLinkedList.traverseDLL();
        doubleLinkedList.deleteDLL();
        doubleLinkedList.traverseDLL();
    }
}
