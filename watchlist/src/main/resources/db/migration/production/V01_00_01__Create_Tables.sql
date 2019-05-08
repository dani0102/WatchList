--
-- PostgreSQL database dump
--

-- Dumped from database version 10.4
-- Dumped by pg_dump version 10.4

-- Started on 2018-11-14 14:37:44

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 1 (class 3079 OID 12924)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: -
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 3023 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: -
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;


--create database watchlist;

create table public.movie (
	movie_id bigserial NOT NULL unique PRIMARY KEY,
	title varchar(100) NOT NULL,
	alias_title varchar(100),
	description varchar(255) NOT NULL,
	picture bytea,
	outcome_year bigint,
	length bigint
);

create table public.tvshow (
	tvshow_id bigserial NOT NULL unique PRIMARY KEY,
	title varchar(100) NOT NULL,
	alias_title varchar(100),
	description varchar(255) NOT NULL,
	picture bytea,
	outcome_year bigint,
	end_year bigint,
	average_length bigint
);

create table public.users (
	users_id bigserial NOT NULL unique PRIMARY KEY,
	username varchar(50) not null unique,
	firstname varchar(100) not null,
	lastname varchar(100) not null,
	birthdate date,
	email varchar(255) not null unique,
	password varchar(255) not null
);

create table public.role (
	role_id bigserial NOT NULL unique PRIMARY KEY,
	name varchar(255) not null unique
);

--
-- TOC entry 216 (class 1259 OID 21702)
-- Name: users_role; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.users_role (
    users_id bigint NOT NULL unique,
    role_id bigint NOT NULL unique,
    CONSTRAINT users_role_pkey PRIMARY KEY (users_id, role_id),
    CONSTRAINT fk_users FOREIGN KEY (users_id)
        REFERENCES public.users (users_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_role FOREIGN KEY (role_id)
        REFERENCES public.role (role_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

create table public.authority (
	authority_id bigserial NOT NULL unique PRIMARY KEY,
	name varchar(255) not null unique
);

create table public.authority_role (
	authority_id bigint NOT NULL unique,
	role_id bigint NOT NULL unique,
CONSTRAINT authority_role_pkey PRIMARY KEY (authority_id, role_id),
    CONSTRAINT fk_authority FOREIGN KEY (authority_id)
        REFERENCES public.authority (authority_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_role FOREIGN KEY (role_id)
        REFERENCES public.role (role_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);