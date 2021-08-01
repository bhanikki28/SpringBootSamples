# Getting Started

### Swagger Dependency

Getting the Swagger 2 Spring Dependency

	Add the Swagger dependency in maven pom.xml
		<!-- https://mvnrepository.com/artifact/io.springfox/springfox-boot-starter -->
		<dependency>
			<groupId>io.springfox</groupId>
			<artifactId>springfox-boot-starter</artifactId>
			<version>3.0.0</version>
		</dependency>


### Enabling the Swagger

	No additional step required from springfox-boot-starter version 3.0.0
 			

### Configuring the Swagger

Configuring Swagger

		To customize Swagger with the controllers to be scanned and add more details, need to define below configurations
		
			1. Docket Bean
			2. API Info 
			3. API Operation - to be defined at the controller
			4. API Param - param definition for the controller
			5. API Model - more info on models been used

### Accessing the Swagger docs
			
			Hit the endpoint : http://localhost:<<PORT_NO>>/swagger-ui/index.html


