import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by outba on 10/22/2016.
 */
public class STGUImain extends JFrame implements ActionListener {
    JLabel mainTitleLabel = new JLabel("Mineral Supertrumps");
    JLabel instructionsNumOfPlayersLabel = new JLabel("Select the amount of players you would like to play with: ");
    JLabel instructionTitleLabel = new JLabel("Instructions");
    JLabel instructionsDescription = new JLabel("To be added.");
    JButton startGameButton = new JButton("Start Game");
    JButton exitButton = new JButton("Exit Game");
    JButton readInstructionsButton = new JButton("Read Instructions");
    JButton returnToMenuButton = new JButton("Return to Menu");
    Font titleFont = new Font("Arial", Font.BOLD, 36);
    JComboBox<Integer> numOfPlayers = new JComboBox<>();

    JPanel mainPanel = new JPanel(new GridBagLayout());
    GridBagConstraints buttonPanelConstraints = new GridBagConstraints();

    public STGUImain() {
        setTitle("Mineral Supertrumps");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainScreenSettings();
        }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object buttonClickedSource = e.getSource();
        if (buttonClickedSource == startGameButton) {
            mainPanel.remove(mainTitleLabel);
            mainPanel.remove(startGameButton);
            mainPanel.remove(exitButton);
            mainPanel.remove(readInstructionsButton);
            numOfPlayers.addActionListener(this);

            mainPanel.add(instructionsNumOfPlayersLabel);
            mainPanel.add(numOfPlayers);
            numOfPlayers.addItem(3);
            numOfPlayers.addItem(4);
            numOfPlayers.addItem(5);
        }
        else {
            if (buttonClickedSource == exitButton) {
                System.exit(0);
            }
            else {
                if (buttonClickedSource == readInstructionsButton) {
                    mainPanel.remove(mainTitleLabel);
                    mainPanel.remove(startGameButton);
                    mainPanel.remove(exitButton);
                    mainPanel.remove(readInstructionsButton);
                    instructionTitleLabel.setFont(titleFont);
                    buttonPanelConstraints.gridx = 1;
                    buttonPanelConstraints.gridy = 0;
                    mainPanel.add(instructionTitleLabel, buttonPanelConstraints);
                    buttonPanelConstraints.gridx = 1;
                    buttonPanelConstraints.gridy = 1;
                    mainPanel.add(instructionsDescription, buttonPanelConstraints);
                    buttonPanelConstraints.gridx = 1;
                    buttonPanelConstraints.gridy = 2;
                    mainPanel.add(returnToMenuButton, buttonPanelConstraints);

                }
                else {
                    if (buttonClickedSource == returnToMenuButton) {
                        mainPanel.remove(instructionTitleLabel);
                        mainPanel.remove(instructionsDescription);
                        mainPanel.remove(returnToMenuButton);
                        mainScreenSettings();
                    }
                }
            }
        }
        revalidate();
        repaint();
    }

    private void mainScreenSettings() {
        mainTitleLabel.setFont(titleFont);
        add(mainPanel);
        buttonPanelConstraints.gridx = 1;
        buttonPanelConstraints.gridy = 0;
        buttonPanelConstraints.weighty = 2;
        mainPanel.add(mainTitleLabel, buttonPanelConstraints);
        buttonPanelConstraints.gridx = 1;
        buttonPanelConstraints.gridy = 2;
        buttonPanelConstraints.weighty = 1;
        mainPanel.add(startGameButton, buttonPanelConstraints);
        buttonPanelConstraints.gridx = 1;
        buttonPanelConstraints.gridy = 3;
        buttonPanelConstraints.weighty = 1;
        mainPanel.add(exitButton, buttonPanelConstraints);
        buttonPanelConstraints.gridx = 1;
        buttonPanelConstraints.gridy = 4;
        buttonPanelConstraints.weighty = 1;
        mainPanel.add(readInstructionsButton, buttonPanelConstraints);
        startGameButton.addActionListener(this);
        exitButton.addActionListener(this);
        readInstructionsButton.addActionListener(this);
        returnToMenuButton.addActionListener(this);
    }

    public static void main(String[] args) {
        STGUImain frame = new STGUImain();
        frame.setSize(500, 500);
        frame.setVisible(true);
    }
}
