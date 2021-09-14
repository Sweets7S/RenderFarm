DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS tasks;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq AS INTEGER START WITH 1000;

CREATE TABLE users
(
    id          INTEGER NOT NULL DEFAULT nextval('global_seq') PRIMARY KEY,
    login       VARCHAR(25)     NOT NULL,
    password    VARCHAR(30)     NOT NULL
);
ALTER SEQUENCE global_seq INCREMENT BY 1;

CREATE TABLE tasks
(
    id          INTEGER NOT NULL DEFAULT nextval('global_seq') PRIMARY KEY,
    task_id     int             NOT NULL,
    user_id     int             NOT NULL,
    name        VARCHAR(50)     NOT NULL,
    status      VARCHAR(25)     NOT NULL,
    date_time   TIMESTAMP       NOT NULL
);

