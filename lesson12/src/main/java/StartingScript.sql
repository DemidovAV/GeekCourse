BEGIN;

DROP TABLE IF EXISTS items;
CREATE TABLE items (id serial PRIMARY KEY, val int not null);

COMMIT;