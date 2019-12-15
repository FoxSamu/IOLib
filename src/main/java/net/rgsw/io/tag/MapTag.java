/*
 * Copyright (c) 2019 RedGalaxySW
 * Licensed under Apache Licence 2.0
 */

package net.rgsw.io.tag;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.*;
import java.util.stream.Stream;

public abstract class MapTag<K> implements Tag, Map<K, Tag> {
    private final HashMap<K, Tag> tags = new HashMap<>();

    public MapTag() {
    }

    public MapTag( Iterable<? extends Entry<? extends K, ? extends Tag>> values ) {
        values.forEach( e -> put( e.getKey(), e.getValue() ) );
    }

    public MapTag( Iterator<? extends Entry<? extends K, ? extends Tag>> values ) {
        values.forEachRemaining( e -> put( e.getKey(), e.getValue() ) );
    }

    public MapTag( Collection<? extends Entry<? extends K, ? extends Tag>> values ) {
        values.forEach( e -> put( e.getKey(), e.getValue() ) );
    }

    public MapTag( Stream<? extends Entry<? extends K, ? extends Tag>> values ) {
        values.forEach( e -> put( e.getKey(), e.getValue() ) );
    }

    public MapTag( Map<? extends K, ? extends Tag> values ) {
        putAll( values );
    }

    @Override
    public int size() {
        return tags.size();
    }

    @Override
    public boolean isEmpty() {
        return tags.isEmpty();
    }

    @Override
    public boolean containsKey( Object key ) {
        return tags.containsKey( key );
    }

    @Override
    public boolean containsValue( Object value ) {
        return tags.containsValue( value );
    }

    @Override
    public Tag get( Object key ) {
        return tags.get( key );
    }

    @Override
    public Tag put( K key, Tag value ) {
        if( key == null ) throw new NullPointerException( "Key is null" );
        if( value == null ) throw new NullPointerException( "Can't add null tags" );
        return tags.put( key, value );
    }

    @Override
    public Tag remove( Object key ) {
        return tags.remove( key );
    }

    @Override
    public void putAll( Map<? extends K, ? extends Tag> m ) {
        if( m == null ) throw new NullPointerException( "Map is null" );
        for( Entry<? extends K, ? extends Tag> e : m.entrySet() ) {
            if( e.getKey() == null ) throw new NullPointerException( "Key is null" );
            if( e.getValue() == null ) throw new NullPointerException( "Can't add null tags" );
        }
        tags.putAll( m );
    }

    @Override
    public void clear() {
        tags.clear();
    }

    @Override
    public Set<K> keySet() {
        return tags.keySet();
    }

    @Override
    public Collection<Tag> values() {
        return tags.values();
    }

    @Override
    public Set<Entry<K, Tag>> entrySet() {
        return tags.entrySet();
    }



    @Override
    public void read( DataInput in, TagFormat format ) throws IOException {
        tags.clear();
        for( int i = 0; i < Integer.MAX_VALUE; i++ ) {
            Tag tag = format.tag( in );
            if( tag == null ) return;
            K key = readKey( in );
            tag.read( in, format );
            tags.put( key, tag );
        }
    }

    @Override
    public void write( DataOutput out, TagFormat format ) throws IOException {
        for( Entry<K, Tag> e : tags.entrySet() ) {
            format.writeID( e.getValue(), out );
            writeKey( e.getKey(), out );
            e.getValue().write( out, format );
        }
        format.writeEnd( out );
    }

    protected abstract K readKey( DataInput in ) throws IOException;
    protected abstract void writeKey( K key, DataOutput out ) throws IOException;


    public void putByte( K key, byte value ) {
        put( key, new ByteTag( value ) );
    }

    public byte getByte( K key ) {
        Tag tag = get( key );
        return tag == null ? 0 : tag.byteValue();
    }

    public boolean isByte( K key ) {
        return get( key ) instanceof ByteTag;
    }


    public void putShort( K key, short value ) {
        put( key, new ShortTag( value ) );
    }

    public short getShort( K key ) {
        Tag tag = get( key );
        return tag == null ? 0 : tag.shortValue();
    }

