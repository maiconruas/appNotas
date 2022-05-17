package com.example.appnotas.controller;

import com.example.appnotas.model.AppNotas;

public class AppNotaController {

    public double media(AppNotas appNotas) {
        return (appNotas.getNota1() + appNotas.getNota2()) / 2;
    }

}
