package com.example.turismoApp.Controladores;

import com.example.turismoApp.modelos.Oferta;
import com.example.turismoApp.servicios.OfertaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;




@RestController
@RequestMapping("/oferta")
public class OfertaControladores {


    @Autowired
    OfertaServicio ofertaservicio;

    @PostMapping
    public ResponseEntity<?> registrarOferta(@RequestBody Oferta datosOferta){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.ofertaservicio.registrarOferta(datosOferta));
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    @PutMapping ("{idOferta}")
    public  ResponseEntity<?> editarOferta(@RequestBody Oferta datosNuevosOferta,@PathVariable Integer idOferta){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.ofertaservicio.modificarOferta(idOferta,datosNuevosOferta));
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<?> buscarUnaOferta(@PathVariable Integer id){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.ofertaservicio.buscarOfertaPorId(id));
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> buscarTodasOferta(){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.ofertaservicio.buscarTodasLasOferta());
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> borrarOferta(@PathVariable Integer id){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.ofertaservicio.eliminarOferta(id));
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }



}
