import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by outba on 10/22/2016.
 */
public class STGUImain extends JFrame implements ActionListener {
    JLabel mainTitleLabel = new JLabel("Mineral Supertrumps");
    JButton startGameButton = new JButton("Start Game");
    JButton exitButton = new JButton("Exit Game");
    JButton readInstructionsButton = new JButton("Read Instructions");
    Font titleFont = new Font("Arial", Font.BOLD, 36);


    JPanel mainPanel = new JPanel(new GridBagLayout());
    GridBagConstraints buttonPanelConstraints = new GridBagConstraints();

    public STGUImain() {
        setTitle("Mineral Supertrumps");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
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
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object buttonClickedSource = e.getSource();
        if (buttonClickedSource == startGameButton) {
            remove(startGameButton);
            remove(exitButton);
            remove(readInstructionsButton);


        }
        else {
            if (buttonClickedSource == exitButton) {
                System.exit(0);
            }
            else {
                if (buttonClickedSource == readInstructionsButton) {
                    remove(startGameButton);
                    remove(exitButton);
                    remove(readInstructionsButton);
                }
            }
        }



    }

    public static void main(String[] args) {
        STGUImain frame = new STGUImain();
        frame.setSize(500, 500);
        frame.setVisible(true);
    }
}
