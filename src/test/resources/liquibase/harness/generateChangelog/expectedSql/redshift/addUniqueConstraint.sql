-- changeset liquibase:1
CREATE TABLE "unique_test" ("id" INTEGER NOT NULL, "code" VARCHAR(10), CONSTRAINT "unique_test_pkey" PRIMARY KEY ("id"));

ALTER TABLE "unique_test" ADD CONSTRAINT "unique_test_code_key" UNIQUE ("code");