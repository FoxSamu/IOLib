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

public class ListTag extends AbstractList<Tag> implements Tag {
    private final ArrayList<Tag> tags = new ArrayList<>();

    public ListTag() {
    }

    public ListTag( Tag... values ) {
        if( values == null ) throw new NullPointerException();
        addAll( Arrays.asList( values ) );
    }

    public ListTag( Iterable<Tag> values ) {
        if( values == null ) throw new NullPointerException();
        values.forEach( this::add );
    }

    public ListTag( Iterator<Tag> values ) {
        if( values == null ) throw new NullPointerException();
        values.forEachRemaining( this::add );
    }

    public ListTag( Collection<Tag> values ) {
        if( values == null ) throw new NullPointerException();
        addAll( values );
    }

    public ListTag( Stream<Tag> values ) {
        if( values == null ) throw new NullPointerException();
        values.forEachOrdered( this::add );
    }

    public ListTag( ListTag values ) {
        if( values == null ) throw new NullPointerException();
        addAll( values );
    }

    @Override
    public void clear() {
        tags.clear();
    }

    @Override
    public Tag get( int index ) {
        return tags.get( index );
    }

    @Override
    public int size() {
        return tags.size();
    }

    @Override
    public void add( int index, Tag tag ) {
        if( tag == null ) throw new NullPointerException( "Cannot add null tags" );
        tags.add( index, tag );
    }

    @Override
    public Tag remove( int index ) {
        return tags.remove( index );
    }

    @Override
    public Tag set( int index, Tag tag ) {
        if( tag == null ) throw new NullPointerException( "Cannot add null tags" );
        return tags.set( index, tag );
    }


    public void addByte( byte value ) {
        tags.add( new ByteTag( value ) );
    }

    public void addByte( int index, byte value ) {
        tags.add( index, new ByteTag( value ) );
    }

    public void setByte( int index, byte value ) {
        tags.set( index, new ByteTag( value ) );
    }

    public byte getByte( int index ) {
        return tags.get( index ).byteValue();
    }

    public boolean isByte( int index ) {
        return tags.get( index ) instanceof ByteTag;
    }


    public void addShort( short value ) {
        tags.add( new ShortTag( value ) );
    }

    public void addShort( int index, short value ) {
        tags.add( index, new ShortTag( value ) );
    }

    public void setShort( int index, short value ) {
        tags.set( index, new ShortTag( value ) );
    }

    public short getShort( int index ) {
        return tags.get( index ).shortValue();
    }

    public boolean isShort( int index ) {
        return tags.get( index ) instanceof ShortTag;
    }


    public void addInt( int value ) {
        tags.add( new IntTag( value ) );
    }

    public void addInt( int index, int value ) {
        tags.add( index, new IntTag( value ) );
    }

    public void setInt( int index, int value ) {
        tags.set( index, new IntTag( value ) );
    }

    public int getInt( int index ) {
        return tags.get( index ).intValue();
    }

    public boolean isInt( int index ) {
        return tags.get( index ) instanceof IntTag;
    }


    public void addLong( long value ) {
        tags.add( new LongTag( value ) );
    }

    public void addLong( int index, long value ) {
        tags.add( index, new LongTag( value ) );
    }

    public void setLong( int index, long value ) {
        tags.set( index, new LongTag( value ) );
    }

    public long getLong( int index ) {
        return tags.get( index ).longValue();
    }

    public boolean isLong( int index ) {
        return tags.get( index ) instanceof LongTag;
    }


    public void addFloat( float value ) {
        tags.add( new FloatTag( value ) );
    }

    public void addFloat( int index, float value ) {
        tags.add( index, new FloatTag( value ) );
    }

    public void setFloat( int index, float value ) {
        tags.set( index, new FloatTag( value ) );
    }

    public float getFloat( int index ) {
        return tags.get( index ).floatValue();
    }

    public boolean isFloat( int index ) {
        return tags.get( index ) instanceof FloatTag;
    }


    public void addDouble( double value ) {
        tags.add( new DoubleTag( value ) );
    }

    public void addDouble( int index, double value ) {
        tags.add( index, new DoubleTag( value ) );
    }

