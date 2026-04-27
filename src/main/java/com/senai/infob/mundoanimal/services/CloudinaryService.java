package com.senai.infob.mundoanimal.services; 

import java.io.IOException;
import java.util.Map; 

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service; 
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils; 


@Service 
public class CloudinaryService { 

    private final Cloudinary cloudinary;
    public CloudinaryService( 

            @Value("${cloudinary.cloud-name}") String cloudName, 
            @Value("${cloudinary.api-key}") String apiKey, 
            @Value("${cloudinary.api-secret}") String apiSecret) { 

        cloudinary = new Cloudinary(ObjectUtils.asMap( 

            "cloud_name", cloudName, 
            "api_key",    apiKey, 
            "api_secret", apiSecret 

        )); 

    } 

    public String uploadImagem(MultipartFile arquivo, String pasta) { 

        try { 
            Map resultado = cloudinary.uploader().upload( 
                arquivo.getBytes(), 
                ObjectUtils.asMap("folder", pasta) 
            ); 

            return (String) resultado.get("url"); 

        } catch (IOException e) { 
            throw new RuntimeException("Erro ao fazer upload: " + e.getMessage()); 

        } 

    } 

} 