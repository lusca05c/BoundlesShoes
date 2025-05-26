package br.com.primeshoes.api.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.primeshoes.api.entites.ProductVariation;

@Repository
public interface ProductVariationRepository extends JpaRepository<ProductVariation, Long> {

}
