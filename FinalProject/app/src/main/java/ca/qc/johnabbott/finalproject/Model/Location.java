package ca.qc.johnabbott.finalproject.Model;

import java.util.UUID;

import ca.qc.johnabbott.finalproject.sqlite.Identifiable;

public class Location implements Identifiable<Long> {
    private static int CURRENT_LOCAL_ID = 0;

    private long id;
    private UUID uuid;

    private String name;
    private String address;
    private String hours;
    private String phoneNumber;
    private String map;
    private Double latitude;
    private Double longitude;

    public String getName() {
        return name;
    }
    public Location setName(String name) {
        this.name = name;
        return this;
    }

    public Double getLatitude() {
        return latitude;
    }
    public Location setLatitude(Double latitude) {
        this.latitude = latitude;
        return this;
    }

    public Double getLongitude() {
        return longitude;
    }
    public Location setLongitude(Double longitude) {
        this.longitude = longitude;
        return this;
    }


    public Location() { this(++CURRENT_LOCAL_ID, UUID.randomUUID()); }

    public Location( int id, UUID uuid){
        this.id = id;
        this.uuid = uuid;
        this.address = null;
        this.hours = null;
        this.phoneNumber = null;
        this.map = null;
        this.latitude = null;
        this.longitude = null;
    }

    public Long getId() {
        return id;
    }

    @Override
    public Identifiable<Long> setId(Long id) {
        this.id = id;
        return this;
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
