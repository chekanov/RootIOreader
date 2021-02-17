package rootio;


import hep.io.root.RootClassNotFound;
import hep.io.root.RootFileReader;
import hep.io.root.daemon.RootAuthenticator;
import hep.io.root.daemon.RootURLStreamFactory;
import hep.io.root.interfaces.*;
import jas.hist.DataSource;
import java.util.List;
import java.util.ArrayList;
import hep.io.root.reps.*;
import hep.io.root.core.RootInput;



/**
 * Read ROOt files 
 */
public class Main
{
  
 public static void main(String[] args)   throws java.io.IOException, RootClassNotFound
   {


        System.setProperty("debugRoot", "true");
        //System.setProperty("jasminPath", "jasmin");
        RootFileReader reader = new RootFileReader("Example.root");

  }

}
  
