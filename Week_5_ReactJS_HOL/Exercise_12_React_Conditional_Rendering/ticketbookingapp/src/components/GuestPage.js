import React from "react";

import FlightDetails from "./FlightDetails";

function GuestPage() {

  return (

    <div>

      <h1>Please sign up.</h1>

      <h2>Flight Details</h2>

      <FlightDetails />

      <p>

        Guest users can only view flight
        information.

      </p>

    </div>

  );

}

export default GuestPage;