INSERT INTO `city` (`zip_code`, `name`) VALUES
('11000', 'Beograd'),
('18000', 'Nis'),
('21000', 'Novi Sad');

INSERT INTO `semester_entity` (`semester_entity_id`, `semester_name`) VALUES (1, 'Winter'), (2, 'Summer');

INSERT INTO `exam_period_status` (`status_id`, `name`) VALUES (1, 'Active'), (2, 'Inactive');

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
('Petar', 'Petrovic', '3522', 2022, 'a.by@c.com', 'Stojana Protica 32', 11000, 1),
('Jovan', 'Jovanovic', '8522', 2021, 'a.bf@c.com', 'Lava Tolstoja 876', 18000, 2),
('Petar', 'Petrovic', '4521', 2022, 'a.bg@c.com', 'Mostarska 21', 11000, 2),
('Zika', 'Zikic', '1523', 2020, 'a.bqw@c.com', 'Vukovarska 33', 11000, 3);

INSERT INTO `subject` (`name`, `description`, `no_of_esp`,`year_of_study`, `semester`) VALUES
('Matematika 1', 'Matematicka analiza Zakljucno sa izvodima', 5, 1, 1),
('Matematika 2', 'Matematicka analiza Zakljucno diferencijalnim jednacinama viseg reda', 5, 1, 2),
('OOP1', 'Objektno orjentisano programiranje 1', 7, 1, 2),
('OOP2', 'Objektno orjentisano programiranje 2', 7, 2, 1),
('Dizajn i analiza algoritama', 'Slozenost algoritama, podela, osnovni algoritmi pretrage itd.', 7, 2, 2),
('Uvod u web programiranje', 'HTML, CSS, osnove JavaScript-a', 6, 1, 2);

INSERT INTO `professor` (`firstname`, `lastname`, `email`, `address`, `phone`, `reelection_date`, `postal_code`, `title`) VALUES
('Predrag', 'Krtolica', 'predrag.krtolica@pmf.edu.rs', 'Boska Buhe 21', '0612233445', '2023-06-18', 18000, 2),
('Miljana', 'Stamenkovic', 'miljana.stamenkovic@pmf.edu.rs', 'Takovska 121', '0612873456', '2023-06-18', 18000, 2),
('Stefan', 'Stanimirovic', 'stefan.stanimirovic@pmf.edu.rs', 'Decanska 73', '0643287610', '2023-10-15', 18000, 1),
('Lola', 'Lolic', 'lola.lolic@fon.edu.rs', 'Proleterskih Brigada 98', '0643276610', '2022-10-15', 11000, 3);

INSERT INTO `engagement` (`professor_id`, `subject_id`) VALUES
(2, 1),
(2, 2),
(3, 5),
(4, 1);