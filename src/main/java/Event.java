public class Event extends Task {

    protected String at;

    public Event(String description, String at) {
        super(description);
        this.at = at;
    }

    @Override
    public String getType() {
        return "[E]";
    }

    @Override
    public String getAddedInfo() {
        return " (at: " + at + ")";
    }
}
