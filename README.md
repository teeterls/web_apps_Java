# web_apps_Java
Developing web applications using the Java programming language, client side technologies, and database access. 
In this repo, multiple tasks and more complex projects are developed (all resources used are included). In almost every project, there are 2 folders:
- /src -> Java code (DAO pattern)
- /web -> client side web technologies code (html, css, Javascript, JSP, XML, etc)
Every web page is locally executed.
The structure of the repo is the following:

### 1. Mysql DataBase access using JDBC and DAO pattern
In this project, JDBC driver is used to connect to a database in mysql, which records vehicles data.
There are 3 folders:
- DAO -> .java files neccesary for connection (jdbc:mysql://127.0.0.1:3306/vehiculos)
- domain -> Class .java file
- UI -> user interface .java file (executable)

### 2. Simple web page development
In this project, a simple responsive web page is developed using the following client-side technologies: HTML, CSS and JavaScript. The web page is dynamic, so apart from static text and images, there is a search box, in which, according to some constraints, the user can type any valid String (OK! message), and the web page will take him to Google results page. Some screenshots are:
![image](https://user-images.githubusercontent.com/46919127/161437261-b4688d69-7cae-48f8-9dad-f0f20ccf15c3.png)
![image](https://user-images.githubusercontent.com/46919127/161437274-941f01cd-1f08-4d28-823e-e8a1e050b25a.png)

### 3. Java Servlets
In this project, a web calculator (+,-,x,·/· operations) is developed using HTML and CSS as client-side technologies, and including Java Servlets in back-end to handle HTTP petitions (request & respond). Moreover, main calculation exceptions are managed (HTTP 500 error status). Some examples of how it works:
![image](https://user-images.githubusercontent.com/46919127/161437303-4a0cb39c-8516-4744-b37b-646b0a90317f.png)
![image](https://user-images.githubusercontent.com/46919127/161437397-bf7c39c7-27d7-4e34-97bb-c61e7063fdb3.png)
![image](https://user-images.githubusercontent.com/46919127/161437377-4196859b-cbbd-4ba4-8947-429e53c2e227.png)

### 4. JavaServer Pages (JSP)
In this project, an online registration form with validation is developed using .jsp technology (for request and response), HTML and CSS. The form looks like:
![image](https://user-images.githubusercontent.com/46919127/161436901-619cbb9f-77c3-44b3-9bf9-7a1fd9600284.png)
![image](https://user-images.githubusercontent.com/46919127/161437144-664d1783-c451-4c16-85ec-a0c1607ad81f.png)

### 5. Model-View-Controller Architecture Pattern (MVC)
In this project, the previous form is improved, including client-side validation with  Java Servlets, and recording satisfactory registrations in a mySQL DataBase. The client validation flow is the following:
![image](https://user-images.githubusercontent.com/46919127/161436872-fefc0ef7-b098-4ffe-8f34-53373dbb8b25.png)

### 6. Jakarta Expression Language (EL) and JSP tag  library (JSTL)
In this project, a simple web app for a library orders' maganement (shopping cart) is developed. For this purpose, EL and JSTL are used, as well as client-side web technologies JDBC driver for connection to database
![image](https://user-images.githubusercontent.com/46919127/161437011-11a55e40-5baf-4c60-8654-467ee37b5eff.png)
![image](https://user-images.githubusercontent.com/46919127/161437017-d6a74cfb-3502-4331-8156-550002f3cf55.png)
![image](https://user-images.githubusercontent.com/46919127/161437043-e3eac693-22e3-4f6c-bc36-16761f8e017a.png)
![image](https://user-images.githubusercontent.com/46919127/161437034-a85db3db-71c7-4db6-ab50-1f99ad74709c.png)

