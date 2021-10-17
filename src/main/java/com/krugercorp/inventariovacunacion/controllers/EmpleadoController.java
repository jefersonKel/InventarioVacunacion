package com.krugercorp.inventariovacunacion.controllers;

import com.krugercorp.inventariovacunacion.enumeration.TipoVacuna;
import com.krugercorp.inventariovacunacion.excepcion.EmpleadoException;
import com.krugercorp.inventariovacunacion.models.EmpleadoModel;
import com.krugercorp.inventariovacunacion.services.EmpleadoService;
import io.swagger.v3.oas.annotations.Operation;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * EmpleadoController.java clase rest para API de empleados 
 *
 * @author jbalcazar
 */
@RestController
@RequestMapping("/empleados")
public class EmpleadoController {

    @Autowired
    EmpleadoService empleadoService;

    @Operation(summary = "Guardar/Modificar empleado")
    @PostMapping()
    public ResponseEntity<EmpleadoModel> guardarEmpleado(@Valid @RequestBody EmpleadoModel empleado) {
        return ResponseEntity.ok(this.empleadoService.guardarUsuario(empleado));
    }

    @Operation(summary = "Eliminar empleado por id")
    @DeleteMapping(path = "/{id}")
    public boolean eliminarPorId(@PathVariable("id") Long id) {
        return this.empleadoService.eliminarEmpelado(id);
    }

    @Operation(summary = "Actualizar infromación de vacunación del empleado")
    @PutMapping()
    public boolean ActualizarEmpleado(@RequestBody EmpleadoModel empleado) {
        try {
            this.empleadoService.ActualizarInformacion(empleado);
        } catch (EmpleadoException ex) {
            return false;
        }
        return true;
    }

    @Operation(summary = "Listar todos los empleados")
    @GetMapping()
    public ArrayList<EmpleadoModel> listarTodos() {
        return empleadoService.listarTodos();
    }

    @Operation(summary = "Buscar empleado por id")
    @GetMapping(path = "/{id}")
    public Optional<EmpleadoModel> obtenerEmpleadoPorId(@PathVariable("id") Long id) {
        return this.empleadoService.obtenerPorId(id);
    }

    @Operation(summary = "Buscar empleado por identificacion")
    @GetMapping("/buscarPor")
    public Optional<EmpleadoModel> obtenerPorIdentificacion(@RequestParam("identificacion") String identificacion) {
        return this.empleadoService.obtenerPorIdentificacion(identificacion);
    }

    @Operation(summary = "Buscar empleados vacunados o sin vacunar (1/0)")
    @GetMapping("/listarPorVacunacion")
    public List<EmpleadoModel> listarPorVacunacion(
            @RequestParam(name = "vacunado") Integer vacunado) {
        return this.empleadoService.listarPorVacunacion(vacunado);
    }

    @Operation(summary = "Buscar empleados por tipo de vacunacion")
    @GetMapping("/listarPorTipoVacuna")
    public List<EmpleadoModel> listarPorTipoVacuna(
            @RequestParam(name = "vacunado") TipoVacuna tipoVacuna) {
        return this.empleadoService.listarPorTipoVacuna(tipoVacuna);
    }

    @Operation(summary = "Buscar empleados por fecha de vacunacion")
    @GetMapping("/listarPorFechaVacunacio")
    public List<EmpleadoModel> listarPorFechaVacunacio(
            @RequestParam(name = "fechaDesde") Date fechaDesde,
            @RequestParam(name = "fechaHasta") Date fechaHasta) {
        return this.empleadoService.listarPorFechaVacunacio(fechaDesde, fechaHasta);
    }
}