    public void setDouble( int index, double value ) {
        tags.set( index, new DoubleTag( value ) );
    }

    public double getDouble( int index ) {
        return tags.get( index ).doubleValue();
    }

    public boolean isDouble( int index ) {
        return tags.get( index ) instanceof DoubleTag;
    }


    public void addChar( char value ) {
        tags.add( new CharTag( value ) );
    }

    public void addChar( int index, char value ) {
        tags.add( index, new CharTag( value ) );
    }

    public void setChar( int index, char value ) {
        tags.set( index, new CharTag( value ) );
    }

    public char getChar( int index ) {
        return tags.get( index ).charValue();
    }

    public boolean isChar( int index ) {
        return tags.get( index ) instanceof CharTag;
    }


    public void addBoolean( boolean value ) {
        tags.add( new BooleanTag( value ) );
    }

    public void addBoolean( int index, boolean value ) {
        tags.add( index, new BooleanTag( value ) );
    }

    public void setBoolean( int index, boolean value ) {
        tags.set( index, new BooleanTag( value ) );
    }

    public boolean getBoolean( int index ) {
        return tags.get( index ).booleanValue();
    }

    public boolean isBoolean( int index ) {
        return tags.get( index ) instanceof BooleanTag;
    }


    public void addString( String value ) {
        tags.add( new StringTag( value ) );
    }

    public void addString( int index, String value ) {
        tags.add( index, new StringTag( value ) );
    }

    public void setString( int index, String value ) {
        tags.set( index, new StringTag( value ) );
    }

    public String getString( int index ) {
        return tags.get( index ).stringValue();
    }

    public boolean isString( int index ) {
        return tags.get( index ) instanceof StringTag;
    }


    public void addUUID( UUID value ) {
        tags.add( new UUIDTag( value ) );
    }

    public void addUUID( int index, UUID value ) {
        tags.add( index, new UUIDTag( value ) );
    }

    public void setUUID( int index, UUID value ) {
        tags.set( index, new UUIDTag( value ) );
    }

    public UUID getUUID( int index ) {
        return tags.get( index ).uuidValue();
    }

    public boolean isUUID( int index ) {
        return tags.get( index ) instanceof UUIDTag;
    }


    public void addByteArray( byte... value ) {
        tags.add( new ByteArrayTag( value ) );
    }

    public void addByteArray( int index, byte... value ) {
        tags.add( index, new ByteArrayTag( value ) );
    }

    public void setByteArray( int index, byte... value ) {
        tags.set( index, new ByteArrayTag( value ) );
    }

    public byte[] getByteArray( int index ) {
        return tags.get( index ).byteArrValue();
    }

    public boolean isByteArray( int index ) {
        return tags.get( index ) instanceof ByteArrayTag;
    }


    public void addShortArray( short... value ) {
        tags.add( new ShortArrayTag( value ) );
    }

    public void addShortArray( int index, short... value ) {
        tags.add( index, new ShortArrayTag( value ) );
    }

    public void setShortArray( int index, short... value ) {
        tags.set( index, new ShortArrayTag( value ) );
    }

    public short[] getShortArray( int index ) {
        return tags.get( index ).shortArrValue();
    }

    public boolean isShortArray( int index ) {
        return tags.get( index ) instanceof ShortArrayTag;
    }


    public void addIntArray( int... value ) {
        tags.add( new IntArrayTag( value ) );
    }

    public void addIntArray( int index, int... value ) {
        tags.add( index, new IntArrayTag( value ) );
    }

    public void setIntArray( int index, int... value ) {
        tags.set( index, new IntArrayTag( value ) );
    }

    public int[] getIntArray( int index ) {
        return tags.get( index ).intArrValue();
    }

    public boolean isIntArray( int index ) {
        return tags.get( index ) instanceof IntArrayTag;
    }


    public void addLongArray( long... value ) {
        tags.add( new LongArrayTag( value ) );
    }

    public void addLongArray( int index, long... value ) {
        tags.add( index, new LongArrayTag( value ) );
    }

    public void setLongArray( int index, long... value ) {
        tags.set( index, new LongArrayTag( value ) );
    }

