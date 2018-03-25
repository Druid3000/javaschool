package javase03.t02;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceManager {
    private ResourceBundle resourceBundleAnswers;
    private ResourceBundle resourceBundleQuestions;
    private final String resourceNameAnswers = "answers";
    private final String resourceNameQuestions = "questions";

    public ResourceManager() {
        resourceBundleAnswers = ResourceBundle.getBundle
                (resourceNameAnswers, Locale.getDefault());
        resourceBundleQuestions = ResourceBundle.getBundle
                (resourceNameQuestions, Locale.getDefault());
    }

    public void changeLocale(Locale locale) {
        resourceBundleAnswers = ResourceBundle.getBundle
                (resourceNameAnswers, locale);
        resourceBundleQuestions = ResourceBundle.getBundle
                (resourceNameQuestions, locale);
    }

    public String getAnswer(String key) {
        return resourceBundleAnswers.getString(key);
    }

    public String getQuestion(String key) {
        return resourceBundleQuestions.getString(key);
    }

    public int getSizeOfQuestionsKeySet() {
        return resourceBundleQuestions.keySet().size();
    }

    public boolean isAnswersContainsKey(String key) {
        return resourceBundleAnswers.containsKey(key);
    }
}