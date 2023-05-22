package com.balmes.cursos.exceptions;

public class ResourceNotFoundException extends Exception{
    //Les excepcions han de ser serialitzables: guardar l'error en el disc dur
    //per tornar-ho a tenir o guardar els logs del log4j

    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(String msg) {
        super(msg);
    }
}

