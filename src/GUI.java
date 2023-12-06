import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {
    GUI() {
        Customer cust1 = new Customer();
        Merchandise masks = new Merchandise("Mask", 250, 15);
        Merchandise knives = new Merchandise("Knife", 300, 22);
        OnSaleMerchandise fakeBloodz = new OnSaleMerchandise("Fake Blood",199.9,29,0.35);

        setTitle("Shop of Horror");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1080, 640);
        JPanel panel = new JPanel();

        JPanel maskPanel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));
        JLabel maskLabel = new JLabel(masks.getProductName());
        JLabel maskPrice = new JLabel(String.valueOf(masks.getPrice() + "kr"));
        JButton buyMask = new JButton("Buy mask");
        maskPanel.add(maskLabel);
        maskPanel.add(maskPrice);
        maskPanel.add(buyMask);

        JPanel knifePanel = new JPanel();
        JLabel knifeLabel = new JLabel(knives.getProductName());
        JLabel knifePrice = new JLabel(String.valueOf(knives.getPrice()) + "kr");
        JButton buyKnife = new JButton("Buy knife");
        knifePanel.add(knifeLabel);
        knifePanel.add(knifePrice);
        knifePanel.add(buyKnife);

        JPanel bloodPanel = new JPanel(new BorderLayout());
        JLabel bloodLabel = new JLabel(fakeBloodz.getProductName());
        JLabel bloodPrice = new JLabel(String.valueOf(fakeBloodz.getPrice()) + "kr");
        JButton buyBlood = new JButton("Buy blood");
        knifePanel.add(bloodLabel);
        knifePanel.add(bloodPrice);
        knifePanel.add(buyBlood);

        panel.add(maskPanel);
        panel.add(knifePanel);
        panel.add(bloodPanel);

        add(panel);
        setVisible(true);
    }
}
