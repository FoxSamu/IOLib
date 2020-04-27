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
