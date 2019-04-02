-- users
create table users
(
  username varchar(10) not null
    primary key,
  password blob        not null,
  enabled  tinyint(1)  not null
)
  comment 'user table';

-- authorities
create table authorities
(
  username  varchar(10)                not null,
  authority varchar(50) default 'USER' not null,
  constraint authorities_users_username_fk
    foreign key (username) references users (username)
)
  comment 'authorities table';


-- users_authorities
create table users_authorities
(
  users_username       varchar(10) null,
  authorities_username varchar(10) null,
  constraint users_authorities_authorities_username_fk
    foreign key (authorities_username) references authorities (username),
  constraint users_authorities_users_username_fk
    foreign key (users_username) references users (username)
);


insert into users (username,password,enabled)
  values ('user','$2a$10$MKHQYipd.6DsGs9tiBAjyejzdJ0oKIjr5zeNVbVBy8UPQ9/7GgBUO',1);

insert into authorities (username,authority)
  values ('user','USER');

insert into users_authorities (users_username,authorities_username)
  values ('user','user');