    public long[] getLongArray( int index ) {
        return tags.get( index ).longArrValue();
    }

    public boolean isLongArray( int index ) {
        return tags.get( index ) instanceof LongArrayTag;
    }


    public void addFloatArray( float... value ) {
        tags.add( new FloatArrayTag( value ) );
    }

    public void addFloatArray( int index, float... value ) {
        tags.add( index, new FloatArrayTag( value ) );
    }

    public void setFloatArray( int index, float... value ) {
        tags.set( index, new FloatArrayTag( value ) );
    }

    public float[] getFloatArray( int index ) {
        return tags.get( index ).floatArrValue();
    }

    public boolean isFloatArray( int index ) {
        return tags.get( index ) instanceof FloatArrayTag;
    }


    public void addDoubleArray( double... value ) {
        tags.add( new DoubleArrayTag( value ) );
    }

    public void addDoubleArray( int index, double... value ) {
        tags.add( index, new DoubleArrayTag( value ) );
    }

    public void setDoubleArray( int index, double... value ) {
        tags.set( index, new DoubleArrayTag( value ) );
    }

    public double[] getDoubleArray( int index ) {
        return tags.get( index ).doubleArrValue();
    }

    public boolean isDoubleArray( int index ) {
        return tags.get( index ) instanceof DoubleArrayTag;
    }


    public void addCharArray( char... value ) {
        tags.add( new CharArrayTag( value ) );
    }

    public void addCharArray( int index, char... value ) {
        tags.add( index, new CharArrayTag( value ) );
    }

    public void setCharArray( int index, char... value ) {
        tags.set( index, new CharArrayTag( value ) );
    }

    public char[] getCharArray( int index ) {
        return tags.get( index ).charArrValue();
    }

    public boolean isCharArray( int index ) {
        return tags.get( index ) instanceof CharArrayTag;
    }


    public void addBooleanArray( boolean... value ) {
        tags.add( new BooleanArrayTag( value ) );
    }

    public void addBooleanArray( int index, boolean... value ) {
        tags.add( index, new BooleanArrayTag( value ) );
    }

    public void setBooleanArray( int index, boolean... value ) {
        tags.set( index, new BooleanArrayTag( value ) );
    }

    public boolean[] getBooleanArray( int index ) {
        return tags.get( index ).booleanArrValue();
    }

    public boolean isBooleanArray( int index ) {
        return tags.get( index ) instanceof BooleanArrayTag;
    }


    public void addStringArray( String... value ) {
        tags.add( new StringArrayTag( value ) );
    }

    public void addStringArray( int index, String... value ) {
        tags.add( index, new StringArrayTag( value ) );
    }

    public void setStringArray( int index, String... value ) {
        tags.set( index, new StringArrayTag( value ) );
    }

    public String[] getStringArray( int index ) {
        return tags.get( index ).stringArrValue();
    }

    public boolean isStringArray( int index ) {
        return tags.get( index ) instanceof StringArrayTag;
    }


    public void addList( Tag... value ) {
        tags.add( new ListTag( value ) );
    }

    public void addList( Iterable<Tag> value ) {
        tags.add( new ListTag( value ) );
    }

    public void addList( Collection<Tag> value ) {
        tags.add( new ListTag( value ) );
    }

    public void addList( Stream<Tag> value ) {
        tags.add( new ListTag( value ) );
    }

    public void addList( Iterator<Tag> value ) {
        tags.add( new ListTag( value ) );
    }

    public void addList( ListTag value ) {
        add( value );
    }

    public void addList( int index, Tag... value ) {
        tags.add( index, new ListTag( value ) );
    }

    public void addList( int index, Iterable<Tag> value ) {
        tags.add( index, new ListTag( value ) );
    }

    public void addList( int index, Collection<Tag> value ) {
        tags.add( index, new ListTag( value ) );
    }

    public void addList( int index, Stream<Tag> value ) {
        tags.add( index, new ListTag( value ) );
    }

    public void addList( int index, Iterator<Tag> value ) {
        tags.add( index, new ListTag( value ) );
    }

    public void addList( int index, ListTag value ) {
        add( index, value );
    }

    public void setList( int index, Tag... value ) {
        tags.set( index, new ListTag( value ) );
    }

