## Association Assignment

1. Create TWO entities with Many To One (Unidirectional) association.

    ```
    Entity-1: Loan
        acc_No (PK) Auto_increment
        loan_amount, rateofinterest, duration
        cust_id FK
    Entity-2: Customer
        cust_id (PK) Auto_increment
        firstname, lastname, phone
    ```

2.  Use Schema-Generation to create the table on start-up.

3.  Use 'EAGER' fetch mode in 'Loan' for property 'customer'

4.  To create One customer and three loans from SINGLE transactions.

5.  Test by login into database (MySQL Workbench).