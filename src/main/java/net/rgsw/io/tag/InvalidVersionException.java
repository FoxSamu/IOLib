/*
 * Copyright (c) 2020 RedGalaxy & contributors
 * All rights reserved. Do not distribute.
 *
 * For a full license, see LICENSE.txt
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
