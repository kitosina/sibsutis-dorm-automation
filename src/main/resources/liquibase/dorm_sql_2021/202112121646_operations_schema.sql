create table operations.payment
(
    id          integer not null
        constraint payment_pk
            primary key,
    payment_end date,
    tenant_id   integer
);

comment on table operations.payment is 'оплата';

comment on column operations.payment.payment_end is 'Конец периода оплаты';

alter table operations.payment
    owner to dorm;

create unique index payment_id_uindex
    on operations.payment (id);

create table operations.living
(
    id          integer not null
        constraint living_pk
            primary key,
    action_type varchar(30),
    comment     varchar(300),
    tenant_id   integer
);

comment on column operations.living.action_type is 'Вид операции(заселение/переселение/выселение)';

comment on column operations.living.comment is 'Комментарий/основание (приказ, заявление)';

alter table operations.living
    owner to dorm;

create unique index living_id_uindex
    on operations.living (id);

create table operations.request_status
(
    id   integer     not null
        constraint request_status_pk
            primary key,
    name varchar(10) not null
);

alter table operations.request_status
    owner to dorm;

create unique index request_status_id_uindex
    on operations.request_status (id);

create table operations.repair_type
(
    id   integer not null
        constraint repair_type_pk
            primary key,
    type varchar(30)
);

comment on column operations.repair_type.type is 'Тип ремонта(сантехника, электрика...)';

alter table operations.repair_type
    owner to dorm;

create table operations.repair_request
(
    id          integer      not null
        constraint repair_request_pk
            primary key,
    status_id   integer      not null
        constraint repair_request_request_status_id_fk
            references operations.request_status,
    comment     varchar(500) not null,
    place       varchar(10)  not null,
    repair_type integer      not null
        constraint repair_request_repair_type_id_fk
            references operations.repair_type
);

comment on column operations.repair_request.status_id is 'Статус заявки';

comment on column operations.repair_request.comment is 'Текст заявки';

alter table operations.repair_request
    owner to dorm;

create unique index repair_request_id_uindex
    on operations.repair_request (id);

create unique index repair_type_id_uindex
    on operations.repair_type (id);