    public boolean isShort( K key ) {
        return get( key ) instanceof ShortTag;
    }


    public void putInt( K key, int value ) {
        put( key, new IntTag( value ) );
    }

    public int getInt( K key ) {
        Tag tag = get( key );
        return tag == null ? 0 : tag.intValue();
    }

    public boolean isInt( K key ) {
        return get( key ) instanceof IntTag;
    }


    public void putLong( K key, long value ) {
        put( key, new LongTag( value ) );
    }

    public long getLong( K key ) {
        Tag tag = get( key );
        return tag == null ? 0 : tag.longValue();
    }

    public boolean isLong( K key ) {
        return get( key ) instanceof LongTag;
    }


    public void putFloat( K key, float value ) {
        put( key, new FloatTag( value ) );
    }

    public float getFloat( K key ) {
        Tag tag = get( key );
        return tag == null ? 0 : tag.floatValue();
    }

    public boolean isFloat( K key ) {
        return get( key ) instanceof FloatTag;
    }


    public void putDouble( K key, double value ) {
        put( key, new DoubleTag( value ) );
    }

    public double getDouble( K key ) {
        Tag tag = get( key );
        return tag == null ? 0 : tag.doubleValue();
    }

    public boolean isDouble( K key ) {
        return get( key ) instanceof DoubleTag;
    }


    public void putChar( K key, char value ) {
        put( key, new CharTag( value ) );
    }

    public char getChar( K key ) {
        Tag tag = get( key );
        return tag == null ? 0 : tag.charValue();
    }

    public boolean isChar( K key ) {
        return get( key ) instanceof CharTag;
    }


    public void putBoolean( K key, boolean value ) {
        put( key, new BooleanTag( value ) );
    }

    public boolean getBoolean( K key ) {
        Tag tag = get( key );
        return tag != null && tag.booleanValue();
    }

    public boolean isBoolean( K key ) {
        return get( key ) instanceof BooleanTag;
    }


    public void putString( K key, String value ) {
        put( key, new StringTag( value ) );
    }

    public String getString( K key ) {
        Tag tag = get( key );
        return tag == null ? "" : tag.stringValue();
    }

    public boolean isString( K key ) {
        return get( key ) instanceof StringTag;
    }


    public void putByteArray( K key, byte... value ) {
        put( key, new ByteArrayTag( value ) );
    }

    public byte[] getByteArray( K key ) {
        Tag tag = get( key );
        return tag == null ? new byte[ 0 ] : tag.byteArrValue();
    }

    public boolean isByteArray( K key ) {
        return get( key ) instanceof ByteArrayTag;
    }


    public void putShortArray( K key, short... value ) {
        put( key, new ShortArrayTag( value ) );
    }

    public short[] getShortArray( K key ) {
        Tag tag = get( key );
        return tag == null ? new short[ 0 ] : tag.shortArrValue();
    }

    public boolean isShortArray( K key ) {
        return get( key ) instanceof ShortArrayTag;
    }


    public void putIntArray( K key, int... value ) {
        put( key, new IntArrayTag( value ) );
    }

    public int[] getIntArray( K key ) {
        Tag tag = get( key );
        return tag == null ? new int[ 0 ] : tag.intArrValue();
    }

    public boolean isIntArray( K key ) {
        return get( key ) instanceof IntArrayTag;
    }


    public void putLongArray( K key, long... value ) {
        put( key, new LongArrayTag( value ) );
    }

    public long[] getLongArray( K key ) {
        Tag tag = get( key );
        return tag == null ? new long[ 0 ] : tag.longArrValue();
    }

    public boolean isLongArray( K key ) {
        return get( key ) instanceof LongArrayTag;
    }


    public void putFloatArray( K key, float... value ) {
        put( key, new FloatArrayTag( value ) );
    }

    public float[] getFloatArray( K key ) {
        Tag tag = get( key );
        return tag == null ? new float[ 0 ] : tag.floatArrValue();
    }

    public boolean isFloatArray( K key ) {
        return get( key ) instanceof FloatArrayTag;
    }


    public void putDoubleArray( K key, double... value ) {
        put( key, new DoubleArrayTag( value ) );
    }

