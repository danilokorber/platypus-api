package io.easyware.platypus.exceptions;

import java.util.logging.Logger;
import java.util.logging.Level;

public class PlatypusPermissionsException extends Exception {

    private static final Logger LOGGER = Logger.getLogger( PlatypusPermissionsException.class.getName() );

    public PlatypusPermissionsException(String errorMessage) {
        super(errorMessage);
        LOGGER.log(Level.WARNING, errorMessage);
    }
}
