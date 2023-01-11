CREATE TABLE "test_table_reference" ("id" INTEGER NOT NULL, "test_column" INTEGER NOT NULL, CONSTRAINT "test_table_reference_pkey" PRIMARY KEY ("id"));

ALTER TABLE "test_table_reference" ADD CONSTRAINT "test_table_reference_test_column_key" UNIQUE ("test_column");

CREATE TABLE "test_table_base" ("id" INTEGER NOT NULL, CONSTRAINT "test_table_base_pkey" PRIMARY KEY ("id"));

ALTER TABLE "test_table_base" ADD CONSTRAINT "test_fk" FOREIGN KEY ("id") REFERENCES "test_table_reference" ("test_column") ON UPDATE RESTRICT ON DELETE CASCADE;