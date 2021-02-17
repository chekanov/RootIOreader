package rootio;


import hep.io.root.RootClassNotFound;
import hep.io.root.RootFileReader;
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
 * ROOT Histogram browser. 
 */
public class HBrowser
{

     private JFrame frame;

     public  HBrowser(String path)  throws java.io.IOException  {
 
     URL.setURLStreamHandlerFactory(new RootURLStreamFactory());

      frame = new JFrame("Root Histogram Browser");
      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      RootHistogramBrowser browser = new RootHistogramBrowser();

      Authenticator.setDefault(new RootAuthenticator(browser));
      URLConnection.setDefaultAllowUserInteraction(true);

      if (path.startsWith("root:")) browser.setRootFile(new URL(path));
      else browser.setRootFile(new File(path));
      frame.setContentPane(browser);
      // Make this exit when the close button is clicked.
      frame.addWindowListener(new WindowAdapter()
      {
         public void windowClosing(WindowEvent e)
         {
            //System.exit(0);
             frame.dispose();
         }
      });
      frame.pack();
      frame.setVisible(true);

      }

}


  
