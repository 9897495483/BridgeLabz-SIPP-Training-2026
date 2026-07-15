public class CallStack {

    private static class Node {

        String functionName;
        Node next;

        Node(String functionName) {
            this.functionName = functionName;
        }
    }

    private Node top;

    public void push(String functionName) {

        Node newNode = new Node(functionName);
        newNode.next = top;
        top = newNode;
    }

    public String pop() {

        if (isEmpty()) {
            throw new RuntimeException("Call stack is empty");
        }

        String currentFunction = top.functionName;
        top = top.next;

        return currentFunction;
    }

    public String peek() {

        if (isEmpty()) {
            throw new RuntimeException("Call stack is empty");
        }

        return top.functionName;
    }

    public boolean isEmpty() {
        return top == null;
    }
}