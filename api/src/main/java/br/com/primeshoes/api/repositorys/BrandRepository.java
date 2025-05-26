package br.com.primeshoes.api.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.primeshoes.api.entites.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {

}
