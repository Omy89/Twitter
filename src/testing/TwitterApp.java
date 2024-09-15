package testing;



import javax.swing.*;

public class TwitterApp {
    private JFrame mainFrame;

    public TwitterApp() {
        // Set up the main JFrame
        mainFrame = new JFrame("Simplified Twitter");
        mainFrame.setSize(400, 400);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(null);
        
        // Button to open the tweet dialog
        JButton tweetButton = new JButton("Tweet");
        tweetButton.setBounds(150, 150, 100, 30);
        tweetButton.addActionListener(e -> openTweetDialog());

        mainFrame.add(tweetButton);
        mainFrame.setVisible(true);
    }

    private void openTweetDialog() {
        // Create a modal JDialog
        JDialog tweetDialog = new JDialog(mainFrame, "New Tweet", true);
        tweetDialog.setSize(300, 200);
        tweetDialog.setLayout(null);

        // Text area for the tweet
        JTextArea tweetTextArea = new JTextArea();
        tweetTextArea.setBounds(10, 10, 260, 100);
        tweetDialog.add(tweetTextArea);

        // Button to post the tweet
        JButton postTweetButton = new JButton("Tweet");
        postTweetButton.setBounds(100, 120, 100, 30);
        postTweetButton.addActionListener(e -> {
            // Logic to post the tweet
            String tweet = tweetTextArea.getText();
            System.out.println("Tweet posted: " + tweet);
            tweetDialog.dispose(); // Close the dialog
        });

        tweetDialog.add(postTweetButton);
        tweetDialog.setVisible(true); // Show the dialog
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TwitterApp::new);
    }
}
