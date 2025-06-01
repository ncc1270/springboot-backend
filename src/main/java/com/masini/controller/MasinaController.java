package com.masini.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.masini.exception.ResourceNotFoundException;
import com.masini.model.Masina;
import com.masini.repository.MasinaRepository;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class MasinaController {

    @Autowired
	private final MasinaRepository masinaRepository;

    public MasinaController(MasinaRepository masinaRepository) {
        this.masinaRepository = masinaRepository;
    }

    //lista toate masinile
    @GetMapping("/masini")
    public List<Masina> getAll() {
        return masinaRepository.findAll();
    }

    
    //lista masina cu id-ul date
    @GetMapping("/{id}")
    public Masina getById(@PathVariable Long id) {
        return masinaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Nu exista masina cu id:" + id));
    }

    //adauga masina in lista
    @PostMapping
    public Masina create(@RequestBody Masina masina) {
        return masinaRepository.save(masina);
    }

    //update masina in lista
    @PutMapping("/{id}")
    public Masina update(@PathVariable Long id, @RequestBody Masina masinaNoua) {
        Masina masina = masinaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Nu exista masina cu id:" + id));
        masina.setMarca(masinaNoua.getMarca());
        masina.setModel(masinaNoua.getModel());
        masina.setAnFabricatie(masinaNoua.getAnFabricatie());
        return masinaRepository.save(masina);
    }

    //sterge masina din lista
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
    	Masina masina = masinaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Nu exista masina cu id:" + id));
        masinaRepository.deleteById(id);
    }
}