# Teacher-Student-Resource-Platform
Group project for CSC340-02

# Members
William Sanders
Jason Isler
Matthew Davis

# Description
We are developing a education resource platform that allows for students and teachers to share useful information via uploading data. Student users should be able to create an account that indicates their major, interest, clubs, and contact information. Student users should then be able to lookup profile, class, and resource information from established teacher users. Teacher users should be able to create an account that allows them to add their faculty information, list their classes, and adds useful information to their class descriptions. 

This application is intended to allow students to have easy access to faculty and school resource information while providing easy dispersion of information for faculty as well. Additionally, functions will be designed for an administrative user such as the ability to monitor other users, remove or add other users, edit user information, etc. The application is cool because it will help condense a ton of useful school data and resources into a neat and easy to use application for both students and faculty.

# Dependencies
Requires depedencies to JPA, MySQL, and ThymeLeaf, in addition to the usual. JPA handles the persistence, MySQL is the database to be used, ThymeLeaf generates HTML templates.

Make sure you have xampp installed and working properly: file name for the database is in application.properties; It is teacher-student-resource-platform and the port is 3306.

# How to run Application
1. Download zip file of repo
2. Extract project folder and open in Intellij
3. Start up Apache server and MYSQL on XAMPP control panel
4. Make sure the database is properly set up
5. Start up application by running TsrpBackendApplication.java in main folder
6. Open Localhost:8080 in browser

# Cases

For (Customer) Student cases:
1. Sign up for account
- From the starting page click on the "create student account" link
- Enter first and last name, email, password, then hit create account.
- From there you go to your new profile
2. Edit Student Account info
- Click the edit button on you profile for the update account page
- There you can change all the info you signed up with, along with the option to add a profile description, graduation year, and ypur college major.
- Save the info and it will appear on your profile as you have updated it.

3. Create a new post as a student
- From profile or click on home page link or go to posts/all
- view any post already there by other accounts
- create a new post by click on the new post button
- type what you on the post and hit post, the new post should be there.

  4. Create a new review for a teacher page
  - find the teacher you want to review
  - similar to posts, click on new button to create a new review
  - type the review out and hit submit, the review should appear below the teacher profile page. 
