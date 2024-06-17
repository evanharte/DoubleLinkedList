package com.keyin;

// Undo/Redo functionality: In applications that support undo/redo, a doubly linked list can be used to maintain
// a sequence of states.
public class UndoRedoManager<T> {
    // "T" represents the data type that will eventually be used in the list

    private class Node {
        private T state;
        private Node prev;
        private Node next;

        // setter method?
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
        Node nextState = currentState.next;
        if (nextState == null) {
            System.out.println("No state to redo.");
            return null;
        } else {
            currentState = nextState;
        }
        return currentState.state;
    }


    public void performAction(T newState) {
        // create a new node to ADD to the list
        Node newNode = new Node(newState);

        // set the <> links for the new node adding it after the 'currentNode' which was there before adding this one >>
        // (so it is no longer 'current')
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
        // IMPORTANT! Setting the 'T' or 'type' value that we will be using in the list to be string
        UndoRedoManager<String> undoRedoManager = new UndoRedoManager<>();
        undoRedoManager.performAction("I");
        undoRedoManager.performAction("love");
        undoRedoManager.performAction("coding");
        undoRedoManager.performAction("with");
        undoRedoManager.performAction("Java");

        System.out.println("Current state: " + undoRedoManager.currentState.state);
        System.out.println();
        undoRedoManager.undo();
        undoRedoManager.undo();
        undoRedoManager.undo();
        undoRedoManager.undo();

        System.out.println("Current state: " + undoRedoManager.currentState.state);
        undoRedoManager.redo();
        System.out.println("Current state: " + undoRedoManager.currentState.state);
        undoRedoManager.redo();
        System.out.println("Current state: " + undoRedoManager.currentState.state);
        undoRedoManager.redo();
        System.out.println("Current state: " + undoRedoManager.currentState.state);
        undoRedoManager.redo();
        System.out.println("Current state: " + undoRedoManager.currentState.state);


    }


}
