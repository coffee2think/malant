CREATE USER c##malant IDENTIFIED BY malant;
GRANT CONNECT, RESOURCE TO c##malant;
GRANT CREATE VIEW TO c##malant;
ALTER USER c##malant
QUOTA 1024M ON USERS;