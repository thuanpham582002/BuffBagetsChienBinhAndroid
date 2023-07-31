package Application;

import View.MainFrame;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Controller {
    private List<String> url_badges = new ArrayList<>();
    private List<AnswerMapsData> answerMaps = new ArrayList<>();

    public Controller() {
        answerMaps = IOFile.getInstance().read("answerMaps.DAT");
        url_badges.add("https://developer.android.com/courses/quizzes/android-basics-compose-unit-1-pathway-1/android-basics-compose-unit-1-pathway-1?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-compose-unit-1-pathway-1%23quiz-%2Fcourses%2Fquizzes%2Fandroid-basics-compose-unit-1-pathway-1%2Fandroid-basics-compose-unit-1-pathway-1");
        url_badges.add("https://developer.android.com/courses/quizzes/android-basics-compose-unit-1-pathway-2/android-basics-compose-unit-1-pathway-2?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-compose-unit-1-pathway-2%23quiz-%2Fcourses%2Fquizzes%2Fandroid-basics-compose-unit-1-pathway-2%2Fandroid-basics-compose-unit-1-pathway-2");
        url_badges.add("https://developer.android.com/courses/quizzes/android-basics-compose-unit-1-pathway-3/android-basics-compose-unit-1-pathway-3?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-compose-unit-1-pathway-3%23quiz-%2Fcourses%2Fquizzes%2Fandroid-basics-compose-unit-1-pathway-3%2Fandroid-basics-compose-unit-1-pathway-3");
        url_badges.add("https://developer.android.com/courses/quizzes/android-basics-compose-unit-2-pathway-1/android-basics-compose-unit-2-pathway-1?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-compose-unit-2-pathway-1%23quiz-%2Fcourses%2Fquizzes%2Fandroid-basics-compose-unit-2-pathway-1%2Fandroid-basics-compose-unit-2-pathway-1");
        url_badges.add("https://developer.android.com/courses/quizzes/android-basics-compose-unit-2-pathway-2/android-basics-compose-unit-2-pathway-2?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-compose-unit-2-pathway-2%23quiz-%2Fcourses%2Fquizzes%2Fandroid-basics-compose-unit-2-pathway-2%2Fandroid-basics-compose-unit-2-pathway-2");
        url_badges.add("https://developer.android.com/courses/quizzes/android-basics-compose-unit-2-pathway-3/android-basics-compose-unit-2-pathway-3?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-compose-unit-2-pathway-3%23quiz-%2Fcourses%2Fquizzes%2Fandroid-basics-compose-unit-2-pathway-3%2Fandroid-basics-compose-unit-2-pathway-3");
        url_badges.add("https://developer.android.com/courses/quizzes/android-basics-compose-unit-3-pathway-1/android-basics-compose-unit-3-pathway-1?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-compose-unit-3-pathway-1%23quiz-%2Fcourses%2Fquizzes%2Fandroid-basics-compose-unit-3-pathway-1%2Fandroid-basics-compose-unit-3-pathway-1");
        url_badges.add("https://developer.android.com/courses/quizzes/android-basics-compose-unit-3-pathway-2/android-basics-compose-unit-3-pathway-2?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-compose-unit-3-pathway-2%23quiz-%2Fcourses%2Fquizzes%2Fandroid-basics-compose-unit-3-pathway-2%2Fandroid-basics-compose-unit-3-pathway-2");
        url_badges.add("https://developer.android.com/courses/quizzes/android-basics-compose-unit-3-pathway-3/android-basics-compose-unit-3-pathway-3?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-compose-unit-3-pathway-3%23quiz-%2Fcourses%2Fquizzes%2Fandroid-basics-compose-unit-3-pathway-3%2Fandroid-basics-compose-unit-3-pathway-3");
        url_badges.add("https://developer.android.com/courses/quizzes/android-basics-compose-unit-4-pathway-1/android-basics-compose-unit-4-pathway-1?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-compose-unit-4-pathway-1%23quiz-%2Fcourses%2Fquizzes%2Fandroid-basics-compose-unit-4-pathway-1%2Fandroid-basics-compose-unit-4-pathway-1");
        url_badges.add("https://developer.android.com/courses/quizzes/android-basics-compose-unit-4-pathway-2/android-basics-compose-unit-4-pathway-2?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-compose-unit-4-pathway-2%23quiz-%2Fcourses%2Fquizzes%2Fandroid-basics-compose-unit-4-pathway-2%2Fandroid-basics-compose-unit-4-pathway-2");
        url_badges.add("https://developer.android.com/courses/quizzes/android-basics-compose-unit-4-pathway-3/android-basics-compose-unit-4-pathway-3?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-compose-unit-4-pathway-3%23quiz-%2Fcourses%2Fquizzes%2Fandroid-basics-compose-unit-4-pathway-3%2Fandroid-basics-compose-unit-4-pathway-3");
        url_badges.add("https://developer.android.com/courses/quizzes/android-basics-compose-unit-5-pathway-1/android-basics-compose-unit-5-pathway-1?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-compose-unit-5-pathway-1%23quiz-%2Fcourses%2Fquizzes%2Fandroid-basics-compose-unit-5-pathway-1%2Fandroid-basics-compose-unit-5-pathway-1");
        url_badges.add("https://developer.android.com/courses/quizzes/android-basics-compose-unit-5-pathway-2/android-basics-compose-unit-5-pathway-2?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-compose-unit-5-pathway-2%23quiz-%2Fcourses%2Fquizzes%2Fandroid-basics-compose-unit-5-pathway-2%2Fandroid-basics-compose-unit-5-pathway-2");
        url_badges.add("https://developer.android.com/courses/quizzes/android-basics-compose-unit-6-pathway-1/android-basics-compose-unit-6-pathway-1?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-compose-unit-6-pathway-1%23quiz-%2Fcourses%2Fquizzes%2Fandroid-basics-compose-unit-6-pathway-1%2Fandroid-basics-compose-unit-6-pathway-1");
        url_badges.add("https://developer.android.com/courses/quizzes/android-basics-compose-unit-6-pathway-2/android-basics-compose-unit-6-pathway-2?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-compose-unit-6-pathway-2%23quiz-%2Fcourses%2Fquizzes%2Fandroid-basics-compose-unit-6-pathway-2%2Fandroid-basics-compose-unit-6-pathway-2");
        url_badges.add("https://developer.android.com/courses/quizzes/android-basics-compose-unit-6-pathway-3/android-basics-compose-unit-6-pathway-3?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-compose-unit-6-pathway-3%23quiz-%2Fcourses%2Fquizzes%2Fandroid-basics-compose-unit-6-pathway-3%2Fandroid-basics-compose-unit-6-pathway-3");
        url_badges.add("https://developer.android.com/courses/quizzes/android-basics-compose-unit-7-pathway-1/android-basics-compose-unit-7-pathway-1?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-compose-unit-7-pathway-1%23quiz-%2Fcourses%2Fquizzes%2Fandroid-basics-compose-unit-7-pathway-1%2Fandroid-basics-compose-unit-7-pathway-1");
        url_badges.add("https://developer.android.com/courses/quizzes/android-basics-compose-unit-8-pathway-1/android-basics-compose-unit-8-pathway-1?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-compose-unit-8-pathway-1%23quiz-%2Fcourses%2Fquizzes%2Fandroid-basics-compose-unit-8-pathway-1%2Fandroid-basics-compose-unit-8-pathway-1");
        url_badges.add("https://developer.android.com/courses/quizzes/android-basics-compose-unit-8-pathway-2/android-basics-compose-unit-8-pathway-2?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-compose-unit-8-pathway-2%23quiz-%2Fcourses%2Fquizzes%2Fandroid-basics-compose-unit-8-pathway-2%2Fandroid-basics-compose-unit-8-pathway-2");
        url_badges.add("https://developer.android.com/courses/quizzes/jetpack-compose-for-android-developers-1/jetpack-compose-for-android-developers-1?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fjetpack-compose-for-android-developers-1%23quiz-%2Fcourses%2Fquizzes%2Fjetpack-compose-for-android-developers-1%2Fjetpack-compose-for-android-developers-1");
        url_badges.add("https://developer.android.com/courses/quizzes/jetpack-compose-for-android-developers-2/jetpack-compose-for-android-developers-2?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fjetpack-compose-for-android-developers-2%23quiz-%2Fcourses%2Fquizzes%2Fjetpack-compose-for-android-developers-2%2Fjetpack-compose-for-android-developers-2");
        url_badges.add("https://developer.android.com/courses/quizzes/jetpack-compose-for-android-developers-3/jetpack-compose-for-android-developers-3?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fjetpack-compose-for-android-developers-3%23quiz-%2Fcourses%2Fquizzes%2Fjetpack-compose-for-android-developers-3%2Fjetpack-compose-for-android-developers-3");
        url_badges.add("https://developer.android.com/courses/quizzes/jetpack-compose-for-android-developers-4/jetpack-compose-for-android-developers-4?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fjetpack-compose-for-android-developers-4%23quiz-%2Fcourses%2Fquizzes%2Fjetpack-compose-for-android-developers-4%2Fjetpack-compose-for-android-developers-4");
        url_badges.add("https://developer.android.com/courses/quizzes/jetpack-compose-for-android-developers-5/jetpack-compose-for-android-developers-5?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fjetpack-compose-for-android-developers-5%23quiz-%2Fcourses%2Fquizzes%2Fjetpack-compose-for-android-developers-5%2Fjetpack-compose-for-android-developers-5");
    }

    public void tryGetBadge() {
        try {
            answerMaps.clear();
            Profile profile = new Profile(false);
            for (String url : url_badges) {
                answerMaps.add(profile.tryGetBadges(url));
                IOFile.getInstance().write("answerMaps.DAT", answerMaps);
            }
            profile.close();
            MainFrame.jTextField1.setText("Done tryGetBadge");
        } catch (Exception e) {
            MainFrame.jTextField1.setText("Error: " + e.getMessage());
        }
    }

    public void submit() {
        try {
            Profile profile = new Profile(true);
            System.out.println("Profile created");
            for (int i = 0; i < answerMaps.size(); i++) {
                System.out.println("Profile created");
                profile.submit(url_badges.get(i), answerMaps.get(i).listAnswer);
            }
            profile.close();
            MainFrame.jTextField1.setText("Done submit");
        } catch (Exception e) {
            MainFrame.jTextField1.setText("Error: " + e.getMessage());
        }
    }
}
