/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.krugercorp.inventariovacunacion;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.krugercorp.inventariovacunacion.controllers.EmpleadoController;
import com.krugercorp.inventariovacunacion.enumeration.TipoVacuna;
import com.krugercorp.inventariovacunacion.models.EmpleadoModel;
import com.krugercorp.inventariovacunacion.services.EmpleadoService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.CoreMatchers.notNullValue;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 *
 * @author jbalcazar
 */
@WebMvcTest(EmpleadoController.class)
public class EmpleadoControllerTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper mapper;

    @MockBean
    EmpleadoService empleadoService;

    EmpleadoModel RECORD_1 = new EmpleadoModel(null,
            "1234567890", "Juan", "Perez", "JPerez@gmail.com",
            null, null, null, false, null, null, 0);
    EmpleadoModel RECORD_2 = new EmpleadoModel(1L,
            "1234567890", "Juan", "Perez", "JPerez@gmail.com",
            null, null, null, false, null, null, 0);

    @Test
    public void testListarTodos() throws Exception {
        ArrayList<EmpleadoModel> records = new ArrayList<>(Arrays.asList(RECORD_1));

        Mockito.when(empleadoService.listarTodos()).thenReturn(records);
        mockMvc.perform(MockMvcRequestBuilders
                .get("/empleados")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testGuardar() throws Exception {

        Mockito.when(empleadoService.guardarUsuario(RECORD_1)).thenReturn(RECORD_2);

        MockHttpServletRequestBuilder mockRequest
                = MockMvcRequestBuilders.post("/empleados")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(this.mapper.writeValueAsString(RECORD_1));

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", notNullValue()));
    }

}
