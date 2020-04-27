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
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Stream;

public class IntMapTag extends MapTag<Integer> {

    public IntMapTag() {
    }

    public IntMapTag( Iterable<? extends Entry<? extends Integer, ? extends Tag>> values ) {
        super( values );
    }

    public IntMapTag( Iterator<? extends Entry<? extends Integer, ? extends Tag>> values ) {
        super( values );
    }

    public IntMapTag( Collection<? extends Entry<? extends Integer, ? extends Tag>> values ) {
        super( values );
    }

    public IntMapTag( Stream<? extends Entry<? extends Integer, ? extends Tag>> values ) {
        super( values );
    }

    public IntMapTag( Map<? extends Integer, ? extends Tag> values ) {
        super( values );
    }

    @Override
    protected Integer readKey( DataInput in ) throws IOException {
        return in.readInt();
    }

    @Override
    protected void writeKey( Integer key, DataOutput out ) throws IOException {
        out.writeInt( key );
    }
}
