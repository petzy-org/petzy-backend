CREATE TABLE IF NOT EXISTS "animals" (
    "id" UUID NOT NULL UNIQUE,
    "pictures" UUID ARRAY,
    "type" SMALLINT,
    "shelterId" UUID,
    "description" VARCHAR,
    "createdAt" TIMESTAMP,
    "updatedAt" TIMESTAMP,
    "available" BOOLEAN,
    "medicalDetails" VARCHAR ARRAY,
    "placementType" SMALLINT,
    "breed" VARCHAR,
    "preferences" UUID ARRAY,
    PRIMARY KEY("id")
);

CREATE TABLE IF NOT EXISTS "shelters" (
    "id" UUID NOT NULL UNIQUE,
    "name" VARCHAR,
    "country" VARCHAR,
    "city" VARCHAR,
    "coordinates" POINT,
    -- This is an array
    "pictures" UUID ARRAY,
    "verified" BOOLEAN,
    "description" VARCHAR,
    "contact" UUID,
    "donations" VARCHAR ARRAY,
    PRIMARY KEY("id")
);

CREATE TABLE IF NOT EXISTS "users" (
    "id" UUID NOT NULL UNIQUE,
    "name" VARCHAR,
    "contact" UUID,
    "pictures" UUID ARRAY,
    "description" VARCHAR,
    "preferences" UUID ARRAY,
    "type" SMALLINT,
    PRIMARY KEY("id")
);

CREATE TABLE IF NOT EXISTS "credentials" (
    "id" INTEGER NOT NULL UNIQUE,
    "email" VARCHAR NOT NULL,
    "password" VARCHAR NOT NULL,
    "role" VARCHAR NOT NULL,
    "user_id" UUID NOT NULL UNIQUE,
    PRIMARY KEY("id"),
    UNIQUE("email")
);

CREATE TABLE IF NOT EXISTS "pictures" (
    "id" UUID NOT NULL UNIQUE,
    "url" VARCHAR,
    PRIMARY KEY("id")
);

CREATE TABLE IF NOT EXISTS "contacts" (
    "id" UUID NOT NULL UNIQUE,
    "mail" VARCHAR,
    "phoneNumber" VARCHAR,
    "instagramProfile" VARCHAR,
    "facebookProfile" VARCHAR,
    PRIMARY KEY("id")
);

ALTER TABLE "animals"
ADD FOREIGN KEY("shelterId") REFERENCES "shelters"("id")
ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE "shelters"
ADD FOREIGN KEY("contact") REFERENCES "contacts"("id")
ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE "users"
ADD FOREIGN KEY("contact") REFERENCES "contacts"("id")
ON UPDATE NO ACTION ON DELETE NO ACTION;
CREATE INDEX "credentials_email"
ON "credentials" ("email");