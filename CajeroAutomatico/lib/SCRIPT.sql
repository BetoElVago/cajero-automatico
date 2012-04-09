CREATE TABLE "ADMIN"."PERSON" ("ID" BIGINT NOT NULL GENERATED BY DEFAULT AS IDENTITY (START WITH 1, INCREMENT BY 1), "DOCUMENT" VARCHAR(255), "NAME" VARCHAR(255) NOT NULL, "LAST_NAME" VARCHAR(255) NOT NULL, "PASSWORD" VARCHAR(255) NOT NULL, "USER_NAME" VARCHAR(255) NOT NULL, "BALANCE" DOUBLE NOT NULL);

ALTER TABLE "ADMIN"."PERSON" ADD CONSTRAINT "SQL120326201836210" PRIMARY KEY ("ID");