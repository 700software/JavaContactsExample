JavaContactSample
=================

A simple webapp I created for a tech test.

Warning
-------

I am not happy with the architecture/design of this application,
and probably would find something quite different for an actual production deployment.

The framework I previously used is proprietary, so I just found something online to start from.

When I have access to your applications I'll be able to reuse an architecture your team is familiar with. 

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

Then visit http://localhost:8080/JavaContactsExample/
