package entity;

public class WriterEntity extends Entity<Integer> {

    private String name;
    private int age;
    private String style;

    public WriterEntity() {
        super();
    }

    public WriterEntity(String name, int age, String style) {
        this.name = name;
        this.age = age;
        this.style = style;
    }

    public WriterEntity(Integer id, String name, int age, String style) {
        super(id);
        this.name = name;
        this.age = age;
        this.style = style;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    @Override
    public String toString() {
        return "WriterEntity{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", style='" + style + '\'' +
                "} " + super.toString();
    }
}
