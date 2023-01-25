-- liquibase formatted sql

-- changeset yodzh:1674562081600-1
CREATE TABLE "view_test_table" ("test_column" INTEGER);

-- changeset yodzh:1674562081600-2
CREATE VIEW "test_view" AS SELECT view_test_table.test_column FROM view_test_table;;

