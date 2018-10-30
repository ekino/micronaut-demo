CREATE TABLE book (
  id UUID NOT NULL,
  isbn VARCHAR(100) NOT NULL,
  copynumber INTEGER NOT NULL,
  title VARCHAR(100) NOT NULL,
  author VARCHAR(100) NOT NULL,
  year INTEGER NOT NULL,
  description VARCHAR(500),
  CONSTRAINT pk_book PRIMARY KEY (id)
);

ALTER TABLE book
  ADD CONSTRAINT uk_book UNIQUE (isbn, copynumber);
