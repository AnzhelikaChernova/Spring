create table user
(
    role       varchar(31)                                                                                                          not null,
    id         bigint auto_increment
        primary key,
    created_at datetime(6)                                                                                                          not null,
    email      varchar(255)                                                                                                         not null,
    firstname  varchar(255)                                                                                                         not null,
    is_deleted bit                                                                                                                  not null,
    lastname   varchar(255)                                                                                                         not null,
    password   varchar(255)                                                                                                         not null,
    course     enum ('FIRST', 'SECOND', 'THIRD', 'FOURTH')                                                       default 'FIRST'    null,
    department enum ('IT', 'ECONOMICS_AND_MANAGEMENT', 'LAW_AND_POLICY', 'ARTS_AND_SOCIAL_SCIENCES', 'BUSINESS') default 'IT'       null,
    grade      enum ('BACHELOR', 'MASTER', 'PHD')                                                                default 'BACHELOR' null,
    unique (email)
);

create table lesson
(
    id             bigint auto_increment
        primary key,
    cabinet        int                                                                                               null,
    course         enum ('FIRST', 'FOURTH', 'SECOND', 'THIRD')                                                       null,
    day_of_week    enum ('FRIDAY', 'MONDAY', 'SATURDAY', 'SUNDAY', 'THURSDAY', 'TUESDAY', 'WEDNESDAY')               null,
    department     enum ('ARTS_AND_SOCIAL_SCIENCES', 'BUSINESS', 'ECONOMICS_AND_MANAGEMENT', 'IT', 'LAW_AND_POLICY') null,
    name           varchar(255)                                                                                      not null,
    student_count  int                                                                                               null,
    time_of_lesson enum ('EIGHTH', 'FIFTH', 'FIRST', 'FOURTH', 'NINTH', 'SECOND', 'SEVENTH', 'SIXTH', 'THIRD')       null,
    created_at     datetime(6)                                                                                       not null,
    is_deleted     bit                                                                                               not null
);

create table student_lesson
(
    id         bigint auto_increment
        primary key,
    lesson_id  bigint not null,
    student_id bigint not null,
    foreign key (lesson_id) references lesson (id),
    foreign key (student_id) references user (id)
);

create table teacher_lesson
(
    id         bigint auto_increment
        primary key,
    lesson_id  bigint not null,
    teacher_id bigint not null,
    foreign key (teacher_id) references user (id),
    foreign key (lesson_id) references lesson (id)
);

