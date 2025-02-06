--
-- PostgreSQL database dump
--

-- Dumped from database version 17.2
-- Dumped by pg_dump version 17.2

-- Started on 2025-02-05 16:20:55

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 224 (class 1259 OID 16452)
-- Name: equipe; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.equipe (
    idequipe integer NOT NULL,
    usuarioliderid integer,
    areaatuacao character varying,
    descricao character varying,
    funcao character varying,
    idprojeto integer
);


ALTER TABLE public.equipe OWNER TO postgres;

--
-- TOC entry 223 (class 1259 OID 16451)
-- Name: equipe_idequipe_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.equipe ALTER COLUMN idequipe ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.equipe_idequipe_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 50000
    CACHE 1
);


--
-- TOC entry 226 (class 1259 OID 16524)
-- Name: equipemembro; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.equipemembro (
    idequipe integer NOT NULL,
    idusuario integer NOT NULL
);


ALTER TABLE public.equipemembro OWNER TO postgres;

--
-- TOC entry 218 (class 1259 OID 16413)
-- Name: perfil; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.perfil (
    nome character varying NOT NULL,
    descricao character varying,
    funcao character varying,
    idusuario integer NOT NULL,
    idperfil integer NOT NULL
);


ALTER TABLE public.perfil OWNER TO postgres;

--
-- TOC entry 232 (class 1259 OID 16603)
-- Name: perfil_idperfil_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.perfil ALTER COLUMN idperfil ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.perfil_idperfil_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 100000
    CACHE 1
);


--
-- TOC entry 221 (class 1259 OID 16429)
-- Name: projeto; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.projeto (
    idprojeto integer NOT NULL,
    nome character varying NOT NULL,
    descricao character varying,
    datacriacao date,
    dataultima date,
    objetivo character varying
);


ALTER TABLE public.projeto OWNER TO postgres;

--
-- TOC entry 220 (class 1259 OID 16428)
-- Name: projeto_idprojeto_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.projeto ALTER COLUMN idprojeto ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.projeto_idprojeto_seq
    START WITH 1
    INCREMENT BY 1
    MINVALUE 0
    MAXVALUE 100000
    CACHE 1
);


--
-- TOC entry 222 (class 1259 OID 16441)
-- Name: projetolider; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.projetolider (
    idprojeto integer NOT NULL,
    idusuario integer NOT NULL
);


ALTER TABLE public.projetolider OWNER TO postgres;

--
-- TOC entry 225 (class 1259 OID 16494)
-- Name: projetomembro; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.projetomembro (
    idprojeto integer NOT NULL,
    idusuario integer NOT NULL
);


ALTER TABLE public.projetomembro OWNER TO postgres;

--
-- TOC entry 228 (class 1259 OID 16540)
-- Name: tarefa; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tarefa (
    idtarefa integer NOT NULL,
    prazoentrega date,
    descricao character varying,
    prioridade character varying,
    datacriacao date,
    idusuario integer,
    idequipe integer,
    idprojeto integer
);


ALTER TABLE public.tarefa OWNER TO postgres;

--
-- TOC entry 227 (class 1259 OID 16539)
-- Name: tarefa_idtarefa_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.tarefa ALTER COLUMN idtarefa ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.tarefa_idtarefa_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 100000
    CACHE 1
);


--
-- TOC entry 229 (class 1259 OID 16567)
-- Name: tarefaacademica; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tarefaacademica (
    idtarefa integer NOT NULL,
    materia character varying,
    professor character varying,
    nota double precision
);


ALTER TABLE public.tarefaacademica OWNER TO postgres;

--
-- TOC entry 230 (class 1259 OID 16579)
-- Name: tarefapessoal; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tarefapessoal (
    idtarefa integer NOT NULL,
    recorrencia character varying,
    local character varying
);


ALTER TABLE public.tarefapessoal OWNER TO postgres;

