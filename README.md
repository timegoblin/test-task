# Greeting application task
#
Greeting application that has two end points 

Endpoint 1 – GET /greetings will be a public end point running on port 80.
				Returns a json payload with the message “Hello World”.

Endpoint 2 – GET /internal-greetings will be a management end point on port 8080.
				Returns a json payload with the message “Hello Management”.
				
Implementation notes :

Both endpoint ports are configurable in the application.yml file for which ever environment the application is deployed to.  Testing is done against the local profile, which can prove the functionality.

Ideally for endpoint 1, a webserver would be configured to redirect port 80 accesses /greetings to the Tomcat instance running on configured port for /greetings in the application.yml. 
An alternative would be to run the Tomcat container as a root process to allow access to port 80, which is unwise and most organisations will already have a webserver servicing the default port 80.