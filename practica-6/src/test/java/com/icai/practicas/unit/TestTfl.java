package com.icai.practicas.unit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.icai.practicas.model.Telefono;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class TestTfl {

    @ParameterizedTest
    @ValueSource(strings = {"1234567890","123-456-7890","(123) 456-7890","123.456.7890","123 456 789","123 45 67 89",
    "+12345678901", "+12 345678901", "+12 345 67 89 01", "+12 (345) 678-9012"})
    public void TelefonoValidoTest(String telefono){
        // Teléfonos que cumplen con el formato establecido
        Telefono tlf = new Telefono(telefono);
        assertEquals(true,tlf.validar());
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "123", "1234567", "+123456 789", "+748278738288848", "1.5.6.1", "Fernando Alonso",
    "123456789012"})
    public void TelefonoInvalidoTest(String telefono){
        Telefono tlf = new Telefono(telefono);
        assertEquals(false,tlf.validar());
    }
}
