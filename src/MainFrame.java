import javax.swing.*;

public class MainFrame extends JFrame{
    private static final String TITLE_NAME = "Restaurant Menu";
    private JMenuBar menu;
    private JPanel activePanel;
    private JPanel DBPanel;

    public JPanel getMenuFormerPanel() {
        return MenuFormerPanel;
    }

    private JPanel MenuFormerPanel;
    public JPanel getDBPanel() {
        return DBPanel;
    }

    public MainFrame(JPanel activePanel) {
        this.setTitle(TITLE_NAME);
        this.setSize(600,800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MainMenuBar menu = new MainMenuBar();
        this.menu = menu;
        this.activePanel = activePanel;
        this.setJMenuBar(this.menu);
        this.add(this.activePanel);
        this.setVisible(true);
        this.pack();
    }
    public void changePanel(JPanel panel) {
        this.remove(this.activePanel);
        this.add(panel);
        this.activePanel = panel;
        this.pack();
    }
}
