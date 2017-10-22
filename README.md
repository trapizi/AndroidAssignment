# Spaghetti - INFS3634 Project

## App description: 
Spaghetti is an android application that assists INFS3634 tutors and lecturers in teaching the course to future students. We aim to create a study platform where students and tutors can interact and communicate to each others easily via their smartphone.

The application offers 3 unique features:

- Forum
- Quiz
- Ranking

Spaghetti also offers powerful Firebase integrated functions to help the Lecturers and Tutors use the app at its best potential:

- Announcement
- NoSQL Database
- Manage quiz
- Account management

# Feature highlights
## Forum


## [Quiz](https://imgur.com/a/zcHpz)

Quiz is one of the core features of Spaghetti. Like the name speaks for itself, this function offers lecturers and tutors to test their students using the course materials and resources. The quiz is in multiple choice format. Each question consists of four possible answers and with only **one correct answer**. Students may have many attempts. 

Spaghetti offers lecturers and tutors to create custom quizzes and upload them into the database using JSON file. A quiz can consist of many questions but one question belongs to one quiz. Spaghetti supports displaying question either in **Text** OR **Image** format.

When students are taking the quizzes, each students have 1 minute to do each question. To help students keep their time, a countdown bar is added. This countdown bar will reset itself once students proceed to the next question.

When an incorrect answer is picked, the app will stop students from doing the quiz and display their result.

## Performance and Ranking
Once students finished their quiz. The app will update their score to the database under *Question_Score*. The result is stored as an instance in *AccountUid_QuizId* format. For instance

    59MxyDqDgJh75vwKjB1nr6zc8Xf2_01
    59MxyDqDgJh75vwKjB1nr6zc8Xf2_02

where **59MxyDqDgJh75vwKjB1nr6zc8Xf2** is the Uid and **01** and **02** are the QuizID.


As students completed more quizzes, the system will add up all the quiz scores and store the total score in Ranking database.

## Manual guide

### Account management
Account management is done via Firebase Authentication. This is where lecturers can add new account for students and tutors. Changing password, disable accounts or delete them.

To grant console access to tutors, simply go to *Users and permission*. There, we can add tutors email account and their roles. Each role comes with unique access to the console. Tutors account are recommended to be added under *Editor* role.

###Upload quizzes and questions
Users are assumed to have basic knowledge in JSON in order to make their own quizzes. For inexperience users, it is recommended to use [ObjGen](http://www.objgen.com/).


**Step1**: Open Firebase App console and select Database.

**Step2**: Select Realtime Database

**Step3**: Select More options and click "Export JSON"

**Step4**: Follow the sample code below to add quiz and questions.

**Step5**: Once quiz and questions have been added. Save the file. Go to Firebase Database console.

**Step6**: Select "Import JSON" and upload the new JSON file. Done!

*Sample Quiz JSON* with QuizID=01.
    
    "Quiz": {
      "01": {
      "Name": "Week 1 Quiz - Java Warm Up",
      "Image": "https://squashskills.com/images/sized/1400x660/617cf53aa4-poi615.269-qx100.png"
    }

    
*Sample Questions for the above quiz in JSON*. Each question has key *"QuizId" : "01"* to indicate it belongs to a quiz WHERE QuizId=01.


    "Quiz": {
    "01": {
      "Name": "Week 1 Quiz - Java Warm Up",
      "Image": "https://squashskills.com/images/sized/1400x660/617cf53aa4-poi615.269-qx100.png"
    } "Questions" : {
    "01" : {
      "AnswerA" : "Salmon egg sushi",
      "AnswerB" : "ラメン",
      "AnswerC" : "Pho",
      "AnswerD" : "Burrito",
      "CorrectAnswer" : "Salmon egg sushi",
      "IsImageQuestion" : "true",
      "Question" : "http://www.onesushiandgrill.com/wp-content/uploads/2013/03/IMG_5238-ed1-906x604.jpg",
      "QuizId" : "01"
    },
    "02" : {
      "AnswerA" : "1",
      "AnswerB" : "2",
      "AnswerC" : "3",
      "AnswerD" : "4",
      "CorrectAnswer" : "1",
      "IsImageQuestion" : "false",
      "Question" : "Correct Answer is 1",
      "QuizId" : "01"
    },
    "03" : {
      "AnswerA" : "Orange",
      "AnswerB" : "Omelette",
      "AnswerC" : "Oreo",
      "AnswerD" : "Olive Oil",
      "CorrectAnswer" : "Oreo",
      "IsImageQuestion" : "false",
      "Question" : "What is the newest version of Android?",
      "QuizId" : "01"
    }

### Announcement
Announcement messages are made via Firebase Console.

**Step1**: Open Firebase App console and select Notification.

**Step2**: Select NEW MESSAGE.
 
**Step3**: Enter message text and label then select Spaghetti.

**Step4**: Once everything is entered. Click SEND MESSAGE.


