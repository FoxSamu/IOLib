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

public class ShortArrayTag implements Tag {
    private short[] value;

    public ShortArrayTag( short... value ) {
        if( value == null ) throw new NullPointerException( "Value must not be null" );
        this.value = value;
    }

    public ShortArrayTag() {
    }

    public short[] getValue() {
        return value;
    }

    public void setValue( short... value ) {
        if( value == null ) throw new NullPointerException( "Value must not be null" );
        this.value = value;
    }

    @Override
    public void read( DataInput in, TagFormat format ) throws IOException {
        int len = in.readInt();
        short[] array = new short[ len ];
        for( int i = 0; i < len; i++ ) {
            array[ i ] = in.readShort();
        }
        value = array;
    }

    @Override
    public void write( DataOutput out, TagFormat format ) throws IOException {
        out.writeInt( value.length );
        for( short s : value ) {
            out.writeShort( s );
        }
    }
}
