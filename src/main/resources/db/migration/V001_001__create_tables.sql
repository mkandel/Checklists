/*
 * Copyright (c) 2020. Marc Kandel
 */

--
-- Copyright (c) 2020. Marc Kandel
--

create table users
(
    id          int           not null auto_increment primary key,
    username    VARCHAR(30)   not null unique,
    email       VARCHAR(50)   not null unique,
    displayname VARCHAR(50)   null,
    active      BIT default 1 not null
);
create table roles
(
    id       int         not null auto_increment primary key,
    rolename VARCHAR(30) not null unique
);
create table user_roles
(
    user_id int not null,
    role_id int not null,
    foreign key (user_id) references users (id),
    foreign key (role_id) references roles (id),
    unique (user_id, role_id),
    primary key (user_id, role_id)
);
create table checklist_templates
(
    id      int not null auto_increment primary key,
    creator int not null,
    name    VARCHAR(50) not null,
    foreign key (creator) references users (id)
);
create table item_templates
(
    id                 int auto_increment not null primary key,
    name               varchar(50)        not null,
    text               text               not null,
    position           int,
    checklist_template int                not null,
    foreign key (checklist_template) references checklist_templates (id)
);
create table checklists
(
    id                 int         not null auto_increment primary key,
    name               varchar(50) not null,
    checklist_template int         not null,
    creator            int         not null,
    create_date        datetime    not null default current_timestamp,
    update_date        datetime    not null default current_timestamp,
    complete           bit                  default 0 not null,
    completed_date     datetime,
    foreign key (checklist_template) references checklist_templates (id),
    foreign key (creator) references users (id)
);
create table items
(
    id             int           not null auto_increment primary key,
    item_template  int           not null,
    complete       bit default 0 not null,
    completed_date datetime,
    checklist      int,
    foreign key (item_template) references item_templates (id),
    foreign key (checklist) references checklists (id)
);
create table usergroups
(
        id int not null auto_increment primary key,
        groupname VARCHAR(30) not null unique
);
create table user_usergroups
(
    user  int not null,
    usergroup int not null,
    foreign key (user) references users (id),
    foreign key (usergroup) references usergroups (id),
    unique (user, usergroup),
    primary key (user, usergroup)
);
create table checklist_assignees
(
    user      int not null,
    checklist int not null,
    foreign key (user) references users (id),
    foreign key (checklist) references checklists (id),
    unique (user, checklist),
    primary key (user, checklist)
);
create table usergroup_roles
(
    usergroup int not null,
    role  int not null,
    foreign key (usergroup) references usergroups (id),
    foreign key (role) references roles (id),
    unique (usergroup, role),
    primary key (usergroup, role)
);