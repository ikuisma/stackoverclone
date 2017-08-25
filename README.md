# StackOverClone

StackOverClone is a simple question and answer site intended for person small scale use. 
The application allows for any registered users to post and answer questions but no tagging or search functionality has yet been added. 
The application was created as the final project work for a web server development course done at the University of Helsinki.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. 

### Prerequisites

In order for the project to work you need to have a working installation of Java and Maven on your machine. Clone this repository, navigate to the root of the project and simply run the command below. 

```
mvn spring-boot:run
```

This will launch the development environment of the application with a non-persistent database that you can play around with. 

## Running the tests

The automated tests can be run by navigating to the root of the project and executing the command below. 

```
mvn test
```

The tests include mock MVC tests as well as FluentLenium automated browser tests. The test coverage is quite pitiful due to time constraints. 

## Built With

* [SpringBoot](https://projects.spring.io/spring-boot/) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management
* [Bootstrap](https://v4-alpha.getbootstrap.com/) - Used for styling the front end
* [Summer course](http://web-palvelinohjelmointi.github.io) - Course used during the creation of this project

## Authors

* **Yours truly** - *Initial work* -

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

* Pepsi Max, coffee and Fazer chocolate. 