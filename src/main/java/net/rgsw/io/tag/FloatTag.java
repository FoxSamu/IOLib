/*
 * Copyright (c) 2019 RedGalaxySW
 * Licensed under Apache Licence 2.0
 */

package net.rgsw.io.tag;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class FloatTag implements Tag {
    private float value;

    public FloatTag( float value ) {
        this.value = value;
    }

    public FloatTag() {
    }

    public float getValue() {
        return value;
    }

    public void setValue( float value ) {
        this.value = value;
    }

    @Override
    public void read( DataInput in, TagFormat format ) throws IOException {
        value = in.readFloat();
    }

    @Override
    public void write( DataOutput out, TagFormat format ) throws IOException {
        out.writeFloat( value );
    }
}
