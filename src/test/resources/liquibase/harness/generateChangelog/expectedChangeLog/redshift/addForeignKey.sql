-- changeset liquibase:1
CREATE TABLE "fk_child" ("id" INTEGER NOT NULL, "parent_id" INTEGER, CONSTRAINT "fk_child_pkey" PRIMARY KEY ("id"));

CREATE TABLE "fk_parent" ("id" INTEGER NOT NULL, "name" VARCHAR(255), CONSTRAINT "fk_parent_pkey" PRIMARY KEY ("id"));