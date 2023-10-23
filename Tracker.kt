import kotlin.math.*

// Made By Taylor Christian Newsome

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
    val location2 = Location(48.8566, 2.3522) // Paris, France

    val distance = calculateDistance(location1, location2)
    println("Distance between Berlin and Paris: $distance km")
}
