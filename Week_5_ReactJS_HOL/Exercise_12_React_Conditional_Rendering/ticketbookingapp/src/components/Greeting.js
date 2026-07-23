import React from "react";

import LoginButton from "./LoginButton";
import LogoutButton from "./LogoutButton";
import GuestPage from "./GuestPage";
import UserPage from "./UserPage";

function Greeting(props) {

  const isLoggedIn = props.isLoggedIn;

  if (isLoggedIn) {

    return (

      <div>

        <UserPage />

        <br />

        <LogoutButton
          onClick={props.onLogout}
        />

      </div>

    );

  }

  return (

    <div>

      <GuestPage />

      <br />

      <LoginButton
        onClick={props.onLogin}
      />

    </div>

  );

}

export default Greeting;