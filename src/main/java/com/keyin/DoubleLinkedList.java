package com.keyin;

public class DoubleLinkedList {
    DoublyNode head;
    DoublyNode tail;
    int size;

    // Create a DLL
    public DoublyNode createDLL(int nodeValue) {
        head = new DoublyNode();
        DoublyNode newNode = new DoublyNode();
        newNode.value = nodeValue;
        head = newNode;
        tail = newNode;
        size = 1;
        return head;
    }

    // Insert a DLL
    // If DLL doesn't exist, insert at beginning, end, or anywhere
    public void insertDLL(int nodeValue, int location) {
        DoublyNode newNode = new DoublyNode();
        newNode.value = nodeValue;
        if (head == null) {
            createDLL(nodeValue);
            return;
        } else if (location == 0) {
            // location is at 0
            newNode.next = head;
            newNode.prev = null;
            head.prev = tail;
            head = newNode;
        } else if (location >= size) {
            // insert at the end
            newNode.next = null;
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        } else {
            // insert anywhere
            DoublyNode tempNode = head;
            int index = 0;
            while (index < location - 1) {
                tempNode = tempNode.next;
                index++;
            }
            newNode.prev = tempNode;
            newNode.next = tempNode.next;
            tempNode.next = newNode;
            newNode.next.prev = newNode;
        }
        size++;
    }

    // Traverse a DLL
    public void traverseDLL() {
        if (head == null) {
            System.out.println("DLL does not exist");
        } else {
            DoublyNode tempNode = head;
            for (int i = 0; i < size; i++) {
                System.out.print(tempNode.value);
                if (i != size - 1) {
                    System.out.print(" <-> ");
                }
                tempNode = tempNode.next;
            }
        }
        System.out.println("\n");
    }

    // reverse traverse
    public void reverseTraverseDLL() {
        if (head == null) {
            System.out.println("DLL does not exist");
        } else {
            DoublyNode tempNode = tail;
            for (int i = 0; i < size; i++) {
                System.out.print(tempNode.value);
                if (i != size - 1) {
                    System.out.print(" <-> ");
                }
                tempNode = tempNode.prev;
            }
        }
        System.out.println("\n");
    }

    // Search for a node
    public boolean searchNode(int nodeValue) {
        if (head == null) {
            System.out.println("DLL does not exist");
        } else {
            DoublyNode tempNode = head;
            for (int i = 0; i < size; i++) {
                if (tempNode.value == nodeValue) {
                    System.out.println("Found node: " + tempNode.value);
                    return true;
                }
                tempNode = tempNode.next;
            }
        }
        System.out.println("Node not found.");
        return false;
    }

    public boolean deleteNode(int location){
        if (head == null) {
            System.out.println("DLL does not exist");
            return false;
        } else if (location == 0) {
            head = head.next;
            size--;
            if (size == 0) {
                tail = null;
            }
            return true;
        } else if (location >= size) {
            DoublyNode tempNode = head;
            for (int i = 0; i < size - 1; i++) {
                tempNode = tempNode.next;
            }
            if (tempNode == head) {
                head = tail = null;
                size--;
                return true;
            }
            tempNode.next = null;
            tail = tempNode;
            size--;
            return true;
        } else {
            DoublyNode tempNode = head;
            for (int i = 0; i < location - 1; i++) {
                tempNode = tempNode.next;
            }
            tempNode.next = tempNode.next.next;
            size--;
            return true;
        }
    }

    // Method to delete an entire DoubleLinkedList
    public void deleteDLL() {
        if (head == null) {
            System.out.println("DLL does not exist");
        } else {
            head = null;
            tail = null;
            System.out.println("The DLL has been deleted.");
        }
    }

    // Reverse Traverse - start from the tail and traverse to the head
    // Search DLL for a Node
    // Delete method for single Node (beginning, end, anywhere)
    // Delete entire DLL (set head null, tail null?)

}
