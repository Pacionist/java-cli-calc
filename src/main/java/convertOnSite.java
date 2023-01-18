import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

class convertOnSite {

    public static String getNumber(String resultArabic) throws Exception {

        Document doc = getDoc(resultArabic);
        Element pcValue = doc.getElementById("dialogv6285503b9b9a9_roman");
        if (pcValue != null) {
            return pcValue.text();
        }
        return "";
    }

    public static Document getDoc(String resultArabic) throws IOException {
        String url = "https://planetcalc.ru/378/";
        String charset = "UTF-8";
        String query = String.format("dec=%s", URLEncoder.encode(resultArabic, charset));

        Logger.getLogger(PhantomJSDriverService.class.getName()).setLevel(Level.OFF);

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        String[] phantomArgs = {"--webdriver-loglevel=NONE"};

        LogManager.getLogManager().reset();
        Logger globalLogger = Logger.getLogger(java.util.logging.Logger.GLOBAL_LOGGER_NAME);
        globalLogger.setLevel(java.util.logging.Level.OFF);

        desiredCapabilities.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, phantomArgs);


        PhantomJSDriver driver = new PhantomJSDriver(desiredCapabilities);
        driver.setLogLevel(Level.OFF);
        driver.get(url + "?" + query);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.err.println("Вы прервали ожидание.");
        }
        String pageSource = driver.getPageSource();
        return Jsoup.parse(pageSource);
    }
}
