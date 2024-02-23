package com.example.FinalProject.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String descrizione;
    private String titolo;
    private Date data;
    private String luogo;
    @Column(name = "numero_posti_disponibili")
    private int numeroPostiDisponibili;
    @ManyToMany
    @JoinTable(name = "listaUtenti")
    private List<Utente> utenti;


    public Evento() {}

    public Evento(String descrizione, String titolo, Date data, String luogo, int numeroPostiDisponibili) {
        this.descrizione = descrizione;
        this.titolo = titolo;
        this.data = data;
        this.luogo = luogo;
        this.numeroPostiDisponibili = numeroPostiDisponibili;
        this.utenti = new ArrayList<>();
    }
    public void addUtente(Utente utente) {
        utenti.add(utente);
    }
}
