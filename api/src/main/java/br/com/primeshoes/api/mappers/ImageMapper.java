package br.com.primeshoes.api.mappers;

import br.com.primeshoes.api.dtos.ImageCreateDTO;
import br.com.primeshoes.api.dtos.ImageUpdateResponseDTO;
import br.com.primeshoes.api.entites.Image;

public class ImageMapper {
    
    public static Image toEntity(ImageCreateDTO imageCreateDTO){
        Image image = new Image();
        image.setFilePath(imageCreateDTO.filePath());
        return image;
    }

    public static ImageUpdateResponseDTO toDTO(Image image){
        return new ImageUpdateResponseDTO(image.getId(), image.getFilePath());
    }

}
