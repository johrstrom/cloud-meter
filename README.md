# CloudMeter

# Introduction

This is an attempt to port the [Apache Jmeter](http://jmeter.apache.org/) project to a  
[Spring](http://spring.io/projects) web applciation. The design goals behind the project 
are to 1; use a web interface instead of a standalone client and 2; have a more distributed 
layout for users.  

The end goal for this layout would look something like this: Users connect throw a web browser
to a cloud-meter server (either locally or clustered across a network). They store testplans in a
repository (relational-database, etc.,). Given a permission/directory structure other users may then 
interact with other users test plans. Distributed test runs behave much like they do in the Apache project.

# Disclaimer

This project is still in 0.0.1-SNAPSHOT version, meaning if you happen to be reading this you're probably 
about 6 months early. It does not work. It may do very little other than boot and it may not even do that.

I can make no guarantees about the working state of this project or the code.  If it's here, it compiles, 
but that's about it at this time. I intend to be working on it a lot in the future and this README will change as 
the maturity of this project increases.

	
