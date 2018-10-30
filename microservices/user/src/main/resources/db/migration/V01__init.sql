CREATE TABLE "user" (
  id UUID NOT NULL,
  emailAddress VARCHAR(100) NOT NULL,
  firstName VARCHAR(100) NOT NULL,
  lastName VARCHAR(100) NOT NULL,
  age INTEGER NOT NULL,
  CONSTRAINT pk_user PRIMARY KEY (id)
);

ALTER TABLE "user"
  ADD CONSTRAINT uk_user UNIQUE (emailAddress);
