import javax.swing.*;

public class FormerPanel extends JPanel {
    public FormerPanel(RestaurantMenuPanel restaurantMenuPanel, ControlPanel controlPanel, DBPanel dbPanel) {
        this.add(restaurantMenuPanel);
        this.add(controlPanel);
        this.add(dbPanel);
    }

}
