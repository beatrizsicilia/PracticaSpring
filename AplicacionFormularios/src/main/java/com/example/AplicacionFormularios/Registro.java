package com.example.AplicacionFormularios;

import javax.validation.constraints.NotBlank;

import javax.validation.constraints.Size;


record Registro(

    @NotBlank
    @Size(min=8)
    String usuario,

    
    String password) {}

   