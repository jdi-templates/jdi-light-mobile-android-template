##This template contains jdi-light-mobile Android tests

###How to launch android tests

1) Stable requirements:
Java 8, Maven 3.6.3, TestNG 6.14.3, Appium 1.18.3, Android 10 <br>

2) Install Appium & Android studio for Android emulator

3) Install test-app on your emulator

4) _mvn clean install_ - to install project dependencies

5) Run tests by Maven command: 
`mvn clean test site -Dsuite.xml.file=src/test/resources/androidApps.xml`

6) Get allure report in target/site package
