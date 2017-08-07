[![Build Status](https://travis-ci.org/johrstrom/cloud-meter.svg?branch=master)](https://travis-ci.org/johrstrom/cloud-meter)
# CloudMeter 

# Introduction

This is an attempt to port the [Apache Jmeter](http://jmeter.apache.org/) project to a [Spring](http://spring.io/projects) web application. 

The reasons and design goals for this endeavor are:
* Distributed Architecture
	* JMeter already runs distributed tests, but in a large organization it's hard to share testplans or compute 
resources to run them. 
	* CloudMeter is entirely distributed so everyone can access testplans (given access roles), schedule tests to be 
run on available resources, store and share results easily.


The end goal for this layout would look something like this: Users connect throw a web browser
to a cloud-meter server (either locally or clustered across a network). They store testplans in a
repository (relational-database, etc.,). Given a permission/directory structure other users may then 
interact with other users test plans. Distributed test runs behave much like they do in the Apache project.

# Disclaimer

This project is still in the very beginning stage of development, meaning if you happen to be reading this you're probably 
about 4 years early. It does not work. It may do very little other than boot and it may not even do that.

I can make no guarantees about the working state of this project or the code.  If it's here, it compiles, 
but that's about it at this time. I intend to be working on it a lot in the future and this README will change as 
the maturity of this project increases.

# Current Status

Right now I'm working a lot on the UI in js/Angular and the testplan/testelement apis that backups up retrieving and saving test plans.

Specifically the tree on the left hand side of the UI that actually manipulates the overall test plan.  

At this moment I'm mostly working on the static html pages (in cloud-meter-server/src/main/resources) so I can modify the frontend
js and simply refresh my browser without having to recompile the jar.
