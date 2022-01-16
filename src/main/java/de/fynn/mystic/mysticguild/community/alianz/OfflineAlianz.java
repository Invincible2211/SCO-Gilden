package de.fynn.mystic.mysticguild.community.alianz;

import de.fynn.mystic.mysticguild.community.OfflineCommunity;
import de.fynn.mystic.mysticguild.system.database.alianz.AlianzDBManger;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OfflineAlianz extends OfflineCommunity {

    protected final AlianzDBManger dbManager = new AlianzDBManger(this);

    public OfflineAlianz(UUID uuid) {
        super(uuid);
    }

    public OfflineAlianz(UUID alianz, UUID owner, String name) {
        super(alianz,owner,name);
    }

    @Override
    public void syncWithDB() {
        setXp(dbManager.getXP());
        setName(dbManager.getName());
        setPrefix(dbManager.getPrefix());
        setLevel(dbManager.getLevel());
        setOwner(dbManager.getOwner());
        setStatus(dbManager.getStatus());
        setDescription(getDescription());
    }

    @Override
    public Alianz getOnlineCommunity() {
        return new Alianz(getUuid());
    }

    @Override
    public List<UUID> loadMembers() {
        return dbManager.getMembers();
    }

    @Override
    public void addJoinRequest(UUID uuid, String displayname) {
        dbManager.addJoinRequest(uuid, displayname);
    }

    @Override
    public void removeJoinRequest(UUID uuid) {
        dbManager.removeJoinRequest(uuid);
    }

    @Override
    public boolean isBanned(UUID uuid) {
        return dbManager.isBanned(uuid);
    }

    @Override
    public boolean isInvited(UUID uuid) {
        return dbManager.isInvited(uuid);
    }

    @Override
    public void delete() {
        dbManager.delete();
    }

    @Override
    public void addMember(UUID uuid, String displayname) {
        dbManager.addMember(uuid, displayname);
    }

    @Override
    public void removeMember(UUID uuid) {
        dbManager.removeMember(uuid);
    }

    @Override
    public List<UUID> syncMembersWithDB() {
        List<UUID> uuids = new ArrayList<>();
        List<UUID> allMembers = dbManager.getMembers();
        for (UUID uuid:
             getMembers()) {
            allMembers.remove(uuid);
        }
        if(!allMembers.isEmpty()){
            getMembers().addAll(allMembers);
        }
        return allMembers;
    }


}
