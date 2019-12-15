/*
 * Copyright (c) 2019 RedGalaxySW
 * Licensed under Apache Licence 2.0
 */

package net.rgsw.io.tag;

import java.io.DataInput;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

public class TagInputStream extends InputStream implements DataInput {
    private final TagFormat format;
    private final DataInput in;

    public TagInputStream( DataInput in, TagFormat format ) {
        this.in = in;
        this.format = format;
    }

    public TagInputStream( DataInput in ) throws IOException {
        this.in = in;
        this.format = StandardFormat.read( in );
    }

    public DataInput getIn() {
        return in;
    }

    public TagFormat getFormat() {
        return format;
    }

    public Tag readTag() throws IOException {
        Tag bin = format.tag( in );
        bin.read( in, format );
        return bin;
    }

    @Override
    public void readFully( byte[] b ) throws IOException {
        in.readFully( b );
    }

    @Override
    public void readFully( byte[] b, int off, int len ) throws IOException {
        in.readFully( b, off, len );
    }

    @Override
    public int skipBytes( int n ) throws IOException {
        return in.skipBytes( n );
    }

    @Override
    public boolean readBoolean() throws IOException {
        return in.readBoolean();
    }

    @Override
    public byte readByte() throws IOException {
        return in.readByte();
    }

    @Override
    public int readUnsignedByte() throws IOException {
        return in.readUnsignedByte();
    }

    @Override
    public short readShort() throws IOException {
        return in.readShort();
    }

    @Override
    public int readUnsignedShort() throws IOException {
        return in.readUnsignedShort();
    }

    @Override
    public char readChar() throws IOException {
        return in.readChar();
    }

    @Override
    public int readInt() throws IOException {
        return in.readInt();
    }

    @Override
    public long readLong() throws IOException {
        return in.readLong();
    }

    @Override
    public float readFloat() throws IOException {
        return in.readFloat();
    }

    @Override
    public double readDouble() throws IOException {
        return in.readDouble();
    }

    @Override
    public String readLine() throws IOException {
        return in.readLine();
    }

    @Override
    public String readUTF() throws IOException {
        return in.readUTF();
    }

    @Override
    public int read() throws IOException {
        try {
            return in.readByte() & 0xFF;
        } catch( EOFException exc ) {
            return - 1;
        }
    }
}
