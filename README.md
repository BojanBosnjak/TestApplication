# TestApplication
## Job interwiev test <h2> Azure: http://bojanapi.azurewebsites.net
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
  * To get Farms User has access to: /farms/list/user/{userId}
  * To get Accounts User has access to: /accounts/list/user/{userId}
  * Post user: /users/create
  * Put user: /users/{userId}
  * Delete user: /users/{userId}
 
Database info

> In files you will find two sql files. One is for running the program locally **DataBase**.sql
> Second one is **AzureDB**.sql which is deployed on Azure. The only difference is data inside the databases. 
