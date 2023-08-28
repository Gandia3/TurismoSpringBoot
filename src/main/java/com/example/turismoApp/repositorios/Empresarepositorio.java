package com.example.turismoApp.repositorios;


import com.example.turismoApp.modelos.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Empresarepositorio extends JpaRepository<Empresa,Integer> {
}
