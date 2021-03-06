# RootIOreader

This program shows how to read ROOT files (https://root.cern/) using Java.
It illustrates problems with the compatibility of JDK versions. 
This example shows that compiling this code using JDK 1.5 creates a functional package that can read the file "Example.root". The JDK 1.5 compiled package can be executed on new versions of JDK 1.8 - JDK 15.
However, the package compiled using JDK 1.6 (and above) creates a jar file that cannot be used for reading such files. 

This compatibility issue affects several projects: http://java.freehep.org/freehep-rootio/  (original library),
Jas3 http://jas.freehep.org/jas3/, Root4j https://github.com/diana-hep/root4j, Jas4pp https://atlaswww.hep.anl.gov/asc/jas4pp/, 
DataMelt https://datamelt.org etc.  The problem  is likely related to the Apache-BCEL library and may affect other projects that 
rely on dynamic creation of Java classes.

The issue is visible on bugs.java.com under JDK-8261887 ticket number.


# How to recreate this problem

```
git clone git@github.com:chekanov/RootIOreader.git
cd RootIOreader
```
This assumes Linux and installed  JDK 1.8 that supports the JDK target/source version 1.5.
Compile the package using JDK target=1.5:

```
ant
```

(the ant build tool should be installed). This creates the file "rootio.jar". 
Then run this package:

```
ant run
```

It will read objects from the file "Example.root".

Now change the target JDK version to 1.8. To do this, modify the line:

```
 <property name="jdkversion" value="1.5" />
```

to

```
<property name="jdkversion" value="1.8" />
```

in the file "build.xml" (it can be also 1.6, 1.7). Then compile the package again and run it:

```
ant clean; ant; ant run
```

It will return the error:


```
Object hep.io.root.proxy.TString has length=1025
     [java] Exception in thread "main" java.lang.ClassFormatError: Invalid code attribute name index 29 in class file hep/io/root/proxy/TString
at java.base/java.lang.ClassLoader.defineClass1(Native Method)
     [java] 	at java.base/java.lang.ClassLoader.defineClass(ClassLoader.java:1016)
     [java] 	at java.base/java.lang.ClassLoader.defineClass(ClassLoader.java:877)
     [java] 	at hep.io.root.core.RootClassLoader.findClass(RootClassLoader.java:97)
     [java] 	at java.base/java.lang.ClassLoader.loadClass(ClassLoader.java:588)
     [java] 	at java.base/java.lang.ClassLoader.loadClass(ClassLoader.java:521)
     [java] 	at hep.io.root.core.GenericRootClass.getClass(GenericRootClass.java:143)
     [java] 	at hep.io.root.core.GenericRootClass.getProxyClass(GenericRootClass.java:162)
     [java] 	at hep.io.root.core.GenericRootClass.newInstance(GenericRootClass.java:97)
     [java] 	at hep.io.root.core.RootInputStream.readObject(RootInputStream.java:354)
     [java] 	at hep.io.root.core.FastInputStream.readObject(FastInputStream.java:269)
     [java] 	at hep.io.root.RootFileReader.init(RootFileReader.java:226)
     [java] 	at hep.io.root.RootFileReader.init(RootFileReader.java:157)
     [java] 	at hep.io.root.RootFileReader.<init>(RootFileReader.java:137)
     [java] 	at rootio.FileRoot.<init>(FileRoot.java:61)
     [java] 	at rootio.Main.main(Main.java:27)

```

Note the object length 1025 is different from 1003 when using JDK 1.5 compiled version.

If you use JDK13 - JDK15 versions for the above tests, 
the error message when compiling and running the code is different:

```
Object hep.io.root.proxy.TString has length=1025
     [java] Exception in thread "main" java.lang.ClassFormatError: LineNumberTable attribute has wrong length in class file hep/io/root/proxy/TString
     [java] 	at java.base/java.lang.ClassLoader.defineClass1(Native Method)
...
```


Conclusion: Only JDK 1.5 can create a functional program that can read the file Example.root.
Since JDK 1.8 (that supports the JDK 1.5 target) will be discontinued, this package cannot be used for future Java versions.