--
-- TOC entry 231 (class 1259 OID 16591)
-- Name: tarefatrabalho; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tarefatrabalho (
    idtarefa integer NOT NULL,
    departamento character varying,
    prazorevisao date
);


ALTER TABLE public.tarefatrabalho OWNER TO postgres;

--
-- TOC entry 217 (class 1259 OID 16388)
-- Name: usuario; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.usuario (
    senha character varying NOT NULL,
    nome character varying NOT NULL,
    email character varying,
    "idUsuario" integer NOT NULL
);


ALTER TABLE public.usuario OWNER TO postgres;

--
-- TOC entry 219 (class 1259 OID 16427)
-- Name: usuario_idUsuario_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.usuario ALTER COLUMN "idUsuario" ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public."usuario_idUsuario_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 100000
    CACHE 1
);


--
-- TOC entry 4694 (class 2606 OID 16456)
-- Name: equipe equipe_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.equipe
    ADD CONSTRAINT equipe_pkey PRIMARY KEY (idequipe);


--
-- TOC entry 4698 (class 2606 OID 16528)
-- Name: equipemembro equipemembro_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.equipemembro
    ADD CONSTRAINT equipemembro_pkey PRIMARY KEY (idequipe, idusuario);


--
-- TOC entry 4688 (class 2606 OID 16612)
-- Name: perfil perfil_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.perfil
    ADD CONSTRAINT perfil_pkey PRIMARY KEY (idperfil);


--
-- TOC entry 4690 (class 2606 OID 16433)
-- Name: projeto projeto_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.projeto
    ADD CONSTRAINT projeto_pkey PRIMARY KEY (idprojeto);


--
-- TOC entry 4692 (class 2606 OID 16445)
-- Name: projetolider projetolider_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.projetolider
    ADD CONSTRAINT projetolider_pkey PRIMARY KEY (idprojeto, idusuario);


--
-- TOC entry 4696 (class 2606 OID 16498)
-- Name: projetomembro projetomembro_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.projetomembro
    ADD CONSTRAINT projetomembro_pkey PRIMARY KEY (idprojeto, idusuario);


--
-- TOC entry 4700 (class 2606 OID 16546)
-- Name: tarefa tarefa_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tarefa
    ADD CONSTRAINT tarefa_pkey PRIMARY KEY (idtarefa);


--
-- TOC entry 4702 (class 2606 OID 16573)
-- Name: tarefaacademica tarefaacademica_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tarefaacademica
    ADD CONSTRAINT tarefaacademica_pkey PRIMARY KEY (idtarefa);


--
-- TOC entry 4704 (class 2606 OID 16585)
-- Name: tarefapessoal tarefapessoal_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tarefapessoal
    ADD CONSTRAINT tarefapessoal_pkey PRIMARY KEY (idtarefa);


--
-- TOC entry 4706 (class 2606 OID 16597)
-- Name: tarefatrabalho tarefatrabalho_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tarefatrabalho
    ADD CONSTRAINT tarefatrabalho_pkey PRIMARY KEY (idtarefa);


--
-- TOC entry 4686 (class 2606 OID 16412)
-- Name: usuario usuario_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_pkey PRIMARY KEY ("idUsuario");


--
-- TOC entry 4710 (class 2606 OID 16514)
-- Name: equipe equipe_idprojeto_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.equipe
    ADD CONSTRAINT equipe_idprojeto_fkey FOREIGN KEY (idprojeto) REFERENCES public.projeto(idprojeto);


--
-- TOC entry 4711 (class 2606 OID 16519)
-- Name: equipe equipe_usuarioliderid_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.equipe
    ADD CONSTRAINT equipe_usuarioliderid_fkey FOREIGN KEY (usuarioliderid) REFERENCES public.usuario("idUsuario");


