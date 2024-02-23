package com.example.FinalProject.model;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

@Data
public class EventoRequest {
    @NotBlank(message = "Titolo obbligatorio")
    private String titolo;
    @NotBlank(message = "Descrizione obbligatoria")
    private String descrizione;
    @NotBlank(message = "Luovo obbligatorio")
    private String luogo;
    @NotBlank(message = "Data obbligatorio")
    private Date date;
    @NotBlank(message = "Numero massimo obbligatorio")
    private int numeroPostiDisponibili;
    @NotBlank(message = "ID Utente obbligatorio")
    private int utente_id;

}
