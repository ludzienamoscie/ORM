package Util;

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
        UUID uuid = uuidCodec.decode(bsonReader, decoderContext);
        return new UniqueIdMgd(uuid);
    }

    @Override
    public void encode(BsonWriter bsonWriter, UniqueIdMgd uniqueIdMgd, EncoderContext encoderContext) {
        uuidCodec.encode(bsonWriter, uniqueIdMgd.getUuid(), encoderContext);
    }

    @Override
    public Class<UniqueIdMgd> getEncoderClass() {
        return UniqueIdMgd.class;
    }
}
