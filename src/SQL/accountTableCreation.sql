CREATE TABLE accounts
(
    account_id   INTEGER PRIMARY KEY,
    customer_id  INTEGER,
    account_type TEXT,
    currency     TEXT,
    balance      DECIMAL,
    FOREIGN KEY (customer_id) REFERENCES customers (customer_id)
);