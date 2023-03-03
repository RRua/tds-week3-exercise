#  Tópicos de Desenvolvimento de Software

## Week 3

### Requirements:
- Android SDK and Android Studio
- Android device (or emulator) with enabled developer options
- Sample app

### Objectives:
- Implement and manipulate classes designed with typical Android Design Patterns;
- Implement App architecture patterns in Android;
- Explore static analysis tools to detect and refactor code issues;
- Understand the fundamentals of native Android development:

#### Exercise 1


This exercise requires using and constructing an application that is illustrative of typical Android development patterns. It was developed in Java and built using the Gradle build system. It presents several types of views/screens (Activities and Fragments) that are defined in XML format and loaded and transformed through Java classes. Each Java class extending an Activity or Fragment represents a part of the UI of the application. This demo application is a very simple soccer quiz, that loads a set of questions (transformed into Question models) from a questions.json file that is located in a specific resources directory (res/raw). These questions also contain associated images, which are contained in the /res/drawable folder. 


1. Open the Sample App project with Android Studio and try to execute the app on your device. Verify that the app runs without problems. Inspect the source code and verify what components correspond to each view being displayed on the system. Hint: inspect the app navigation graph.

2. The RecyclerView component efficiently displays lists of items (ViewHolders). It reuses each one of the ViewHolders being displayed on the screen, avoid to create new instances every time a user scrolls through the item list. To be able to display any type of View in a listable format and know what to place in each item requires the development of a custom RecyclerView.Adapter classes allow adapting lists of items to be displayed to the existing views. Classes extending must implement the methods onCreateViewHolder and onBindViewHolder, which define what to create every time an item has to be created (View Holder) and how to adapt each item to display to the View Holder instance. Complete the onBindViewHolder method according to the instructions contained in the comments of the method.


#### Exercise 2

1. In this app, the UI and Business logic is tightly coupled, since the QuestionListFragment directly manages and interacts with the Model (Question class). Separate these concerns by using the ViewModel (AndroidViewModel class) to separate UI logic from Business Logic. 

#### Exercise 3

1. This application contains several performance smells reported in the literature. These smells can be identified manually, through the Lint tool that is used by the Android Studio. The application contains several smells in its source code. Identify the smells contained in the application and refactor the smells according to the suggestions given by the Android Studio 

2. In addition to the code smells that can be found, major performance improvements can be added through simple refactorings. Identify some of the app bottlenecks and perform refactors to repair them. Hints: change of image loading method, object caching.


