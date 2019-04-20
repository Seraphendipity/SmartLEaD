package TreeExampleOnline;

public class Item {
    protected int uid;
    protected String name;
    protected Boolean bOn = false;
    protected int brightness = 70;
    protected String color = "White";
    protected static int serialCounter = 0;

    public Item() {
        this.uid = serialCounter++;
        this.name = "Item_" + this.uid;
    }

    public Item(String newName) {
        new Item();
        this.name = newName;
    }

    public String toString() {
        return "Bulb{uid=" + this.uid + ", name=" + this.name + ", bOn=" + this.bOn + ", brightness=" + this.brightness + ", color=" + this.color + "}";
    }
    
    public String toCsv(String parent) {
        char c = ','; //delimiter
        return (this.name + c + this.uid + c + this.bOn + c + this.brightness + c + this.color + c + parent);
    }

    public int getUid() {
        return this.uid;
    }

    public String getName() {
        return this.name;
    }

    public Boolean getStatus() {
        return this.bOn;
    }

    public int getBrightness() {
        return this.brightness;
    }

    public String getColor() {
        return this.color;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void turnOn() {
        this.bOn = true;
    }

    public void turnOff() {
        this.bOn = false;
    }

    public void setBrightness(int brightness) {
        this.brightness = brightness = brightness > 100 ? 100 : (brightness < 0 ? 0 : brightness);
    }

    public void setColor(String color) {
        this.color = color;
    }
}