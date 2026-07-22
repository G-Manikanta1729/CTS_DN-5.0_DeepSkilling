import React from "react";
import "./App.css";
import office from "./office.jpg";

function App() {

  // Heading
  const heading = "Office Space";

  // Single Office Object
  const officeDetails = {
    Name: "DBS",
    Rent: 50000,
    Address: "Chennai"
  };

  // List of Office Objects
  const officeList = [
    {
      Name: "DBS",
      Rent: 50000,
      Address: "Chennai"
    },
    {
      Name: "Regus",
      Rent: 75000,
      Address: "Hyderabad"
    },
    {
      Name: "WeWork",
      Rent: 65000,
      Address: "Bangalore"
    },
    {
      Name: "SmartWorks",
      Rent: 45000,
      Address: "Pune"
    }
  ];

  return (
    <div className="App">

      {/* Heading */}

      <h1>
        {heading}, at Affordable Range
      </h1>

      {/* Office Image */}

      <img
        src={office}
        alt="Office Space"
        width="300"
        height="220"
      />

      <br />
      <br />

      {/* Single Office Object */}

      <h2>Name: {officeDetails.Name}</h2>

      <h3
        style={{
          color:
            officeDetails.Rent <= 60000
              ? "red"
              : "green"
        }}
      >
        Rent: Rs. {officeDetails.Rent}
      </h3>

      <h3>
        Address: {officeDetails.Address}
      </h3>

      <hr />

      <h2>Available Office Spaces</h2>

      {/* Office List */}

      {
        officeList.map((officeItem, index) => (

          <div
            className="office-card"
            key={index}
          >

            <img
              src={office}
              alt="Office"
              width="250"
              height="180"
            />

            <h2>
              Name: {officeItem.Name}
            </h2>

            <h3
              style={{
                color:
                  officeItem.Rent <= 60000
                    ? "red"
                    : "green"
              }}
            >
              Rent: Rs. {officeItem.Rent}
            </h3>

            <h3>
              Address: {officeItem.Address}
            </h3>

            <hr />

          </div>

        ))
      }

    </div>
  );
}

export default App;