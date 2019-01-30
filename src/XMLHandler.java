import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringWriter;

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
    public ArrayList<Product> deserialize(String xmlContent) {
        JAXBContext jaxbContext = JAXBContext.newInstance(RestaurantMenu.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        RestaurantMenu menu = (RestaurantMenu) unmarshaller.unmarshal(xmlContent);
        return menu.getRestaurantMenu();
    }

}
