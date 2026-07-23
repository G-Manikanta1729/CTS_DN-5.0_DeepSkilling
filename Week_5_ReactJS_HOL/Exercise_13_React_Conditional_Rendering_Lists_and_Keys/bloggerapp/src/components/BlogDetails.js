import React from "react";

function BlogDetails(props) {

    let content;

    if (props.blogs.length > 0) {

        content = (

            <div>

                {

                    props.blogs.map((blog) => (

                        <div key={blog.id}>

                            <h2>{blog.title}</h2>

                            <h4>{blog.author}</h4>

                            <p>{blog.description}</p>

                            <br />

                        </div>

                    ))

                }

            </div>

        );

    } else {

        content = <h3>No Blogs Available</h3>;

    }

    return (

        <div className="section">

            <h1>Blog Details</h1>

            {content}

        </div>

    );

}

export default BlogDetails;