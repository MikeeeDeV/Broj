import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FamilyApp {

    // Method to create the main menu with colored buttons
    public static void createMainMenu(JFrame frame) {
        frame.getContentPane().removeAll();
        frame.setLayout(new GridLayout(1, 5));

        String[] names = {"أمى", "مريم", "رحمه", "سدره", "عمر"};
        String[] messages = {
                "السلام عليكم\nانا ممتن لوجودك بجانبى ك ام لى و سوف احاول دائما أن ارتقى إلى توقعاتك",
                "السلام عليكم\nانتى بنت عسوله و طيبه حددى طريق و امشى فيه و اعملى مع رحمه و سدره ورد قرآن...",
                "السلام عليكم\nكيف حالك .... لا يعرف تفكيرى الهدوء منذ أن علمت ب مرضك...",
                "السلام عليكم\nانتى عسوله و ماما بتحبك و عايزك تحفظى قرآن مع رحمه و مريم...",
                "السلام عليكم\nحفظك الله يا عمر و يسر عليك نطقك و لنا لقاء قريب إن شاء الله..."
        };

        Color[] colors = {Color.WHITE, Color.YELLOW, new Color(173, 216, 230), Color.PINK, Color.WHITE};

        for (int i = 0; i < names.length; i++) {
            JButton button = createButton(names[i], colors[i], messages[i], frame);
            frame.add(button);
        }

        frame.revalidate();
        frame.repaint();
    }

    // Method to create a button for each person
    public static JButton createButton(String name, Color bgColor, String message, JFrame frame) {
        JButton button = new JButton(name);
        button.setBackground(bgColor);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setFocusable(false);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createMessagePage(frame, message, bgColor);
            }
        });
        return button;
    }

    // Method to create the message page for each person
    public static void createMessagePage(JFrame frame, String message, Color bgColor) {
        frame.getContentPane().removeAll();
        frame.setLayout(new BorderLayout());

        JTextArea textArea = new JTextArea(message);
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
        textArea.setEditable(false);
        textArea.setFont(new Font("Arial", Font.PLAIN, 16));
        textArea.setBackground(bgColor);

        frame.add(textArea, BorderLayout.CENTER);

        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createMainMenu(frame);
            }
        });

        frame.add(backButton, BorderLayout.SOUTH);
        frame.revalidate();
        frame.repaint();
    }

    // Method to create the welcome screen
    public static void createWelcomeScreen(JFrame frame) {
        frame.getContentPane().removeAll();
        frame.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setBackground(Color.PINK);
        panel.setLayout(new BorderLayout());

        JLabel label = new JLabel("اهلا ب اسره عم حسن", SwingConstants.CENTER);
        label.setForeground(Color.BLACK);
        label.setFont(new Font("Arial", Font.BOLD, 24));
        panel.add(label, BorderLayout.CENTER);

        JButton startButton = new JButton("Start");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createMainMenu(frame);
            }
        });

        frame.add(panel, BorderLayout.CENTER);
        frame.add(startButton, BorderLayout.SOUTH);

        frame.revalidate();
        frame.repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Family App");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the welcome screen
        createWelcomeScreen(frame);

        frame.setVisible(true);
    }
}