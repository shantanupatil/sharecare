# Share Care

![Share Care](https://github.com/shantanupatil/sharecare/blob/master/Share%20Care.png)

This is a prototype for an application whose usage is to help senior citizen. The application has the following features

- Volunteers: This will allow senior citizens to select volunteers based on different categories. The user (senior citizen) will be able to contact the volunteer for the described purpose. The contact option allows the user to directly call.
- Routines: This feature will allow senior citizens to set task or what they do in their daily curriculum in the application. After adding they will be asked everyday to perform that task. This feature can also help doctors to understand what the user (senior citizen) has missied in past few days when they visit the hospital.
- HomeScreen: The homescreen of the application contains two features
  - CalendarView: This will allow you to select any date and check what the user has completed and what has not been completed
  - News: NewsApi.org is used to fetch the news. (This can be changed depending on what country the use belongs). Kindly refer to their documentation.

You can directly refer this classes to understand how the code works:
- Retrofit: Refer to these classes directly:  [Retrofit Classes](https://github.com/shantanupatil/sharecare/tree/master/app/src/main/java/in/shantanupatil/sharecare/api)
- Custom text views, EditText, and Bottom Navigation: [Kotlin Classes](https://github.com/shantanupatil/sharecare/tree/master/app/src/main/java/in/shantanupatil/sharecare/custom), [Attributes XML](https://github.com/shantanupatil/sharecare/blob/master/app/src/main/res/values/attributes.xml)
- Room Database: [Database Classes](https://github.com/shantanupatil/sharecare/tree/master/app/src/main/java/in/shantanupatil/sharecare/db)
- DaggerHilt: [Dependency Injection](https://github.com/shantanupatil/sharecare/tree/master/app/src/main/java/in/shantanupatil/sharecare/di)
- Volunteers, Routine, HomeScreen Modules: [Modules](https://github.com/shantanupatil/sharecare/tree/master/app/src/main/java/in/shantanupatil/sharecare/modules)

