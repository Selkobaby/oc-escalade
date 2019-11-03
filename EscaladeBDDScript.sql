
CREATE SEQUENCE public.compte_id_seq;

CREATE TABLE public.compte (
                id INTEGER NOT NULL DEFAULT nextval('public.compte_id_seq'),
                nom VARCHAR NOT NULL,
                prenom VARCHAR NOT NULL,
                mail VARCHAR NOT NULL,
                mot_de_passe VARCHAR NOT NULL,
                CONSTRAINT compte_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.compte_id_seq OWNED BY public.compte.id;

CREATE SEQUENCE public.topo_id_seq;

CREATE TABLE public.topo (
                id INTEGER NOT NULL DEFAULT nextval('public.topo_id_seq'),
                nom VARCHAR NOT NULL,
                statut VARCHAR NOT NULL,
                date_upload DATE NOT NULL,
                description VARCHAR NOT NULL,
                compte_id INTEGER NOT NULL,
                CONSTRAINT topo_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.topo_id_seq OWNED BY public.topo.id;

CREATE SEQUENCE public.resa_topo_id_seq;

CREATE TABLE public.resa_topo (
                id INTEGER NOT NULL DEFAULT nextval('public.resa_topo_id_seq'),
                statut VARCHAR NOT NULL,
                date_debut DATE NOT NULL,
                date_fin DATE NOT NULL,
                proprietaire_topo INTEGER NOT NULL,
                compte_id INTEGER NOT NULL,
                topo_id INTEGER NOT NULL,
                CONSTRAINT resa_topo_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.resa_topo_id_seq OWNED BY public.resa_topo.id;

CREATE SEQUENCE public.messagerie_id_seq;

CREATE TABLE public.messagerie (
                id VARCHAR NOT NULL DEFAULT nextval('public.messagerie_id_seq'),
                date_message DATE NOT NULL,
                messsage VARCHAR NOT NULL,
                resa_topo_id INTEGER NOT NULL,
                compte_id INTEGER NOT NULL,
                CONSTRAINT messagerie_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.messagerie_id_seq OWNED BY public.messagerie.id;

CREATE SEQUENCE public.site_id_seq;

CREATE TABLE public.site (
                id INTEGER NOT NULL DEFAULT nextval('public.site_id_seq'),
                nom VARCHAR NOT NULL,
                region VARCHAR NOT NULL,
                desription VARCHAR NOT NULL,
                compte_id INTEGER NOT NULL,
                CONSTRAINT site_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.site_id_seq OWNED BY public.site.id;

CREATE SEQUENCE public.commentaire_id_seq;

CREATE TABLE public.commentaire (
                id INTEGER NOT NULL DEFAULT nextval('public.commentaire_id_seq'),
                commentaire VARCHAR,
                site_id INTEGER,
                topo_id INTEGER,
                compte_id INTEGER NOT NULL,
                CONSTRAINT commentaire_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.commentaire_id_seq OWNED BY public.commentaire.id;

CREATE SEQUENCE public.photo_id_seq;

CREATE TABLE public.photo (
                id INTEGER NOT NULL DEFAULT nextval('public.photo_id_seq'),
                nom VARCHAR NOT NULL,
                topo_id INTEGER,
                site_id INTEGER,
                url_image VARCHAR,
                CONSTRAINT photo_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.photo_id_seq OWNED BY public.photo.id;

CREATE SEQUENCE public.secteur_id_seq;

CREATE TABLE public.secteur (
                id INTEGER NOT NULL DEFAULT nextval('public.secteur_id_seq'),
                description VARCHAR NOT NULL,
                nom VARCHAR NOT NULL,
                site_id INTEGER NOT NULL,
                CONSTRAINT secteur_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.secteur_id_seq OWNED BY public.secteur.id;

CREATE SEQUENCE public.voie_id_seq;

CREATE TABLE public.voie (
                id INTEGER NOT NULL DEFAULT nextval('public.voie_id_seq'),
                nom VARCHAR NOT NULL,
                description VARCHAR,
                type_voie VARCHAR NOT NULL,
                cotation VARCHAR NOT NULL,
                hauteur REAL NOT NULL,
                secteur_id INTEGER NOT NULL,
                CONSTRAINT voie_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.voie_id_seq OWNED BY public.voie.id;

CREATE SEQUENCE public.longueur_id_seq;

CREATE TABLE public.longueur (
                id VARCHAR NOT NULL DEFAULT nextval('public.longueur_id_seq'),
                num_longueur INTEGER NOT NULL,
                num_relai INTEGER,
                hauteur REAL NOT NULL,
                cotation VARCHAR NOT NULL,
                voie_id INTEGER NOT NULL,
                CONSTRAINT longueur_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.longueur_id_seq OWNED BY public.longueur.id;

ALTER TABLE public.site ADD CONSTRAINT compte_site_fk
FOREIGN KEY (compte_id)
REFERENCES public.compte (id)
ON DELETE CASCADE
ON UPDATE CASCADE
NOT DEFERRABLE;

ALTER TABLE public.messagerie ADD CONSTRAINT compte_messagerie_fk
FOREIGN KEY (compte_id)
REFERENCES public.compte (id)
ON DELETE CASCADE
ON UPDATE CASCADE
NOT DEFERRABLE;

ALTER TABLE public.resa_topo ADD CONSTRAINT compte_resa_topo_fk
FOREIGN KEY (compte_id)
REFERENCES public.compte (id)
ON DELETE CASCADE
ON UPDATE CASCADE
NOT DEFERRABLE;

ALTER TABLE public.topo ADD CONSTRAINT compte_topo_fk
FOREIGN KEY (compte_id)
REFERENCES public.compte (id)
ON DELETE CASCADE
ON UPDATE CASCADE
NOT DEFERRABLE;

ALTER TABLE public.commentaire ADD CONSTRAINT compte_commentaire_fk
FOREIGN KEY (compte_id)
REFERENCES public.compte (id)
ON DELETE CASCADE
ON UPDATE CASCADE
NOT DEFERRABLE;

ALTER TABLE public.photo ADD CONSTRAINT topo_photo_fk
FOREIGN KEY (topo_id)
REFERENCES public.topo (id)
ON DELETE CASCADE
ON UPDATE CASCADE
NOT DEFERRABLE;

ALTER TABLE public.resa_topo ADD CONSTRAINT topo_resa_topo_fk
FOREIGN KEY (topo_id)
REFERENCES public.topo (id)
ON DELETE CASCADE
ON UPDATE CASCADE
NOT DEFERRABLE;

ALTER TABLE public.commentaire ADD CONSTRAINT topo_commentaire_fk
FOREIGN KEY (topo_id)
REFERENCES public.topo (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.messagerie ADD CONSTRAINT resa_topo_messagerie_fk
FOREIGN KEY (resa_topo_id)
REFERENCES public.resa_topo (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.secteur ADD CONSTRAINT site_secteur_fk
FOREIGN KEY (site_id)
REFERENCES public.site (id)
ON DELETE CASCADE
ON UPDATE CASCADE
NOT DEFERRABLE;

ALTER TABLE public.photo ADD CONSTRAINT site_photo_fk
FOREIGN KEY (site_id)
REFERENCES public.site (id)
ON DELETE CASCADE
ON UPDATE CASCADE
NOT DEFERRABLE;

ALTER TABLE public.commentaire ADD CONSTRAINT site_commentaire_fk
FOREIGN KEY (site_id)
REFERENCES public.site (id)
ON DELETE CASCADE
ON UPDATE CASCADE
NOT DEFERRABLE;

ALTER TABLE public.voie ADD CONSTRAINT secteur_voie_fk
FOREIGN KEY (secteur_id)
REFERENCES public.secteur (id)
ON DELETE CASCADE
ON UPDATE CASCADE
NOT DEFERRABLE;

ALTER TABLE public.longueur ADD CONSTRAINT voie_longueur_fk
FOREIGN KEY (voie_id)
REFERENCES public.voie (id)
ON DELETE CASCADE
ON UPDATE CASCADE
NOT DEFERRABLE;
