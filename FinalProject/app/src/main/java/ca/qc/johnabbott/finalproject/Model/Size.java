package ca.qc.johnabbott.finalproject.Model;

public enum Size {
    SMALL("SMALL"),
    MEDIUM("MEDIUM"),
    LARGE("LARGE");

    private String sizes;

    private Size(String sizes){
        this.sizes = sizes;
    }

    @Override public String toString(){
        return sizes;
    }


}