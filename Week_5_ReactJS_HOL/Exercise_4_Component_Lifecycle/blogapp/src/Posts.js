import React from 'react';
import Post from './Post';

class Posts extends React.Component {

    constructor(props) {

        super(props);

        this.state = {
            posts: []
        };

    }

    loadPosts() {

        fetch("https://jsonplaceholder.typicode.com/posts")
            .then(response => response.json())
            .then(data => {

                const posts = data.map(post =>
                    new Post(post.id, post.title, post.body)
                );

                this.setState({
                    posts: posts
                });

            })
            .catch(error => {
                throw error;
            });

    }

    componentDidMount() {

        this.loadPosts();

    }

    componentDidCatch(error, info) {

        alert("Error: " + error);

        console.error(info);

    }

    render() {

        return (

            <div style={{ margin: "20px" }}>

                <h1>Blog Posts</h1>

                {

                    this.state.posts.map(post => (

                        <div
                            key={post.id}
                            style={{
                                border: "1px solid gray",
                                marginBottom: "20px",
                                padding: "15px",
                                borderRadius: "8px"
                            }}
                        >

                            <h2>{post.title}</h2>

                            <p>{post.body}</p>

                        </div>

                    ))

                }

            </div>

        );

    }

}

export default Posts;