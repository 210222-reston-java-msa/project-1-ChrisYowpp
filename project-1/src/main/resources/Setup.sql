
DROP TABLE IF EXISTS user_roles;
CREATE TABLE IF NOT EXISTS user_roles (
  ur_id SERIAL PRIMARY KEY,
  user_role VARCHAR(50)
);

DROP TABLE IF EXISTS users;
CREATE TABLE IF NOT EXISTS users (

  u_id SERIAL PRIMARY KEY,
  username VARCHAR(50),
  pass_word VARCHAR(50),
  first_name VARCHAR(50),
  last_name VARCHAR(50),
  email VARCHAR(50)
  role_id_fk FOREIGN KEY REFERENCES user_roles(id)
);

DROP TABLE IF EXISTS reimbursement_type;
CREATE TABLE IF NOT EXISTS reimbursement_type (
  rt_id SERIAL PRIMARY KEY,
  reimb_type VARCHAR(50)
);

DROP TABLE IF EXISTS reimbursement_status;
CREATE TABLE IF NOT EXISTS reimbursement_status (
  rs_id SERIAL PRIMARY KEY,
  reimb_status VARCHAR(50)
);

DROP TABLE IF EXISTS reimbursement
CREATE TABLE IF NOT EXISTS reimbursement (
  r_id SERIAL PRIMARY KEY,
  amount INT NOT NULL,
  descript VARCHAR(50),
  author FOREIGN KEY REFERENCES users(u_id),
  resolver FOREIGN KEY REFERENCES users(u_id),
  status_id_fk FOREIGN KEY REFERENCES reimbursement_status(rs_id),
  type_id_fk FOREIGN KEY REFERENCES reimbursement_type(rt_id)
);

INSERT INTO user_roles (user_role)
  VALUES ('employee'), ('manager');

INSERT INTO users (username, pass_word, first_name, last_name, email, role_id_fk) 
  VALUES ('Batman', ' Batz', 'Bruce', 'Wayne', 'Bwayne@gmail.com', 2);

INSERT INTO reimbursement_type (reimb_type)
  VALUES ('LODGING'), ('TRAVEL'), ('FOOD'), ('OTHER');

INSERT INTO reimbursement_status(reimb_status)
  VALUES ('Pending'), ('Approved'), ('Denied');

INSERT INTO reimbursement (amount, descript, author, status_id_fk, type_id_fk)
  VALUES (2000, 'fees', 2, 1, 1, 1);