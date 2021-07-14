CREATE TABLE oldnametable (test_id INTEGER NOT NULL, test_column VARCHAR(50) NOT NULL, CONSTRAINT oldnametable_pkey PRIMARY KEY (test_id))
ALTER TABLE oldnametable RENAME TO newnametable
