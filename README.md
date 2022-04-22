# MoneyExchange
Challenge: Application to register the money exchange. It is developed in Java Spring Boot.

Database:
Create database named "test".
Execute "script.sql" file in database console.

Application:
After you clone from https://github.com/johnnysalgadom/MoneyExchange.git repository
You can execute it:
	- open cmd
	- Move to MoneyExchange folder: cd $source_folder/MoneyExchange
	- Execute maven: mvnw spring-boot:run

Test:
Run Postman application
	- User register
		* http://localhost:8090/api/auth/signup
		* method: Post
		* payload:
			{
				"username": "your_user",
				"password": "your_pass",
				"email": "your@email.com"
			}
	- Login
		* http://localhost:8090/api/auth/signin
		* method: Post
		* payload:
			{
				"username": "your_user",
				"password": "your_pass"
			}
		* Json response:
			{
				"username": "your_user,
				"token": "token_auth"
			}
	- Currency list
		* http://localhost:8090/currency
		* method: get
		* Authorization: Bearer token (use the "token_auth")
	- User list
		* http://localhost:8090/user
		* method: get
		* Authorization: Bearer token (use the "token_auth")
	- Exchange Rate
		* http://localhost:8090/exchange-rate
		* method: get
		* Authorization: Bearer token (use the "token_auth")
