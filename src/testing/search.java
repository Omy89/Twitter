import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class search {
    public static void main(String[] args) {
        JFrame frame = new JFrame("User Search Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(5, 1)); // Set layout to 5 rows

        // Sample data
        User[] users = {
            new User("Omar Farooq", 25),
            new User("Omar Khalid", 30),
            new User("John Doe", 22),
            new User("Jane Omar", 28),
            new User("Omar Abdullah", 35)
        };

        // Search bar (JTextField)
        JTextField searchField = new JTextField(20);

        // Button to trigger the search
        JButton searchButton = new JButton("Search");

        // Labels to display user information
        JLabel nameLabel = new JLabel();
        JLabel ageLabel = new JLabel();
        JLabel imageLabel = new JLabel();
        JLabel notFoundLabel = new JLabel();

        // Add components to the frame
        frame.add(searchField);
        frame.add(searchButton);
        frame.add(nameLabel);
        frame.add(ageLabel);
        frame.add(imageLabel);
        frame.add(notFoundLabel);

        // Add action listener to the search button
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchTerm = searchField.getText().toLowerCase();
                boolean found = false;

                // Search for the user
                for (User user : users) {
                    if (user.getName().toLowerCase().contains(searchTerm)) {
                        nameLabel.setText("Name: " + user.getName());
                        ageLabel.setText("Age: " + user.getAge());
                        imageLabel.setText("Image: [Placeholder]");
                        notFoundLabel.setText(""); // Clear not found label
                        found = true;
                        break;
                    }
                }

                // If user is not found, show "User not found"
                if (!found) {
                    nameLabel.setText("");
                    ageLabel.setText("");
                    imageLabel.setText("");
                    notFoundLabel.setText("User not found");
                }
            }
        });

        frame.setVisible(true);
    }
}

// User class to store name and age
class User {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
