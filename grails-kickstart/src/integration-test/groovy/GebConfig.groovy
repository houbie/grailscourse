import org.openqa.selenium.chrome.ChromeDriver

driver = {
    System.setProperty('webdriver.chrome.driver', '/Users/ivo/dev/chromedriver')
    return new ChromeDriver()
}

baseUrl = 'http://localhost:8080'
reportsDir = 'build/reports/geb'