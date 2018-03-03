package javase01.t06;

//import javase01.t06.Note;
//Я хз, надо ли в таком случае импортить, ошибки-то нет.

public class NoteBook {
    //TODO По сути, нужно написать самому Arraylist. Как сказал Лапин, в этом задумка.
    //TODO не понял, можно ли заюзать Arraylist

    Note[] notes;
    private static final int CAPACITY_OF_NOTEBOOK = 10;
    private int countOfNotes;

    public NoteBook() {

        countOfNotes = 0;
        notes = new Note[CAPACITY_OF_NOTEBOOK];

        for (int i = 0; i < CAPACITY_OF_NOTEBOOK; i++)
            notes[i] = new Note();
    }

    public void addNote(int id, String title, String body) {
        notes[id].setId(id);
        notes[id].setTitle(title);
        notes[id].setBody(body);
        countOfNotes++;
    }

    private void replaceTheNoteWithTheFollowingNote(int id) {
        notes[id].setId(notes[id + 1].getId());
        notes[id].setTitle(notes[id + 1].getTitle());
        notes[id].setBody(notes[id + 1].getBody());

        if (countOfNotes - 1 != id) {
            replaceTheNoteWithTheFollowingNote(id + 1);
        }
    }

    public void removeNote(int id) {
        replaceTheNoteWithTheFollowingNote(id);
        countOfNotes--;
    }

    public void editNote(int id, String title, String body) {
        notes[id].setId(id);
        notes[id].setTitle(title);
        notes[id].setBody(body);
    }

    public void showAllNotes() {
        for (int i = 0; i < countOfNotes; i++) {
            System.out.println(notes[i].getId() + " | " +
                    notes[i].getTitle() +
                    ": " +
                    notes[i].getBody());
        }
    }
}
