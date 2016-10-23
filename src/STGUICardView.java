import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by outba on 10/23/2016.
 */
public class STGUICardView extends JPanel{
    STcard card;
    JLabel cardName;
    int numOfClicks = 0;
    final int SINGLE_CLICK = 1;
    final int DOUBLE_CLICK = 2;

    public STGUICardView(STcard card) {
        this.card = card;
        cardName = new JLabel();
        String cardText = ("id-" + card.getId() + ".jpg");
        //String basePath = new File("").getAbsolutePath();
        //System.out.println(basePath);
        String path = new File("src/cardImages/" + cardText).getAbsolutePath();
        ImageIcon imageIcon = new ImageIcon(new ImageIcon(path).getImage().getScaledInstance(240, 335, Image.SCALE_DEFAULT));
        cardName.setIcon(imageIcon);
        System.out.println(path);
        add(cardName);


        addMouseListener(new MouseInputAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                numOfClicks++;
                if (numOfClicks == SINGLE_CLICK) {
                    Border border = BorderFactory.createLineBorder(Color.blue);
                    cardName.setBorder(border);
                    //cardName.setText("Selected");
                    super.mouseClicked(e);
                }
                else {
                    if (numOfClicks == DOUBLE_CLICK) {
                        cardName.setIcon(null);
                        cardName.setText("Played, and sent to the deck.");
                        cardName.setBorder(null);
                        super.mouseClicked(e);
                    }
                }

            }

            @Override
            public void mouseEntered(MouseEvent e) {

                super.mouseEntered(e);
            }
        });
    }
}
