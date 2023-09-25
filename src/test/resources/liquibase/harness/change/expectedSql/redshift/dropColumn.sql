ALTER TABLE public.posts ADD varcharColumn VARCHAR(25)
UPDATE public.posts SET varcharColumn = 'INITIAL_VALUE'
ALTER TABLE public.posts DROP COLUMN varcharColumn