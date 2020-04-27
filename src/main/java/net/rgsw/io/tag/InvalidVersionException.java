/*
 * Copyright (c) 2020 RGSW
 * Licensed under the Apache 2.0 license
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
