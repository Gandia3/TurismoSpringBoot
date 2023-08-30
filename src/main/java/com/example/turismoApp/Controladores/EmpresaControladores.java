package com.example.turismoApp.Controladores;


import com.example.turismoApp.modelos.Empresa;
import com.example.turismoApp.servicios.Empresaservicio;
import jakarta.websocket.Endpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/empresas")
public class EmpresaControladores {

    @Autowired
    Empresaservicio empresaservicio;

    @PostMapping
    public ResponseEntity<?> registrarEmpresa(@RequestBody Empresa datosEmpresa){
        return null;
    }

    @PutMapping
    public  ResponseEntity<?> editarEmpresa(@RequestBody Empresa datosNuevosEmpresa,@PathVariable Integer idEmpresa){
        return null;
    }

    @GetMapping
    public ResponseEntity<?> buscarUnaEmpresa(@PathVariable Integer id){
        return null;
    }

    @GetMapping
    public ResponseEntity<?> buscarTodasEmpresa(){
        return null;
    }

    @DeleteMapping
    public ResponseEntity<?> borrarEmpresa(@PathVariable Integer id){
        return null;
    }





}