--
-- TOC entry 4714 (class 2606 OID 16529)
-- Name: equipemembro equipemembro_idequipe_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.equipemembro
    ADD CONSTRAINT equipemembro_idequipe_fkey FOREIGN KEY (idequipe) REFERENCES public.equipe(idequipe);


--
-- TOC entry 4715 (class 2606 OID 16534)
-- Name: equipemembro equipemembro_idusuario_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.equipemembro
    ADD CONSTRAINT equipemembro_idusuario_fkey FOREIGN KEY (idusuario) REFERENCES public.usuario("idUsuario");


--
-- TOC entry 4707 (class 2606 OID 16420)
-- Name: perfil perfil_idusuario_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.perfil
    ADD CONSTRAINT perfil_idusuario_fkey FOREIGN KEY (idusuario) REFERENCES public.usuario("idUsuario");


--
-- TOC entry 4708 (class 2606 OID 16446)
-- Name: projetolider projetolider_idprojeto_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.projetolider
    ADD CONSTRAINT projetolider_idprojeto_fkey FOREIGN KEY (idprojeto) REFERENCES public.projeto(idprojeto);


--
-- TOC entry 4709 (class 2606 OID 24820)
-- Name: projetolider projetolider_idusuario_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.projetolider
    ADD CONSTRAINT projetolider_idusuario_fkey FOREIGN KEY (idusuario) REFERENCES public.usuario("idUsuario") NOT VALID;


--
-- TOC entry 4712 (class 2606 OID 16499)
-- Name: projetomembro projetomembro_idprojeto_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.projetomembro
    ADD CONSTRAINT projetomembro_idprojeto_fkey FOREIGN KEY (idprojeto) REFERENCES public.projeto(idprojeto);


--
-- TOC entry 4713 (class 2606 OID 16504)
-- Name: projetomembro projetomembro_idusuario_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.projetomembro
    ADD CONSTRAINT projetomembro_idusuario_fkey FOREIGN KEY (idusuario) REFERENCES public.usuario("idUsuario");


--
-- TOC entry 4716 (class 2606 OID 16552)
-- Name: tarefa tarefa_idequipe_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tarefa
    ADD CONSTRAINT tarefa_idequipe_fkey FOREIGN KEY (idequipe) REFERENCES public.equipe(idequipe);


--
-- TOC entry 4717 (class 2606 OID 16557)
-- Name: tarefa tarefa_idprojeto_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tarefa
    ADD CONSTRAINT tarefa_idprojeto_fkey FOREIGN KEY (idprojeto) REFERENCES public.projeto(idprojeto);


--
-- TOC entry 4718 (class 2606 OID 16547)
-- Name: tarefa tarefa_idusuario_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tarefa
    ADD CONSTRAINT tarefa_idusuario_fkey FOREIGN KEY (idusuario) REFERENCES public.usuario("idUsuario");


--
-- TOC entry 4719 (class 2606 OID 16623)
-- Name: tarefaacademica tarefaacademica_idtarefa_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tarefaacademica
    ADD CONSTRAINT tarefaacademica_idtarefa_fkey FOREIGN KEY (idtarefa) REFERENCES public.tarefa(idtarefa) ON DELETE CASCADE;


--
-- TOC entry 4720 (class 2606 OID 16618)
-- Name: tarefapessoal tarefapessoal_idtarefa_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tarefapessoal
    ADD CONSTRAINT tarefapessoal_idtarefa_fkey FOREIGN KEY (idtarefa) REFERENCES public.tarefa(idtarefa) ON DELETE CASCADE;


--
-- TOC entry 4721 (class 2606 OID 16613)
-- Name: tarefatrabalho tarefatrabalho_idtarefa_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tarefatrabalho
    ADD CONSTRAINT tarefatrabalho_idtarefa_fkey FOREIGN KEY (idtarefa) REFERENCES public.tarefa(idtarefa) ON DELETE CASCADE;


-- Completed on 2025-02-05 16:20:58

--
-- PostgreSQL database dump complete
--

