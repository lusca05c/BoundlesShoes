package br.com.primeshoes.api.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.primeshoes.api.entites.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {
    
}
