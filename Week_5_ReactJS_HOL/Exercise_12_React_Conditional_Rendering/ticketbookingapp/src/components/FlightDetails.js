import React from "react";

function FlightDetails() {

  return (

    <table border="1">

      <thead>

        <tr>

          <th>Flight</th>

          <th>Source</th>

          <th>Destination</th>

          <th>Fare</th>

        </tr>

      </thead>

      <tbody>

        <tr>

          <td>AI202</td>

          <td>Hyderabad</td>

          <td>Delhi</td>

          <td>₹6,500</td>

        </tr>

        <tr>

          <td>6E315</td>

          <td>Chennai</td>

          <td>Mumbai</td>

          <td>₹5,200</td>

        </tr>

        <tr>

          <td>UK808</td>

          <td>Bangalore</td>

          <td>Kolkata</td>

          <td>₹7,100</td>

        </tr>

      </tbody>

    </table>

  );

}

export default FlightDetails;