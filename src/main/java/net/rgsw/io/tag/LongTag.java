/*
 * Copyright (c) 2020 RGSW
 * Licensed under the Apache 2.0 license
 */

package net.rgsw.io.tag;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class LongTag implements Tag {
    private long value;

    public LongTag( long value ) {
        this.value = value;
    }

    public LongTag() {
    }

    public long getValue() {
        return value;
    }

    public void setValue( long value ) {
        this.value = value;
    }

    @Override
    public void read( DataInput in, TagFormat format ) throws IOException {
        value = in.readLong();
    }

    @Override
    public void write( DataOutput out, TagFormat format ) throws IOException {
        out.writeLong( value );
    }
}
