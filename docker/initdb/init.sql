CREATE TABLE IF NOT EXISTS users(
	id SERIAL PRIMARY KEY,
	login VARCHAR(20) NOT NULL UNIQUE,
	password VARCHAR(20) NOT NULL,
	fio VARCHAR(255) NOT NULL,
	mobile_phone VARCHAR(20)
);
