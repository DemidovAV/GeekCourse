BEGIN;

DROP TABLE IF EXISTS client CASCADE;
CREATE TABLE client (id serial PRIMARY KEY, name text UNIQUE);

DROP TABLE IF EXISTS products CASCADE;
CREATE TABLE products (id serial PRIMARY KEY, title text UNIQUE, price int NOT NULL);

DROP TABLE IF EXISTS orders CASCADE;
CREATE TABLE orders (id serial PRIMARY KEY, client_id int REFERENCES client (id) ON DELETE CASCADE, product_id int REFERENCES products (id) ON DELETE CASCADE, price int);

COMMIT;