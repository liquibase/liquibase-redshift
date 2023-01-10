CREATE OR REPLACE FUNCTION "public".test_function()
 RETURNS trigger
 LANGUAGE plpgsql
AS $function$
      BEGIN
      RAISE NOTICE 'Test function created';
      RETURN NEW;
      END;
      $function$;