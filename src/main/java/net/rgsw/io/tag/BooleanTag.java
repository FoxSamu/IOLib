/*
 * Copyright (c) 2019 RedGalaxySW
 * Licensed under Apache Licence 2.0
 */

package net.rgsw.io.tag;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class BooleanTag implements Tag {
    private boolean value;

    public BooleanTag( boolean value ) {
        this.value = value;
    }

    public BooleanTag() {
    }

    public boolean getValue() {
        return value;
    }

    public void setValue( boolean value ) {
        this.value = value;
    }

    @Override
    public void read( DataInput in, TagFormat format ) throws IOException {
        value = in.readBoolean();
    }

    @Override
    public void write( DataOutput out, TagFormat format ) throws IOException {
        out.writeBoolean( value );
    }
}
