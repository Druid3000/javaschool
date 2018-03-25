package javase03.t02;

import java.util.Locale;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

        ResourceManager resourceManager = new ResourceManager();

        System.out.println("Press key 1 to select english or key 2 to select russian");

        Scanner in = new Scanner(System.in);
        switch (in.nextInt()) {
            case 1:
                resourceManager.changeLocale(new Locale("en", "US"));
                break;
            case 2:
                resourceManager.changeLocale(new Locale("ru", "RU"));
                break;
            default:
                resourceManager.changeLocale(Locale.getDefault());
                System.out.println("Selected default language");
        }

        for (int i = 1; i <= resourceManager.getSizeOfQuestionsKeySet(); i++) {
            System.out.println(i + " - " + resourceManager.getQuestion(String.valueOf(i)));
        }

        String answerNumber;
        answerNumber = in.next();

        if (resourceManager.isAnswersContainsKey(answerNumber)) {
            System.out.println(resourceManager.getAnswer(answerNumber));
        } else {
            System.out.println("No matches for this key");
        }
    }
}
