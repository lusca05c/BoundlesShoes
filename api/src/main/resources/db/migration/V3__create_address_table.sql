CREATE TABLE addresses (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,        
    street VARCHAR(255) NOT NULL,                 
    city VARCHAR(255) NOT NULL,                   
    state VARCHAR(255) NOT NULL,                  
    zipCode VARCHAR(255) NOT NULL,                 
    number VARCHAR(255) NOT NULL,                  
    created_at TIMESTAMP,
    updated_at TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    users_id BIGINT,                 
    FOREIGN KEY (users_id) REFERENCES users(id) ON DELETE CASCADE
);
