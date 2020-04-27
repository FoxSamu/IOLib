/*
 * Copyright (c) 2020 RGSW
 * Licensed under the Apache 2.0 license
 */

package net.rgsw.io.tag;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class StringTag implements Tag {
    private String value;

    public StringTag( String value ) {
        if( value == null ) throw new NullPointerException( "Value must not be null" );
        this.value = value;
    }

    public StringTag() {
        value = "";
    }

    public String getValue() {
        return value;
    }

    public void setValue( String value ) {
        if( value == null ) throw new NullPointerException( "Value must not be null" );
        this.value = value;
    }

    @Override
    public void read( DataInput in, TagFormat format ) throws IOException {
        value = in.readUTF();
    }

    @Override
    public void write( DataOutput out, TagFormat format ) throws IOException {
        out.writeUTF( value );
    }
}
