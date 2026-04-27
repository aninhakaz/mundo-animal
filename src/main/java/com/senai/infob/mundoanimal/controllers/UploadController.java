package com.senai.infob.mundoanimal.controllers; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.senai.infob.mundoanimal.services.CloudinaryService;
import com.senai.infob.mundoanimal.services.UsuarioService;

 

@RestController 

@RequestMapping("/api/upload") 

public class UploadController { 


    @Autowired 
    private CloudinaryService cloudinaryService; 

    @Autowired 
    private UsuarioService usuarioService; 

 
    // Atualizar ou add foto de perfil do usuário 
    // FlutterFlow chama: POST /api/upload/perfil/123 
    @PostMapping("/perfil/{usuarioId}") 
    public ResponseEntity<String> uploadFotoPerfil( 
            @RequestParam("imagem") MultipartFile arquivo, 
            @PathVariable Integer usuarioId) { 
        String url = cloudinaryService.uploadImagem(arquivo, "perfis"); 
        usuarioService.atualizarFotoPerfil(usuarioId, url); 
        return ResponseEntity.ok(url); 

    } 


    // Imagem de uma postagem 
    // FlutterFlow chama: POST /api/upload/postagem 
    @PostMapping("/postagem") 
    public ResponseEntity<String> uploadImagemPostagem( 
            @RequestParam("imagem") MultipartFile arquivo) {
        String url = cloudinaryService.uploadImagem(arquivo, "postagens"); 
        return ResponseEntity.ok(url);

    } 
}