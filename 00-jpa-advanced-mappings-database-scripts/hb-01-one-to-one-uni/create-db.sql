-- Table: public.instructor

-- DROP TABLE IF EXISTS public.instructor;
]
CREATE TABLE IF NOT EXISTS public.instructor
(
    id bigint NOT NULL,
    first_name character varying(45) COLLATE pg_catalog."default" DEFAULT NULL::character varying,
    last_name character varying(45) COLLATE pg_catalog."default" DEFAULT NULL::character varying,
    email character varying(45) COLLATE pg_catalog."default" DEFAULT NULL::character varying,
    instructor_detail_id bigint NOT NULL,
    CONSTRAINT instructor_pkey PRIMARY KEY (id),
    CONSTRAINT "FK_DETAIL" FOREIGN KEY (instructor_detail_id)
        REFERENCES public.instructor_detail (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.instructor
    OWNER to postgres;
	
	
-------------------------------------
-- Table: public.instructor_detail

-- DROP TABLE IF EXISTS public.instructor_detail;

CREATE TABLE IF NOT EXISTS public.instructor_detail
(
    id bigint NOT NULL,
    youtube_channel character varying(128) COLLATE pg_catalog."default" DEFAULT NULL::character varying,
    hobby character varying(45) COLLATE pg_catalog."default" DEFAULT NULL::character varying,
    CONSTRAINT instructor_detail_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.instructor_detail
    OWNER to postgres;
	
	
-----------------------------------------------
-- SEQUENCE: public.auto_increment_instructor

-- DROP SEQUENCE IF EXISTS public.auto_increment_instructor;

CREATE SEQUENCE IF NOT EXISTS public.auto_increment_instructor
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1
    OWNED BY instructor.id;

ALTER SEQUENCE public.auto_increment_instructor
    OWNER TO postgres;
-------------------------------------------------------
-- SEQUENCE: public.auto_increment_instructor_detail

-- DROP SEQUENCE IF EXISTS public.auto_increment_instructor_detail;

CREATE SEQUENCE IF NOT EXISTS public.auto_increment_instructor_detail
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.auto_increment_instructor_detail
    OWNER TO postgres;
	