package javase04.t04;

public class FilmCollection implements java.io.Serializable {
    private String title;
    private Set<Film> listOfFilms = new Set<>();

    public FilmCollection(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void addFilm(Film film){
        listOfFilms.put(film);
    }

    public void removeFilm(Film film){
        listOfFilms.remove(film);
    }

    @Override
    public String toString() {
        return "FilmCollection{" +
                "title='" + title + '\'' +
                ", listOfFilms=" + listOfFilms + "\n" +
                '}';
    }

    public void printInfo(){
        System.out.println("Title: " + title);
        System.out.println(" Object reference: " + super.toString());
        System.out.println(" List of Films " + listOfFilms);
    }
}
