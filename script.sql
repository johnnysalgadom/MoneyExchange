-- DROP SCHEMA public;

CREATE SCHEMA public AUTHORIZATION postgres;

-- DROP SEQUENCE public.currency_id_seq;

CREATE SEQUENCE public.currency_id_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;
-- DROP SEQUENCE public.exchange_id_seq;

CREATE SEQUENCE public.exchange_id_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;
-- DROP SEQUENCE public.exchange_rate_id_seq;

CREATE SEQUENCE public.exchange_rate_id_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;
-- DROP SEQUENCE public.rol_id_seq;

CREATE SEQUENCE public.rol_id_seq
	NO MINVALUE
	NO MAXVALUE;
-- DROP SEQUENCE public.role_id_seq;

CREATE SEQUENCE public.role_id_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;
-- DROP SEQUENCE public.users_id_seq;

CREATE SEQUENCE public.users_id_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;-- public.currency definition

-- Drop table

-- DROP TABLE public.currency;

CREATE TABLE public.currency (
	id bigserial NOT NULL,
	description varchar(32) NOT NULL,
	abbreviation varchar(4) NOT NULL,
	status bool NOT NULL DEFAULT true,
	created timestamp NOT NULL DEFAULT now(),
	created_by varchar(64) NULL DEFAULT NULL::character varying,
	updated timestamp NULL,
	updated_by varchar(64) NULL DEFAULT NULL::character varying,
	CONSTRAINT currency_pkey PRIMARY KEY (id)
);


-- public.databasechangelog definition

-- Drop table

-- DROP TABLE public.databasechangelog;

CREATE TABLE public.databasechangelog (
	id varchar(255) NOT NULL,
	author varchar(255) NOT NULL,
	filename varchar(255) NOT NULL,
	dateexecuted timestamp NOT NULL,
	orderexecuted int4 NOT NULL,
	exectype varchar(10) NOT NULL,
	md5sum varchar(35) NULL,
	description varchar(255) NULL,
	"comments" varchar(255) NULL,
	tag varchar(255) NULL,
	liquibase varchar(20) NULL,
	contexts varchar(255) NULL,
	labels varchar(255) NULL,
	deployment_id varchar(10) NULL
);


-- public.databasechangeloglock definition

-- Drop table

-- DROP TABLE public.databasechangeloglock;

CREATE TABLE public.databasechangeloglock (
	id int4 NOT NULL,
	"locked" bool NOT NULL,
	lockgranted timestamp NULL,
	lockedby varchar(255) NULL,
	CONSTRAINT databasechangeloglock_pkey PRIMARY KEY (id)
);


-- public."role" definition

-- Drop table

-- DROP TABLE public."role";

CREATE TABLE public."role" (
	id bigserial NOT NULL,
	description varchar(32) NOT NULL,
	status bool NOT NULL DEFAULT true,
	created timestamp NOT NULL DEFAULT now(),
	created_by varchar(64) NULL DEFAULT NULL::character varying,
	updated timestamp NULL,
	updated_by varchar(64) NULL DEFAULT NULL::character varying,
	CONSTRAINT role_pkey PRIMARY KEY (id)
);
CREATE INDEX idx_role_status ON public.role USING btree (status);


-- public.exchange_rate definition

-- Drop table

-- DROP TABLE public.exchange_rate;

CREATE TABLE public.exchange_rate (
	id bigserial NOT NULL,
	currency_id int4 NOT NULL,
	exchange_date timestamp NOT NULL,
	sale_value numeric(6, 3) NOT NULL,
	purchase_value numeric(6, 3) NOT NULL,
	status bool NOT NULL DEFAULT true,
	created timestamp NOT NULL DEFAULT now(),
	created_by varchar(64) NULL DEFAULT NULL::character varying,
	updated timestamp NULL,
	updated_by varchar(64) NULL DEFAULT NULL::character varying,
	CONSTRAINT exchange_rate_pkey PRIMARY KEY (id),
	CONSTRAINT exchange_rate_fk FOREIGN KEY (currency_id) REFERENCES public.currency(id)
);


-- public.users definition

-- Drop table

-- DROP TABLE public.users;
CREATE DATABASE test;

CREATE TABLE public.users (
	id bigserial NOT NULL,
	user_name varchar(64) NOT NULL,
	"password" varchar(64) NOT NULL,
	email varchar(128) NULL DEFAULT NULL::character varying,
	status bool NOT NULL DEFAULT true,
	created timestamp NOT NULL DEFAULT now(),
	created_by varchar(64) NULL DEFAULT NULL::character varying,
	updated timestamp NULL,
	updated_by varchar(64) NULL DEFAULT NULL::character varying,
	role_id int4 NULL,
	CONSTRAINT user_pkey PRIMARY KEY (id),
	CONSTRAINT users_fk FOREIGN KEY (role_id) REFERENCES public."role"(id)
);


-- public.exchange definition

-- Drop table

-- DROP TABLE public.exchange;

CREATE TABLE public.exchange (
	id bigserial NOT NULL,
	currency_id int4 NOT NULL,
	user_id int4 NOT NULL,
	exchange_date timestamp NOT NULL,
	sale_value numeric(6, 3) NOT NULL,
	purchase_value numeric(6, 3) NOT NULL,
	sale_amount numeric(10, 3) NOT NULL,
	purchase_amount numeric(10, 3) NOT NULL,
	sale_total numeric(10, 3) NOT NULL,
	purchase_total numeric(10, 3) NOT NULL,
	status bool NOT NULL DEFAULT true,
	created timestamp NOT NULL DEFAULT now(),
	created_by varchar(64) NULL DEFAULT NULL::character varying,
	updated timestamp NULL,
	updated_by varchar(64) NULL DEFAULT NULL::character varying,
	CONSTRAINT exchange_pkey PRIMARY KEY (id),
	CONSTRAINT exchange_fk FOREIGN KEY (currency_id) REFERENCES public.currency(id),
	CONSTRAINT exchange_fk_1 FOREIGN KEY (user_id) REFERENCES public.users(id)
);

INSERT INTO public.currency (description, abbreviation, created_by) VALUES('Soles', 'S/.', 'johnny');
INSERT INTO public.currency (description, abbreviation, created_by) VALUES('Dólar americano', 'US$', 'johnny');
INSERT INTO public.currency (description, abbreviation, created_by) VALUES('Euro', '€', 'johnny');

INSERT INTO public."role" (description, created_by) VALUES('ROLE_ADMIN', 'johnny');
INSERT INTO public."role" (description, created_by) VALUES('ROLE_USER', 'johnny');
