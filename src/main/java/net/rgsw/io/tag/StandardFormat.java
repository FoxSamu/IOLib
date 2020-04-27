/*
 * Copyright (c) 2020 RGSW
 * Licensed under the Apache 2.0 license
 */

package net.rgsw.io.tag;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class StandardFormat implements TagFormat {
    public static final int LATEST_DEFAULT_VERSION = 0;
    private static final StandardFormat[] DEFAULTS = {
        builder().version0().build()
    };

    private final Map<Byte, Supplier<Tag>> constructors;
    private final Map<Class<? extends Tag>, Byte> ids;

    private StandardFormat( Map<Byte, Supplier<Tag>> constructors, Map<Class<? extends Tag>, Byte> ids ) {
        this.constructors = constructors;
        this.ids = ids;
    }


    @Override
    public void writeID( Tag tag, DataOutput out ) throws IOException {
        if( tag == null ) throw new NullPointerException( "Null tag" );

        Byte b = ids.get( tag.getClass() );
        if( b != null ) out.writeByte( b );
        else {
            throw new InvalidTagException( "Of " + tag.getClass() );
        }
    }

    @Override
    public void writeEnd( DataOutput out ) throws IOException {
        out.writeByte( ids.get( null ) );
    }

    @Override
    public Supplier<Tag> constructor( DataInput input ) throws IOException {
        byte id = input.readByte();
        if( constructors.containsKey( id ) ) {
            return constructors.get( id );
        }
        throw new InvalidTagException( "For id " + id );
    }

    public static StandardFormat version( int v ) {
        if( v < 0 || v >= DEFAULTS.length ) throw new IllegalArgumentException( "Unsupported version " + v );
        return DEFAULTS[ v ];
    }

    public static StandardFormat read( DataInput i ) throws IOException {
        int v = i.readShort();
        if( v < 0 || v >= DEFAULTS.length ) throw new InvalidVersionException( "Unsupported version " + v );
        return DEFAULTS[ v ];
    }

    public static StandardFormat version0() {
        return DEFAULTS[ 0 ];
    }

    public static StandardFormat latest() {
        return DEFAULTS[ LATEST_DEFAULT_VERSION ];
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final HashMap<Byte, Supplier<Tag>> constructors = new HashMap<>();
        private final HashMap<Class<? extends Tag>, Byte> ids = new HashMap<>();

        public <T extends Tag> Builder define( int id, Class<T> cls, Supplier<T> supp ) {
            constructors.put( (byte) id, supp::get );
            ids.put( cls, (byte) id );
            return this;
        }

        public StandardFormat build() {
            return new StandardFormat( Collections.unmodifiableMap( constructors ), Collections.unmodifiableMap( ids ) );
        }

        public Builder version( int version ) {
            if( version == 0 ) {
                return version0();
            }
            throw new IllegalArgumentException( "Unsupported version " + version );
        }

        public Builder version0() {
            define( 0, null, () -> null );
            define( 1, ByteTag.class, ByteTag::new );
            define( 2, ShortTag.class, ShortTag::new );
            define( 3, IntTag.class, IntTag::new );
            define( 4, LongTag.class, LongTag::new );
            define( 5, FloatTag.class, FloatTag::new );
            define( 6, DoubleTag.class, DoubleTag::new );
            define( 7, BooleanTag.class, BooleanTag::new );
            define( 8, CharTag.class, CharTag::new );
            define( 9, StringTag.class, StringTag::new );
            define( 10, ByteArrayTag.class, ByteArrayTag::new );
            define( 11, ShortArrayTag.class, ShortArrayTag::new );
            define( 12, IntArrayTag.class, IntArrayTag::new );
            define( 13, LongArrayTag.class, LongArrayTag::new );
            define( 14, FloatArrayTag.class, FloatArrayTag::new );
            define( 15, DoubleArrayTag.class, DoubleArrayTag::new );
            define( 16, BooleanArrayTag.class, BooleanArrayTag::new );
            define( 17, CharArrayTag.class, CharArrayTag::new );
            define( 18, StringArrayTag.class, StringArrayTag::new );
            define( 19, UUIDTag.class, UUIDTag::new );
            define( 20, ListTag.class, ListTag::new );
            define( 21, StringMapTag.class, StringMapTag::new );
            define( 22, IntMapTag.class, IntMapTag::new );
            define( 23, LongMapTag.class, LongMapTag::new );
            return this;
        }
    }
}
