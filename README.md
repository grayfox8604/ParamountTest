# ParamountTest
- Written in Java using Selenium on IntelliJ
- To run all the tests at once, simply run the FullParamountTests.java file. You can also run tests individually from this file.
- To run a test independently, run the class associated to that test. 

In this project I wrote the tests in 2 different styles; as independent classes or as a single class using junit. The reason for this is to give a company options
on how to organize their testing strategy. Despite the styles, the overall structure is to use the Page Object Model to ensure that all elements are 
captured in their respected pages. This project has 3 pages distinct pages
1. Login page
2. Project main page
3. Project creation page

Given that the test are very simple, I focused all the Project page elements into one class to ensure that readability and context would be together. Should the 
project expand and the creation page gathered more elements, I would advise a seperate page.
