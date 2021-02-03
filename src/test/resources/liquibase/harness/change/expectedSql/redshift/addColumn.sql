ALTER TABLE authors ADD varcharColumn VARCHAR(25)
ALTER TABLE authors ADD intColumn INTEGER
ALTER TABLE authors ADD dateColumn date
UPDATE authors SET varcharColumn = 'INITIAL_VALUE'
UPDATE authors SET intColumn = 5
UPDATE authors SET dateColumn = '2020-09-21'