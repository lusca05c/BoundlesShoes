package br.com.primeshoes.api.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.primeshoes.api.dtos.*;
import br.com.primeshoes.api.entites.Image;
import br.com.primeshoes.api.mappers.ImageMapper;
import br.com.primeshoes.api.repositorys.ImageRepository;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    public void store(ImageCreateDTO dto) {
        imageRepository.save(ImageMapper.toEntity(dto));
    }

    public List<ImageUpdateResponseDTO> list() {
        return imageRepository.findAll()
            .stream()
            .map(ImageMapper::toDTO)
            .toList();
    }

    public ImageUpdateResponseDTO show(Long id) {
        Image image = imageRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Imagem não encontrada"));
        return ImageMapper.toDTO(image);
    }

    public ImageUpdateResponseDTO update(ImageUpdateResponseDTO dto) {
        Image image = imageRepository.findById(dto.id())
            .orElseThrow(() -> new RuntimeException("Imagem não encontrada"));
        imageRepository.save(image);
        
        return ImageMapper.toDTO(image);
    }

    public void destroy(Long id) {
        Image image = imageRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Imagem não encontrada"));
        imageRepository.delete(image);
    }
}
