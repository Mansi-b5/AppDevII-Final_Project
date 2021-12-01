package ca.qc.johnabbott.finalproject.Model;

import java.util.UUID;

public class Location {
    private static int CURRENT_LOCAL_ID = 0;

    private int id;
    private UUID uuid;

    private String address;
    private String hours;
    private String phoneNumber;
    private String map;

    public Location() { this(++CURRENT_LOCAL_ID, UUID.randomUUID()); }

    public Location( int id, UUID uuid){
        this.id = id;
        this.uuid = uuid;
        this.address = null;
        this.hours = null;
        this.phoneNumber = null;
        this.map = null;
    }

    public int getId() {
        return id;
    }
    public Location setId(int id) {
        this.id = id;
        return this;
    }

    public UUID getUuid() {
        return uuid;
    }
    public Location setUuid(UUID uuid) {
        this.uuid = uuid;
        return this;
    }

    public String getAddress() {
        return address;
    }
    public Location setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getHours() {
        return hours;
    }
    public Location setHours(String hours) {
        this.hours = hours;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public Location setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getMap() {
        return map;
    }
    public Location setMap(String map) {
        this.map = map;
        return this;
    }
}
