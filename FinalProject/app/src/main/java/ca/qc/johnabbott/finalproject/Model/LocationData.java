package ca.qc.johnabbott.finalproject.Model;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class LocationData {

    private static List<Location> data;

    private static void loadData() throws ParseException {
        data = new ArrayList<>();

        data.add(new Location()
        .setAddress("21275 Rue Lakeshore Road, Sainte-Anne-de-Bellevue, QC H9X 3L9")
        .setHours("Open Hours\n   Mon:  8AM - 9PM\n   Tue:  8AM - 9PM\n   Wed:  8AM - 9PM\n   Thurs: 8AM - 9PM\n   Fri:   8AM - 9PM\n")
        .setPhoneNumber("(514) 233-5442"));

        data.add(new Location()
                .setAddress("12345 Rue Daniel Road, Sainte-Anne-de-Bellevue, QC H9X 3L9")
                .setHours("Open Hours\n   Mon:  8AM - 9PM\n   Tue:  8AM - 9PM\n   Wed:  8AM - 9PM\n   Thurs: 8AM - 9PM\n   Fri:   8AM - 9PM\n")
                .setPhoneNumber("(514) 123-4567")
                .setMap("Open Map"));
    }

    public static List<Location> getData() {
        if (data == null) {
            try {
                loadData();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return data;
    }
}
