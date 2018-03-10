package javase01.t06;
/**
 * The class describing a notebook.
 *
 * <p>
 *     The class {@code NoteBook} describes main functions
 *     and parameters of a notebook.
 * </p>
 *
 * @author Sergey Sarvarov
 */
public class NoteBook {

    Note[] notes;
    private static final int CAPACITY_OF_NOTEBOOK = 10;
    private int countOfNotes;

    /**
     * Constructor
     *
     */
    public NoteBook() {
        countOfNotes = 0;
        notes = new Note[CAPACITY_OF_NOTEBOOK];

        for (int i = 0; i < CAPACITY_OF_NOTEBOOK; i++)
            notes[i] = new Note();
    }

    /**
     * Add a note to the notebook.
     *
     * @param id - note identifier
     * @param title - message title
     * @param body - message body
     */
    public void addNote(int id, String title, String body) {
        notes[id].setId(id);
        notes[id].setTitle(title);
        notes[id].setBody(body);
        countOfNotes++;
    }

    /**
     * Replace the note with the following note.
     *
     * <p>
     *     If a note was deleted it needs to be replaced by
     *     the following note. Other following notes needs
     *     to be replaced too. Recursion is used
     *     for replacing of all notes in the notebook.
     * </p>
     *
     * @param id - note identifier
     */
    private void replaceTheNoteWithTheFollowingNote(int id) {
        notes[id].setId(notes[id + 1].getId());
        notes[id].setTitle(notes[id + 1].getTitle());
        notes[id].setBody(notes[id + 1].getBody());

        if (countOfNotes - 1 != id) {
            replaceTheNoteWithTheFollowingNote(id + 1);
        }
    }

    /**
     * Remove a note from the notebook.
     *
     * <p>
     *    @see NoteBook#replaceTheNoteWithTheFollowingNote(int id)
     * </p>
     *
     * @param id - note identifier
     */
    public void removeNote(int id) {
        replaceTheNoteWithTheFollowingNote(id);
        countOfNotes--;
    }

    /**
     * Edit a note of the notebook.
     *
     * @param id - note identifier
     * @param title - message title
     * @param body - message body
     */
    public void editNote(int id, String title, String body) {
        notes[id].setId(id);
        notes[id].setTitle(title);
        notes[id].setBody(body);
    }

    /**
     * Show all notes.
     *
     * <p>
     *     The function is used to display all notes.
     * </p>
     */
    public void showAllNotes() {
        for (int i = 0; i < countOfNotes; i++) {
            System.out.println(notes[i].getId() + " | " +
                    notes[i].getTitle() +
                    ": " +
                    notes[i].getBody());
        }
    }
}
