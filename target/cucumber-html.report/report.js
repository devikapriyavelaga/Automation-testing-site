$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("C:/Users/user/eclipse-workspace/AutomationTestingSite/src/test/resources/features/Readmore.feature");
formatter.feature({
  "line": 1,
  "name": "Readmore about a book",
  "description": "",
  "id": "readmore-about-a-book",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "Read more about a book",
  "description": "",
  "id": "readmore-about-a-book;read-more-about-a-book",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 2,
      "name": "@Readmore"
    }
  ]
});
formatter.step({
  "line": 4,
  "name": "the user launches the app in browser",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "user clicks on Shop",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "user clicks Read more",
  "keyword": "Then "
});
formatter.step({
  "line": 7,
  "name": "I validate the outcomes of Read more",
  "keyword": "Then "
});
formatter.match({
  "location": "ReadmoreTest.the_user_launches_the_app_in_browser()"
});
formatter.result({
  "duration": 28708904257,
  "status": "passed"
});
formatter.match({
  "location": "ReadmoreTest.user_clicks_on_Shop()"
});
formatter.result({
  "duration": 30878572762,
  "status": "passed"
});
formatter.match({
  "location": "ReadmoreTest.user_clicks_Read_more()"
});
formatter.result({
  "duration": 6564362556,
  "status": "passed"
});
formatter.match({
  "location": "ReadmoreTest.i_validate_the_outcomes_of_Read_more()"
});
formatter.result({
  "duration": 13591352428,
  "status": "passed"
});
});