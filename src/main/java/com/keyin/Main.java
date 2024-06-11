package com.keyin;

public class Main {
    public static void main(String[] args) {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.insertDLL(1, 0);
        doubleLinkedList.insertDLL(2, 1);
        doubleLinkedList.insertDLL(3, 2);

        doubleLinkedList.traverseDLL();
    }
}
