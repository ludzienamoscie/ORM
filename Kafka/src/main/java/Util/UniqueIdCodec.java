package main.java.Util;

import org.bson.BsonReader;
import org.bson.BsonWriter;
import org.bson.codecs.Codec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;
import org.bson.codecs.configuration.CodecRegistry;

import java.util.UUID;

public class UniqueIdCodec implements Codec<UUID> {

    private Codec<UUID> uuidCodec;

    public UniqueIdCodec(CodecRegistry registry) {
        uuidCodec = registry.get(UUID.class);
    }

    @Override
    public UUID decode(BsonReader bsonReader, DecoderContext decoderContext) {
        return uuidCodec.decode(bsonReader, decoderContext);
    }

    @Override
    public void encode(BsonWriter bsonWriter, UUID uuid, EncoderContext encoderContext) {
        uuidCodec.encode(bsonWriter, uuid, encoderContext);
    }

    @Override
    public Class<UUID> getEncoderClass() {
        return UUID.class;
    }
}
