create table users
(
    id           bigint generated by default as identity primary key,
    first_name   varchar(50),
    last_name varchar(50),
    username varchar(50),
    email         varchar(150) constraint email_uk_6dotkott2kjsp8vw4d0m25fb7 unique
);
