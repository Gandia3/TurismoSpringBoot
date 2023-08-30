package com.example.turismoApp.Controladores;

import com.example.turismoApp.modelos.Empresa;
import com.example.turismoApp.modelos.Oferta;
import com.example.turismoApp.servicios.Empresaservicio;
import com.example.turismoApp.servicios.Ofertaservicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;




@RestController
@RequestMapping("/oferta")
public class OfertaControladores {


    @Autowired
    Ofertaservicio ofertaservicio;

    @PostMapping
    public ResponseEntity<?> registrarOferta(@RequestBody Oferta datosOferta){
        return null;
    }

    @PutMapping
    public  ResponseEntity<?> editarOferta(@RequestBody Oferta datosNuevosOferta,@PathVariable Integer idOferta){
        return null;
    }

    @GetMapping
    public ResponseEntity<?> buscarUnaOferta(@PathVariable Integer id){
        return null;
    }

    @GetMapping
    public ResponseEntity<?> buscarTodasOferta(){
        return null;
    }

    @DeleteMapping
    public ResponseEntity<?> borrarOferta(@PathVariable Integer id){
        return null;
    }



}
