CREATE TABLE products(
		id BIGINT AUTO_INCREMENT PRIMARY KEY,
		name VARCHAR(255) NOT NULL,
		description VARCHAR(255),
		price DECIMAL(15,2) DEFAULT 0,
		raitingA DECIMAL(1,1) DEFAULT 0,
		user_id BIGINT,
		created_at TIMESTAMP,
		updated_at TIMESTAMP,
		FOREIGN KEY(user_id) FROM users(id)
);