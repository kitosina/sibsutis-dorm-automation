create table data.dorm
(
    id           integer not null
        constraint dorm_pk
            primary key,
    name         varchar(50),
    living_space double precision,
    count_room     integer
);

comment on table data.dorm is 'Общежитие';

comment on column data.dorm.name is 'Название общежития (Общежитие №4) и т.п.';

comment on column data.dorm.living_space is 'Жилая площадь';

comment on column data.dorm.count_room is 'Количество комнат жилых';

alter table data.dorm
    owner to dorm;

create unique index dorm_name_uindex
    on data.dorm (name);

create unique index dorm_id_uindex
    on data.dorm (id);

create table data.section
(
    id      integer not null
        constraint section_pk
            primary key,
    name    varchar(20),
    dorm_id integer
        constraint section_dorm_id_fk
            references data.dorm
);

comment on table data.section is 'Секция/блок/коридор';

comment on column data.section.name is 'Номер секции/ коридора (701-708/ 3)';

alter table data.section
    owner to dorm;

create unique index section_id_uindex
    on data.section (id);

create table data.room
(
    id         integer not null
        constraint room_pk
            primary key,
    num_room   integer,
    space      double precision,
    capacity   integer,
    section_id integer
        constraint room_section_id_fk
            references data.section
);

comment on table data.room is 'Комната';

comment on column data.room.num_room is 'Номер комнаты';

comment on column data.room.space is 'Площадь';

comment on column data.room.capacity is 'Вместимость(кол-во чел проживающих)';

alter table data.room
    owner to dorm;

create table data.payment_type
(
    id             integer not null
        constraint payment_type_pk
            primary key,
    name_type      varchar(100),
    amount         double precision,
    amount_rub     double precision,
    com_amount     double precision,
    com_amount_rub double precision
);

comment on column data.payment_type.name_type is 'Группа оплаты (обычная, старосты, члены дпд и т.д.)';

comment on column data.payment_type.amount is 'Размер оплаты(в процентах)';

comment on column data.payment_type.amount_rub is 'Размер оплаты - руб.';

alter table data.payment_type
    owner to dorm;

create unique index payment_type_name_type_uindex
    on data.payment_type (name_type);

create table data.tenant
(
    id              integer      not null
        constraint tenant_pk
            primary key,
    name            varchar(30)  not null,
    last_name       varchar(120) not null,
    patronymic      varchar(60)  not null,
    room_id         integer      not null
        constraint tenant_room_id_fk
            references data.room,
    contract_begin  date,
    contract_end    date,
    birth_date      date,
    passport        varchar(10),
    passport_ref    varchar,
    reg_ref         integer,
    payment_type_id integer
        constraint tenant_payment_type_id_fk
            references data.payment_type,
    email           varchar
);

comment on table data.tenant is 'Жильцы(арендаторы)';

comment on column data.tenant.name is 'имя';

comment on column data.tenant.last_name is 'Фамилия';

comment on column data.tenant.patronymic is 'отчество';

alter table data.tenant
    owner to dorm;

create unique index tenant_email_uindex
    on data.tenant (email);

create unique index tenant_id_uindex
    on data.tenant (id);

create unique index payment_type_id_uindex
    on data.payment_type (id);

create table data.inventory
(
    id        integer not null
        constraint inventory_pk
            primary key,
    inventory varchar(30)
);

comment on table data.inventory is 'Инвентарь';

alter table data.inventory
    owner to dorm;

create table data.inventarisation
(
    id           integer not null
        constraint inventarisation_pk
            primary key,
    room_id      integer
        constraint inventarisation_room_id_fk
            references data.room,
    inventory_id integer
        constraint inventarisation_inventory_id_fk
            references data.inventory,
    quantity     integer
);

comment on column data.inventarisation.quantity is 'Количество инвентаря';

alter table data.inventarisation
    owner to dorm;

create unique index inventory_inventory_uindex
    on data.inventory (inventory);

create unique index inventarisation_id_uindex
    on data.inventarisation (id);

create unique index inventory_id_uindex
    on data.inventory (id);

create table data.workers
(
    id             integer not null
        constraint workers_pk
            primary key,
    name           varchar,
    last_name      varchar,
    patronymic     varchar,
    birth_day      date,
    passport       varchar(10),
    inn            varchar(14),
    snils          varchar(16),
    contract_begin date,
    contract_end   date,
    dorm_id        integer
        constraint workers_fk
            references data.dorm,
    post           varchar,
    email          varchar
);

alter table data.workers
    owner to dorm;

create unique index workers_email_uindex
    on data.workers (email);

create unique index workers_id_uindex
    on data.workers (id);