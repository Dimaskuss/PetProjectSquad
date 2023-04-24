--liquibase formatted sql

--changeset derkachev:0
CREATE TABLE users
(
    id        BIGINT generated by default as identity primary key,
    chat_id   BIGINT NOT NULL UNIQUE,
    phone     INT,
    bot_state VARCHAR(20)
);
CREATE TABLE cat
(
    id               BIGINT generated by default as identity primary key,
    breed            VARCHAR(20),
    cat_name             VARCHAR(20),
    year_of_birthday INT,
    description      VARCHAR

);

--changeset couldlie:0.1
CREATE TABLE dog
(
    id               BIGINT generated by default as identity primary key,
    breed            VARCHAR(20),
    dog_name            VARCHAR(20),
    year_of_birthday INT,
    description      VARCHAR

);

--changeset couldlie:0.2
ALTER TABLE users RENAME TO user_dog;
CREATE TABLE user_cat
(
    id        BIGINT generated by default as identity primary key,
    chat_id   BIGINT NOT NULL UNIQUE,
    phone     INT,
    bot_state VARCHAR(20)
);

--changeset couldlie:0.3
CREATE TABLE shelter
(
    number    BIGINT generated by default as identity primary key,
    name      VARCHAR(20),
    address   VARCHAR(50),
    telephone_number    VARCHAR(20),
    work_schedule       VARCHAR(20),
    shelter_type        VARCHAR(20)
);

--changeset couldlie:0.4
CREATE TABLE user_table
(

    id        BIGINT generated by default as identity primary key,
    chat_id   BIGINT NOT NULL UNIQUE,
    name      VARCHAR(20)

);

--changeset couldlie:0.5
DROP TABLE shelter;
ALTER TABLE user_cat DROP COLUMN bot_state;
ALTER TABLE user_dog DROP COLUMN bot_state;

--changeset couldlie:0.6
AlTER TABLE user_table ADD COLUMN user_cat_id BIGINT;
AlTER TABLE user_table ADD COLUMN user_dog_id BIGINT;

--changeset couldlie:0.7
ALTER TABLE user_cat ADD COLUMN cat_id BIGINT;
ALTER TABLE user_dog ADD COLUMN dog_id BIGINT;