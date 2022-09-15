--liquibase formatted sql
--changeset ilya:1
create table empl_project (
    prj_id bigint not null,
    empl_id bigint not null,
    primary key (prj_id, empl_id))
    engine=MyISAM;
--changeset ilya:2
create table Employee (
     id bigint not null auto_increment,
     name varchar(255), surname varchar(255),
     empl_id bigint, primary key (id))
    engine=MyISAM;
--changeset ilya:3
create table Position (
     id bigint not null auto_increment,
     name varchar(255),
     primary key (id))
    engine=MyISAM;
--changeset ilya:3
create table Project (
     id bigint not null auto_increment,
     name varchar(255),
     customer_id bigint,
      primary key (id))
    engine=MyISAM;
--changeset ilya:4
alter table empl_project
    add constraint FKi61jiw0nl0ixahmy261koucse
        foreign key (empl_id)
            references Employee (id);
--changeset ilya:5
alter table empl_project
    add constraint FKqjvx0rcoxohsncxnpev9bgelx
        foreign key (prj_id)
            references Project (id);

--changeset ilya:6
alter table Employee
    add constraint
        FK3vmreodv23dhp4ajdfqlsq2hp
        foreign key (empl_id)
            references Position (id);
--changeset ilya:7
alter table Project
    add constraint
        FKsbm64qmwf17w5fdaueknmxbji
        foreign key (customer_id)
            references Customer(id);
