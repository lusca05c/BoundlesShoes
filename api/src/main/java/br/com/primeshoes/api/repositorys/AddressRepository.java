package br.com.primeshoes.api.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.primeshoes.api.entites.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{

}
