class LogNode {
    int timeStamp;
    LogNode next;

    LogNode(int timeStamp) {
        this.timeStamp = timeStamp;
        this.next = null;
    }
}

public class SortedLogStreamMerge {

    // Merge two sorted log streams
    public static LogNode mergeLogStreams(LogNode stream1, LogNode stream2) {

        // Dummy node simplifies handling the first node
        LogNode dummy = new LogNode(-1);
        LogNode tail = dummy;

        while (stream1 != null && stream2 != null) {

            if (stream1.timeStamp <= stream2.timeStamp) {
                tail.next = stream1;
                stream1 = stream1.next;
            } else {
                tail.next = stream2;
                stream2 = stream2.next;
            }

            tail = tail.next;
        }

        // Attach the remaining nodes
        if (stream1 != null) {
            tail.next = stream1;
        } else {
            tail.next = stream2;
        }

        return dummy.next;
    }

    // Display the merged log stream
    public static void displayLogStream(LogNode head) {

        while (head != null) {
            System.out.print(head.timeStamp + " -> ");
            head = head.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {

        // First log stream
        LogNode stream1 = new LogNode(1);
        stream1.next = new LogNode(4);
        stream1.next.next = new LogNode(7);
        stream1.next.next.next = new LogNode(10);

        // Second log stream
        LogNode stream2 = new LogNode(2);
        stream2.next = new LogNode(3);
        stream2.next.next = new LogNode(8);
        stream2.next.next.next = new LogNode(12);

        System.out.println("First Log Stream:");
        displayLogStream(stream1);

        System.out.println("Second Log Stream:");
        displayLogStream(stream2);

        LogNode mergedStream = mergeLogStreams(stream1, stream2);

        System.out.println("Merged Log Stream:");
        displayLogStream(mergedStream);
    }
}