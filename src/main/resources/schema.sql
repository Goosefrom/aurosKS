create database if not exists `auros`;
use `auros`;
create table if not exists `knowledge_packages` (
    `id`    bigint  not null auto_increment,
    `title` varchar(250)    default null,
    `description`   varchar(2000)   not null,
    `date` varchar(10) not null,
    primary key (`id`),
    unique key `knowledge_packages_id_uindex` (`id`)
)
engine = InnoDB auto_increment = 1 default charset  = utf8mb3;

create table if not exists `knowledge_package_sets` (
    `id`    bigint  not null auto_increment,
    `title` varchar(250)    not null,
    primary key (`id`),
    unique key `knowledge_package_sets_id_uindex` (`id`)
)
engine = InnoDB auto_increment = 1 default charset  = utf8mb3;

create table if not exists `knowledge_packages_knowledge_package_sets` (
    `knowledge_package_id`  bigint  not null,
    `knowledge_package_set_id`  bigint  not null,
    key `foreign_kpac_idx` (`knowledge_package_id`),
    key `foreign_kpac_set_idx` (`knowledge_package_set_id`),
    constraint `foreign_kpac` foreign key (`knowledge_package_id`) references `knowledge_packages` (`id`) on delete cascade,
    constraint `foreign_kpac_set` foreign key (`knowledge_package_set_id`) references `knowledge_package_sets` (`id`) on delete cascade
)
engine = InnoDB default charset  = utf8mb3;
