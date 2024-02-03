package bai04;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CopyApp extends JFrame {
    private JTextField sourceTextField;
    private JTextField destinationTextField;
    private JButton selectSourceButton;
    private JButton selectDestinationButton;
    private JButton copyButton;
    private JFileChooser fileChooser;

    public CopyApp() {
        createView();
        setTitle("File Copy App");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void createView() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        getContentPane().add(panel);

        JLabel titleLabel = new JLabel("Copy File App");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        panel.add(titleLabel);

        JPanel sourcePanel = new JPanel();
        sourcePanel.setLayout(new BoxLayout(sourcePanel, BoxLayout.X_AXIS));
        sourceTextField = new JTextField();
        JLabel sourceLabel = new JLabel("Source File:");
        sourceLabel.setPreferredSize(new Dimension(50, sourceLabel.getPreferredSize().height));
        sourcePanel.add(sourceLabel);
        sourceTextField.setPreferredSize(new Dimension(400, 40));
        sourcePanel.add(sourceTextField, BorderLayout.CENTER);

        selectSourceButton = new JButton("Select");
        selectSourceButton.setPreferredSize(new Dimension(selectSourceButton.getPreferredSize().width, 40));
        selectSourceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    sourceTextField.setText(fileChooser.getSelectedFile().getPath());
                }
            }
        });
        sourcePanel.add(selectSourceButton, BorderLayout.EAST);
        panel.add(sourcePanel);

        JPanel destinationPanel = new JPanel();
        destinationPanel.setLayout(new BoxLayout(destinationPanel, BoxLayout.X_AXIS));
        JLabel destinationLabel = new JLabel("Destination Directory:");
        destinationLabel.setPreferredSize(new Dimension(50, destinationLabel.getPreferredSize().height));
        destinationPanel.add(destinationLabel);
        destinationTextField = new JTextField();
        destinationTextField.setPreferredSize(new Dimension(400, 40));
        destinationPanel.add(destinationTextField, BorderLayout.CENTER);
        selectDestinationButton = new JButton("Select");
        selectDestinationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    destinationTextField.setText(fileChooser.getSelectedFile().getPath());
                }
            }
        });
        destinationPanel.add(selectDestinationButton, BorderLayout.EAST);
        panel.add(destinationPanel);

        copyButton = new JButton("Copy File");
        copyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Path sourcePath = Paths.get(sourceTextField.getText());
                Path destinationPath = Paths.get(destinationTextField.getText(), sourcePath.getFileName().toString());
                try {
                    Files.copy(sourcePath, destinationPath);
                    JOptionPane.showMessageDialog(null, "File copied successfully!");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        panel.add(copyButton);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CopyApp().setVisible(true);
            }
        });
    }
}