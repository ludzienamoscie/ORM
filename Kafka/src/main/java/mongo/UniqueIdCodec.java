package main.java.mongo;

import org.bson.BsonReader;
import org.bson.BsonWriter;
import org.bson.codecs.Codec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;
import org.bson.codecs.configuration.CodecRegistry;

import java.util.UUID;

public class UniqueIdCodec implements Codec<UniqueIdMgd> {

    private Codec<UUID> uuidCodec;

    public UniqueIdCodec(CodecRegistry registry) {
        uuidCodec = registry.get(UUID.class);
    }

    @Override
    public UniqueIdMgd decode(BsonReader bsonReader, DecoderContext decoderContext) {
        return new UniqueIdMgd(uuidCodec.decode(bsonReader, decoderContext));
    }

    @Override
    public void encode(BsonWriter bsonWriter, UniqueIdMgd uuid, EncoderContext encoderContext) {
        uuidCodec.encode(bsonWriter, uuid.getUuid(), encoderContext);
    }

    @Override
    public Class<UniqueIdMgd> getEncoderClass() {
        return UniqueIdMgd.class;
    }
}
