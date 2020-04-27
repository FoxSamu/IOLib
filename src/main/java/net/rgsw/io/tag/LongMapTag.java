/*
 * Copyright (c) 2020 RGSW
 * Licensed under the Apache 2.0 license
 */

package net.rgsw.io.tag;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Stream;

public class LongMapTag extends MapTag<Long> {

    public LongMapTag() {
    }

    public LongMapTag( Iterable<? extends Entry<? extends Long, ? extends Tag>> values ) {
        super( values );
    }

    public LongMapTag( Iterator<? extends Entry<? extends Long, ? extends Tag>> values ) {
        super( values );
    }

    public LongMapTag( Collection<? extends Entry<? extends Long, ? extends Tag>> values ) {
        super( values );
    }

    public LongMapTag( Stream<? extends Entry<? extends Long, ? extends Tag>> values ) {
        super( values );
    }

    public LongMapTag( Map<? extends Long, ? extends Tag> values ) {
        super( values );
    }

    @Override
    protected Long readKey( DataInput in ) throws IOException {
        return in.readLong();
    }

    @Override
    protected void writeKey( Long key, DataOutput out ) throws IOException {
        out.writeLong( key );
    }
}
