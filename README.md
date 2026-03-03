# BookSearch

BookSearch is a Command Line Interface (CLI) application developed in Java using Spring Boot.
It was created to provide a simple and efficient way to search, store, and query books and authors, consuming data from an external public API and persisting it in a relational database.

### Key Features
* Book Search: Searches books from an external API and saves them into a local database.

#### Author Filtering

* Shows author attributes such as: Birth year, death year and Authors alive in a specific year

#### Language Filtering

* Show books count by language.

#### Database Persistence

* Books and authors are stored locally using JPA and Hibernate for future queries.

---

### Technologies Used

* Java 17+
* Spring Boot
* Spring Data JPA
* Hibernate
* Relational Database (e.g., PostgreSQL / H2)
* HTTP Client (for API consumption)
* Jackson
  * Used for serialization and deserialization of JSON data received from the external API.

---

### Applied Concepts

* Object-Oriented Programming (OOP)
* Use of entities, services, repositories, and encapsulation to structure the system in a modular and scalable way.
* Spring Boot Architecture
* Relationships (@OneToMany, @ManyToOne)
* Derived queries
* Custom JPQL queries
* External API Integration
* Connection with the Gutendex public API to retrieve book data.
* JSON Handling
* Use of Jackson to deserialize JSON responses into Java objects.
* Database Relationships

---

## How to Run the Project

To run the **Book Search** on your local machine, follow the steps below:

### Prerequisites

1. Java 17 or higher
2. Maven
3. Database configured (PostgreSQL)

### Execution Steps

1. Clone the Repository
    ```bash
    git clone https://github.com/YuriOC/bookSearch.git
    cd bookSearch
    ```

2. Configure Database

   Create your database

   Edit your application.properties:
    ```bash
    spring.datasource.url=jdbc:postgresql://localhost/database_name
    spring.datasource.username=your_username
    spring.datasource.password=your_password

    spring.jpa.hibernate.ddl-auto=update
    ```

3. Run the Application
   Using Maven:

   ```bash
    mvn spring-boot:run
   ```
4. Usage

  The application runs in the terminal and provides a menu with options such as:

  * Search book by title

  * List saved books

  * Filter books by language

  * List authors alive in a specific year

  Example:

  Enter the year:
  1850

  The system will return books whose authors were alive during that year.

---

🤝 Contributions

Contributions are welcome!

If you would like to improve the project:

Fork the repository

Create a new branch

git checkout -b feature/your-improvement

Commit your changes

git commit -m "feat: adds improvement X"

Open a Pull Request

👨‍💻 Author

YuriOC

GitHub Profile: https://github.com/YuriOC
