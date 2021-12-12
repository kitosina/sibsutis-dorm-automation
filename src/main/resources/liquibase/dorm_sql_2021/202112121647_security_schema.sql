create table security.users
(
    id       serial
        constraint users_pk
            primary key,
    password varchar(255),
    email    varchar(25) not null
);

comment on table security.users is 'Таблица пользователей системы';

alter table security.users
    owner to dorm;

create unique index users_email_uindex
    on security.users (email);

create table security.user_role
(
    user_id integer     not null
        constraint user_id
            references security.users
            on update cascade on delete cascade,
    roles   varchar(15) not null
);

comment on table security.users is 'Таблица ролей пользователей';

alter table security.user_role
    owner to dorm;

