CREATE TABLE public.full_name_table (first_name VARCHAR(50), last_name VARCHAR(50))
INSERT INTO public.full_name_table (first_name) VALUES ('John')
UPDATE public.full_name_table SET last_name = 'Doe' WHERE first_name='John'
INSERT INTO public.full_name_table (first_name) VALUES ('Jane')
UPDATE public.full_name_table SET last_name = 'Doe' WHERE first_name='Jane'
ALTER TABLE public.full_name_table ADD full_name VARCHAR(255)
UPDATE public.full_name_table SET full_name = first_name || ' ' || last_name
ALTER TABLE public.full_name_table DROP COLUMN first_name
ALTER TABLE public.full_name_table DROP COLUMN last_name