/*
 * Copyright (c) 2020 RGSW
 * Licensed under the Apache 2.0 license
 */

package net.rgsw.io.tag;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.UUID;

public interface Tag {
    void read( DataInput in, TagFormat format ) throws IOException;
    void write( DataOutput out, TagFormat format ) throws IOException;

    default byte byteValue() {
        return 0;
    }

    default short shortValue() {
        return 0;
    }

    default int intValue() {
        return 0;
    }

    default long longValue() {
        return 0;
    }

    default float floatValue() {
        return 0;
    }

    default double doubleValue() {
        return 0;
    }

    default char charValue() {
        return 0;
    }

    default boolean booleanValue() {
        return false;
    }

    default byte[] byteArrValue() {
        return new byte[ 0 ];
    }

    default short[] shortArrValue() {
        return new short[ 0 ];
    }

    default int[] intArrValue() {
        return new int[ 0 ];
    }

    default long[] longArrValue() {
        return new long[ 0 ];
    }

    default float[] floatArrValue() {
        return new float[ 0 ];
    }

    default double[] doubleArrValue() {
        return new double[ 0 ];
    }

    default char[] charArrValue() {
        return new char[ 0 ];
    }

    default boolean[] booleanArrValue() {
        return new boolean[ 0 ];
    }

    default String stringValue() {
        return "";
    }

    default String[] stringArrValue() {
        return new String[ 0 ];
    }

    default UUID uuidValue() {
        return UUID.randomUUID();
    }

    default ListTag asListTag() {
        return this instanceof ListTag ? (ListTag) this : new ListTag();
    }

    default StringMapTag asStringMapTag() {
        return this instanceof StringMapTag ? (StringMapTag) this : new StringMapTag();
    }

    default IntMapTag asIntMapTag() {
        return this instanceof IntMapTag ? (IntMapTag) this : new IntMapTag();
    }

    default LongMapTag asLongMapTag() {
        return this instanceof LongMapTag ? (LongMapTag) this : new LongMapTag();
    }
}
