CREATE TABLE product_variations (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    color VARCHAR(100) NOT NULL,
    size VARCHAR(50) NOT NULL,
    stock BIGINT NOT NULL,
    products_id BIGINT NOT NULL,
    FOREIGN KEY (products_id) REFERENCES products(id) ON DELETE CASCADE
);