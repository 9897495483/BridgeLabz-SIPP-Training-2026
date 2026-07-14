class ServerNode {
    int serverId;
    ServerNode next;

    ServerNode(int serverId) {
        this.serverId = serverId;
        this.next = null;
    }
}

public class RelayChainMiddleServer {

    // Find the middle server of the relay chain
    public static ServerNode findMiddleServer(ServerNode head) {

        if (head == null) {
            return null;
        }

        ServerNode slow = head;
        ServerNode fast = head;

        // Move slow by 1 step and fast by 2 steps
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // Display the relay chain
    public static void displayRelayChain(ServerNode head) {

        while (head != null) {
            System.out.print(head.serverId + " -> ");
            head = head.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {

        ServerNode head = new ServerNode(101);
        head.next = new ServerNode(102);
        head.next.next = new ServerNode(103);
        head.next.next.next = new ServerNode(104);
        head.next.next.next.next = new ServerNode(105);

        System.out.println("Relay Chain:");
        displayRelayChain(head);

        ServerNode middle = findMiddleServer(head);

        System.out.println("Middle Server: " + middle.serverId);
    }
}