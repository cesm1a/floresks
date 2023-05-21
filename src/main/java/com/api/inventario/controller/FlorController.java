package com.api.inventario.controller;
import com.api.inventario.model.Flor;
import com.api.inventario.repository.FlorRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/")
public class FlorController {

    @PostMapping
    public void guardarFlores(@RequestBody List<Flor> nuevasFlores) {
        FlorRepository.addFlores(nuevasFlores);
    }

    @GetMapping
    public List<Flor> obtenerFlores() {
        return FlorRepository.getAllFlores();
    }

    @GetMapping
    @RequestMapping("/ordenado")
    public List<Flor> obtenerFloresDesc() {
        return FlorRepository.getFloresOrderDesc();
    }

    @GetMapping
    @RequestMapping("/precio")
    public List<Flor> obtenerFlorPrecio() {
        return FlorRepository.getFloresByPrice();
    }

    @DeleteMapping(path = "/{id}")
    public void deleteFlorById(@PathVariable("id") int id){
        FlorRepository.deleteFlores(id);
    }

    @GetMapping(path = "/consultanombre/{name}")
    public List<Flor> optenerFlorByName( @PathVariable("name")  String name){
        return FlorRepository.getFloresByName(name);
    }
}


