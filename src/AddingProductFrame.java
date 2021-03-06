import javax.swing.*;
import java.awt.event.ActionEvent;

public class AddingProductFrame extends JFrame {
    private static final String TITLE = "Додавання нового продукту";
    private static final String NAME_LABEL_TEXT = "Назва";
    private static final String DESC_LABEL_TEXT = "Опис";
    private static final String RATING_LABEL_TEXT = "Рейтинг";
    private static final String PRICE_LABEL_TEXT = "Ціна";
    private static final String WEIGHT_LABEL_TEXT = "Вага";
    private static final String ADD_BUTTON_TEXT = "Додати";
    public AddingProductFrame() {
        setTitle(TITLE);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setSize(400,300);
        setResizable(false);
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
        JButton addButton = new JButton(ADD_BUTTON_TEXT);

        addButton.addActionListener((ActionEvent e) -> {
            String name = nameTF.getText();
            String desc = descTF.getText();
            Integer rating = Integer.parseInt(ratingTF.getText());
            Integer price = Integer.parseInt(priceTF.getText());
            Integer weight = Integer.parseInt(weightTF.getText());
            Product product = new Product(Product.getNewID(), name, desc, weight, price, rating);
            product.add();
        });

        JPanel panel = new JPanel();

        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);
        layout.linkSize(SwingConstants.HORIZONTAL, nameLabel, descLabel, priceLabel, weightLabel, ratingLabel);
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nameLabel)
                        .addComponent(nameTF))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(descLabel)
                        .addComponent(descTF))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(weightLabel)
                        .addComponent(weightTF))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(priceLabel)
                        .addComponent(priceTF))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ratingLabel)
                        .addComponent(ratingTF))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addButton)))
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
