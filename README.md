# Tennis Refunds Service

### Description
A service to manage order refunds.

### For developers

#### Requirements
- Java 17
- Containerization (Docker|Podman)

#### Environment
Mysql db is required to run the service:
```bash
$ docker run -p 3308:3306 -d --name refunds-mysql-db -e MYSQL_USER=user -e MYSQL_PASSWORD=password -e MYSQL_DATABASE=REFUNDS -e MYSQL_ROOT_PASSWORD=root_password mysql:latest
```

#### Resources
- [Annotations for swagger](https://www.baeldung.com/spring-rest-openapi-documentation)

### Error Handling
| Title | Description | Code |
| --- | --- | --- |
| TransactionNotFound | The transaction with id <%d> was not found | GUAMA-TS-009 |
