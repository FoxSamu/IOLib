/*
 * Copyright (c) 2019 RedGalaxySW
 * Licensed under Apache Licence 2.0
 */

package net.rgsw.io.tag;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class IntArrayTag implements Tag {
    private int[] value;

    public IntArrayTag( int... value ) {
        if( value == null ) throw new NullPointerException( "Value must not be null" );
        this.value = value;
    }

    public IntArrayTag() {
    }

    public int[] getValue() {
        return value;
    }

    public void setValue( int... value ) {
        if( value == null ) throw new NullPointerException( "Value must not be null" );
        this.value = value;
    }

    @Override
    public void read( DataInput in, TagFormat format ) throws IOException {
        int len = in.readInt();
        int[] array = new int[ len ];
        for( int i = 0; i < len; i++ ) {
            array[ i ] = in.readInt();
        }
        value = array;
    }

    @Override
    public void write( DataOutput out, TagFormat format ) throws IOException {
        out.writeInt( value.length );
        for( int s : value ) {
            out.writeInt( s );
        }
    }
}
