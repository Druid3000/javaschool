package javase01.t06;

public class Test {
    public static void main(String[] args){
        NoteBook noteBook = new NoteBook();
        noteBook.addNote(0, "Запись", "Текст");
        noteBook.addNote(1, "Запись", "Текст");
        noteBook.addNote(2, "Запись", "Текст");
        noteBook.addNote(3, "Запись", "Текст");
        noteBook.addNote(4, "Запись", "Текст");

        noteBook.showAllNotes();

        System.out.println();

        noteBook.editNote(1, "Запись (отредактирована)", "Новый текст");
        noteBook.removeNote(3);
        noteBook.showAllNotes();
    }
}
