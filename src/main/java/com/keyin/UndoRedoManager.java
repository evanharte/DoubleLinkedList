package com.keyin;

// Undo/Redo functionality: In applications that support undo/redo, a doubly linked list can be used to maintain
// a sequence of states.
public class UndoRedoManager<T> {
    private class Node {
        private T state;
        private Node prev;
        private Node next;

        private Node (T state) {
            this.state = state;
        }
    }
    private Node currentState;

    public T undo() {
        if (currentState == null) {
            System.out.println("No state to undo.");
            return null;
        }

        // Get the previous state, if null, then you know it was the only element
        Node previousState = currentState.prev;
        if (previousState == null) {
            System.out.println("Reached the initial state.");
            return null;
        } else {
            // update the current state to the previous state
            currentState = previousState;
        }
        return currentState.state;
    }

    // leverage the 'next' - keep track of the 'next'
    public T redo() {
        if (currentState == null) {
            System.out.println("No state to undo.");
            return null;
        }

        // Get the previous state, if null, then you know it was the only element
        Node previousState = currentState.prev;
        if (previousState == null) {
            System.out.println("Reached the initial state.");
            return null;
        } else {
            // update the current state to the previous state
            currentState = previousState;
        }
        return currentState.state;
    }



    public void performAction(T newState) {
        // create a new node for the new task - to add this to the list
        Node newNode = new Node(newState);

        // set the links for the new node
        newNode.prev = currentState;
        newNode.next = null;

        // update the next link for the current state
        if (currentState != null) {
            currentState.next = newNode;
        }
        // update the current state to the new state

        currentState = newNode;
    }


    // state 1 <> state 2 <> state 3 <> state 4 <> state 5
    // state 1 <> state 2 <> state 3 <> state 4
    // state 1 <> state 2 <> state 3   ... etc.

    public static void main(String[] args) {
        UndoRedoManager<String> undoRedoManager = new UndoRedoManager<>();
        undoRedoManager.performAction("State 1");
        undoRedoManager.performAction("State 2");
        undoRedoManager.performAction("State 3");
        undoRedoManager.performAction("State 4");
        undoRedoManager.performAction("State 5");

        System.out.println("Current state: " + undoRedoManager.currentState.state);
        undoRedoManager.undo();
        System.out.println("Current state: " + undoRedoManager.currentState.state);
        undoRedoManager.undo();
        System.out.println("Current state: " + undoRedoManager.currentState.state);
    }


}
