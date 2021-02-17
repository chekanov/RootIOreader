package rootio;


import hep.io.root.RootClassNotFound;
import hep.io.root.RootFileReader;
import hep.io.root.daemon.xrootd.XrootdURLStreamFactory;
import hep.io.root.daemon.RootAuthenticator;
import hep.io.root.daemon.RootURLStreamFactory;
import hep.io.root.interfaces.*;
import jas.hist.DataSource;
import jas.hist.JASHist;
import java.io.*;
import java.util.List;
import hep.io.root.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.net.URL;
import java.net.URLConnection;
import java.net.Authenticator;

/**
 * ROOT object browser. 
 */
public class Browser
{

     private JFrame frame;

     public  Browser(String path)  throws java.io.IOException  {
 


      URL.setURLStreamHandlerFactory(new XrootdURLStreamFactory());

      frame = new JFrame("Root Object Browser");
      RootObjectBrowser browser = new RootObjectBrowser();
      Authenticator.setDefault(new RootAuthenticator(browser));
      URLConnection.setDefaultAllowUserInteraction(true);

      if (path.startsWith("root:")) browser.setRootFile(new URL(path));
      else browser.setRootFile(new File(path));
      frame.setContentPane(browser);
      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      frame.pack();
      frame.setVisible(true);

      }

}


  
