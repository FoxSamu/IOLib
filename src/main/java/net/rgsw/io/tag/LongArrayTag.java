/*
 * Copyright (c) 2019 RedGalaxySW
 * Licensed under Apache Licence 2.0
 */

package net.rgsw.io.tag;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class LongArrayTag implements Tag {
    private long[] value;

    public LongArrayTag( long... value ) {
        if( value == null ) throw new NullPointerException( "Value must not be null" );
        this.value = value;
    }

    public LongArrayTag() {
    }

    public long[] getValue() {
        return value;
    }

    public void setValue( long... value ) {
        if( value == null ) throw new NullPointerException( "Value must not be null" );
        this.value = value;
    }

    @Override
    public void read( DataInput in, TagFormat format ) throws IOException {
        int len = in.readInt();
        long[] array = new long[ len ];
        for( int i = 0; i < len; i++ ) {
            array[ i ] = in.readLong();
        }
        value = array;
    }

    @Override
    public void write( DataOutput out, TagFormat format ) throws IOException {
        out.writeInt( value.length );
        for( long s : value ) {
            out.writeLong( s );
        }
    }
}
