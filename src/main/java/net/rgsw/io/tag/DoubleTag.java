/*
 * Copyright (c) 2019 RedGalaxySW
 * Licensed under Apache Licence 2.0
 */

package net.rgsw.io.tag;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class DoubleTag implements Tag {
    private double value;

    public DoubleTag( double value ) {
        this.value = value;
    }

    public DoubleTag() {
    }

    public double getValue() {
        return value;
    }

    public void setValue( double value ) {
        this.value = value;
    }

    @Override
    public void read( DataInput in, TagFormat format ) throws IOException {
        value = in.readDouble();
    }

    @Override
    public void write( DataOutput out, TagFormat format ) throws IOException {
        out.writeDouble( value );
    }
}
