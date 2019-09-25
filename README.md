# Reminder-App-Kotlin
reminder app for android using Kotlin

## Idea
For this project, We wanted to try out the language that JetBrains created: Kotlin. Since Kotlin became the new officially supported
language for android, we decided to create a reminder app.

### Challenges
Determining how we were going to sort the list of reminders by date and time components. We arrived at a solution to convert the date 
into number of days and the time to seconds divided by number of seconds in 24 hours. This sum is computed at the time the reminder 
is created and an insertion sort is used to sort it by using the sum.

Creating the app's GUI using XML documents

### Improvements
Currently we have a list stored locally on the phone and is saved when the app is closed. We would like to attempt to add a database
for the reminders such as Google Firebase for learning purposes.

Allow the app to push notifications to your phone.
