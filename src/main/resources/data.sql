insert into knowledge_packages (title, description, date) values("title 1", "description 1", "12-03-2023");
insert into knowledge_packages (title, description, date) values("title 2", "description 2", "13-03-2023");
insert into knowledge_packages (title, description, date) values("title 3", "description 3", "14-03-2023");

insert into knowledge_package_sets (title) values("title 1");
insert into knowledge_package_sets (title) values("title 2");
insert into knowledge_package_sets (title) values("title 3");

insert into knowledge_packages_knowledge_package_sets (knowledge_package_id, knowledge_package_set_id) values(1, 1);
insert into knowledge_packages_knowledge_package_sets (knowledge_package_id, knowledge_package_set_id) values(2, 1);
insert into knowledge_packages_knowledge_package_sets (knowledge_package_id, knowledge_package_set_id) values(3, 2);
insert into knowledge_packages_knowledge_package_sets (knowledge_package_id, knowledge_package_set_id) values(1, 3);