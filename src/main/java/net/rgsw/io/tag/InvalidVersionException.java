/*
 * Copyright (c) 2019 RedGalaxySW
 * Licensed under Apache Licence 2.0
 */

package net.rgsw.io.tag;

import java.io.IOException;

public class InvalidVersionException extends IOException {
    public InvalidVersionException() {
    }

    public InvalidVersionException( String message ) {
        super( message );
    }

    public InvalidVersionException( String message, Throwable cause ) {
        super( message, cause );
    }

    public InvalidVersionException( Throwable cause ) {
        super( cause );
    }
}
