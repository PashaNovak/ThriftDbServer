package view;

import controller.Controller;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Dzmitry Saladukha on 15.04.2016.
 */
public class ReadingPanel extends JPanel {
    public ReadingPanel(final Controller controller) {
        super(new BorderLayout());

        JButton button = new JButton("read");
        final JTextField textField = new JTextField(20);
        JPanel panel = new JPanel();
        final JLabel label = new JLabel();

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = textField.getText().trim();
                String definition = controller.read(name);
                if (definition != null) {
                    label.setText(
                            "<html><body style=\"padding: 20px\"><p style=\"font-size: 1.5em\"><span style=\"color: red; font-size: 3em\">" +
                                    name + "</span> \u2013 " + definition + "</p></body></html>");
                } else {
                    label.setText(
                            "<html><body style=\"padding: 20px\"><p style=\"font-size: 2em\">Nothing was found.</p></body></html>");
                }
            }
        });

        panel.add(textField);
        panel.add(button);
        add(panel, BorderLayout.NORTH);
        add(label, BorderLayout.CENTER);
    }
}
