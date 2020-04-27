/*
 * Copyright (c) 2020 RGSW
 * Licensed under the Apache 2.0 license
 */

package net.rgsw.io.tag;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class CharArrayTag implements Tag {
    private char[] value;

    public CharArrayTag( char... value ) {
        if( value == null ) throw new NullPointerException( "Value must not be null" );
        this.value = value;
    }

    public CharArrayTag() {
    }

    public char[] getValue() {
        return value;
    }

    public void setValue( char... value ) {
        if( value == null ) throw new NullPointerException( "Value must not be null" );
        this.value = value;
    }

    @Override
    public void read( DataInput in, TagFormat format ) throws IOException {
        int len = in.readInt();
        char[] array = new char[ len ];
        for( int i = 0; i < len; i++ ) {
            array[ i ] = in.readChar();
        }
        value = array;
    }

    @Override
    public void write( DataOutput out, TagFormat format ) throws IOException {
        out.writeInt( value.length );
        for( char s : value ) {
            out.writeChar( s );
        }
    }
}
