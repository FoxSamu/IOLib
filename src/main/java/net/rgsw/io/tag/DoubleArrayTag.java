/*
 * Copyright (c) 2020 RGSW
 * Licensed under the Apache 2.0 license
 */

package net.rgsw.io.tag;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class DoubleArrayTag implements Tag {
    private double[] value;

    public DoubleArrayTag( double... value ) {
        if( value == null ) throw new NullPointerException( "Value must not be null" );
        this.value = value;
    }

    public DoubleArrayTag() {
    }

    public double[] getValue() {
        return value;
    }

    public void setValue( double... value ) {
        if( value == null ) throw new NullPointerException( "Value must not be null" );
        this.value = value;
    }

    @Override
    public void read( DataInput in, TagFormat format ) throws IOException {
        int len = in.readInt();
        double[] array = new double[ len ];
        for( int i = 0; i < len; i++ ) {
            array[ i ] = in.readDouble();
        }
        value = array;
    }

    @Override
    public void write( DataOutput out, TagFormat format ) throws IOException {
        out.writeInt( value.length );
        for( double s : value ) {
            out.writeDouble( s );
        }
    }
}
