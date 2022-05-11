import React from "react"
import { Link } from "react-router-dom"

const LocationTile = ({ location: { id, name } }) => {
  return (
    <div>
      <Link to={`/locations/${id}`}>
        <h1>{name}</h1>
      </Link>
    </div>
  )
}

export default LocationTile
