import React from "react";

import FlightDetails from "./FlightDetails";

function UserPage() {

  function bookTicket() {

    alert("Your flight ticket has been booked successfully.");

  }

  return (

    <div>

      <h1>Welcome Back</h1>

      <h2>Book Your Ticket</h2>

      <FlightDetails />

      <br /><br />

      <button onClick={bookTicket}>

        Book Ticket

      </button>

    </div>

  );

}

export default UserPage;