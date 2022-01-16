package de.fynn.sco.guild.community.guild;

import de.fynn.sco.guild.community.OfflineCommunity;
import de.fynn.sco.guild.system.database.guild.GuildDBManager;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OfflineGuild extends OfflineCommunity {

    protected final GuildDBManager dbManager = new GuildDBManager(this);

    public OfflineGuild(UUID uuid) {
        super(uuid);
        syncWithDB();
    }

    @Override
    protected List<UUID> loadMembers() {
        return dbManager.getMembers();
    }

    public OfflineGuild(UUID uuid, UUID owner, String name) {
        super(uuid,owner,name);
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
    public Guild getOnlineCommunity(){
        return new Guild(getUuid());
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
