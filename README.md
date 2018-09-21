# Teaching-HEIGVD-AMT-Discovery

## Introduction

This repo contains artifacts to illustrate the high-level Java EE development cycle:

* **developers** use an IDE (such as Netbeans) to write code and produce an application package (a .war file)
* they have access to the Java EE APIs (servlets, JSPs, etc.)
* **IT ops engineers** deploy the .war files in one of the available Java EE compliant application servers (Payara, Wildfly, TomcatEE)

## Quick start

Assuming that you have installed **docker** and **docker-compose** on your machine, move to the `topology-amt` directory and fire up docker-compose to start the 3 app servers:

```
cd topology-amt
docker-compose up --build
```

The first time you do that, it will take a while since docker will fetch the source images from Docker Hub.

When the process is done, you should be able to access the app servers at the following URLs:

```
Payara -> http://192.168.99.100:8080 (apps) and https://192.168.99.100:4848 (console -> admin/admin)
JBoss Wildfly -> http://192.168.99.100:9090 (apps) and http://192.168.99.100:9990 (console -> admin/admin)
Apache Tomcat -> http://192.168.99.100:7070 (apps) and http://192.168.99.100:7070/manager (console -> admin/admin)
```
You will find 2 apps (.war files) in the `apps-dist` folder. You can deploy them in the 3 app servers via their console. You can then access the web apps, by using the proper root context as a URL prefix.

## Detailed information

Have a look at his [Youtube playlist](https://www.youtube.com/playlist?list=PLfKkysTy70QaWqP7sD6xiqFvLZemVLQw_&disable_polymer=true) for a detailed description of the setup (there are 4 webcasts: Bootcamp 1.1, 1.2, 1.3 and 1.4).

## Modifying the code

If you want to look at the code of the apps and change it, the easiest is to use Intellij (make sure that you install the ultimate edition, which comes with Java EE support). If you do a `clean and build` on the project, you will generate a new .war file (in the `target` directory) and be able to upload it via the console.

## Deploying the apps automatically

There are different ways to deploy .war files. The details are specific to every app server, but in general, there are 3 ways:

* use the web console: good for this demo but not used in practice
* use of a Command Line Interface tool (e.g. `asadmin` for Glassfish): used a lot in "traditional" production environments
* copy of the .war file in a special directory monitored by the server (autodeploy): very interesting when combined with Docker

Since you goal is to make it possible to start your entire project with a single command (`docker-compose up`), you will probably want to use the last one. The strategy will be to create a special image and to add a `ADD` or `COPY` instruction in the `Dockerfile`, so that your .war file is copied to the special autodeploy directory when the image is build. It is easy to do, but you will have to search in the app server documentation to see where this "magic" directory is located.
