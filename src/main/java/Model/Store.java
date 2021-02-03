package Model;


import java.util.Date;

public class Store extends Base {
    private Double quantity;
    private String name;
    private Integer isActive;
    private Date insertDate;
    public Store() {
    }

    public Store(Double quantity, String name, Integer isActive, Date insertDate) {
        this.quantity = quantity;
        this.name = name;
        this.isActive = isActive;
        this.insertDate = insertDate;
    }

    @Override
    public Long getId() {
        return super.getId();
    }

    @Override
    public void setId(Long id) {
        super.setId(id);
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

    @Override
    public String toString() {
        return "Store{" +
                "quantity='" + quantity + '\'' +
                ", name='" + name + '\'' +
                ", is_active=" + isActive +
                ", insert_date=" + insertDate +
                ", id=" + id +
                '}';
    }
}
