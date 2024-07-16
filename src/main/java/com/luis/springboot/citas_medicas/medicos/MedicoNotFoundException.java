package com.luis.springboot.citas_medicas.medicos;

public class MedicoNotFoundException extends Throwable {
    public MedicoNotFoundException(String message) {
        super(message);
    }
}
