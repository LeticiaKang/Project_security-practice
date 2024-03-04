
insert into user_account (id, name, email, password) values
                                                         (1,'땡땡 가', 'aasa@naver.com', '{noop}asdf123'),
                                                         (2, '땡떙 나', 'azasa@naver.com', '{noop}asdf123'),
                                                         (3, '땡떙 다', 'aaafa@naver.com', '{noop}asdf123')
;

insert into roles (id, name) values
    (1,'ROLE_ADMIN'),
    (2,'ROLE_USER'),
    (3,'ROLE_VIP')
;

insert into users_roles (user_account_id, role_id) values
               (3,1),
               (2,2),
               (1,3)
;