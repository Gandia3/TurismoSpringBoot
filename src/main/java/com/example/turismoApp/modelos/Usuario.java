package com.example.turismoApp.modelos;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity

public class Usuario {

@Id
public Integer id;
public String nombre;
public String cedula;
public Integer rol;


}
