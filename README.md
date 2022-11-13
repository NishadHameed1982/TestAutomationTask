# TestAutomationTask
Test Aitomation Task by Nishad Hameed

# Test Automation Framework

|**IntelliJ IDEA**|**Java**|**Cucumber BDD**|**Selenium**|**Junit**|**Serenity**|
| :----: | :----: | :----: | :----: | :----: |  :----: | 
|[<img width="50" height="50" src="https://github.com/NishadHameed1982/TestAutomationTask/blob/master/logos/IntelliJ.png">](https://www.jetbrains.com/idea/)|[<img height="60" src="https://github.com/NishadHameed1982/TestAutomationTask/blob/master/logos/Java.png">](https://www.oracle.com/java/technologies/java-se-glance.html)|[<img height="60" src="https://github.com/NishadHameed1982/TestAutomationTask/blob/master/logos/Cucumber.png">](https://cucumber.io/tools/cucumber-open/)|[<img height="60" src="https://github.com/NishadHameed1982/TestAutomationTask/blob/master/logos/SeleniumWebdriver.png">](https://www.selenium.dev/)|[<img height="45" src="https://github.com/NishadHameed1982/CanadaCargoesCommunityVBS/blob/main/Logos/Junit5.png">](https://junit.org/junit5/docs/current/user-guide/)|[<img height="60" src="https://github.com/NishadHameed1982/TestAutomationTask/blob/master/logos/SerenityBDD.png">](https://github.com/serenity-bdd)|

✔ Created using Java Serenity BDD framework for API tasks.<br/>

### Prerequisites
✔ Maven version 3 or above and JDK version 11 or above are already installed on the host machine.<br/>

### Limitations
✔ Framework design, readability and documentation areas are given higher priority over broader test coverage.<br/>

### Executing the tests
Ensure you are in the project root directory and run the following command from the command line.<br/>

To execute all the API tests
```
mvn clean verify
```
Once executed, the Full Report will be stored in this path target/site/serenity/index.html
Also Single Page HTML Summary will be saved in target/site/serenity/serenity-summary.html

Run the following command from the root directory to view the result after execution. <br/>
On Windows:<br/>
```
start target/site/serenity/index.html
```

On Mac:<br/>
```
open target/site/serenity/index.html
```
### Environment-specific configurations and other default configs
Application's environments are configured in the test/resources/serenity.conf file so that the tests can be run in different environments.

### Other libraries used in the framework
✔ Assertj - To assert the tests. Soft assertions are used where multiple assertions are present to see all passing assertions along with the failed ones.<br/>

