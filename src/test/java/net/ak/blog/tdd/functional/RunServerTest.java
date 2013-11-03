package net.ak.blog.tdd.functional;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * @author Akira Koyasu <mail@akirakoyasu.net>
 */
public class RunServerTest {
    private static final String baseUrl = "http://localhost:8080";

    @Test
    public void serverShowsFirstPage() {
        ServerRunner.start();
        WebDriver driver = null;
        try {
            driver = new FirefoxDriver();
            driver.get(baseUrl);
            WebElement heading = driver.findElement(By.xpath("//h1"));
            assertThat(heading.getText(), equalTo("Welcome!"));
        } finally {
            if (driver != null) {
                driver.quit();
            }
            ServerRunner.stop();
        }
    }
}
