interface TextModeration {

    void checkText(String post);

    default void displayModerationPolicy() {
        System.out.println("No offensive language allowed.");
    }

    static boolean containsRestrictedWords(String post) {
        return post.contains("bad") || post.contains("hate");
    }
}

interface SpamDetection {

    void detectSpam(String post);

    default void displayModerationPolicy() {
        System.out.println("Spam messages are prohibited.");
    }
}

class ContentModerator implements TextModeration, SpamDetection {

    public void checkText(String post) {

        if (TextModeration.containsRestrictedWords(post))
            System.out.println("Offensive Post");
    }

    public void detectSpam(String post) {

        if (post.contains("Buy Now"))
            System.out.println("Spam Post");
    }

    @Override
    public void displayModerationPolicy() {

        TextModeration.super.displayModerationPolicy();
        SpamDetection.super.displayModerationPolicy();
    }
}

public class aiContentModeration {

    public static void main(String[] args) {

        String posts[] = {
                "Hello Everyone",
                "Buy Now Offer",
                "I hate this",
                "Good Morning"
        };

        ContentModerator cm = new ContentModerator();

        cm.displayModerationPolicy();

        System.out.println();

        for (String post : posts) {

            System.out.println(post);

            if (post.contains("Buy Now"))
                System.out.println("Spam");

            else if (TextModeration.containsRestrictedWords(post))
                System.out.println("Offensive");

            else
                System.out.println("Valid");

            System.out.println();
        }
    }
}