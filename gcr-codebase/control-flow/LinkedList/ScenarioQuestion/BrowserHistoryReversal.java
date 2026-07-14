class HistoryNode {
    String page;
    HistoryNode next;

    HistoryNode(String page) {
        this.page = page;
        this.next = null;
    }
}

public class BrowserHistoryReversal {

    // Reverse the browser history
    public static HistoryNode reverseHistory(HistoryNode head) {

        HistoryNode previous = null;
        HistoryNode current = head;

        while (current != null) {

            // Store the next node
            HistoryNode next = current.next;

            // Reverse the link
            current.next = previous;

            // Move previous and current one step forward
            previous = current;
            current = next;
        }

        return previous;
    }

    // Display browser history
    public static void displayHistory(HistoryNode head) {

        while (head != null) {
            System.out.print(head.page + " -> ");
            head = head.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {

        HistoryNode head = new HistoryNode("Google");
        head.next = new HistoryNode("YouTube");
        head.next.next = new HistoryNode("GitHub");
        head.next.next.next = new HistoryNode("LeetCode");

        System.out.println("Original History:");
        displayHistory(head);

        head = reverseHistory(head);

        System.out.println("Reversed History:");
        displayHistory(head);
    }
}