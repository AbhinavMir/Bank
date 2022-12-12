CREATE TABLE transactions
(
    transaction_id   INTEGER PRIMARY KEY,
    account_id       INTEGER,
    transaction_type TEXT,
    amount           DECIMAL,
    currency         TEXT,
    FOREIGN KEY (account_id) REFERENCES accounts (account_id)
);