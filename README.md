# TestApplication
## Job interwiev test <h2> Azure: http://bojanapi.azurewebsites.net (This link will be available for few more days, after that I will have to remove it from Azure)
###### Job interwiev test <h6>
**Endpoints:**
* Farm
  * Get list of farms: /farms
  * Get one farm: /farms/{farmId}
  * Post method: /farms/create
  * Put method: /farms/{farmId}
  * Delete method: /farms/{farmId}
* Customer
  * Get list of customers: /customers
  * Get one customer: /customers/{customerId}
  * Post method: /customers
  * Put method: /customers/{customerId}
  * Delete method: /customers/{customerId}
* User
  * Get list of users: /users/list
  * Get one user: /users/{userId}
  * To get Farms User has access to: /farms/user/{userId}
  * To get Accounts User has access to: /accounts/user/{userId}
  * Post user: /users/create
  * Put user: /users/{userId}
  * Delete user: /users/{userId}
 
Database info

> In files you will find two sql files. One is for running the program locally **DataBase**.sql.
> Second one is **AzureDB**.sql which is deployed on Azure. The only difference is data inside the databases. 

When you test User authentication, use any user_name from database with "password" as password.


Test

> In src/test/java you will find package with tests for Customer and User services. Test are in JUnit4. With test I have
> covered save user, save customer, update user, update customer, failed update user, failed update customer, get user by id, and get all users.

