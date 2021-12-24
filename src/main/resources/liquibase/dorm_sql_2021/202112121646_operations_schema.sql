create table operations.action_type
(
    id               serial
        constraint action_type_pk
            primary key,
    action_type_name varchar(30)
);

alter table operations.action_type
    owner to dorm;

create unique index action_type_action_type_name_uindex
    on operations.action_type (action_type_name);

create unique index action_type_id_uindex
    on operations.action_type (id);

create table operations.payment
(
    id          serial
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
    id          serial
        constraint living_pk
            primary key,
    action_type_id integer
        constraint living_action_type_id_fk
            references operations.action_type,
    comment        text,
    tenant_id      integer
);

comment on column operations.living.action_type_id is 'Вид операции(заселение/переселение/выселение)';

comment on column operations.living.comment is 'Комментарий/основание (приказ, заявление)';

alter table operations.living
    owner to dorm;

create unique index living_id_uindex
    on operations.living (id);

create table operations.request_status
(
    id   serial
        constraint request_status_pk
            primary key,
    request_status_name varchar(20) not null
);

alter table operations.request_status
    owner to dorm;

create unique index request_status_id_uindex
    on operations.request_status (id);

create unique index request_status_request_status_name_uindex
    on operations.request_status (request_status_name);

create table operations.repair_type
(
    id   serial
        constraint repair_type_pk
            primary key,
    repair_type_name varchar(30)
);

comment on column operations.repair_type.repair_type_name is 'Тип ремонта(сантехника, электрика...)';

alter table operations.repair_type
    owner to dorm;

create unique index repair_type_id_uindex
    on operations.repair_type (id);

create unique index repair_type_repair_type_name_uindex
    on operations.repair_type (repair_type_name);

create table operations.repair_info
(
    id           serial
        constraint repair_info_pk
            primary key,
    num_room     integer     not null,
    section_name varchar(10) not null,
    dorm_id      integer     not null
);

alter table operations.repair_info
    owner to dorm;

create unique index repair_info_dorm_id_uindex
    on operations.repair_info (dorm_id);

create unique index repair_info_id_uindex
    on operations.repair_info (id);

create unique index repair_info_num_room_uindex
    on operations.repair_info (num_room);

create unique index repair_info_section_name_uindex
    on operations.repair_info (section_name);



create table operations.repair_request
(
    id             serial
        constraint repair_request_pk
            primary key,
    status_id      integer not null
        constraint repair_request_request_status_id_fk
            references operations.request_status,
    comment        text    not null,
    repair_info_id integer not null
        constraint repair_request_repair_info_id_fk
            references operations.repair_info,
    repair_type_id    integer not null
        constraint repair_request_repair_type_id_fk
            references operations.repair_type
);

comment on column operations.repair_request.status_id is 'Статус заявки';

comment on column operations.repair_request.comment is 'Текст заявки';

alter table operations.repair_request
    owner to dorm;

create unique index repair_request_id_uindex
    on operations.repair_type (id);

create table operations.certificate_request
(
    id        serial
        constraint certificate_request_pk
            primary key,
    comment   text,
    quantity  integer,
    status_id integer
        constraint certificate_request_request_status_id_fk
            references operations.request_status,
    tenant_id integer not null
);

comment on table operations.certificate_request is 'Заявка на справку о проживании';

alter table operations.certificate_request
    owner to dorm;

create unique index certificate_request_id_uindex
    on operations.certificate_request (id);
