CREATE TABLE public.game_user (
	id int4 NOT NULL,
	id_game int4 NOT NULL,
	id_user int4 NOT NULL,
	vote int4 NULL,
	CONSTRAINT game_user_pkey PRIMARY KEY (id, id_game, id_user),
	CONSTRAINT fkb8qjqajavxcc5vd65i0nsriev FOREIGN KEY (id_user) REFERENCES public.users(id),
	CONSTRAINT fkdm86pk71hd928v38td5oalu2b FOREIGN KEY (id_game) REFERENCES public.game(id)
);