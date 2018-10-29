CREATE TABLE borrowing (
  id UUID NOT NULL,
  userid UUID NOT NULL,
  bookid UUID NOT NULL,
  startdate DATE NOT NULL,
  enddate DATE,
  exceeded BOOLEAN,
  CONSTRAINT pk_borrowing PRIMARY KEY (id)
);

ALTER TABLE borrowing
  ADD CONSTRAINT uk_borrowing UNIQUE (userid, bookid, startdate);
