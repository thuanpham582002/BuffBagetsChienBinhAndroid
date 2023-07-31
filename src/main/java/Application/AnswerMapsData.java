package Application;

import org.openqa.selenium.WebElement;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AnswerMapsData implements Serializable {
    public List<List<Integer>> listAnswer = new ArrayList<>();
    public AnswerMapsData() {
    }

    public AnswerMapsData(List<List<Integer>> listAnswer) {
        this.listAnswer = listAnswer;
    }
}
