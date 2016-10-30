CREATE SEQUENCE user_id_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 19
  CACHE 1;

CREATE TABLE sys_user
(
  user_id bigint NOT NULL DEFAULT nextval('user_id_seq'::regclass),
  user_name character varying(50) NOT NULL,
  password character varying(60),
  first_name character varying(50),
  last_name character varying(50),
  email character varying(100),
  activated boolean NOT NULL,
  lang_key character varying(5),
  activation_key character varying(20),
  reset_key character varying(20),
  reset_date timestamp without time zone,
  created_by character varying(50) NOT NULL,
  created_date timestamp without time zone NOT NULL,
  updated_by character varying(50),
  updated_date timestamp without time zone DEFAULT now(),
  CONSTRAINT pk_user PRIMARY KEY (user_id),
  CONSTRAINT user_email_key UNIQUE (email),
  CONSTRAINT user_user_name_key UNIQUE (user_name)
)

CREATE SEQUENCE public.role_id_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 19
  CACHE 1;

CREATE TABLE public.sys_role
(
  role_id bigint NOT NULL DEFAULT nextval('role_id_seq'::regclass),
  name character varying(100),
  CONSTRAINT sys_role_pk PRIMARY KEY (role_id)
)


CREATE TABLE r_user_role(
user_id bigint NOT NULL,
role_id bigint NOT NULL,
CONSTRAINT r_user_role_pk primary key(user_id,role_id)
);