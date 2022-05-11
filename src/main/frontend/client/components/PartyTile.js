import React from "react"

const PartyTile = ({ party: { name, description } }) => {
  return (
    <li>
      {name}
      <p>{description}</p>
    </li>
  )
}

export default PartyTile
