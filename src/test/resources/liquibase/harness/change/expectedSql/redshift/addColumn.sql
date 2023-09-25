ALTER TABLE public.authors ADD varcharColumn VARCHAR(25)
ALTER TABLE public.authors ADD intColumn INTEGER
ALTER TABLE public.authors ADD dateColumn date
UPDATE public.authors SET varcharColumn = 'INITIAL_VALUE'
UPDATE public.authors SET intColumn = 5
UPDATE public.authors SET dateColumn = '2020-09-21'