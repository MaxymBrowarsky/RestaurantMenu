import java.sql.SQLException;

public class Product {

    private Integer Id;
    private String Name;
    private String Description;
    private Integer Weight;
    private Double Price;
    private Integer Rating;

    public Product(){}

    public Product(Integer Id, String Name, String Description, Integer Weight, Double Price, Integer Rating){
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

    public Double getPrice() {
        return Price;
    }

    public Product setPrice(Double price) {
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
