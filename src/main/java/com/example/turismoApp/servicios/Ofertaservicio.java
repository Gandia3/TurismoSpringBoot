package com.example.turismoApp.servicios;

import com.example.turismoApp.modelos.Empresa;
import com.example.turismoApp.modelos.Oferta;
import com.example.turismoApp.repositorios.Ofertarepositorio;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class Ofertaservicio {

    @Autowired
    Ofertarepositorio ofertarepositorio;

    public Oferta registrarOferta(Oferta datosARegistrar)throws Exception{
        try {
            return (this.ofertarepositorio.save(datosARegistrar));
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public Oferta modificarOferta(Integer id, Oferta datosAModificar)throws Exception{
        try {
            Optional<Oferta> ofertaEncontrada=this.ofertarepositorio.findById(id);
            if (ofertaEncontrada.isEmpty()){
                throw new Exception("Oferta no encontrada");
            }
            Oferta ofertaQueExiste=ofertaEncontrada.get();

            ofertaQueExiste.setTitulo(datosAModificar.getTitulo());
            ofertaQueExiste.setDescripcion(datosAModificar.getDescripcion());

            return  (this.ofertarepositorio.save(ofertaQueExiste));


        }catch (Exception error){
            throw new Exception(error.getMessage());
        }

    }


    public Oferta buscarOfertaPorId(Integer id)throws Exception{
        try {

            Optional<Oferta> ofertaOpcional= this.ofertarepositorio.findById(id);
            if (ofertaOpcional.isEmpty()){
                throw new Exception("Oferta no encontrada");
            }

            return  ofertaOpcional.get();

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public List<Oferta> buscarTodasLasOferta() throws Exception{
        try {

            List<Oferta>listaOferta=this.ofertarepositorio.findAll();
            return listaOferta;

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
    public boolean eliminarOferta(Integer id) throws Exception{
        try {

            Optional<Oferta>ofertaOpcional=this.ofertarepositorio.findById(id);
            if (ofertaOpcional.isPresent()){
                this.ofertarepositorio.deleteById(id);
                return true;
            }else{
                throw new Exception("Oferta no encontrada");
            }

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }


}

