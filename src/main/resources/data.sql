INSERT INTO public.sys_user
(user_id, user_name, password, first_name, last_name, email, activated, lang_key, activation_key, reset_key, reset_date, created_by, created_date, updated_by, updated_date)
VALUES(2, 'ujang', 'ss', 'ss', 'ss', 'ss', true, 'ss', 'ss', 'ss', NULL, 'ss', '2016-10-30', NULL, '2016-10-30');
INSERT INTO public.sys_user
(user_id, user_name, password, first_name, last_name, email, activated, lang_key, activation_key, reset_key, reset_date, created_by, created_date, updated_by, updated_date)
VALUES(1, 'edwar', 'ee', 'dd', 'dd', 'ddd', true, '11', '11', '11', NULL, 'edwar', '2016-10-30', NULL, '2016-10-30');


insert into sys_role(role_id, name) values(1,'ADMIN');
insert into sys_role(role_id, name) values(2,'USER');

INSERT INTO public.r_user_role
(user_id, role_id)
VALUES(2, 2);
INSERT INTO public.r_user_role
(user_id, role_id)
VALUES(1, 2);
INSERT INTO public.r_user_role
(user_id, role_id)
VALUES(1, 1);