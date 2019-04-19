
package TreeExampleOnline;


public class Item
{
	// Declaring the attributes page 424
	private String Name;
	private String Color;
        private String state;
        private String brightness;
        private String uid;
       
 

	public Item(String Name, String Color, String state, String brightness)
	{
            this.Name = Name;
            this.Color = Color;
            this.state = state;
            this.brightness = brightness;
             
	}

        // QUERRIES
        
	@Override
	public String toString() {
            return Name + ": (" + uid + ") " + state + ", " + Color + ", " 
                + brightness;
	}
        
	public String getName()
	{
		return Name;
	}


	public String getColor()
	{
		return Color;
	}

        
        public String getState() {
            return state;
        }
        
        
        public String getBrightness() {
            return brightness;
        }
        
        
        public String getUID() {
            return uid;
        }
        
        // COMMANDS
        
	public void setName(String Name)
	{
            this.Name = Name;
	}
        
	public void setColor(String Color)
	{
            this.Color = Color;
	}
        
        public void setState(String state) {
            this.state = state;
        }
        
        public void setBrightness(String brightness) {
            this.brightness = brightness;
        }
        
        public void setUID(String uid) {
            this.uid = uid;
        }
        

}