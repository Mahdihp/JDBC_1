package entity;

public abstract class Entity<I> {

    private I id;

    public Entity(I id) {
        this.id = id;
    }

    public Entity() {
    }

    public I getId() {
        return id;
    }

    public void setId(I id) {
        this.id = id;
    }
}
