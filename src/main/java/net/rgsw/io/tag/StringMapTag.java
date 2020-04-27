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

public class StringMapTag extends MapTag<String> {

    public StringMapTag() {
    }

    public StringMapTag( Iterable<? extends Entry<? extends String, ? extends Tag>> values ) {
        super( values );
    }

    public StringMapTag( Iterator<? extends Entry<? extends String, ? extends Tag>> values ) {
        super( values );
    }

    public StringMapTag( Collection<? extends Entry<? extends String, ? extends Tag>> values ) {
        super( values );
    }

    public StringMapTag( Stream<? extends Entry<? extends String, ? extends Tag>> values ) {
        super( values );
    }

    public StringMapTag( Map<? extends String, ? extends Tag> values ) {
        super( values );
    }

    @Override
    protected String readKey( DataInput in ) throws IOException {
        return in.readUTF();
    }

    @Override
    protected void writeKey( String key, DataOutput out ) throws IOException {
        out.writeUTF( key );
    }
}
