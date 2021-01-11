JavaContactSample
=================

A simple webapp I created for a tech test.

I didn't have a web framework picked out at the time
so I just found something and went with it.  
(My personal webapps are normally in Node. My Java apps are work-related.)

Dependencies
------------

It's set for Java 1.8 or better
but you might be able to run with 1.6 or 1.7

You must have Maven installed and added to path so you can run `mvn`.

Also `JAVA_HOME` environment variable should reference the JDK not the JRE.

To run
------

    git clone https://github.com/700software/JavaContactSample
    cd JavaContactSample
    mvn tomcat7:run
