package Model;

public class Product extends Base{
    private String name;
    private Double price;
    private Category category;
    private Unit unit;

    public Product() {
    }

    public Product(String name, Double price, Category category, Unit unit) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.unit = unit;
    }

    @Override
    public Long getId() {
        return super.getId();
    }

    @Override
    public void setId(Long id) {
        super.setId(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", category=" + category +
                ", unit=" + unit +
                ", id=" + id +
                '}';
    }
}
