create user "dorm" WITH PASSWORD 'jw8s0F4';

create schema data;
alter schema data owner to dorm;

create schema operations;
alter schema operations owner to dorm;

create schema security;
alter schema security owner to dorm;

GRANT ALL ON SCHEMA data TO dorm; --права на CREATE и USAGE
ALTER DEFAULT PRIVILEGES IN SCHEMA data GRANT ALL ON TABLES TO dorm; --права на таблицы
ALTER DEFAULT PRIVILEGES IN SCHEMA data GRANT ALL ON SEQUENCES TO dorm; --права на sequence-ы
ALTER DEFAULT PRIVILEGES IN SCHEMA data GRANT ALL ON FUNCTIONS TO dorm; --права на функции
ALTER DEFAULT PRIVILEGES IN SCHEMA data GRANT ALL ON TYPES TO dorm; --права на типы

GRANT ALL ON SCHEMA operations TO dorm; --права на CREATE и USAGE
ALTER DEFAULT PRIVILEGES IN SCHEMA operations GRANT ALL ON TABLES TO dorm; --права на таблицы
ALTER DEFAULT PRIVILEGES IN SCHEMA operations GRANT ALL ON SEQUENCES TO dorm; --права на sequence-ы
ALTER DEFAULT PRIVILEGES IN SCHEMA operations GRANT ALL ON FUNCTIONS TO dorm; --права на функции
ALTER DEFAULT PRIVILEGES IN SCHEMA operations GRANT ALL ON TYPES TO dorm; --права на типы

GRANT ALL ON SCHEMA security TO dorm; --права на CREATE и USAGE
ALTER DEFAULT PRIVILEGES IN SCHEMA security GRANT ALL ON TABLES TO dorm; --права на таблицы
ALTER DEFAULT PRIVILEGES IN SCHEMA security GRANT ALL ON SEQUENCES TO dorm; --права на sequence-ы
ALTER DEFAULT PRIVILEGES IN SCHEMA security GRANT ALL ON FUNCTIONS TO dorm; --права на функции
ALTER DEFAULT PRIVILEGES IN SCHEMA security GRANT ALL ON TYPES TO dorm; --права на типы