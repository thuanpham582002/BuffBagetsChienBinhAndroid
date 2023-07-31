import View.MainFrame;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        new MainFrame();
    }
}
