--
-- JBoss, Home of Professional Open Source
-- Copyright 2015, Red Hat, Inc. and/or its affiliates, and individual
-- contributors by the @authors tag. See the copyright.txt in the
-- distribution for a full listing of individual contributors.
--
-- Licensed under the Apache License, Version 2.0 (the "License");
-- you may not use this file except in compliance with the License.
-- You may obtain a copy of the License at
-- http://www.apache.org/licenses/LICENSE-2.0
-- Unless required by applicable law or agreed to in writing, software
-- distributed under the License is distributed on an "AS IS" BASIS,
-- WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
-- See the License for the specific language governing permissions and
-- limitations under the License.
--

-- You can use this file to load seed data into the database using SQL statements

INSERT INTO User (id, username, password, email, firstName, lastName, role) VALUES (-1, 'admin', 'ISMvKXpXpadDiUoOSoAfww==', 'admin@test.cz', 'Petr', 'Správce', 'ADMIN');
INSERT INTO User (id, username, password, email, firstName, lastName, role) VALUES (-2, 'manager', 'HQJYwkQKjRnnFikrIx4xkA==', 'manager@test.cz', 'Iva', 'Vedoucí', 'MANAGER');
INSERT INTO User (id, username, password, email, firstName, lastName, role) VALUES (-3, 'pharmacist', '/TBRV3gkraIbPfd3gSxm+g==', 'pharmacist@test.cz', 'Jana', 'Lékarníková', 'PHARMACIST');

INSERT INTO Doctor (id, name, town, street, number, postCode, phone) VALUES (-1, 'Petr Doktor', 'Brno', 'Ulice', '12/345', 60012, '+420 123 456 789');
INSERT INTO Doctor (id, name, town, street, number, postCode, phone) VALUES (-2, 'Jana Lékařka', 'Břeclav', 'Ulice', '12/345', 60012, '+420 123 456 789');

INSERT INTO Category (id, paidPrice, title, validFrom, validTo) VALUES (-1, 40, 'Hrazeno 40%', NOW(), NULL);
INSERT INTO Category (id, paidPrice, title, validFrom, validTo) VALUES (-2, 0, 'Bez doplatku', NOW(), NULL);
INSERT INTO Category (id, paidPrice, title, validFrom, validTo) VALUES (-3, 100, 'Nehrazeno', NOW(), NULL);

INSERT INTO Medicament (id, category_id, deliveryPrice, margin, prescription, title, validFrom, validTo) VALUES (-1, -3, 35.50, 25.60, FALSE, 'Paralen', NOW(), NULL);
INSERT INTO Medicament (id, category_id, deliveryPrice, margin, prescription, title, validFrom, validTo) VALUES (-2, -2, 400.20, 25.60, FALSE, 'Inzulin', NOW(), NULL);
INSERT INTO Medicament (id, category_id, deliveryPrice, margin, prescription, title, validFrom, validTo) VALUES (-3, -1, 152.31, 25.60, FALSE, 'Ataralgin', NOW(), NULL);

INSERT INTO Insurance (id, insuranceNumber, name, citty, street, houseNumber, postcode, phoneNumber) VALUES (-1, 300, 'VZP', 'Praha', 'Jižní', 456, 12345, 789456123);

INSERT INTO Customer (id, name, citty, street, houseNumber, postcode, phoneNumber, email, insurance_id) VALUES (-1, 'Karel Arazim', 'Brno', 'Četnická', 45, 45612, 789456123, 'karel@gmail.com', -1);
