# details-update-lld
# since this is an update api you need to have entries in table for that particular lead id
# here are create table queries

-- Table: usrone.user_perm_add

-- DROP TABLE IF EXISTS usrone.user_perm_add;

CREATE TABLE IF NOT EXISTS usrone.user_perm_add
(
    id character varying(255) COLLATE pg_catalog."default" NOT NULL,
    add_line_one character varying(255) COLLATE pg_catalog."default",
    add_line_two character varying(255) COLLATE pg_catalog."default",
    add_line_three character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT user_perm_add_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS usrone.user_perm_add
    OWNER to postgres;

-- Table: usrone.user_prof_dtls

-- DROP TABLE IF EXISTS usrone.user_prof_dtls;

CREATE TABLE IF NOT EXISTS usrone.user_prof_dtls
(
    id character varying(255) COLLATE pg_catalog."default" NOT NULL,
    occupation character varying(255) COLLATE pg_catalog."default",
    salary integer,
    CONSTRAINT user_prof_dtls_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS usrone.user_prof_dtls
    OWNER to postgres;

    -- Table: usrone.user_prsnl_dtls

-- DROP TABLE IF EXISTS usrone.user_prsnl_dtls;

CREATE TABLE IF NOT EXISTS usrone.user_prsnl_dtls
(
    id character varying(255) COLLATE pg_catalog."default" NOT NULL,
    name character varying(255) COLLATE pg_catalog."default",
    age integer,
    CONSTRAINT user_prsnl_dtls_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS usrone.user_prsnl_dtls
    OWNER to postgres;

    -- Table: usrone.user_temp_add

-- DROP TABLE IF EXISTS usrone.user_temp_add;

CREATE TABLE IF NOT EXISTS usrone.user_temp_add
(
    id character varying(255) COLLATE pg_catalog."default" NOT NULL,
    add_line_one character varying(255) COLLATE pg_catalog."default",
    add_line_two character varying(255) COLLATE pg_catalog."default",
    add_line_three character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT user_temp_add_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS usrone.user_temp_add
    OWNER to postgres;

# you need to add entries in every table.
# then use this curl and hit API from postman.

curl --location 'http://localhost:8083/dtls/update' \
--header 'Content-Type: application/json' \
--data '{
    "leadId":"1",
    "userDtlsReq":{
        "flags":["add","perProf"],
        "dtls":{
            "addOne":"new address line one",
            "addTwo":"new address line two",
            "addThree":"new address line three",
            "occupation":"SDE 2",
	        "name":"Sr.DEV",
	        "age":25,
	        "salary":300000
        }
    }
}'