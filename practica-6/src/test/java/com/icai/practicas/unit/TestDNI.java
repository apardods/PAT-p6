package com.icai.practicas.unit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.icai.practicas.model.DNI;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class TestDNI {
    
    @ParameterizedTest
    @ValueSource(strings = {"74320725C","62613200R","83691850W","00306012C", "47755825M"})
    public void DNIValidoTest(String dni){
        DNI dnivalido = new DNI(dni);
        assertEquals(true,dnivalido.validar());
    }

    @ParameterizedTest
    @ValueSource(strings = {"","1234","123456789","ABCDEFGHI", "374828MR", "7828R1483"})
    public void DNIMalFormatoTest(String dni){
        DNI dniformato = new DNI(dni);
        assertEquals(false,dniformato.validar());
    }

    @ParameterizedTest
    @ValueSource(strings = {"12345678A","66666666R","99999999R"})
    public void DNInvalidoTest(String dni){
        DNI dniinvalido = new DNI(dni);
        assertEquals(false,dniinvalido.validar());
    }
}
