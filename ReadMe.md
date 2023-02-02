<h1>API automation framework using RestAssured.</h1>

<h2>Modules Used:</h2>
<ol>
<li>io.rest-assured </li> 
<li>Testng</li> 
<li> Log4J</li> 
</ol>
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
<ol>
<li>src->main (Main class files)</li>

<li>common -> contains all base classes (contains abstraction methods)</li>
<li>rest -> RestClient with all the rest methods(GET,POST,PUT,DELETE)</li>
<li>Extent Reports -> For generation of reports</li>
<li>helpers -> Contains all  helper classes</li>
<li>Utils -> all Utility Classed</li>
<li>src->test</li>
<li>TestBase-> base test class</li>
<li>LoginTests -> Contains all test classes having tests around login APIs</li>
</ol>
