/*
 * Copyright (c) 2020 RGSW
 * Licensed under the Apache 2.0 license
 */

package net.rgsw.io.tag;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class ShortTag implements Tag {
    private short value;

    public ShortTag( short value ) {
        this.value = value;
    }

    public ShortTag() {
    }

    public short getValue() {
        return value;
    }

    public void setValue( short value ) {
        this.value = value;
    }

    @Override
    public void read( DataInput in, TagFormat format ) throws IOException {
        value = in.readShort();
    }

    @Override
    public void write( DataOutput out, TagFormat format ) throws IOException {
        out.writeShort( value );
    }
}
