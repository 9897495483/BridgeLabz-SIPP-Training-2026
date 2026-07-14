class URLNode {
    String url;
    URLNode next;

    URLNode(String url) {
        this.url = url;
        this.next = null;
    }
}

public class RedirectLoopDetection {

    // Detect whether the redirect chain contains a loop
    public static boolean hasRedirectLoop(URLNode head) {

        if (head == null) {
            return false;
        }

        URLNode slow = head;
        URLNode fast = head;

        // Move slow by 1 step and fast by 2 steps
        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            // If both pointers refer to the same node, a cycle exists
            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    // Display the redirect chain (for non-cyclic lists only)
    public static void displayRedirectChain(URLNode head) {

        while (head != null) {
            System.out.print(head.url + " -> ");
            head = head.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {

        URLNode first = new URLNode("google.com");
        URLNode second = new URLNode("openai.com");
        URLNode third = new URLNode("github.com");
        URLNode fourth = new URLNode("leetcode.com");

        first.next = second;
        second.next = third;
        third.next = fourth;

        // Uncomment the next line to create a cycle
        // fourth.next = second;

        System.out.println("Redirect Loop Exists: " + hasRedirectLoop(first));
    }
}