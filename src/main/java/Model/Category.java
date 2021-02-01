package Model;

public class Category extends Base {

    private String name;
    private Integer isActive;

    public Category() {
    }

    public Category(String name, Integer isActive) {
        this.name = name;
        this.isActive = isActive;
    }

    public Category(String name) {
        this.name = name;
    }

    public Category(Long id) {
        this.setId(id);
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

    @Override
    public Long getId() {
        return super.getId();
    }

    @Override
    public void setId(Long id) {
        super.setId(id);
    }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                ", isActive=" + isActive +
                ", id=" + id +
                '}';
    }
}
