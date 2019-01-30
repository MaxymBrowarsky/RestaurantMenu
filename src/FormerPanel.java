import javax.swing.*;

public class FormerPanel extends JPanel {
    public FormerPanel(RestaurantMenuPanel restaurantMenuPanel, ControlPanel controlPanel, RestaurantMenuPanel dbPanel) {
        this.add(restaurantMenuPanel);
        this.add(controlPanel);
        this.add(dbPanel);
    }

}