    public double[] getDoubleArray( K key ) {
        Tag tag = get( key );
        return tag == null ? new double[ 0 ] : tag.doubleArrValue();
    }

    public boolean isDoubleArray( K key ) {
        return get( key ) instanceof DoubleArrayTag;
    }


    public void putCharArray( K key, char... value ) {
        put( key, new CharArrayTag( value ) );
    }

    public char[] getCharArray( K key ) {
        Tag tag = get( key );
        return tag == null ? new char[ 0 ] : tag.charArrValue();
    }

    public boolean isCharArray( K key ) {
        return get( key ) instanceof CharArrayTag;
    }


    public void putBooleanArray( K key, boolean... value ) {
        put( key, new BooleanArrayTag( value ) );
    }

    public boolean[] getBooleanArray( K key ) {
        Tag tag = get( key );
        return tag == null ? new boolean[ 0 ] : tag.booleanArrValue();
    }

    public boolean isBooleanArray( K key ) {
        return get( key ) instanceof BooleanArrayTag;
    }


    public void putStringArray( K key, String... value ) {
        put( key, new StringArrayTag( value ) );
    }

    public String[] getStringArray( K key ) {
        Tag tag = get( key );
        return tag == null ? new String[ 0 ] : tag.stringArrValue();
    }

    public boolean isStringArray( K key ) {
        return get( key ) instanceof StringArrayTag;
    }


    public void putUUID( K key, UUID value ) {
        put( key, new UUIDTag( value ) );
    }

    public UUID getUUID( K key ) {
        Tag tag = get( key );
        return tag == null ? UUID.randomUUID() : tag.uuidValue();
    }

    public boolean isUUID( K key ) {
        return get( key ) instanceof UUIDTag;
    }


    public void putList( K key, Tag... value ) {
        put( key, new ListTag( value ) );
    }

    public void putList( K key, Collection<Tag> value ) {
        put( key, new ListTag( value ) );
    }

    public void putList( K key, Iterable<Tag> value ) {
        put( key, new ListTag( value ) );
    }

    public void putList( K key, Iterator<Tag> value ) {
        put( key, new ListTag( value ) );
    }

    public void putList( K key, Stream<Tag> value ) {
        put( key, new ListTag( value ) );
    }

    public void putList( K key, ListTag value ) {
        put( key, value );
    }

    public ListTag getList( K key ) {
        Tag tag = get( key );
        return tag == null ? new ListTag() : tag.asListTag();
    }

    public Tag[] getListArray( K key ) {
        return getList( key ).toArray();
    }

    public boolean isList( K key ) {
        return get( key ) instanceof ListTag;
    }


    public void putStringMap( K key, Map<? extends String, ? extends Tag> value ) {
        put( key, new StringMapTag( value ) );
    }

    public void putStringMap( K key, StringMapTag value ) {
        put( key, value );
    }

    public StringMapTag getStringMap( K key ) {
        Tag tag = get( key );
        return tag == null ? new StringMapTag() : tag.asStringMapTag();
    }

    public boolean isStringMap( K key ) {
        return get( key ) instanceof StringMapTag;
    }


    public void putLongMap( K key, Map<? extends Long, ? extends Tag> value ) {
        put( key, new LongMapTag( value ) );
    }

    public void putLongMap( K key, LongMapTag value ) {
        put( key, value );
    }

    public LongMapTag getLongMap( K key ) {
        Tag tag = get( key );
        return tag == null ? new LongMapTag() : tag.asLongMapTag();
    }

    public boolean isLongMap( K key ) {
        return get( key ) instanceof LongMapTag;
    }


    public void putIntMap( K key, Map<? extends Integer, ? extends Tag> value ) {
        put( key, new IntMapTag( value ) );
    }

    public void putIntMap( K key, IntMapTag value ) {
        put( key, value );
    }

    public IntMapTag getIntMap( K key ) {
        Tag tag = get( key );
        return tag == null ? new IntMapTag() : tag.asIntMapTag();
    }

    public boolean isIntMap( K key ) {
        return get( key ) instanceof IntMapTag;
    }
}
