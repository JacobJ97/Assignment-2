import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by outba on 10/22/2016.
 */
public class STGUIMain extends JFrame implements ActionListener {
    JLabel mainTitleLabel = new JLabel("Mineral Supertrumps");
    JLabel instructionsNumOfPlayersLabel = new JLabel("Select the amount of players you would like to play with: ");
    JLabel instructionTitleLabel = new JLabel("Instructions");
    JLabel instructionsDescription = new JLabel("To be added.");
    JButton startGameButton = new JButton("Start Game");
    JButton exitButton = new JButton("Exit Game");
    JButton readInstructionsButton = new JButton("Read Instructions");
    JButton returnToMenuButton = new JButton("Return to Menu");
    JButton dealCardsButton = new JButton("Submit");
    JButton pickUpButton = new JButton("Pick Up Card");
    Font titleFont = new Font("Arial", Font.BOLD, 36);
    JComboBox<Integer> numOfPlayersComboBox = new JComboBox<>();

    JPanel mainPanel = new JPanel(new GridBagLayout());
    GridBagConstraints buttonPanelConstraints = new GridBagConstraints();

    public STGUIMain() {
        setTitle("Mineral Supertrumps");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainScreenSettings();
        }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object buttonClickedSource = e.getSource();
        if (buttonClickedSource == startGameButton) {
            getNumOfPlayers();
        }
        else {
            if (buttonClickedSource == dealCardsButton) {
                mainPanel.remove(instructionsNumOfPlayersLabel);
                mainPanel.remove(numOfPlayersComboBox);
                mainPanel.remove(dealCardsButton);
                int numOfPlayersInt = (int) numOfPlayersComboBox.getSelectedItem();
                System.out.println(numOfPlayersInt);
                STgame game = new STgame(numOfPlayersInt);
                game.selectDealer();
                game.dealRandomCardsToEachPlayer();
                game.assignHumanPlayerID();
                STplayer humanPlayer = game.getHumanPlayer();

                STGUIPlayersView playersView = new STGUIPlayersView(humanPlayer);
                add(playersView, BorderLayout.SOUTH);
                JScrollPane jScrollPane = new JScrollPane(playersView);
                jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
                add(jScrollPane, BorderLayout.SOUTH);
                add(pickUpButton, BorderLayout.LINE_END);



                //game.assignHumanPlayerID();
                //game.assignComputerPlayersID();
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
                        mainPanel.add(instructionTitleLabel,buttonPanelConstraints);
                        buttonPanelConstraints.gridy = 1;
                        mainPanel.add(instructionsDescription, buttonPanelConstraints);
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
        }
        revalidate();
        repaint();
    }

    private void getNumOfPlayers() {
        mainPanel.remove(mainTitleLabel);
        mainPanel.remove(startGameButton);
        mainPanel.remove(exitButton);
        mainPanel.remove(readInstructionsButton);
        numOfPlayersComboBox.addActionListener(this);
        buttonPanelConstraints.gridx = 1;
        buttonPanelConstraints.gridy = 0;
        buttonPanelConstraints.weighty = 0.1;
        buttonPanelConstraints.anchor = GridBagConstraints.PAGE_END;
        mainPanel.add(instructionsNumOfPlayersLabel, buttonPanelConstraints);
        buttonPanelConstraints.gridy = 1;
        buttonPanelConstraints.weighty = 0.2;
        buttonPanelConstraints.anchor = GridBagConstraints.PAGE_START;
        mainPanel.add(numOfPlayersComboBox, buttonPanelConstraints);
        buttonPanelConstraints.gridy = 2;
        buttonPanelConstraints.weighty = 0.1;
        buttonPanelConstraints.anchor = GridBagConstraints.CENTER;
        mainPanel.add(dealCardsButton, buttonPanelConstraints);
        numOfPlayersComboBox.addItem(3);
        numOfPlayersComboBox.addItem(4);
        numOfPlayersComboBox.addItem(5);
    }

    private void mainScreenSettings() {
        mainTitleLabel.setFont(titleFont);
        add(mainPanel);
        buttonPanelConstraints.gridx = 1;
        buttonPanelConstraints.gridy = 0;
        buttonPanelConstraints.weighty = 0.5;
        mainPanel.add(mainTitleLabel, buttonPanelConstraints);
        buttonPanelConstraints.gridx = 1;
        buttonPanelConstraints.gridy = 2;
        buttonPanelConstraints.weighty = 0.15;
        buttonPanelConstraints.anchor = GridBagConstraints.PAGE_START;
        mainPanel.add(startGameButton, buttonPanelConstraints);
        buttonPanelConstraints.gridx = 1;
        buttonPanelConstraints.gridy = 3;
        buttonPanelConstraints.weighty = 0.15;
        mainPanel.add(exitButton, buttonPanelConstraints);
        buttonPanelConstraints.gridx = 1;
        buttonPanelConstraints.gridy = 4;
        buttonPanelConstraints.weighty = 0.15;
        mainPanel.add(readInstructionsButton, buttonPanelConstraints);
        startGameButton.addActionListener(this);
        exitButton.addActionListener(this);
        readInstructionsButton.addActionListener(this);
        returnToMenuButton.addActionListener(this);
        dealCardsButton.addActionListener(this);
    }

    public static void main(String[] args) {
        STGUIMain frame = new STGUIMain();
        frame.setSize(500, 500);
        frame.setVisible(true);
    }
}
