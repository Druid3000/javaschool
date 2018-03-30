package javase04.t04;


import java.io.*;

public class Test {
    public static void main(String[] args) {
        Actor stallone = new Actor("Sylvester", "Stallone");
        Actor schwarzenegger = new Actor("Arnold", "Schwarzenegger");

        Film firstBlood = new Film("First Blood", 1982);
        firstBlood.addActor(stallone);

        Film terminator = new Film("Terminator", 1984);
        terminator.addActor(schwarzenegger);

        Film escapePlan = new Film("Escape Plan", 2013);
        escapePlan.addActor(stallone);
        escapePlan.addActor(schwarzenegger);

        FilmCollection filmCollection = new FilmCollection("Film Collection");
        filmCollection.addFilm(firstBlood);
        filmCollection.addFilm(terminator);
        filmCollection.addFilm(escapePlan);

        filmCollection.printInfo();

        String fileName = "src/main/java/javase04/t04/filmCollection.txt";

        try{
            FileOutputStream os = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(os);

            filmCollection.setTitle("Deserialized film collection");
            filmCollection.removeFilm(escapePlan);
            stallone.setName("Ivan");
            schwarzenegger.setName("Anton");

            oos.writeObject(filmCollection);
            oos.close();
            os.close();

            System.out.println("\nRead objects:");
            FileInputStream is = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(is);

            while(is.available() > 0){
                FilmCollection newFilmCollection = (FilmCollection) ois.readObject();
                newFilmCollection.printInfo();
            }

        } catch (ClassNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}

