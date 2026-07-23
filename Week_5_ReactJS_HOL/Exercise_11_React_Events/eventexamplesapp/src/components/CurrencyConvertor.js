import React, { useState } from "react";

function CurrencyConvertor() {

  const [amount, setAmount] = useState("");

  const [currency, setCurrency] = useState("");

  function handleSubmit(event) {

    event.preventDefault();

    const rupees = parseFloat(amount);

    if (isNaN(rupees)) {

      alert("Please enter a valid amount.");

      return;

    }

    // Conversion Rate
    const euro = (rupees / 90).toFixed(2);

    alert(
      `Converting to Euro Amount is €${euro}`
    );

  }

  return (

    <div className="currency-container">

      <h1>Currency Convertor!!!</h1>

      <form onSubmit={handleSubmit}>

        <div>

          <label>Amount:</label>

          <input
            type="number"
            value={amount}
            onChange={(e) =>
              setAmount(e.target.value)
            }
          />

        </div>

        <br />

        <div>

          <label>Currency:</label>

          <input
            type="text"
            placeholder="Euro"
            value={currency}
            onChange={(e) =>
              setCurrency(e.target.value)
            }
          />

        </div>

        <br />

        <button type="submit">

          Submit

        </button>

      </form>

    </div>

  );

}

export default CurrencyConvertor;