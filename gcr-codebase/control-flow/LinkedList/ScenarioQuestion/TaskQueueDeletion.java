class TaskNode {
    int taskId;
    TaskNode next;

    TaskNode(int taskId) {
        this.taskId = taskId;
        this.next = null;
    }
}

public class TaskQueueDeletion {

    // Remove the completed task from the queue
    public static TaskNode removeCompletedTask(TaskNode head, int completedTaskId) {

        // Empty queue
        if (head == null) {
            return null;
        }

        // If the first task is the completed one
        if (head.taskId == completedTaskId) {
            return head.next;
        }

        TaskNode previous = head;
        TaskNode current = head.next;

        // Search for the task
        while (current != null && current.taskId != completedTaskId) {
            previous = current;
            current = current.next;
        }

        // Task found
        if (current != null) {
            previous.next = current.next;
        }

        return head;
    }

    // Display the task queue
    public static void displayTaskQueue(TaskNode head) {

        while (head != null) {
            System.out.print(head.taskId + " -> ");
            head = head.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {

        TaskNode head = new TaskNode(101);
        head.next = new TaskNode(102);
        head.next.next = new TaskNode(103);
        head.next.next.next = new TaskNode(104);

        System.out.println("Original Task Queue:");
        displayTaskQueue(head);

        // Remove task 103
        head = removeCompletedTask(head, 103);

        System.out.println("After Removing Task 103:");
        displayTaskQueue(head);

        // Remove the first task
        head = removeCompletedTask(head, 101);

        System.out.println("After Removing Task 101:");
        displayTaskQueue(head);
    }
}