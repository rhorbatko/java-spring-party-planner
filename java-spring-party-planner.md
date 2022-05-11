Time to build out a party planner app, so we can keep track of which
locations are hosting which parties. The React frontend has been provided, but we will need to build out the backend to work with it!

## Getting Started

```no-highlight
createdb party_planner_development
et get java-spring-party-planner
cd java-spring-party-planner
idea .
./mvnw spring-boot:run
```

In a second terminal start up the webpack server

```no-highlight
cd src/main/frontend
yarn run dev:client
```

- There is a `V1__empty_migration.sql` included, so that Spring
  Boot can run initially without erroring out due to an empty migration folder.

- There is also an empty `MainSeeder` which you can add to as you go.

## Core Requirements

---

### Day 1

#### Locations Index Page

```no-highlight
As a party seeker
I want to see a list of all available Locations
So that I can decide on the which locations I want to party at.
```

- If we navigate to <http://localhost:8080/locations>, we will see an empty page, but we want to see a list of locations!

- First add a new migration to create a `locations` table.

  - Each `Location` must have a `name`.

- Create the corresponding `Location` `@Entity` and then the necessary `LocationService`, and `LocationsRepository` to interact with the database.

- Create a `LocationSeeder` and add a `seed()` method which will add a few records to the database.

  - Call on this `seed()` method in `MainSeeder`. You can restart your server to test that it ran successfully.

- The `LocationsIndex` component is making a fetch request to `api/v1/locations`. This fetch is expecting a response with a top level key of `locations` that contains a list of all the locations stored in the database so far.

- Create a `LocationsApiV1Controller`, that will contain the endpoint for this fetch request.
  - You will also need to create a `findAll()` method in the service that makes use of the `LocationsRepository`.

#### Location Show Page

```no-highlight
As a party seeker
I want to see the details of a particular location
So that I can decide if I want to go to a location or not.
```

- Next let's build out the backend for the `LocationShow` component. It is making a fetch request to `/api/v1/locations/:id`. It is expecting a response with a top level key of `location`.

- Create an endpoint to handle this GET request in the `LocationsApiV1Controller`.

- Make sure that navigating to <http://localhost:8080/locations/1> (or any valid `id`) works as long as you have a location with that `id` in stored in your database.
  - If there is no `Location` with that `id`, send a `404` error back instead.

#### Party Time 🎉

```no-highlight
As a party seeker
I want to see the the parties hosted at a location
So that I can determine if there are any parties I would like to go to.
```

- Time to host some parties at these locations!

- A `Location` can host many parties, while a party can only be hosted at one location.

- Make another migration to create a `parties` table.

  - A `Party` must have a `name` and a `description`.

- Create the necessary class to interact with the database.
- Update your classes to account for the association between these entities

- Create a `PartySeeder` to add some records. Be sure to add a couple to the same `location` to test out the show page.

- Make sure that navigating to `/locations/:id` is properly displaying any associated parties via the provided React frontend.

---

### Day 2

#### Adding New Locations

```no-highlight
As a party host
I want the ability to add a new location
So that I can host parties at more places.
```

- While using the seeder was great to get started, let's start handling the form that exists at `/locations/new`.

- When the form is submitted, it will send a POST request to `/api/v1/locations`.

- When submitted this should persist a new `Location`.

- After a successful submission the user will be redirected to `/locations` where they should see the new location displayed.

#### Host a Party

```no-highlight
As a party host
I want the ability to create a new party
So that I can host parties at existing locations.
```

- At `/locations/:id`, there is a form to add a new `Party`.

- When the form is submitted, it will send a POST request to `/api/v1/parties`. It is expecting a response with a top level key of `party` and a value of the new `Party` instance.

- Create an endpoint for this request that will persist the party to the database

  - Use a `PartyForm` model to bind the data coming in.

- After a successful submission, the new `Party` should be added to the list of parties on the locations show page.
  - Otherwise a generic `422` error should be sent back.

---

### Day 3

#### Validations

```no-highlight
As a party host
I want to get descriptive errors back when something goes wrong
So that I can correct the issue if possible.
```

- Go back and refactor any endpoints to properly return field-specific errors if a resource can't be found or created.

- Use the provided `ExceptionHandler` to build upon and add your own custom handlers for errors like `LocationNotFoundEException`, `LocationNotCreated` etc.

- Test these out by opening your dev tools in your browser and navigate to a locations show page that includes an id which is not valid. For example `/locations/2020`. That error should be logged to the console.

## Non-Core

---

### Users and Guest Lists

```no-highlight
As a party host
I want the ability to create a guest list
So that I can keep track of which guests are allowed to which event.
```

- Create two new resources, `users` and `guest_lists`. A `User` can be on many `GuestList`'s and a `GuestList` can contain many `User`'s.

- A `User` has:

  - A required `first_name`
  - A required `last_name`
  - A required `phone_number`. This can be a string.
  - An optional `age`

- A `GuestList` just needs its primary key.

- Create a `UserSeeder` and add 3-5 users.
- Next build out a `NewGuestListForm` component that will be loaded at `/guest-lists/new`

  - On this form a user should be able to add existing users to this `GuestList`.
  - All the users selected should now be associated with the new `GuestList`.
  - After the form has submitted successfully, the user should be redirected to `/guest-lists/:id`, where the new `GuestList` and all it's users will be displayed.

- You will also need to update the React code to create a `GuestListShow` component

### Frontend Validation

```no-highlight
As a party host
I want to get descriptive errors back when submitting an incorrect form
So that I can correct the issue if possible.
```

- If I navigate to `/locations/new` and submit a blank form, I should see errors displayed on the page.
  - You only need to validate the presence of required fields.
  - If any required fields are missing, the form should not submit and no
    request to the backend should be sent.
  - Errors describing which field are incomplete should be displayed back to the
    user.
- If all required fields have been filled out successfully, the form should send
  a POST request to the backend.
