package de.fynn.mystic.mysticguild.community;

import de.fynn.mystic.mysticguild.community.role.RoleManager;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class OfflineCommunity {

    private final UUID uuid;
    private String name;
    private UUID owner;
    private int level = 0;
    private double xp = 0;
    private String prefix;
    private Status status;
    private String description = "";

    private final List<UUID> members;
    private RoleManager roleManager;

    public OfflineCommunity(UUID uuid) {
        this.uuid = uuid;
        members = loadMembers();
    }

    protected abstract List<UUID> loadMembers();

    public OfflineCommunity(UUID uuid, UUID owner, String name){
        this.uuid = uuid;
        this.owner = owner;
        this.name = name;
        prefix = name.substring(0,4);
        status = Status.ONLY_INVITE;
        members = new ArrayList<>();
        members.add(owner);
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public String getPrefix() {
        return prefix;
    }

    public int getLevel() {
        return level;
    }

    public double getXp() {
        return xp;
    }

    public String getDescription(){
        return description;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public void setXp(double xp) {
        this.xp = xp;
    }

    public void addLevel(){
        level++;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public UUID getOwner(){
        return owner;
    }

    public void setOwner(UUID owner) {
        this.owner = owner;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public abstract void syncWithDB();


    public abstract OnlineCommunity getOnlineCommunity();


    public List<UUID> getMembers(){
        return members;
    }

    public abstract void addJoinRequest(UUID uuid, String displayname);

    public abstract void removeJoinRequest(UUID uuid);

    public abstract boolean isBanned(UUID uuid);

    public abstract boolean isInvited(UUID uuid);

    public RoleManager getRoleManager() {
        return roleManager;
    }

    public abstract void delete();

    public abstract void addMember(UUID uuid, String displayname);

    public abstract void removeMember(UUID uuid);

    public abstract List<UUID> syncMembersWithDB();

}
