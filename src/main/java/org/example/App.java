package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.*;
import java.util.stream.Collectors;

public class App {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "./chromedriver");
        WebDriver webDriver = new ChromeDriver();

        try {
            webDriver.get("https://www.papercdcase.com/index.php");
            fillForm(webDriver);
            selectOptions(webDriver);
            submitForm(webDriver);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            webDriver.quit();
        }
    }

    private static void fillForm(WebDriver webDriver) throws InterruptedException {
        Map<String, String> xPaths = getXPaths();
        Map<String, String> values = getValues();

        Set<String> textFields = xPaths.keySet().stream()
                .filter(item -> !List.of("Paper", "Type", "CreateBtn").contains(item))
                .collect(Collectors.toSet());

        for (String key : textFields) {
            String xPath = xPaths.get(key);
            String value = values.get(key);
            webDriver.findElement(By.xpath(xPath)).sendKeys(value);

            Thread.sleep(100);
        }
    }

    private static void selectOptions(WebDriver webDriver) {
        Map<String, String> xPaths = getXPaths();

        webDriver.findElement(By.xpath(xPaths.get("Type"))).click();
        webDriver.findElement(By.xpath(xPaths.get("Paper"))).click();
    }

    private static void submitForm(WebDriver webDriver) {
        Map<String, String> xPaths = getXPaths();

        webDriver.findElement(By.xpath(xPaths.get("CreateBtn"))).click();
    }

    private static Map<String, String> getXPaths() {
        return new HashMap<>() {{
            put("Artist", "/html/body/table[2]/tbody/tr/td[1]/div/form/table/tbody/tr[1]/td[2]/input");
            put("Title", "/html/body/table[2]/tbody/tr/td[1]/div/form/table/tbody/tr[2]/td[2]/input");

            put("Track1", "/html/body/table[2]/tbody/tr/td[1]/div/form/table/tbody/tr[3]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[1]/td[2]/input");
            put("Track2", "/html/body/table[2]/tbody/tr/td[1]/div/form/table/tbody/tr[3]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/input");
            put("Track3", "/html/body/table[2]/tbody/tr/td[1]/div/form/table/tbody/tr[3]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[3]/td[2]/input");
            put("Track4", "/html/body/table[2]/tbody/tr/td[1]/div/form/table/tbody/tr[3]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[4]/td[2]/input");
            put("Track5", "/html/body/table[2]/tbody/tr/td[1]/div/form/table/tbody/tr[3]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[5]/td[2]/input");
            put("Track6", "/html/body/table[2]/tbody/tr/td[1]/div/form/table/tbody/tr[3]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[6]/td[2]/input");
            put("Track7", "/html/body/table[2]/tbody/tr/td[1]/div/form/table/tbody/tr[3]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[7]/td[2]/input");
            put("Track8", "/html/body/table[2]/tbody/tr/td[1]/div/form/table/tbody/tr[3]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[8]/td[2]/input");

            put("Track9", "/html/body/table[2]/tbody/tr/td[1]/div/form/table/tbody/tr[3]/td[2]/table/tbody/tr/td[2]/table/tbody/tr[1]/td[2]/input");
            put("Track10", "/html/body/table[2]/tbody/tr/td[1]/div/form/table/tbody/tr[3]/td[2]/table/tbody/tr/td[2]/table/tbody/tr[2]/td[2]/input");
            put("Track11", "/html/body/table[2]/tbody/tr/td[1]/div/form/table/tbody/tr[3]/td[2]/table/tbody/tr/td[2]/table/tbody/tr[3]/td[2]/input");
            put("Track12", "/html/body/table[2]/tbody/tr/td[1]/div/form/table/tbody/tr[3]/td[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td[2]/input");
            put("Track13", "/html/body/table[2]/tbody/tr/td[1]/div/form/table/tbody/tr[3]/td[2]/table/tbody/tr/td[2]/table/tbody/tr[5]/td[2]/input");
            put("Track14", "/html/body/table[2]/tbody/tr/td[1]/div/form/table/tbody/tr[3]/td[2]/table/tbody/tr/td[2]/table/tbody/tr[6]/td[2]/input");
            put("Track15", "/html/body/table[2]/tbody/tr/td[1]/div/form/table/tbody/tr[3]/td[2]/table/tbody/tr/td[2]/table/tbody/tr[7]/td[2]/input");
            put("Track16", "/html/body/table[2]/tbody/tr/td[1]/div/form/table/tbody/tr[3]/td[2]/table/tbody/tr/td[2]/table/tbody/tr[8]/td[2]/input");

            put("Type", "/html/body/table[2]/tbody/tr/td[1]/div/form/table/tbody/tr[4]/td[2]/input[2]");
            put("Paper", "/html/body/table[2]/tbody/tr/td[1]/div/form/table/tbody/tr[5]/td[2]/input[2]");

            put("Force", "/html/body/table[2]/tbody/tr/td[1]/div/form/table/tbody/tr[7]/td[2]/input");
            put("CreateBtn", "/html/body/table[2]/tbody/tr/td[1]/div/form/p/input");
        }};
    }

    private static Map<String, String> getValues() {
        return new HashMap<>() {{
            put("Artist", "Hello");
            put("Title", "hello track programmers");

            put("Track1", "hello from python");
            put("Track2", "hello from java");
            put("Track3", "hello from rust");
            put("Track4", "hello from c++");
            put("Track5", "hello from php");
            put("Track6", "hello from javascript");
            put("Track7", "hello from typescript");
            put("Track8", "hello from erlang");

            put("Track9", "hello from logica");
            put("Track10", "hello from go");
            put("Track11", "hello from ruby");
            put("Track12", "hello from pascal");
            put("Track13", "hello from scala");
            put("Track14", "hello from sql");
            put("Track15", "hello from rabbitmq");
            put("Track16", "hello from docker");
            put("Force", "1");
        }};
    }
}
