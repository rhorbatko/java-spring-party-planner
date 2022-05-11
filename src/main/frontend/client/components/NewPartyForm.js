import React, { useState } from "react"
import { Redirect } from "react-router"
import { Link } from "react-router-dom"
import _ from "lodash"

import ErrorList from "./ErrorList"
const defaultFormPayload = {
  name: "",
  description: ""
}

const NewPartyForm = ({ addParty, errors }) => {
  const [formPayload, setFormPayload] = useState(defaultFormPayload)

  const handleSubmit = (event) => {
    event.preventDefault()
    addParty(formPayload)
    setFormPayload(defaultFormPayload)
  }

  const handleInputChange = (event) => {
    setFormPayload({
      ...formPayload,
      [event.currentTarget.name]: event.currentTarget.value
    })
  }

  return (
    <div>
      <h1>Host a new party at this location!</h1>
      <Link to={"/locations"}>Back to locations</Link>
      <form className="callout" onSubmit={handleSubmit}>
        <ErrorList errors={errors} />
        <div>
          <label htmlFor="name">Name: </label>
          <input
            name="name"
            id="name"
            type="text"
            value={formPayload.name}
            onChange={handleInputChange}
          />
        </div>

        <div>
          <label htmlFor="description">Description: </label>
          <input
            name="description"
            id="description"
            type="text"
            value={formPayload.description}
            onChange={handleInputChange}
          />
        </div>

        <input className="button" type="submit" value="Submit" />
      </form>
    </div>
  )
}

export default NewPartyForm
