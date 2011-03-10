
import java.util.*;
import java.io.*;

public class Msa {
	private Vector mali_name;			/**< Name of sequences of the multiple alignment */
	private Vector mali_seq;			/**< Sequences of the multiple alignment */
	
	public Msa(String fname){
		String tmp;
		int nseq = 0;
		File file = new File(fname);
    FileInputStream fis = null;
    BufferedInputStream bis = null;
    DataInputStream dis = null;
		try {
      fis = new FileInputStream(file);
			
      // Here BufferedInputStream is added for fast reading.
      bis = new BufferedInputStream(fis);
      dis = new DataInputStream(bis);
			
      // dis.available() returns 0 if the file does not have more lines.
      while (dis.available() != 0) {
				
				// this statement reads the line from the file and print it to
        // the console.
        tmp = dis.readLine();
				
      }
			
      // dispose all the resources after using them.
      fis.close();
      bis.close();
      dis.close();
			
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
	}
	
}
