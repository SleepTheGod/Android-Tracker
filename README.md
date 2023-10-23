# Android-Tracker
This Kotlin code calculates the distance between two locations on Earth using the Haversine formula. 

The Location class represents a location with latitude and longitude coordinates.
The calculateDistance function takes two Location objects as parameters and calculates the distance between them.
Inside the function, the latitude and longitude values are converted to radians using the Math.toRadians function.
The difference in longitude and latitude is calculated.
The Haversine formula is applied to calculate the distance between the two locations.
The result is multiplied by the Earth's radius to obtain the distance in kilometers.
In the main function, two Location objects are created for Berlin and Paris.
The calculateDistance function is called with these locations as arguments, and the result is stored in the distance variable.
Finally, the distance is printed to the console using string interpolation.

In this example, it calculates the distance between Berlin and Paris and displays the result.
