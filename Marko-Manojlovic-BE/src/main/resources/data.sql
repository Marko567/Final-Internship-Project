INSERT INTO `city` (`zip_code`, `name`) VALUES
('11000', 'Beograd'),
('18000', 'Nis'),
('21000', 'Novi Sad');

INSERT INTO `semester_entity` (`semester_entity_id`, `semester_name`) VALUES (1, 'Summer'), (2, 'Winter');

INSERT INTO `title` (`title_id`, `name`) VALUES 
(1, 'Docent'),
(2, 'Vanredni profesor'),
(3, 'Redovni profesor');

INSERT INTO `user` (`firstname`, `lastname`, `username`, `password`) VALUES
('Marko', 'Markovic', 'marko', 'marko'),
('Mario', 'Ferketic', 'mar', 'io');

INSERT INTO `authorities` (`username`, `authority`) VALUES
('marko', 'ROLE_ADMIN'),
('mar', 'ROLE_USER');

INSERT INTO `student` (`firstname`, `lastname`, `index_number`, `index_year`, `email`, `address`, `postal_code`, `current_year_of_study`) VALUES
('Petar', 'Petrovic', '3522', 2022, 'a.b@c.com', 'Stojana Protica 32', 11000, 2);

INSERT INTO `subject` (`name`, `description`, `no_of_esp`, `semester`) VALUES
('Matematika 1', 'Matematicka analiza Zakljucno sa izvodima', 7, 1);