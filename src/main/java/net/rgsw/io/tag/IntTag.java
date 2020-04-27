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

public class IntTag implements Tag {
    private int value;

    public IntTag( int value ) {
        this.value = value;
    }

    public IntTag() {
    }

    public int getValue() {
        return value;
    }

    public void setValue( int value ) {
        this.value = value;
    }

    @Override
    public void read( DataInput in, TagFormat format ) throws IOException {
        value = in.readInt();
    }

    @Override
    public void write( DataOutput out, TagFormat format ) throws IOException {
        out.writeInt( value );
    }
}
