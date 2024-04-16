# Spring-Boot-Project-Banking-Application

#### 1. Create a new Bank Account 
** HTTP Method: ** POST  <br>
** URL: ** http://localhost:8080/v1/account  <br>
** Sample Request Body: **  <br>
{
    "accountHolderName": "Sai",
    "balance": 1000.00
}

#### 2. Fetch the details of a specific account:
** HTTP Method: ** GET  <br>
** URL: ** http://localhost:8080/v1/account/{id} (Replace {id} with the actual ID of the account you want to fetch.)  <br>

#### 3. Deposit money into an account: 
** HTTP Method: ** POST  <br>
** URL: ** http://localhost:8080/v1/account/{id}/deposit (Replace {id} with the actual ID of the account you want to deposit money into.)  <br>
** Sample Request Body: **  <br>
{
    "amount": 200.00
}

#### 4. Withdraw money from an account: 
** HTTP Method: ** POST  <br>
** URL: ** http://localhost:8080/v1/account/{id}/deposit (Replace {id} with the actual ID of the account you want to deposit money into.)  <br>
** Sample Request Body: **  <br>
{
    "amount": 200.00
}
