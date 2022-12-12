
# Problem Statement

Assume that you are the CTO for the outsourcing firm which has been chosen to build an
admission form for the Yoga Classes which happen every month.
Requirements for the admission form are:
- Only people within the age limit of 18-65 can enroll for the monthly classes and they will be paying the fees on a month on month basis. I.e. an individual will have to pay the fees every month and he can pay it any time of the month.
- They can enroll any day but they will have to pay for the entire month. The monthly fee is 500/- Rs INR.
- There are a total of 4 batches a day namely 6-7AM, 7-8AM, 8-9AM and 5-6PM. The participants can choose any batch in a month and can move to any other batch next month. I.e. participants can shift from one batch to another in different months but in same month they need to be in same batch
# Yoga-Classes

- A Website where users can create account and login with their credentials and register for the yoga class and can change their class timings once in a month. 
- Built using Spring MVC(Model-View-Controller design pattern) and Spring Boot.
- Used thymleaf for the frontend and MySql as the database to store the user information and perform database authentication, hashed the passwords using  BCrypt strong hashing function.


## Tech Stack

- `Frontend (View):` `Thymleaf`
- `Backend Framework:` `Spring MVC, Spring Boot`
- `Database:` `MySQL`



## To run the project on local machine

Make sure you have a MySql instance running on port 3306 on your local machine.

Pull project Docker Image

```bash
  docker pull rohithgadu/yoga-classes
```

Run Docker Image

```bash
  docker run -p 8080:8080 rohithgadu/yoga-classes
```


## Schema

![image](https://user-images.githubusercontent.com/84178107/207111527-f8a2dc13-9a77-4024-8521-014a69079897.png)


## Website Images

### Registration Page
![image](https://user-images.githubusercontent.com/84178107/207116521-10235b69-d869-45fe-80bb-9135aae1acb7.png)


### Wrong Inputs (Validation) 
![image](https://user-images.githubusercontent.com/84178107/207116737-7fcb5f56-401c-43fb-bc15-d03bf0896eba.png)


### Email Already Exists
![image](https://user-images.githubusercontent.com/84178107/207117003-24eff9dc-f53e-4d78-a3d0-45d2ab73b9ef.png)


### Successful Registration 
![image](https://user-images.githubusercontent.com/84178107/207117363-047457dd-e64b-4a4c-9601-60cec0d0a3fe.png)


### Login Page
![image](https://user-images.githubusercontent.com/84178107/207116456-92c76360-7139-4444-9f9d-a982c6bdd357.png)


### Invalid Credentials
![image](https://user-images.githubusercontent.com/84178107/207118156-9d2a60c4-a54a-4912-a7e5-48207845c55f.png)


### Successful Login
![image](https://user-images.githubusercontent.com/84178107/207117512-8e2745b9-56dc-4718-b7b1-5534d54f4a81.png)


### Change Yoga Class Time Error
![image](https://user-images.githubusercontent.com/84178107/207117897-37b47683-03a3-4bc9-880c-ac3891807286.png)


### Change Yoga Class Time
![image](https://user-images.githubusercontent.com/84178107/207118353-20e3f06d-61f0-41e4-9553-9d835aa0f307.png)


### On Logout
![image](https://user-images.githubusercontent.com/84178107/207117993-48dfccf8-82ec-4b4d-b6a9-ad3300879254.png)
