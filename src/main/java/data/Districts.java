package data;

public enum Districts {
    Bagalkot("270"),
    Bangalore_Rural("276"),
    Bangalore_Urban("265"),
    BBMP("294"),
    Belgaum("264"),
    Bellary("274"),
    Bidar("272"),
    Chamarajanagar("271"),
    Chikamagalur("273"),
    Chikkaballapur("291"),
    Chitradurga("268"),
    Dakshina_Kannada("269"),
    Davanagere("275"),
    Dharwad("278"),
    Gadag("280"),
    Gulbarga("267"),
    Hassan("289"),
    Haveri("279"),
    Kodagu("283"),
    Kolar("277"),
    Koppal("282"),
    Mandya("290"),
    Mysore("266"),
    Raichur("284"),
    Ramanagara("292"),
    Shimoga("287"),
    Tumkur("288"),
    Udupi("286"),
    Uttar_Kannada("281"),
    Vijayapura("293"),
    Yadgir("285");

    public final String districtId;

    private Districts(String districtId) {
        this.districtId = districtId;
    }
}
