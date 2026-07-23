import React, { useState } from "react";

function Counter() {

  const [count, setCount] = useState(0);

  function incrementValue() {

    setCount(count + 1);

  }

  function decrementValue() {

    setCount(count - 1);

  }

  function sayHello() {

    alert("Hello! Member1");

  }

  function increaseAndGreet() {

    incrementValue();

    sayHello();

  }

  function sayWelcome(message) {

    alert(message);

  }

  function handleSyntheticEvent(event) {

    alert("I was clicked");

  }

  return (

    <div>

      <h2>{count}</h2>

      <button onClick={increaseAndGreet}>

        Increment

      </button>

      <br /><br />

      <button onClick={decrementValue}>

        Decrement

      </button>

      <br /><br />

      <button
        onClick={() => sayWelcome("Welcome")}
      >

        Say Welcome

      </button>

      <br /><br />

      <button
        onClick={handleSyntheticEvent}
      >

        Click on me

      </button>

    </div>

  );

}

export default Counter;