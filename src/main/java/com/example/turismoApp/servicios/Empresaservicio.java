package com.example.turismoApp.servicios;

import com.example.turismoApp.Validaciones.EmpresaValidacion;
import com.example.turismoApp.modelos.Empresa;
import com.example.turismoApp.repositorios.Empresarepositorio;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class Empresaservicio {

    @Autowired
    Empresarepositorio empresarepositorio;

    @Autowired
    EmpresaValidacion empresaValidacion;

    public Empresa registrarEmpresa(Empresa datosARegistrar)throws Exception{
       try {

           if (!this.empresaValidacion.validarNombre(datosARegistrar.getNombre())){
               throw new Exception("Error en el servicio");
           }

           //falta validar el nit

           return (this.empresarepositorio.save(datosARegistrar));

       }catch (Exception error){
           throw new Exception(error.getMessage());
       }
    }

    public Empresa modificarEmpresa(Integer id, Empresa datosAModificar)throws Exception{
       try {

           //Validamos informacion
           if (this.empresaValidacion.validarNombre(datosAModificar.getNombre())){
               throw new Exception("error en el dato entregado");
           }

           //Buscar que la empresa que tiene el id que envia el usuario
           Optional<Empresa> empresaEncontrada=this.empresarepositorio.findById(id);
           //Pregunto si lo que busque esta vacio
           if (empresaEncontrada.isEmpty()){
               throw new Exception("Empresa no encontrada");
           }
           //Rutina por si si la encontre
           //Convierto el opcional en la entidad respectiva
           Empresa empresaQueExiste=empresaEncontrada.get();

           //2. A la empresa que existe le cambio el usuario necesita
           empresaQueExiste.setNombre(datosAModificar.getNombre());

           //3. Guardar la informacion que se acaba de editar con el SET
           return  (this.empresarepositorio.save(empresaQueExiste));


       }catch (Exception error){
           throw new Exception(error.getMessage());
       }

    }

    public Empresa buscarEmpresaPorId(Integer id)throws Exception{
        try {

            Optional<Empresa> empresaOpcional= this.empresarepositorio.findById(id);
            if (empresaOpcional.isEmpty()){
                throw new Exception("Empresa no encontrada");
            }

            return  empresaOpcional.get();

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }

    }

    public List<Empresa> buscarTodasLasEmpresas() throws Exception{
        try {

            List<Empresa>listaEmpresa=this.empresarepositorio.findAll();
            return listaEmpresa;

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
    public boolean eliminarEmpresa(Integer id) throws Exception{
        try {

            Optional<Empresa>empresaOpcional=this.empresarepositorio.findById(id);
            if (empresaOpcional.isPresent()){
                this.empresarepositorio.deleteById(id);
                return true;
            }else{
                throw new Exception("Empresa no encontrada");
            }

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

}
