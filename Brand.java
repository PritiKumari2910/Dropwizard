public class Brand {

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Brand(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    private final Long id;
    private final String name;

}
