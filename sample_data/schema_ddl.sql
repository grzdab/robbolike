

-- DROP TABLE IF EXISTS public.game_state;
-- CREATE TABLE public.game_state (
--                                    id serial NOT NULL PRIMARY KEY,
--                                    current_map text NOT NULL,
--                                    saved_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
--                                    player_id integer NOT NULL
-- );

DROP TABLE IF EXISTS public.player;
CREATE TABLE public.player (
                               id serial NOT NULL PRIMARY KEY,
                               player_name text NOT NULL,
                               hp integer NOT NULL,
                               x integer NOT NULL,
                               y integer NOT NULL,
                               exp integer NOT NULL,
                               att integer NOT NULL,
                               def integer NOT NULL
);

DROP TABLE IF EXISTS public.inventory;
CREATE TABLE public.inventory (
    player_id integer NOT NULL,
    breastplate integer,
    coin integer,
    helmet integer,
    key integer,
    nut integer,
    resistor integer,
    screwdriver integer,
    shield integer,
    spring integer,
    taser integer,
    wrench integer
);

alter table inventory
    add constraint inventory_player_id_fk
        foreign key (player_id) references player;
--
-- ALTER TABLE ONLY public.game_state
--     ADD CONSTRAINT fk_player_id FOREIGN KEY (player_id) REFERENCES public.player(id);