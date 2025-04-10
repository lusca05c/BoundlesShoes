package br.com.primeshoes.api.repositorys;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.primeshoes.api.entites.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
