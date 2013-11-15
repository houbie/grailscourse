package groovykickstart.showcase;


import java.util.regex.Pattern;

public class Message_v2 {
    private String to;
    private String from;
    private String title;
    private String body;
    private String reference;
    private boolean reply;

    public Message_v2() {
    }

    public Message_v2(String to, String from, String title, String body) {
        this.to = to;
        this.from = from;
        this.title = title;
        this.body = body;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        if (title != null) {
            reply = Pattern.compile("^\\s*RE\\s*:?").matcher(title).find();
        } else {
            reply = false;
        }
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public boolean isReply() {
        return reply;
    }

    @Override
    public String toString() {
        return "JMessage{" +
                "to='" + to + '\'' +
                ", from='" + from + '\'' +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", reply=" + reply +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Message_v2 message = (Message_v2) o;

        if (body != null ? !body.equals(message.body) : message.body != null) return false;
        if (from != null ? !from.equals(message.from) : message.from != null) return false;
        if (title != null ? !title.equals(message.title) : message.title != null) return false;
        if (to != null ? !to.equals(message.to) : message.to != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = to != null ? to.hashCode() : 0;
        result = 31 * result + (from != null ? from.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (body != null ? body.hashCode() : 0);
        return result;
    }
}
