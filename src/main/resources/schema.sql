drop table users_roles;
drop table user_account;
drop table roles;


-- roles 테이블 생성
CREATE TABLE roles
(
    id   BIGINT AUTO_INCREMENT NOT NULL,
    name VARCHAR(255)          NOT NULL UNIQUE,
    CONSTRAINT pk_roles PRIMARY KEY (id)
);

-- user_account 테이블 생성
CREATE TABLE user_account
(
    id       BIGINT AUTO_INCREMENT NOT NULL,
    name     VARCHAR(255)          NOT NULL,
    email    VARCHAR(255)          NOT NULL UNIQUE,
    password VARCHAR(255)          NOT NULL,
    CONSTRAINT pk_user_account PRIMARY KEY (id)
);

CREATE TABLE users_roles
(
    role_id         BIGINT NOT NULL,
    user_account_id BIGINT NOT NULL
);

ALTER TABLE users_roles
    ADD CONSTRAINT fk_userol_on_role FOREIGN KEY (role_id) REFERENCES roles (id);

ALTER TABLE users_roles
    ADD CONSTRAINT fk_userol_on_user_account FOREIGN KEY (user_account_id) REFERENCES user_account (id);