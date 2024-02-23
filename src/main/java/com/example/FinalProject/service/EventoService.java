package com.example.FinalProject.service;

import com.example.FinalProject.exception.NotFoundException;
import com.example.FinalProject.model.Evento;
import com.example.FinalProject.model.EventoRequest;
import com.example.FinalProject.model.Utente;
import com.example.FinalProject.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import static jdk.internal.org.jline.reader.impl.LineReaderImpl.CompletionType.List;

@Service
public class EventoService {
    @Autowired
    private EventoRepository eventoRepository;

    @Autowired
    private UtenteService utenteService;

    public Page<Evento> getAll(Pageable pageable){
        return  eventoRepository.findAll(pageable);
    }

    public Evento cercaEventoPerId(int id) throws NotFoundException{
        return eventoRepository.findById(id).
                orElseThrow(()->new NotFoundException("Evento con id="+id+" non trovato"));
    }

    public Evento salvaEvento(EventoRequest eventoRequest) throws NotFoundException{

        Evento evento = new Evento (
                eventoRequest.getDescrizione(),
                eventoRequest.getTitolo(),
                eventoRequest.getDate(),
                eventoRequest.getLuogo(),
                eventoRequest.getNumeroPostiDisponibili()
        );
        return eventoRepository.save(evento);
    }

    public Evento aggiornaEvento(int id, EventoRequest eventoRequest) throws NotFoundException{
        Evento evento = cercaEventoPerId(id);

        Utente utente = utenteService.getUtenteById(eventoRequest.getUtente_id());

        evento.setDescrizione(eventoRequest.getDescrizione());
        evento.setNumeroPostiDisponibili();

        return eventoRepository.save(post);
    }

    public void cancellaBlogPost(int id) throws NotFoundException{
        Evento post = cercaPostPerId(id);
        eventoRepository.delete(post);
    }

    public Evento uploadCover(int id, String url){
        Evento evento = cercaPostPerId(id);
        evento.setCover(url);
        return eventoRepository.save(evento);
    }
}
