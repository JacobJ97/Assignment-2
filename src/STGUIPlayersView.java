import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by outba on 10/23/2016.
 */
public class STGUIPlayersView extends JPanel {
    STplayer player;
    JLabel cardLabels = new JLabel("cards");

    public STGUIPlayersView(STplayer player) {
        this.player = player;

        add(cardLabels);

        addAllCards();
    }

    private void addAllCards() {
        ArrayList<STcard> cards = player.getCards();

        for (int i = 0; i < cards.size(); i++) {
            STcard card = cards.get(i);
            STGUICardView cardView = new STGUICardView(card);
            add(cardView);
            repaint();
            revalidate();
        }
    }


}
