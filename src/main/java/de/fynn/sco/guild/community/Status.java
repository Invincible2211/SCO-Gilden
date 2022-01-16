package de.fynn.sco.guild.community;

public enum Status {
    OPEN(0),CLOSED(1),ONLY_INVITE(2);

    public final int value;

    Status(int value) {
        this.value = value;
    }
}
