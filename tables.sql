create table users(
    user_id integer not null,
    user_login varchar(50),
    constraint pkey_users primary key (user_id)
);

create table notes(
    user_id integer not null,
    note_id integer not null,
    tag_list_id integer not null,
    note_text varchar(10000),
    creation_date date not null,
    constraint pkey_notes primary key(note_id),
    constraint fkey_for_users foreign key(user_id) references user(user_id)
);

create table tags(
    tag_id integer not null,
    tag_list_id integer not null,
    tag_text varchar(100),
    constraint pkey_tags primary key(tag_id),
    constraint fkey_for_tag_list foreign key(tag_id) references tag_list(tag_id)
);

create table tag_list(
    tag_list_id integer not null,
    tag_id integer not null,
    constraint pkey_tag_lists primary key(tag_list_id),
    constraint fkey_for_notes foreign key(tag_list_id) references notes(tag_list_id)
);