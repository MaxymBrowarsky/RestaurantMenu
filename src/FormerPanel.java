import javax.swing.*;

public class FormerPanel extends JPanel {
    public FormerPanel(RestaurantMenuPanel restaurantMenuPanel, ControlPanel controlPanel, RestaurantMenuPanel dbPanel) {
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.add(restaurantMenuPanel);
        this.add(controlPanel);
        this.add(dbPanel);
    }

}
