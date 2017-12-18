import edu.duke.*;
import org.apache.commons.csv.*;
public class Part4 {
       public static void main(String[] args) {
		Part4 obj = new Part4();
		obj.readFromURL();
	}
	public void readFromURL()
	{
		int startindx,stopindx;
		URLResource url = new URLResource("http://www.dukelearntoprogram.com/course2/data/manylinks.html");
		for(String line : url.lines())
		{
			String string = line.toLowerCase();
			int indx = string.indexOf("youtube.com") ;
			if(indx!=-1)
			{
				startindx = string.lastIndexOf("\"",indx);
				stopindx = string.indexOf("\"",indx);
				System.out.println(line.substring(startindx+1,stopindx));
			}
			
		}
	}
}


