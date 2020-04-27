/*
 * Copyright (c) 2020 RedGalaxy & contributors
 * All rights reserved. Do not distribute.
 *
 * For a full license, see LICENSE.txt
 */

package net.rgsw.io.tag;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class CharTag implements Tag {
    private char value;

    public CharTag( char value ) {
        this.value = value;
    }

    public CharTag() {
    }

    public char getValue() {
        return value;
    }

    public void setValue( char value ) {
        this.value = value;
    }

    @Override
    public void read( DataInput in, TagFormat format ) throws IOException {
        value = in.readChar();
    }

    @Override
    public void write( DataOutput out, TagFormat format ) throws IOException {
        out.writeChar( value );
    }
}
