package javase05.t01;

import java.util.Scanner;
import static java.lang.System.in;

public class Test {

    public static void printHelp() {
        System.out.println("Usage of commands:\n" +
                "create /home/folder/text.txt - create text file in directory /home/folder\n" +
                "write text.txt               - add some new text to file text.txt in the folder /home/folder/\n" +
                "cat text.txt                 - print text of the file" +
                "cd ..       - change to upper directory\n" +
                "cd /home/   - change directory to /home\n" +
                "cd folder   - change directory to /home/folder\n" +
                "ls .        - list items of current directory\n" +
                "ls /home/   - list items of directory /home\n" +
                "rm text.txt - remove file text.txt" +
                "help        - show help menu\n" +
                "exit        - exit program\n");
    }

    public static void main(String[] args) {
        FileManager fileManager = new FileManager();

        String[] arguments;
        String input;
        boolean isWorking = true;

        System.out.println("Welcome! Input command. For help input command \"help\".");
        try (Scanner scanner = new Scanner(in)) {
            while (isWorking) {
                try {
                    input = scanner.nextLine();
                    arguments = input.split(" ");
                    switch (arguments[0]) {
                        case "ls":
                            fileManager.ls(arguments[1]);
                            break;
                        case "cd":
                            fileManager.cd(arguments[1]);
                            break;
                        case "rm":
                            fileManager.rm(arguments[1]);
                            break;
                        case "create":
                            System.out.println("Enter the text of the created file.");
                            fileManager.createFile(arguments[1], scanner.nextLine());
                            break;
                        case "write":
                            System.out.println("Enter the text that will be added to the file.");
                            fileManager.writeInFile(arguments[1], scanner.nextLine());
                            break;
                        case "cat":
                            fileManager.cat(arguments[1]);
                            break;
                        case "exit":
                            isWorking = false;
                            break;
                        case "help":
                            printHelp();
                            break;
                        default:
                            System.out.println("No such command");
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("You must enter the command and parameter");
                } catch (Exception e) {
                    System.out.println("Error" + e);
                }
            }
        }
    }
}
