package Model;

public class Unit extends Base{

    private String name;

    public Unit() {
    }

    public Unit(String name) {
        this.name = name;
    }

    public Unit(Long id) {
        super.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Long getId() {
        return super.getId();
    }

    @Override
    public void setId(Long id) {
        super.setId(id);
    }
}
