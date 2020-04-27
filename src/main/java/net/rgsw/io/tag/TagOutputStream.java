/*
 * Copyright (c) 2020 RedGalaxy & contributors
 * All rights reserved. Do not distribute.
 *
 * For a full license, see LICENSE.txt
 */

package net.rgsw.io.tag;

import java.io.DataOutput;
import java.io.IOException;
import java.io.OutputStream;

public class TagOutputStream extends OutputStream implements DataOutput {
    private final TagFormat format;
    private final DataOutput out;

    public TagOutputStream( DataOutput out, TagFormat format ) {
        this.out = out;
        this.format = format;
    }

    public TagOutputStream( DataOutput out ) throws IOException {
        this.out = out;
        out.writeShort( StandardFormat.LATEST_DEFAULT_VERSION );
        format = StandardFormat.latest();
    }

    public DataOutput getOut() {
        return out;
    }

    public TagFormat getFormat() {
        return format;
    }

    public void writeTag( Tag bin ) throws IOException {
        format.writeID( bin, out );
        bin.write( out, format );
    }

    @Override
    public void writeBoolean( boolean v ) throws IOException {
        out.writeBoolean( v );
    }

    @Override
    public void writeByte( int v ) throws IOException {
        out.writeByte( v );
    }

    @Override
    public void writeShort( int v ) throws IOException {
        out.writeShort( v );
    }

    @Override
    public void writeChar( int v ) throws IOException {
        out.writeChar( v );
    }

    @Override
    public void writeInt( int v ) throws IOException {
        out.writeInt( v );
    }

    @Override
    public void writeLong( long v ) throws IOException {
        out.writeLong( v );
    }

    @Override
    public void writeFloat( float v ) throws IOException {
        out.writeFloat( v );
    }

    @Override
    public void writeDouble( double v ) throws IOException {
        out.writeDouble( v );
    }

    @Override
    public void writeBytes( String s ) throws IOException {
        out.writeBytes( s );
    }

    @Override
    public void writeChars( String s ) throws IOException {
        out.writeChars( s );
    }

    @Override
    public void writeUTF( String s ) throws IOException {
        out.writeUTF( s );
    }

    @Override
    public void write( int b ) throws IOException {
        out.write( b );
    }

    @Override
    public void write( byte[] b ) throws IOException {
        out.write( b );
    }

    @Override
    public void write( byte[] b, int off, int len ) throws IOException {
        out.write( b, off, len );
    }
}
