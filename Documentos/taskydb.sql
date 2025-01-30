-- This script was generated by the ERD tool in pgAdmin 4.
-- Please log an issue at https://github.com/pgadmin-org/pgadmin4/issues/new/choose if you find any bugs, including reproduction steps.
BEGIN;


CREATE TABLE IF NOT EXISTS public.equipe
(
    idequipe integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 50000 CACHE 1 ),
    usuarioliderid integer,
    areaatuacao character varying COLLATE pg_catalog."default",
    descricao character varying COLLATE pg_catalog."default",
    funcao bit varying,
    idprojeto integer,
    CONSTRAINT equipe_pkey PRIMARY KEY (idequipe)
);

CREATE TABLE IF NOT EXISTS public.equipemembro
(
    idequipe integer NOT NULL,
    idusuario integer NOT NULL,
    CONSTRAINT equipemembro_pkey PRIMARY KEY (idequipe, idusuario)
);

CREATE TABLE IF NOT EXISTS public.perfil
(
    nome character varying COLLATE pg_catalog."default" NOT NULL,
    descricao character varying COLLATE pg_catalog."default",
    funcao character varying COLLATE pg_catalog."default",
    idusuario integer NOT NULL,
    CONSTRAINT perfil_pkey PRIMARY KEY (idusuario)
);

CREATE TABLE IF NOT EXISTS public.projeto
(
    idprojeto integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 100000 CACHE 1 ),
    nome character varying COLLATE pg_catalog."default" NOT NULL,
    descricao character varying COLLATE pg_catalog."default",
    datacriacao date,
    dataultima date,
    objetivo character varying COLLATE pg_catalog."default",
    CONSTRAINT projeto_pkey PRIMARY KEY (idprojeto)
);

CREATE TABLE IF NOT EXISTS public.projetolider
(
    idprojeto integer NOT NULL,
    idusuario integer NOT NULL,
    CONSTRAINT projetolider_pkey PRIMARY KEY (idprojeto, idusuario)
);

CREATE TABLE IF NOT EXISTS public.projetomembro
(
    idprojeto integer NOT NULL,
    idusuario integer NOT NULL,
    CONSTRAINT projetomembro_pkey PRIMARY KEY (idprojeto, idusuario)
);

CREATE TABLE IF NOT EXISTS public.tarefa
(
    idtarefa integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 100000 CACHE 1 ),
    prazoentrega date,
    descricao character varying COLLATE pg_catalog."default",
    prioridade character varying COLLATE pg_catalog."default",
    datacriacao date,
    idusuario integer,
    idequipe integer,
    idprojeto integer,
    CONSTRAINT tarefa_pkey PRIMARY KEY (idtarefa)
);

CREATE TABLE IF NOT EXISTS public.tarefaacademica
(
    idtarefa integer NOT NULL,
    materia character varying COLLATE pg_catalog."default",
    professor character varying COLLATE pg_catalog."default",
    nota double precision,
    CONSTRAINT tarefaacademica_pkey PRIMARY KEY (idtarefa)
);

CREATE TABLE IF NOT EXISTS public.tarefapessoal
(
    idtarefa integer NOT NULL,
    recorrencia character varying COLLATE pg_catalog."default",
    local character varying COLLATE pg_catalog."default",
    CONSTRAINT tarefapessoal_pkey PRIMARY KEY (idtarefa)
);

CREATE TABLE IF NOT EXISTS public.tarefatrabalho
(
    idtarefa integer NOT NULL,
    departamento character varying COLLATE pg_catalog."default",
    prazoentrega date,
    CONSTRAINT tarefatrabalho_pkey PRIMARY KEY (idtarefa)
);

CREATE TABLE IF NOT EXISTS public.usuario
(
    senha character varying COLLATE pg_catalog."default" NOT NULL,
    nome character varying COLLATE pg_catalog."default" NOT NULL,
    email character varying COLLATE pg_catalog."default",
    "idUsuario" integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 100000 CACHE 1 ),
    CONSTRAINT usuario_pkey PRIMARY KEY ("idUsuario")
);

ALTER TABLE IF EXISTS public.equipe
    ADD CONSTRAINT equipe_idprojeto_fkey FOREIGN KEY (idprojeto)
    REFERENCES public.projeto (idprojeto) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;


ALTER TABLE IF EXISTS public.equipe
    ADD CONSTRAINT equipe_usuarioliderid_fkey FOREIGN KEY (usuarioliderid)
    REFERENCES public.usuario ("idUsuario") MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;


ALTER TABLE IF EXISTS public.equipemembro
    ADD CONSTRAINT equipemembro_idequipe_fkey FOREIGN KEY (idequipe)
    REFERENCES public.equipe (idequipe) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;


ALTER TABLE IF EXISTS public.equipemembro
    ADD CONSTRAINT equipemembro_idusuario_fkey FOREIGN KEY (idusuario)
    REFERENCES public.usuario ("idUsuario") MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;


ALTER TABLE IF EXISTS public.perfil
    ADD CONSTRAINT perfil_idusuario_fkey FOREIGN KEY (idusuario)
    REFERENCES public.usuario ("idUsuario") MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;
CREATE INDEX IF NOT EXISTS perfil_pkey
    ON public.perfil(idusuario);


ALTER TABLE IF EXISTS public.projetolider
    ADD CONSTRAINT projetolider_idprojeto_fkey FOREIGN KEY (idprojeto)
    REFERENCES public.projeto (idprojeto) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;


ALTER TABLE IF EXISTS public.projetomembro
    ADD CONSTRAINT projetomembro_idprojeto_fkey FOREIGN KEY (idprojeto)
    REFERENCES public.projeto (idprojeto) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;


ALTER TABLE IF EXISTS public.projetomembro
    ADD CONSTRAINT projetomembro_idusuario_fkey FOREIGN KEY (idusuario)
    REFERENCES public.usuario ("idUsuario") MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;


ALTER TABLE IF EXISTS public.tarefa
    ADD CONSTRAINT tarefa_idequipe_fkey FOREIGN KEY (idequipe)
    REFERENCES public.equipe (idequipe) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;


ALTER TABLE IF EXISTS public.tarefa
    ADD CONSTRAINT tarefa_idprojeto_fkey FOREIGN KEY (idprojeto)
    REFERENCES public.projeto (idprojeto) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;


ALTER TABLE IF EXISTS public.tarefa
    ADD CONSTRAINT tarefa_idusuario_fkey FOREIGN KEY (idusuario)
    REFERENCES public.usuario ("idUsuario") MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;


ALTER TABLE IF EXISTS public.tarefaacademica
    ADD CONSTRAINT tarefaacademica_idtarefa_fkey FOREIGN KEY (idtarefa)
    REFERENCES public.tarefa (idtarefa) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;
CREATE INDEX IF NOT EXISTS tarefaacademica_pkey
    ON public.tarefaacademica(idtarefa);


ALTER TABLE IF EXISTS public.tarefapessoal
    ADD CONSTRAINT tarefapessoal_idtarefa_fkey FOREIGN KEY (idtarefa)
    REFERENCES public.tarefa (idtarefa) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;
CREATE INDEX IF NOT EXISTS tarefapessoal_pkey
    ON public.tarefapessoal(idtarefa);


ALTER TABLE IF EXISTS public.tarefatrabalho
    ADD CONSTRAINT tarefatrabalho_idtarefa_fkey FOREIGN KEY (idtarefa)
    REFERENCES public.tarefa (idtarefa) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;
CREATE INDEX IF NOT EXISTS tarefatrabalho_pkey
    ON public.tarefatrabalho(idtarefa);

END;