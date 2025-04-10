package br.com.primeshoes.api.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.primeshoes.api.entites.User;

public interface UserRepository extends JpaRepository<User, Long>{

	
}