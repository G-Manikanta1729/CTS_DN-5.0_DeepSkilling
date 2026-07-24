import React, { Component } from "react";

class Getuser extends Component {

    constructor(props) {
        super(props);

        this.state = {
            person: null,
            loading: true
        };
    }

    componentDidMount() {

        fetch("https://api.randomuser.me/")
            .then(response => response.json())
            .then(data => {

                this.setState({

                    person: data.results[0],
                    loading: false

                });

            })
            .catch(error => {

                console.log(error);

            });

    }

    render() {

        if (this.state.loading) {

            return <h2>Loading...</h2>;

        }

        const person = this.state.person;

        return (

            <div className="container">

                <h1>Random User Details</h1>

                <img
                    src={person.picture.large}
                    alt="User"
                />

                <h2>
                    {person.name.title} {person.name.first}
                </h2>

            </div>

        );

    }

}

export default Getuser;