import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.sql.SQLException;
@XmlRootElement(name = "Product")
public class Product {
    @XmlAttribute(name = "Id")
    private Integer Id;
    @XmlElement(name = "Name")
    private String Name;
    @XmlElement(name = "Description")
    private String Description;
    @XmlElement(name = "Weight")
    private Integer Weight;
    @XmlElement(name = "Price")
    private Integer Price;
    @XmlElement(name = "Rating")
    private Integer Rating;

    public Product(){}

    public Product(Integer Id, String Name, String Description, Integer Weight, Integer Price, Integer Rating){
        this.setId(Id);
        this.setName(Name);
        this.setDescription(Description);
        this.setWeight(Weight);
        this.setPrice(Price);
        this.setRating(Rating);
    }

    public Integer getId() {
        return Id;
    }

    public Product setId(Integer id) {
        Id = id;
        return this;
    }

    public String getName() {
        return Name;
    }

    public Product setName(String name) {
        Name = name;
        return this;
    }

    public String getDescription() {
        return Description;
    }

    public Product setDescription(String description) {
        Description = description;
        return this;
    }

    public Integer getWeight() {
        return Weight;
    }

    public Product setWeight(Integer weight) {
        Weight = weight;
        return this;
    }

    public Integer getPrice() {
        return Price;
    }

    public Product setPrice(Integer price) {
        Price = price;
        return this;
    }

    public Integer getRating() {
        return Rating;
    }

    public Product setRating(Integer rating) {
        Rating = rating;
        return this;
    }

    @Override
    public String toString() {
        return "Product{" + "\n Id='" + this.Id + "'"
                + "\n Name='" + this.getName() + "'"
                + "\n Description='" + this.getDescription() + "'"
                + "\n Weight='" + this.getWeight() + "'"
                + "\n Price='" + this.getPrice() + "'"
                + "\n Rating='" + this.getRating() + "'";

    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Product product = new Product(getId(),getName(),getDescription(),getWeight(),getPrice(),getRating());
        return product;
    }

    /////////////////
    public void add(){
        try {
            Connection.add(this);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void update(){
        try {
            Connection.update(this);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void delete(){
        try {
            Connection.delete(this.Id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
