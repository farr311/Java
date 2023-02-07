package lesson34.refl;

public class Event {

    private long id;

    public Event(long id) {
        this.id = id;
    }

    private long getId() {
        return id;
    }

    private void setId(long id) {
        this.id = id;
    }
}
