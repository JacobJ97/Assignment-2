import javax.swing.*;

/**
 * Created by outba on 10/23/2016.
 */
public class STGUICardView extends JPanel{
    STcard card;
    JLabel cardName;

    public STGUICardView(STcard card) {
        this.card = card;
        cardName = new JLabel("id: " + card.getId());
        add(cardName);
    }
}
