import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.StringWriter;
import java.util.ArrayList;

public class XMLHandler {
    public String serialize(RestaurantMenu menu) {
        StringWriter writer = new StringWriter();

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(RestaurantMenu.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(menu, writer);
        } catch (Exception e) {

        }
        return writer.toString();
    }
    public ArrayList<Product> deserialize(File xml) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(RestaurantMenu.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            RestaurantMenu menu = (RestaurantMenu) unmarshaller.unmarshal(xml);
            return menu.getRestaurantMenu();
        } catch (Exception e) {

        }

        return null;
    }

}
