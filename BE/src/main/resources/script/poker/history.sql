CREATE TABLE public.history (
	id int4 NOT NULL GENERATED BY DEFAULT AS IDENTITY,
	average int4 NULL,
	players_total int4 NULL,
	players_voted int4 NULL,
	"time" date NULL,
	id_issue int4 NULL,
	CONSTRAINT history_pkey PRIMARY KEY (id),
	CONSTRAINT fkjlkt5yteeqfusnistpbacfy37 FOREIGN KEY (id_issue) REFERENCES public.issue(id)
);