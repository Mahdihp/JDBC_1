package entity;

public class BookEntity extends Entity<Integer> {

    private String name;
    private String isbn;
    private Integer writerId;

    public BookEntity() {
        super();
    }

    public BookEntity(String name, String isbn, Integer writerId) {
        this.name = name;
        this.isbn = isbn;
        this.writerId = writerId;
    }

    public BookEntity(Integer id, String name, String isbn, Integer writerId) {
        super(id);
        this.name = name;
        this.isbn = isbn;
        this.writerId = writerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getWriterId() {
        return writerId;
    }

    public void setWriterId(Integer writerId) {
        this.writerId = writerId;
    }

    @Override
    public String toString() {
        return "BookEntity{" +
                "name='" + name + '\'' +
                ", isbn='" + isbn + '\'' +
                ", writerId=" + writerId +
                "} " + super.toString();
    }
}
