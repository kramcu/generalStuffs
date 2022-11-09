import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Properties;

public class WClipBoard {

	public static void main(String[] args) throws Exception {
		boolean isStop = false;
		HashSet<String> links = new HashSet<String>();
		while(!isStop)
		{
			String cb = null;
			try {
			cb = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
			}
			catch(Exception e)
			{
				continue;
			}
			//System.out.println(cb);
			if(null != cb && cb.contains("instagram"))
			{
			links.add(cb);
			}
			try {
			FileInputStream fis = null;
			Properties prop = null;
			fis = new FileInputStream("D:\\ClipBoardStop.properties");
			prop = new Properties();
			prop.load(fis);
			isStop = ("Y".equalsIgnoreCase(prop.getProperty("stop").toString()))?true:false;
			}
			catch(Exception e)
			{
				continue;
			}
		}

		//PrintWriter pw = new PrintWriter(new FileWriter("D:\\out.txt"));
		Iterator<String> itr =links.iterator();

		/*while(itr.hasNext()) {
			pw.write(itr.next());
		}

		pw.close();*/
		File f=new File("D:\\out.txt");  //Creation of File Descriptor for output file
	      FileWriter fw=new FileWriter(f); //Creation of File Writer object
	      while(itr.hasNext()) {
	    	  fw.write(itr.next()+"\n");
			}
	      fw.flush();
	      fw.close();
	}


}
