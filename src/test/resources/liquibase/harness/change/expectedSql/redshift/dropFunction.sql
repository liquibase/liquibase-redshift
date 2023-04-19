CREATE OR REPLACE FUNCTION public.test_function()
RETURNS varchar(20)
STABLE
AS $$
return 'Test function created'
$$
LANGUAGE plpythonu
DROP FUNCTION public.test_function()