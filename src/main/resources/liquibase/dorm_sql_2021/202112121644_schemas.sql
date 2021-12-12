create user "dorm" WITH PASSWORD 'jw8s0F4';

create schema data;
alter schema data owner to dorm;

create schema operations;
alter schema operations owner to dorm;

create schema security;
alter schema security owner to dorm;

grant SELECT, INSERT, UPDATE, DELETE on ALL tables in schema data TO dorm;
grant SELECT, USAGE on ALL sequences in schema data TO dorm;

grant SELECT, INSERT, UPDATE, DELETE on ALL tables in schema operations TO dorm;
grant SELECT, USAGE on ALL sequences in schema operations TO dorm;

grant SELECT, INSERT, UPDATE, DELETE on ALL tables in schema security TO dorm;
grant SELECT, USAGE on ALL sequences in schema security TO dorm;