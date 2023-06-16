# Getting Started

### Build Project

    gradle clean build

### Dockerizing the APP 

    docker build -t docker build -t directory-service .
    docker-compose up ( to start both the service and mongodb)

### Shutting Down
    
    docker-compose down


### API Documentation

    Get All Contacts(GET)
    
        -   http://localhost:8080/api/v1/contacts 

    Get Contact By Id (GET)

        - http://localhost:8080/api/v1/contacts/78a0eae6-eacd-48f6-a1f8-ee2de2b11e57

    Create New Contact (POST)

        - http://localhost:8080/api/v1/contacts
        Payload
            {"name":"Sehwag","phoneNumber":"0428147212","active":false}

    Update New Contact (PUT)

        - http://localhost:8080/api/v1/contacts
        Payload
            {"name":"Sehwag","phoneNumber":"0428147212","active":true}


### Test Coverage

    gradle clean build
    Coverage Reports can be found inside buiild/reports/jacaco folder
        