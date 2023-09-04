package com.example.turismoApp.Controladores;


import com.example.turismoApp.modelos.Empresa;
import com.example.turismoApp.servicios.EmpresaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/empresas")
public class EmpresaControladores {

    @Autowired
    EmpresaServicio empresaservicio;

    @PostMapping
    public ResponseEntity<?> registrarEmpresa(@RequestBody Empresa datosEmpresa){
        try {
             return ResponseEntity
                     .status(HttpStatus.OK)
                     .body(this.empresaservicio.registrarEmpresa(datosEmpresa));
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    @PutMapping("{idEmpresa}")
    public  ResponseEntity<?> editarEmpresa(@RequestBody Empresa datosNuevosEmpresa,@PathVariable Integer idEmpresa){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.empresaservicio.modificarEmpresa(idEmpresa,datosNuevosEmpresa));
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<?> buscarUnaEmpresa(@PathVariable Integer id){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.empresaservicio.buscarEmpresaPorId(id));
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> buscarTodasEmpresa(){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.empresaservicio.buscarTodasLasEmpresas());
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> borrarEmpresa(@PathVariable Integer id){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.empresaservicio.eliminarEmpresa(id));
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }





}
