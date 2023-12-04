public class part {

    public char content;
    public boolean verbunden;
    public int wert;

    public part partner;
    public boolean hasPartner;
    public part partner2;
    public boolean hasPartner2;
    public part main;
    public boolean gecheckt;
    public boolean special;

    //Konstruktor
    public part(char content)
    {
        this.content = content;
        hasPartner = false;
        hasPartner2 = false;
        verbunden = false;
        gecheckt = false;
        special = false;
    }

    public void setPartner(part partner) {
        this.partner = partner;
    }

    public boolean isVerbunden() {
        return verbunden;
    }

    public int getWert() {
        return wert;
    }

    public void setWert(int wert) {
        this.wert = wert;
    }

    public void setVerbunden(boolean verbunden) {
        this.verbunden = verbunden;
    }

    public void setPartner2(part partner2) {
        this.partner2 = partner2;
    }

    public void setMain(part main) {
        this.main = main;
    }

    public part getPartner() {
        return partner;
    }

    public part getPartner2() {
        return partner2;
    }

    public void setHasPartner(boolean hasPartner) {
        this.hasPartner = hasPartner;
    }

    public void setHasPartner2(boolean hasPartner2) {
        this.hasPartner2 = hasPartner2;
    }

    public void setGecheckt(boolean gecheckt) {
        this.gecheckt = gecheckt;
    }

    public part getMain() {
        return main;
    }

    public void setSpecial(boolean special) {
        this.special = special;
    }
}
