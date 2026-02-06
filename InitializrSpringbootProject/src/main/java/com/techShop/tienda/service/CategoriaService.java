package com.techShop.tienda.service;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import com.techShop.tienda.domain.Categoria;
import com.techShop.tienda.repository.CategoriaRepository;
import java.util.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

/**
 *
 * @author israelapuy
 */
@Service
public class CategoriaService {
    
    //El repositorio es final para aseguriar la inmutabilidad
    private final CategoriaRepository categoriaRepository;
    
    // Inyección por constructor (No requiere @Autowired en Spring moderno)
    public CategoriaService(CategoriaRepository categoriaRepository){
        this.categoriaRepository = categoriaRepository;
    }
    
    @Transactional (readOnly = true)
    public List<Categoria> getCategorias(boolean activo){
        if (activo){
            return categoriaRepository.findByActivoTrue();
        }
        return categoriaRepository.findAll();
    }
}
