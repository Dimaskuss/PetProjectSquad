--liquibase formatted sql

--changeset derkachev:0
CREATE TABLE cat
(
    id               BIGINT generated by default as identity primary key,
    breed            VARCHAR(20),
    cat_name         VARCHAR(20),
    year_of_birthday INT,
    description      VARCHAR,
    user_cat_id      BIGINT
);

CREATE TABLE dog
(
    id               BIGINT generated by default as identity primary key,
    breed            VARCHAR(20),
    dog_name         VARCHAR(20),
    year_of_birthday INT,
    description      VARCHAR,
    user_dog_id      BIGINT
);

CREATE TABLE report_cat
(
    id              BIGINT generated by default as identity primary key,
    report          VARCHAR(100),
    report_date     DATE NOT NULL,
    photo_id        VARCHAR(100),
    report_accepted BOOLEAN,
    user_cat_id     BIGINT
);

CREATE TABLE report_dog
(
    id              BIGINT generated by default as identity primary key,
    report          VARCHAR(100),
    report_date     DATE NOT NULL,
    photo_id        VARCHAR(100),
    report_accepted BOOLEAN,
    user_dog_id     BIGINT
);

CREATE TABLE super_user
(
    id      BIGINT generated by default as identity primary key,
    chat_id BIGINT NOT NULL UNIQUE,
    name    VARCHAR(20)
);

CREATE TABLE users
(
    id        BIGINT generated by default as identity primary key,
    chat_id   BIGINT NOT NULL UNIQUE,
    name      VARCHAR(20),
    user_cat_id     BIGINT,
    user_dog_id     BIGINT
);

CREATE TABLE user_cat
(
    id        BIGINT generated by default as identity primary key,
    cat_id     BIGINT,
    chat_id   BIGINT NOT NULL,
    phone     VARCHAR(20),
    trial_period INT,
    user_id     BIGINT,
    user_need_help BOOLEAN,
    status VARCHAR(20)
);

CREATE TABLE user_dog
(
    id        BIGINT generated by default as identity primary key,
    dog_id     BIGINT,
    chat_id   BIGINT NOT NULL,
    phone     VARCHAR(20),
    trial_period INT,
    user_id     BIGINT,
    user_need_help BOOLEAN,
    status VARCHAR(20)
);

CREATE TABLE user_feedback
(

    id           BIGINT generated by default as identity primary key,
    chat_id      BIGINT      NOT NULL UNIQUE,
    phone_number VARCHAR(20),
    name         VARCHAR(20),
    feedback     BOOLEAN

);

CREATE SEQUENCE report_cat_seq
    MINVALUE 1
    MAXVALUE 50
    INCREMENT BY 1
    CACHE 20;
CREATE SEQUENCE report_dog_seq
    MINVALUE 1
    MAXVALUE 50
    INCREMENT BY 1
    CACHE 20;