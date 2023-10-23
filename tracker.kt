import kotlin.math.*

data class Location(val latitude: Double, val longitude: Double)

fun calculateDistance(location1: Location, location2: Location): Double {
    val lat1 = Math.toRadians(location1.latitude)
    val lon1 = Math.toRadians(location1.longitude)
    val lat2 = Math.toRadians(location2.latitude)
    val lon2 = Math.toRadians(location2.longitude)

    val dlon = lon2 - lon1
    val dlat = lat2 - lat1

    val a = sin(dlat / 2).pow(2) + cos(lat1) * cos(lat2) * sin(dlon / 2).pow(2)
    val c = 2 * atan2(sqrt(a), sqrt(1 - a))

    val earthRadius = 6371 // in kilometers

    return earthRadius * c
}

fun main() {
    val location1 = Location(52.520008, 13.404954) // Berlin, Germany
    
    // Get user permission for live tracking
    println("Do you give permission for live tracking? (yes/no)")
    val permission = readLine()
    
    if (permission?.equals("yes", ignoreCase = true) == true) {
        while (true) {
            // Get updated location
            val location2 = getLocationFromGPS() // Implement this function to get the current location from GPS
            
            val distance = calculateDistance(location1, location2)
            println("Distance between Berlin and your location: $distance km")
            
            // Delay for a certain interval before getting the next location
            Thread.sleep(5000) // Delay for 5 seconds (adjust as needed)
        }
    } else {
        println("Live tracking permission denied.")
    }
}

fun getLocationFromGPS(): Location {
    // Implement this function to get the current location from GPS
    // Return the current location as a Location object
    // You can use external libraries or APIs to interact with GPS hardware or services
    // Example implementation: Prompt the user to enter latitude and longitude manually
    println("Enter your current latitude:")
    val latitude = readLine()?.toDoubleOrNull() ?: 0.0
    
    println("Enter your current longitude:")
    val longitude = readLine()?.toDoubleOrNull() ?: 0.0
    
    return Location(latitude, longitude)
}
