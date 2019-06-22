DROP TABLE IF EXISTS pilots;
CREATE TABLE IF NOT EXISTS pilots
(
    id         INTEGER PRIMARY KEY AUTO_INCREMENT,
    pilotname  VARCHAR(255)  NOT NULL,
    birthdate  SMALLDATETIME NOT NULL,
    experience INT           NOT NULL,
    aircraft   VARCHAR(255)  NOT NULL
);
DROP TABLE IF EXISTS roles;
CREATE TABLE IF NOT EXISTS roles
(
    id        INTEGER PRIMARY KEY AUTO_INCREMENT,
    team_role VARCHAR(255) NOT NULL

);
DROP TABLE IF EXISTS team;
CREATE TABLE IF NOT EXISTS team
(
    id           INTEGER PRIMARY KEY AUTO_INCREMENT,
    pilotes_id   INTEGER       NOT NULL REFERENCES pilots,
    member_name  VARCHAR(255)  NOT NULL,
    roles_id     INTEGER       NOT NULL REFERENCES roles,
    time_in_team SMALLDATETIME NOT NULL
);



-- SELECT * FROM team;
-- SELECT * FROM ROLES;
-- SELECT * FROM pilots;

DROP TABLE IF EXISTS users;
CREATE TABLE IF NOT EXISTS users
(
    id                      INTEGER PRIMARY KEY AUTO_INCREMENT,
    username                VARCHAR(255) UNIQUE NOT NULL,
    password                VARCHAR(255)        NOT NULL,
    enabled                 BOOLEAN             NOT NULL DEFAULT TRUE,
    account_non_expired     BOOLEAN             NOT NULL DEFAULT TRUE,
    account_non_locked      BOOLEAN             NOT NULL DEFAULT TRUE,
    credentials_non_expired BOOLEAN             NOT NULL DEFAULT TRUE
);

DROP TABLE IF EXISTS authorities;
CREATE TABLE IF NOT EXISTS authorities
(
    id        INTEGER PRIMARY KEY AUTO_INCREMENT,
    user_id   INTEGER      NOT NULL REFERENCES users,
    authority VARCHAR(255) NOT NULL
);
