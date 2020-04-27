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

public class ByteTag implements Tag {
    private byte value;

    public ByteTag( byte value ) {
        this.value = value;
    }

    public ByteTag() {
    }

    public byte getValue() {
        return value;
    }

    public void setValue( byte value ) {
        this.value = value;
    }

    @Override
    public void read( DataInput in, TagFormat format ) throws IOException {
        value = in.readByte();
    }

    @Override
    public void write( DataOutput out, TagFormat format ) throws IOException {
        out.writeByte( value );
    }
}
