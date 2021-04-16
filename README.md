Setup:
1. Deploy sql/database-initialize.sql
2. Change the jdbc configuration in application.properties

Testing (File input):
1. Copy the dataSource.txt to the 'file' folder.

Testing (Restful API)
1. call api/auth/login to obtain jwt token.
2. call subsequent api by append the jwt to the header with the following format:
*Authorization: Bearer <jwt-token>

Applied Design Pattern:
* Builder: make code readable, understandable when set up complex objects
* Factory Pattern (Basically used in File Consumer): To encapsulate record reading, validating, mapping.
* Dependency Injection (@Autowired): To skip 'ugly' constructor parameter.
* Data Transfer Object: To encapsulate the data from single / multiple sources.