scala-phonenumber
=================

This will eventually be a port of Google's libphonenumber to Scala. For now, because I need this functionality quick, it simply wraps libphonenumber. It is NOT complete by any means. I've only added the functionality that I needed. Currently you get a PhoneNumber case class that assumes the country is USA when you don't pass the country in. While you can pass the country in, the only country defined is USA. If you're interested in more from this library, report an issue or send me a pull request. I want to complete it and slowly remove the dependency on Google's libphonenumber