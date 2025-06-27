CREATE TABLE categories (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,         
    name VARCHAR(255) NOT NULL,                    
    products_id BIGINT,                            
    FOREIGN KEY (products_id) REFERENCES products(id)
);