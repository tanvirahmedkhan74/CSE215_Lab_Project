# MEET@NSU Spring + Angular Social Media Project :shipit:
### Group Project For Section CSE215 12L

# Head to SpringBoot Folder
### This folder contains the frontend and Backned Code Of the Project  

# Setup
### You can download and try out the Project 
### But Make sure to Change the application.properties file for Database  

# application.properties Changes:
## Database Configuration (MySql)
> - spring.datasource.url=jdbc:mysql://localhost:3306/{`YOUR DATABASE NAME`}?useSSL=false&serverTimezone=UTC&useLegacyDatetimeCode=false  
>   
> - spring.datasource.username={`YOUR MYSQL USERNAME`}  
> - spring.datasource.password={`YOUR MYSQL PASSWORD`}  

## Change SMTP Configuration  
> - spring.mail.host=smtp.mailtrap.io  
> - spring.mail.username={`YOUR FAKE SMTP USERNAME`}  
> - spring.mail.password={`YOUR FAKE SMTP PASSWORD`}  
> - spring.mail.port={`YOUR FAKE SMTP PORT`}  
> - spring.mail.protocol=smtp  

# Front End - Setup

# Install Node Using Nvm
> `sudo apt install curl`  

> `curl https://raw.githubusercontent.com/creationix/nvm/master/install.sh | bash`  

> `source ~/.bashrc`  

### Now install Node using nvm (Version 16.16 Latest Stable at current build time)  
> `nvm install 16.16`

This project was generated with [Angular CLI](https://github.com/angular/angular-cli) version 14.1.1.  
![Angular CLI and Node Version](/angular_version.png)  

## Development server

Run `ng serve` for a dev server. Navigate to `http://localhost:4200/`. The application will automatically reload if you change any of the source files.

## Code scaffolding

Run `ng generate component component-name` to generate a new component. You can also use `ng generate directive|pipe|service|class|guard|interface|enum|module`.

## Build

Run `ng build` to build the project. The build artifacts will be stored in the `dist/` directory.

## Running unit tests

Run `ng test` to execute the unit tests via [Karma](https://karma-runner.github.io).

## Running end-to-end tests

Run `ng e2e` to execute the end-to-end tests via a platform of your choice. To use this command, you need to first add a package that implements end-to-end testing capabilities.

## Further help

To get more help on the Angular CLI use `ng help` or go check out the [Angular CLI Overview and Command Reference](https://angular.io/cli) page.

