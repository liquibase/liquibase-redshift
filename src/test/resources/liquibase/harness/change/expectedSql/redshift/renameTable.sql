CREATE TABLE public.oldnametable (test_id INTEGER NOT NULL, test_column VARCHAR(50) NOT NULL, CONSTRAINT oldnametable_pkey PRIMARY KEY (test_id))
ALTER TABLE public.oldnametable RENAME TO newnametable