/*
 * Copyright (c) 2019 RedGalaxySW
 * Licensed under Apache Licence 2.0
 */

package net.rgsw.io.tag;

import java.io.IOException;

public class InvalidTagException extends IOException {
    public InvalidTagException() {
    }

    public InvalidTagException( String message ) {
        super( message );
    }

    public InvalidTagException( String message, Throwable cause ) {
        super( message, cause );
    }

    public InvalidTagException( Throwable cause ) {
        super( cause );
    }
}
