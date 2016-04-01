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

INSERT INTO User (id, username, password, email, firstName, lastName, role) VALUES (1, 'admin', 'ISMvKXpXpadDiUoOSoAfww==', 'admin@test.cz', 'Správce', 'Správcovič', 'ADMIN');

INSERT INTO Doctor (id, name, town, street, number, postCode, phone) VALUES (1, 'Testovací doktor', 'Město', 'Ulice', '12/345', 60012, '+420 123 456 789');

INSERT INTO Customer (id) VALUES (1);

INSERT INTO Medicament (id) VALUES (1);
