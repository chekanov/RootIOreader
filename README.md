# RootIOreader

An example of the RootIO package http://java.freehep.org/freehep-rootio/ that shows a problem with JDK versions. 
This example shows that compiling the code using JDK 1.5 creates a functional package that reads Example.root. The JDK 1.5 compiled package can be executed on new versions of JDK 1.8 - JDK 15.
However, the package compiled using JDK 1.6 (and above) creates a jar file that cannot be used for reading ROOT files.

