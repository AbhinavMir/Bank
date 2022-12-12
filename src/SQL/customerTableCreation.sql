CREATE TABLE customers
(
    customer_id        INTEGER PRIMARY KEY,
    username           TEXT,
    first_name         TEXT,
    last_name          TEXT,
    address            TEXT,
    email              TEXT,
    phone_number       TEXT,
    encrypted_password TEXT
);