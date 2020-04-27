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

public class StringArrayTag implements Tag {
    private String[] value;

    public StringArrayTag( String... value ) {
        if( value == null ) throw new NullPointerException( "Value must not be null" );
        for( String s : value ) if( s == null ) throw new NullPointerException( "Value may not have null components" );
        this.value = value;
    }

    public StringArrayTag() {
    }

    public String[] getValue() {
        return value;
    }

    public void setValue( String... value ) {
        if( value == null ) throw new NullPointerException( "Value must not be null" );
        for( String s : value ) if( s == null ) throw new NullPointerException( "Value may not have null components" );
        this.value = value;
    }

    @Override
    public void read( DataInput in, TagFormat format ) throws IOException {
        int len = in.readInt();
        String[] array = new String[ len ];
        for( int i = 0; i < len; i++ ) {
            array[ i ] = in.readUTF();
        }
        value = array;
    }

    @Override
    public void write( DataOutput out, TagFormat format ) throws IOException {
        out.writeInt( value.length );
        for( String s : value ) {
            out.writeUTF( s );
        }
    }
}
