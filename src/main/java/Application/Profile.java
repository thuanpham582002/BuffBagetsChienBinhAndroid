package Application;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.swing.*;
import java.util.*;

public class Profile {
    private WebDriver driver;

    public Profile(boolean isDefault) {
        driver = loadProfile(isDefault);
    }

    private WebDriver loadProfile(boolean isDefault) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-gpu");
        if (isDefault) {
            String username = System.getProperty("user.name");
            options.addArguments("user-data-dir=" + "C:\\Users\\" + username + "\\AppData\\Local\\Google\\Chrome\\User Data");
            // use profile 1
            options.addArguments("--disable-extensions");
        }

        try {
            WebDriver driver = new ChromeDriver(options);
            return driver;
        } catch (SessionNotCreatedException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Profile is not loaded\nPlease check chrome version");
        } catch (WebDriverException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Profile is not loaded\nPlease turn off all other chrome of this profile processes");
        }
        return null;
    }

    public AnswerMapsData tryGetBadges(String url) {
        driver.get(url);
        List<WebElement> answers = driver.findElements(By.className("devsite-quiz-question"));
        List<List<Integer>> listAnswer = new ArrayList<>();
        System.out.println(answers.size());
        Map<WebElement, List<WebElement>> answerMap = new HashMap<>();
        for (int i = 0; i < answers.size(); i++) {
            WebElement answer = answers.get(i);
            listAnswer.add(new ArrayList<>());
            List<WebElement> answerList = answer.findElements(By.className("devsite-quiz-answer"));
            System.out.println(answer.getAttribute("data-index") + " " + "answerList  :" + answerList.size());
            for (int j = 0; j < answerList.size(); j++) {
                listAnswer.get(i).add(j);
            }
            answerMap.put(answer, answerList);
        }

        System.out.println("answerMap size: " + answerMap.size());

        while (true) {
            int check = 0;
            for (WebElement answer : answerMap.keySet()) {
                List<WebElement> answerList = answerMap.get(answer);
                for (WebElement answerItem : answerList) {
                    try {
                        answerItem.findElement(By.xpath("./input")).sendKeys(Keys.SPACE);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
            }

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            try {
                driver.findElement(By.xpath("//*[@id=\"gc-wrapper\"]/main/devsite-content/article/div[2]/devsite-quiz/form/button")).sendKeys(Keys.SPACE);
                Thread.sleep(5000);
            } catch (Exception e) {
                System.out.println("Submit error" + e.getMessage());
            }
            for (WebElement answer : answerMap.keySet()) {
                int d = Integer.parseInt(answer.getAttribute("data-index"));
                List<WebElement> answerList = answerMap.get(answer);
                List<WebElement> wrongAnswerList = new ArrayList<>();
                List<Integer> wrongAnswerListIndex = new ArrayList<>();
                for (int i = 0; i < answerList.size(); i++) {
                    WebElement answerItem = answerList.get(i);
                    System.out.println("answerItem: " + d + " " + answerItem.getAttribute("data-index"));
                    if (answerItem.findElement(By.xpath("./input")).getAttribute("class").contains("error")) {
                        wrongAnswerList.add(answerItem);
                        wrongAnswerListIndex.add(i);
                        check = 1;
                    }
                }
                answerList.removeAll(wrongAnswerList);
                for (int i = wrongAnswerListIndex.size() - 1; i >= 0; i--) {
                    Integer answerListIndex = wrongAnswerListIndex.get(i);
                    System.out.println("answerListIndex: " + answerListIndex + " " + d + " " + listAnswer.get(d).size());
                    listAnswer.get(d).remove((int) answerListIndex);
                }

                answerMap.put(answer, answerList);
            }

//            for (Map.Entry<WebElement, List<WebElement>> webElementListEntry : answerMap.entrySet()) {
//                Map.Entry pair = (Map.Entry) webElementListEntry;
//                WebElement answer = (WebElement) pair.getKey();
//                List<WebElement> answerList = (List<WebElement>) pair.getValue();
//                List<WebElement> wrongAnswerList = new ArrayList<>();
//                for (WebElement answerItem : answerList) {
//                    if (answerItem.findElement(By.xpath("./input")).getAttribute("class").contains("error")) {
//                        wrongAnswerList.add(answerItem);
//                        check = 1;
//                    }
//                }
//                answerList.removeAll(wrongAnswerList);
//                answerMap.put(answer, answerList);
//            }

            if (check == 0) {
                break;
            } else {
                try {
                    driver.findElement(By.xpath("//*[@id=\"gc-wrapper\"]/main/devsite-content/article/div[2]/devsite-quiz/footer/section/div/div/button")).sendKeys(Keys.SPACE);
                    Thread.sleep(5000);
                } catch (Exception e) {
                    System.out.println("Error at retry" + e.getMessage());
                }
            }
        }
        return new AnswerMapsData(listAnswer);
    }

    public void submit(String url, List<List<Integer>> listAnswer) {
        driver.get(url);
        List<WebElement> answers = driver.findElements(By.className("devsite-quiz-question"));
        System.out.println(answers.size());
        Map<WebElement, List<WebElement>> answerMap = new HashMap<>();
        for (int i = 0; i < answers.size(); i++) {
            WebElement answer = answers.get(i);
            List<WebElement> answerList = answer.findElements(By.className("devsite-quiz-answer"));
            System.out.println(answer.getAttribute("data-index") + " " + "answerList  :" + answerList.size());
            for (int j = 0; j < answerList.size(); j++) {
            }
            answerMap.put(answer, answerList);
        }

        System.out.println("answerMap size: " + answerMap.size());
        for (WebElement answer : answerMap.keySet()) {
            int d = Integer.parseInt(answer.getAttribute("data-index"));
            List<WebElement> answerList = answerMap.get(answer);
            for (int i = 0; i < listAnswer.get(d).size(); i++) {
                answerList.get(listAnswer.get(d).get(i)).findElement(By.xpath("./input")).sendKeys(Keys.SPACE);
            }
        }

        try {
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@id=\"gc-wrapper\"]/main/devsite-content/article/div[2]/devsite-quiz/form/button")).sendKeys(Keys.SPACE);
            Thread.sleep(5000);
        } catch (Exception e) {
            System.out.println("Submit error" + e.getMessage());
        }
    }

    public void close() {
        driver.quit();
    }
}
