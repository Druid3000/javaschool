package javase01.t06;

/**
 * The class describing a note.
 * <p>
 * <p>
 * The class {@code Note} describes main functions
 * and parameters of a note.
 * <p>
 * </p>
 *
 * @author Sergey Sarvarov
 */
public class Note {

    private int id;
    private String title;
    private String body;

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }
}
