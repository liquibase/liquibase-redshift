CREATE TABLE "view_test_table" ("test_column" INTEGER);

CREATE VIEW "test_view" AS SELECT view_test_table.test_column FROM view_test_table;;