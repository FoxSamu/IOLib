/*
 * Copyright (c) 2020 RedGalaxy & contributors
 * All rights reserved. Do not distribute.
 *
 * For a full license, see LICENSE.txt
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
