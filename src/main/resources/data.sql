INSERT INTO pilots (id, pilotname, birthdate, experience, aircraft)
VALUES (1, 'Martin Sonka', '1973-08-09', 25, 'junkers-87'),
       (2, 'Yoshihide Muroya', '1970-08-07', 30, 'EDGE-540 V3'),
       (3, 'Pete McLeod', '1979-09-08', 20, 'EDGE-540 V3'),
       (4, 'Nicolas Ivanoff', '1968-05-19', 35, 'EDGE-540' ||
                                                ' V2');


INSERT INTO roles (id1, team_role)
VALUES (1, 'technician'),
       (2, 'team manager'),
       (3, 'promoter'),
       (4, 'assistant'),
       (5, 'accountant');

INSERT INTO team (id, pilotes_id, member_name, roles_id, time_in_team)
VALUES (1, 2, 'Morris', 1, '2005-08-09'),
       (2, 2, 'Harris', 2, '2017-09-09'),
       (3, 2, 'Garris', 3, '2017-09-09'),
       (4, 1, 'Evans', 3, '2017-09-09'),
       (5, 1, 'Potter', 4, '2018-05-18'),
       (6, 1, 'Dursley', 4, '2018-05-18'),
       (7, 3, 'Watson', 5, '2017-08-07'),
       (8, 3, 'Wisley', 1, '2016-07-07'),
       (9, 3, 'Dambldor', 1, '2007-07-08'),
       (10, 4, 'McGonagal', 2, '2007-07-08'),
       (11, 4, 'Malfoy', 5, '2007-07-08'),
       (12, 4, 'Granger', 1, '2007-07-08');


SELECT id, pilotes_id, member_name, time_in_team, TEAM_ROLE FROM  team, roles WHERE pilotes_id=1 AND team.ROLES_ID = ROLES.ID1;
 ;


