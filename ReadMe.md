<h1>API automation framework using RestAssured.</h1>

<h2>Modules Used:</h2>
* io.rest-assured 
* Testng
* Log4J

<h2>Run Configuration:</h2>
To run entire suite:
<code>
<PATH>/RancherAPIAutomation/suitefiles/testng.xml -ea -Denv.type=QA
</code>

Environment Params: QA/Prod/Pre-QA ..etc

To run individual TestClass:
<code>
<PATH>/RancherAPIAutomation/src/test/java/LoginTests/LoginTests -ea -Denv.type=QA
</code>
<h2>Folder Structure:</h2>
src->main (Main class files)

common -> contains all base classes (contains abstraction methods)
rest -> RestClient with all the rest methods(GET,POST,PUT,DELETE)
Extent Reports -> For generation of reports
helpers -> Contains all  helper classes
Utils -> all Utility Classed
src->test
TestBase-> base test class
LoginTests -> Contains all test classes having tests around login API's
