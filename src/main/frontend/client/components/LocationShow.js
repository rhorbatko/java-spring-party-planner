import React, { useEffect, useState } from "react"
import { useLocation, Link } from "react-router-dom"

import NewPartyForm from "./NewPartyForm"
import PartyTile from "./PartyTile"

const LocationShow = (props) => {
  let currentWebLocation = useLocation()
  const [location, setLocation] = useState({ parties: [] })
  const [errors, setErrors] = useState({})
  const locationId = props.match.params.id

  const fetchLocation = async () => {
    try {
      const response = await fetch(`/api/v1/locations/${locationId}`)
      if (!response.ok) {
        const errorMessage = `${response.status} (${response.statusText})`
        const error = new Error(errorMessage)
        throw error
      }
      const responseBody = await response.json()
      setLocation(responseBody.location)
    } catch (err) {
      console.error(`Error in fetch: ${err.message}`)
    }
  }

  useEffect(() => {
    fetchLocation()
  }, [currentWebLocation.pathname])

  const addParty = async (formPayload) => {
    formPayload.locationId = locationId

    try {
      const response = await fetch(`/api/v1/parties`, {
        method: "POST",
        headers: new Headers({
          "Content-Type": "application/json"
        }),
        body: JSON.stringify(formPayload)
      })
      if (!response.ok) {
        if (response.status === 422) {
          const body = await response.json()
          return setErrors(body.errors)
        } else {
          const errorMessage = `${response.status} (${response.statusText})`
          const error = new Error(errorMessage)
          throw error
        }
      }

      const body = await response.json()
      if (location.parties) {
        setLocation({ ...location, parties: [...location.parties, body.party] })
      } else {
        setLocation({ ...location, parties: [body.party] })
      }
    } catch (err) {
      console.error(`Error in fetch: ${err.message}`)
    }
  }

  const partyTiles = location?.parties?.map((party) => {
    return <PartyTile key={party.id} party={party} />
  })

  return (
    <div>
      <h1>{location.name}</h1>
      <Link to={"/locations"}>Locations List</Link> | <ul>{partyTiles}</ul>
      <NewPartyForm addParty={addParty} errors={errors} />
    </div>
  )
}

export default LocationShow
