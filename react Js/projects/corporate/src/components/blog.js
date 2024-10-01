import Container from "react-bootstrap/Container";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import Card from "react-bootstrap/Card";
export default function AppBlog() {
  const blogData = [
    {
      id: 1,
      image: require("../assets/images/blog1.jpg"),
      time: "13 Nov 2018",
      title: "Tea Lovers",
      description:
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam",
      link: "https://www.google.com",
    },
    {
      id: 2,
      image: require("../assets/images/blog2.jpg"),
      time: "10 Jun 2014",
      title: "Coffee Lovers",
      description:
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam",
      link: "https://www.twitter.com",
    },
    {
      id: 3,
      image: require("../assets/images/blog3.jpg"),
      time: "13 Nov 2013",
      title: "Tips for UI Design",
      description:
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam",
      link: "https://www.facebook.com",
    },
  ];
  return (
    <section id="blog" className="block blog-block">
      <div className="title-holder">
        <h2>Latest From Blog</h2>
        <div className="subtitle">get our latest news from our blog</div>
      </div>

      <Container fluid>
        <Row>
          {blogData.map((blog) => {
            return (
              <Col key={blog.id} sm={4}>
                <div className="holder">
                  <Card>
                    <Card.Img variant="top" src={blog.image} />
                    <Card.Body>
                      <time>{blog.time}</time>
                      <Card.Title>{blog.title}</Card.Title>
                      <Card.Text>{blog.description}</Card.Text>
                      <a href={blog.link} className="btn btn-primary">
                        Read more<i className="fas fa-chevron-right"></i>
                      </a>
                    </Card.Body>
                  </Card>
                </div>
              </Col>
            );
          })}
        </Row>
      </Container>
    </section>
  );
}
