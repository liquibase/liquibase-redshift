-- changeset liquibase:1
CREATE TABLE "add_column_test" ("id" INTEGER NOT NULL, "name" VARCHAR(255), "description" VARCHAR(255), CONSTRAINT "add_column_test_pkey" PRIMARY KEY ("id"));