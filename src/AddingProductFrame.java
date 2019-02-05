import javax.swing.*;
import java.awt.event.ActionEvent;

public class AddingProductFrame extends JFrame {
    private static final String TITLE = "Adding new product";
    private static final String NAME_LABEL_TEXT = "Adding new product";
    private static final String DESC_LABEL_TEXT = "Adding new product";
    private static final String RATING_LABEL_TEXT = "Adding new product";
    private static final String PRICE_LABEL_TEXT = "Adding new product";
    private static final String WEIGHT_LABEL_TEXT = "Adding new product";
    public AddingProductFrame() {
        setTitle(TITLE);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setSize(400,600);
        setContentPane(createPanel());
        setVisible(true);

    }
    private JPanel createPanel() {
        JLabel nameLabel = new JLabel(NAME_LABEL_TEXT);
        JLabel descLabel = new JLabel(DESC_LABEL_TEXT);
        JLabel ratingLabel = new JLabel(RATING_LABEL_TEXT);
        JLabel priceLabel = new JLabel(PRICE_LABEL_TEXT);
        JLabel weightLabel = new JLabel(WEIGHT_LABEL_TEXT);
        JTextField nameTF = new JTextField();
        JTextField descTF = new JTextField();
        JTextField ratingTF = new JTextField();
        JTextField priceTF = new JTextField();
        JTextField weightTF = new JTextField();
        JButton addButton = new JButton();

        addButton.addActionListener((ActionEvent e) -> {

        });

        JPanel panel = new JPanel();

        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);

        layout.setHorizontalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(nameLabel)
                .addComponent(descLabel)
                .addComponent(ratingLabel)
                .addComponent(priceLabel)
                .addComponent(weightLabel))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(nameTF)
                .addComponent(descTF)
                .addComponent(ratingTF)
                .addComponent(priceTF)
                .addComponent(weightTF))
            .addComponent(addButton)
        );

        layout.setVerticalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(nameLabel)
                .addComponent(nameTF))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(descLabel)
                .addComponent(descTF))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(ratingLabel)
                .addComponent(ratingTF))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(priceLabel)
                .addComponent(priceTF))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(weightLabel)
                .addComponent(weightTF))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
            .addComponent(addButton))

        );

        return panel;
    }
}
