/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.techShop.tienda.controller;

import com.techShop.tienda.service.CategoriaService;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author israelapuy
 */

@Controller
@RequestMapping("/categoria")
public class CategoriaController {
    
    // El servicio es final para asegurar inmutabilidad
    private final CategoriaService categoriaService;
    
    // Inyeccion por constructor (No requiere @Autowired en Spring moderno)
    public CategoriaController(com.techShop.tienda.service.CategoriaService categoriaService){
        this.categoriaService = categoriaService;
    }
    
    @GetMapping("/listado")
    public String inicio(Model model){
        var categorias = categoriaService.getCategorias(false);
        model.addAttribute("categorias", categorias);
        model.addAttribute("totalCategorias", categorias.size());
        return "/categoria/listado";
    }
}
