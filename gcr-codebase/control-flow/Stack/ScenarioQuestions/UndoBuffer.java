public class UndoBuffer {

    private String[] actions;
    private int topIndex;

    public UndoBuffer(int capacity) {
        actions = new String[capacity];
        topIndex = -1;
    }

    public boolean push(String action) {
        if (isFull()) {
            return false;
        }

        actions[++topIndex] = action;
        return true;
    }

    public String pop() {
        if (isEmpty()) {
            throw new RuntimeException("Nothing to undo");
        }

        return actions[topIndex--];
    }

    public String peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }

        return actions[topIndex];
    }

    public boolean isEmpty() {
        return topIndex == -1;
    }

    public boolean isFull() {
        return topIndex == actions.length - 1;
    }
}