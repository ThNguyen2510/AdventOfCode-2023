public class seed {

    public long seednum;
    public long soil = -1;
    public long fertilizer = -1;
    public long water = -1;
    public long light = -1;
    public long temperature = -1;
    public long humidity = -1;
    public long location = -1;

    public seed(long seednum)
    {
        this.seednum = seednum;
    }

    public void setSoil(long soil) {
        this.soil = soil;
    }

    public void setFertilizer(long fertilizer) {
        this.fertilizer = fertilizer;
    }

    public void setHumidity(long humidity) {
        this.humidity = humidity;
    }

    public void setLight(long light) {
        this.light = light;
    }

    public void setLocation(long location) {
        this.location = location;
    }

    public void setTemperature(long temperature) {
        this.temperature = temperature;
    }

    public void setWater(long water) {
        this.water = water;
    }
}
