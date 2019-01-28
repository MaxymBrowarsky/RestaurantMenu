import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

public class MainMenuBar extends JMenuBar {
    private static final String DBMenu_NAME = "DBMenu";
    private static final String HELP_MENU_NAME = "Help";
    private static final String MENU_FORMER_NAME = "Menu Former";
    private static final String PRODUCTS_ITEM_NAME = "Products";
    private static final String HELP_ITEM_NAME = "Open docs";

    public MainMenuBar() {
        JMenu DBMenu = new JMenu(DBMenu_NAME);
        JMenu HelpMenu = new JMenu(HELP_MENU_NAME);
        JMenu MenuFormer = new JMenu(MENU_FORMER_NAME);
        this.formDBMenu(DBMenu);
        JMenuItem helpItem = new JMenuItem(HELP_ITEM_NAME);
        helpItem.addActionListener((ActionEvent a) -> {
            try {
                if (Desktop.isDesktopSupported()) {
                    Desktop.getDesktop().open(new File("D:\\help.docx"));
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        });
        HelpMenu.add(helpItem);
        MenuFormer.addActionListener((ActionEvent a) -> {
            MainFrame frame = (MainFrame) getTopLevelAncestor();
            frame.changePanel(frame.getMenuFormerPanel());
        });
        this.add(MenuFormer);
        this.add(DBMenu);
        this.add(HelpMenu);


    }
    private JMenu formDBMenu(JMenu menu) {
        JMenuItem products = new JMenuItem(PRODUCTS_ITEM_NAME);
        products.addActionListener((ActionEvent action) -> {
            MainFrame frame = (MainFrame) getTopLevelAncestor();
            frame.changePanel(frame.getDBPanel());
        });
        menu.add(products);
        return menu;
    }
}
