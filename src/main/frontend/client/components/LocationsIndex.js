import React, { useEffect, useState } from "react"
import { Link } from "react-router-dom"

import LocationTile from "./LocationTile"

const LocationsIndex = (props) => {
  const [locations, setLocations] = useState([])

  const fetchLocations = async () => {
    try {
      const response = await fetch("/api/v1/locations")
      if (!response.ok) {
        const errorMessage = `${response.status} (${response.statusText})`
        const error = new Error(errorMessage)
        throw error
      }
      const responseBody = await response.json()
      setLocations(responseBody.locations)
    } catch (err) {
      console.error(`Error in fetch: ${err.message}`)
    }
  }

  useEffect(() => {
    fetchLocations()
  }, [])

  const locationTiles = locations.map((location) => {
    return <LocationTile key={location.id} location={location} />
  })

  return (
    <div>
      <Link to={"/locations/new"}>Add a Location</Link>
      {locationTiles}
    </div>
  )
}

export default LocationsIndex
