CREATE TABLE stock (
  id            SERIAL PRIMARY KEY,
  name          VARCHAR(250) NOT NULL,
  current_price DECIMAL      NOT NULL,
  last_update   TIMESTAMP    NOT NULL
);