    public void setList( int index, Iterable<Tag> value ) {
        tags.set( index, new ListTag( value ) );
    }

    public void setList( int index, Iterator<Tag> value ) {
        tags.set( index, new ListTag( value ) );
    }

    public void setList( int index, Collection<Tag> value ) {
        tags.set( index, new ListTag( value ) );
    }

    public void setList( int index, Stream<Tag> value ) {
        tags.set( index, new ListTag( value ) );
    }

    public void setList( int index, ListTag value ) {
        set( index, value );
    }

    public ListTag getList( int index ) {
        return tags.get( index ).asListTag();
    }

    public Tag[] getListArray( int index ) {
        return tags.get( index ).asListTag().toArray();
    }

    public boolean isList( int index ) {
        return tags.get( index ) instanceof ListTag;
    }


    public void addStringMap( Map<? extends String, ? extends Tag> value ) {
        tags.add( new StringMapTag( value ) );
    }

    public void addStringMap( int index, Map<? extends String, ? extends Tag> value ) {
        tags.add( index, new StringMapTag( value ) );
    }

    public void setStringMap( int index, Map<? extends String, ? extends Tag> value ) {
        tags.set( index, new StringMapTag( value ) );
    }

    public void addStringMap( StringMapTag value ) {
        add( value );
    }

    public void addStringMap( int index, StringMapTag value ) {
        add( index, value );
    }

    public void setStringMap( int index, StringMapTag value ) {
        set( index, value );
    }

    public StringMapTag getStringMap( int index ) {
        return tags.get( index ).asStringMapTag();
    }

    public boolean isStringMap( int index ) {
        return tags.get( index ) instanceof StringMapTag;
    }


    public void addLongMap( Map<? extends Long, ? extends Tag> value ) {
        tags.add( new LongMapTag( value ) );
    }

    public void addLongMap( int index, Map<? extends Long, ? extends Tag> value ) {
        tags.add( index, new LongMapTag( value ) );
    }

    public void setLongMap( int index, Map<? extends Long, ? extends Tag> value ) {
        tags.set( index, new LongMapTag( value ) );
    }

    public void addLongMap( LongMapTag value ) {
        add( value );
    }

    public void addLongMap( int index, LongMapTag value ) {
        add( index, value );
    }

    public void setLongMap( int index, LongMapTag value ) {
        set( index, value );
    }

    public LongMapTag getLongMap( int index ) {
        return tags.get( index ).asLongMapTag();
    }

    public boolean isLongMap( int index ) {
        return tags.get( index ) instanceof LongMapTag;
    }


    public void addIntMap( Map<? extends Integer, ? extends Tag> value ) {
        tags.add( new IntMapTag( value ) );
    }

    public void addIntMap( IntMapTag value ) {
        add( value );
    }

    public void addIntMap( int index, Map<? extends Integer, ? extends Tag> value ) {
        tags.add( index, new IntMapTag( value ) );
    }

    public void addIntMap( int index, IntMapTag value ) {
        add( index, value );
    }

    public void setIntMap( int index, Map<? extends Integer, ? extends Tag> value ) {
        tags.set( index, new IntMapTag( value ) );
    }

    public void setIntMap( int index, IntMapTag value ) {
        set( index, value );
    }

    public IntMapTag getIntMap( int index ) {
        return tags.get( index ).asIntMapTag();
    }

    public boolean isIntMap( int index ) {
        return tags.get( index ) instanceof IntMapTag;
    }


    @Override
    public Tag[] toArray() {
        return tags.toArray( new Tag[ 0 ] );
    }



    @Override
    public void read( DataInput in, TagFormat format ) throws IOException {
        tags.clear();
        for( int i = 0; i < Integer.MAX_VALUE; i++ ) {
            Tag tag = format.tag( in );
            if( tag == null ) { // End tag
                return;
            }
            tag.read( in, format );
            tags.add( tag );
        }
    }

    @Override
    public void write( DataOutput out, TagFormat format ) throws IOException {
        for( Tag tag : tags ) {
            format.writeID( tag, out );
            tag.write( out, format );
        }
        format.writeEnd( out );
    }
}
