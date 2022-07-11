-- liquibase formatted sql

-- changeset thepro545:1

create table notification_task (
    id serial not null primary key,
    chat_id bigint not null,
    notification_date timestamp not null,
    notification_message varchar(255) not null,
    status varchar(255) not null default 'SCHEDULED',
    send_date timestamp
);

CREATE INDEX notification_task_date_idx ON notification_task (notification_date) WHERE status = 'SCHEDULED';

