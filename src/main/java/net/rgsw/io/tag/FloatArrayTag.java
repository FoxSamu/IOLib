/*
 * Copyright (c) 2020 RGSW
 * Licensed under the Apache 2.0 license
 */

package net.rgsw.io.tag;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class FloatArrayTag implements Tag {
    private float[] value;

    public FloatArrayTag( float... value ) {
        if( value == null ) throw new NullPointerException( "Value must not be null" );
        this.value = value;
    }

    public FloatArrayTag() {
    }

    public float[] getValue() {
        return value;
    }

    public void setValue( float... value ) {
        if( value == null ) throw new NullPointerException( "Value must not be null" );
        this.value = value;
    }

    @Override
    public void read( DataInput in, TagFormat format ) throws IOException {
        int len = in.readInt();
        float[] array = new float[ len ];
        for( int i = 0; i < len; i++ ) {
            array[ i ] = in.readFloat();
        }
        value = array;
    }

    @Override
    public void write( DataOutput out, TagFormat format ) throws IOException {
        out.writeInt( value.length );
        for( float s : value ) {
            out.writeFloat( s );
        }
    }
}
