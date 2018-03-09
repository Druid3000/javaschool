package javase01.t06;

public class Test {
    public static void main(String[] args){
        NoteBook noteBook = new NoteBook();
        noteBook.addNote(0, "Запись 0", "Запись 0");
        noteBook.addNote(1, "Запись 1", "Запись 1");
        noteBook.addNote(2, "Запись 2", "Запись 2");
        noteBook.addNote(3, "Запись 3", "Запись 3");
        noteBook.addNote(4, "Запись 4", "Запись 4");

        noteBook.showAllNotes();

        System.out.println();

        //noteBook.editNote(1, "Запись 2 (отреактирована)", "Новый текст");
        noteBook.removeNote(1);
        noteBook.showAllNotes();
    }
}
