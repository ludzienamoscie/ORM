package repositories;

import java.util.UUID;

public class UniqueIdMgd {

    private UUID uuid;

    public UniqueIdMgd(){
        this.uuid = UUID.randomUUID();
    }

    public UniqueIdMgd(UUID uuid) {
        this.uuid = uuid;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUniqueID(UUID uuid) {
        this.uuid = uuid;
    }

    public String toString() {
        return uuid.toString();
    }



}
