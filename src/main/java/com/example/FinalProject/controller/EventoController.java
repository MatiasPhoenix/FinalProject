package com.example.FinalProject.controller;

import com.example.FinalProject.exception.BadRequestException;
import com.example.FinalProject.model.Evento;
import com.example.FinalProject.model.EventoRequest;
import com.example.FinalProject.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public class EventoController {

    @Autowired
    private EventoService eventoService;

    @GetMapping("/evento")
    public Page<Evento> getAll(Pageable pageable){

        return eventoService.getAll(pageable);
    }
    @GetMapping("/evento/{id}")
    public Evento getEventoById(@PathVariable int id){
        return eventoService.cercaEventoPerId(id);

    }
    @PostMapping("/evento")
    public Evento saveEvento(@RequestBody @Validated EventoRequest eventoRequest, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            throw new BadRequestException(bindingResult.getAllErrors().toString());
        }

        return eventoService.salvaEvento(eventoRequest);
    }
    @PutMapping("/evento/{id}")
    public Evento updateEvento(@PathVariable int id, @RequestBody @Validated EventoRequest eventoRequest, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            throw new BadRequestException(bindingResult.getAllErrors().toString());
        }
        return eventoService.aggiornaEvento(id, eventoRequest);
    }

    @DeleteMapping("/evento/{id}")
    public void deleteEvento(@PathVariable int id){
        eventoService.cancellaEvento(id);
    }

    @PatchMapping("/evento/aggingiList/{id}")
    public Evento addUtenteToEvento(@PathVariable int id, @RequestBody @Validated EventoRequest eventoRequest, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            throw new BadRequestException(bindingResult.getAllErrors().toString());
        }
        return  eventoService.aggiornaListaPartecipanti(eventoRequest, id);
    }
}
