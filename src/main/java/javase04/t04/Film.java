package javase04.t04;

public class Film implements java.io.Serializable {
    private String title;
    private int yearOfIssue;
    private Set<Actor> cast = new Set<>();

    public Film(String title, int yearOfIssue) {
        this.title = title;
        this.yearOfIssue = yearOfIssue;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYearOfIssue() {
        return yearOfIssue;
    }

    public void setYearOfIssue(int yearOfIssue) {
        this.yearOfIssue = yearOfIssue;
    }

    public void addActor(Actor actor) {
        cast.put(actor);
    }

    public void removeActor(Actor actor) {
        cast.remove(actor);
    }

    @Override
    public String toString() {
        return "Film{" +
                "title='" + title + '\'' +
                ", yearOfIssue=" + yearOfIssue +
                ", cast=" + cast +
                '}';
    }
}
