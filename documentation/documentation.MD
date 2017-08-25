# Documentation master file

This file contains a brief description of the application, implemented use cases as well as features and 
use cases that have yet to be implemented. 

## Description of application

StackOverClone is a simple question and answer site intended for person small scale use. 
I got the idea for the application at work when I noticed that FAQ's and QA -pages were easier to maintain and read 
than big bloated feature documents. The application allows users to register to the application and to post and answer questions. No tagging or search 
functionality has yet been added to the program. 

The goal was to make a very light and easy to use application for making the gathering of questions and answers 
easy and public within a local work network. The application was created as the final project work for a web server 
development course arranged by the University of Helsinki.

## Implemented use cases

Below is a lost of use cases in no particular order. 

- A user can register an account. 
- A registered user can log in using their credentials. 
- A registered user can post a new question.
- A registered user can browse the list of all questions in the application.
- A registered user can click on a question to open the question page. 
- A registered user can browse answers to the question on the page. 
- A registered user can add an answer to the question through a form on the page. 
- Trying to register an existing username will display an error message. 
- Trying to create questions and answers with invalid inputs will display an error message. 

## Todos and future plans

This list could potentially go on for forever. There are some that I consider crucial and others that could be nice, 
but I like the idea of keeping the application lightweight and not bloated. 

### Important features

Tagging and searching is in my opinion by far the most important feature along with timestamps since they help with 
evaluating the validity of answers.  

- Add possibility to add tags to questions and answers.
- Implement a search feature for searching for specific questions and tags.
- Make the list of questions consist of multiple pages instead of the never-ending list.
- Add "last updated" -timestamps to questions to help with searching and ranking.
- Grant admin or moderator rights to specific users so they can moderate and delete posts.
- Add voting to answers in order to rank them. 


### Nice-to-have features

I have nothing against these features but they don't feel as important as the ones above. 

- Answers could have comments added to them to allow for follow-up questions and discussion. 
- Users could have a profile page where they can see all of their questions and answers.
- Add possibility to mark questions as duplicates or link them together. 
