package ca.qc.johnabbott.finalproject.Model;

import java.util.UUID;

import ca.qc.johnabbott.finalproject.sqlite.Identifiable;

public class LocationD implements Identifiable<Long> {
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
    private boolean selected = false;

    public String getName() {
        return name;
    }
    public LocationD setName(String name) {
        this.name = name;
        return this;
    }

    public boolean isSelected() {
        return selected;
    }

    public LocationD setSelected(boolean selected) {
        this.selected = selected;
        return this;
    }

    public Double getLatitude() {
        return latitude;
    }
    public LocationD setLatitude(Double latitude) {
        this.latitude = latitude;
        return this;
    }

    public Double getLongitude() {
        return longitude;
    }
    public LocationD setLongitude(Double longitude) {
        this.longitude = longitude;
        return this;
    }


    public LocationD() { this(++CURRENT_LOCAL_ID, UUID.randomUUID()); }

    public LocationD(int id, UUID uuid){
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

    public LocationD setId(int id) {
        this.id = id;
        return this;
    }

    public UUID getUuid() {
        return uuid;
    }
    public LocationD setUuid(UUID uuid) {
        this.uuid = uuid;
        return this;
    }

    public String getAddress() {
        return address;
    }
    public LocationD setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getHours() {
        return hours;
    }
    public LocationD setHours(String hours) {
        this.hours = hours;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public LocationD setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getMap() {
        return map;
    }
    public LocationD setMap(String map) {
        this.map = map;
        return this;
    }
}
