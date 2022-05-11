import React, { useEffect } from "react"
import { hot } from "react-hot-loader/root"
import "foundation-sites"
import $ from "jquery"
import "../assets/scss/main.scss"

import { Route, BrowserRouter, Switch, Redirect } from "react-router-dom"

import LocationsIndex from "./LocationsIndex"
import LocationShow from "./LocationShow"
import NewLocationForm from "./NewLocationForm"

const App = (props) => {
  useEffect(() => {
    $(document).foundation()
  }, [])

  return (
    <BrowserRouter>
      <Switch>
        <Route exact path="/">
          <Redirect to="/locations" />
        </Route>
        <Route exact path="/locations" component={LocationsIndex} />
        <Route exact path="/locations/new" component={NewLocationForm} />
        <Route exact path="/locations/:id" component={LocationShow} />
      </Switch>
    </BrowserRouter>
  )
}

export default hot(App)
