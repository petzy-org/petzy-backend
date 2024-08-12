CREATE TABLE "animals" (
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

CREATE TABLE "shelters" (
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

CREATE TABLE "user" (
    "id" UUID NOT NULL UNIQUE,
    "name" VARCHAR,
    "contact" UUID,
    "pictures" UUID ARRAY,
    "description" VARCHAR,
    "preferences" UUID ARRAY,
    "type" SMALLINT,
    PRIMARY KEY("id")
);

CREATE TABLE "pictures" (
    "id" UUID NOT NULL UNIQUE,
    "url" VARCHAR,
    PRIMARY KEY("id")
);

CREATE TABLE "contact" (
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
ADD FOREIGN KEY("contact") REFERENCES "contact"("id")
ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE "user"
ADD FOREIGN KEY("contact") REFERENCES "contact"("id")
ON UPDATE NO ACTION ON DELETE NO ACTION;