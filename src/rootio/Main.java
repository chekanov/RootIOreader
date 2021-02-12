package rootio;


import hep.io.root.RootClassNotFound;
import hep.io.root.RootFileReader;
import hep.io.root.daemon.RootAuthenticator;
import hep.io.root.daemon.RootURLStreamFactory;
import hep.io.root.interfaces.TH1;
import hep.io.root.interfaces.TKey;
import jas.hist.DataSource;
import jas.hist.JASHist;
import java.io.*;


/**
 * Read ROOt files 
 */
public class Main
{
  
	
   public static void main(String[] args) throws IOException 
   {

        System.setProperty("useNIO","true");
        System.setProperty("debugRoot","true"); 
        RootFileReader reader = new RootFileReader("Example.root"); 
  }

}
  
