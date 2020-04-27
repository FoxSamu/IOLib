/*
 * Copyright (c) 2020 RGSW
 * Licensed under the Apache 2.0 license
 */

package net.rgsw.io.tag;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.UUID;

public class UUIDTag implements Tag {
    private UUID value;

    public UUIDTag( UUID value ) {
        if( value == null ) throw new NullPointerException( "Value must not be null" );
        this.value = value;
    }

    public UUIDTag() {
        value = UUID.randomUUID();
    }

    public UUID getValue() {
        return value;
    }

    public void setValue( UUID value ) {
        if( value == null ) throw new NullPointerException( "Value must not be null" );
        this.value = value;
    }

    @Override
    public void read( DataInput in, TagFormat format ) throws IOException {
        value = new UUID( in.readLong(), in.readLong() );
    }

    @Override
    public void write( DataOutput out, TagFormat format ) throws IOException {
        out.writeLong( value.getMostSignificantBits() );
        out.writeLong( value.getLeastSignificantBits() );
    }
}
