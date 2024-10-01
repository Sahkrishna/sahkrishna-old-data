import Container from "react-bootstrap/Container";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import Image from "react-bootstrap/Image";
import Pagination from "react-bootstrap/Pagination";

export default function AppWorks() {
  const worksData = [
    {
      id: 1,
      link: "https://www.google.com",
      image: require("../assets/images/img2.jpg"),
      title: "Lonely path",
      subtitle: "web design",
    },
    {
      id: 2,
      link: "https://www.google.com",
      image: require("../assets/images/img3.jpg"),
      title: "Photographer Girl",
      subtitle: "Branding",
    },
    {
      id: 3,
      link: "https://www.google.com",
      image: require("../assets/images/img4.jpg"),
      title: "The Difference",
      subtitle: "Web Design",
    },
    {
      id: 4,
      link: "https://www.google.com",
      image: require("../assets/images/img5.jpg"),
      title: "Lonely path",
      subtitle: "web design",
    },
    {
      id: 5,
      link: "https://www.google.com",
      image: require("../assets/images/img6.jpg"),
      title: "Lonely path",
      subtitle: "web design",
    },
    {
      id: 6,
      link: "https://www.google.com",
      image: require("../assets/images/img7.jpg"),
      title: "Lonely path",
      subtitle: "web design",
    },
  ];
  let active = 2;
  let items = [];
  for (let number = 1; number <= 5; number++) {
    items.push(
      <Pagination.Item key={number} active={number === active}>
        {number}
      </Pagination.Item>
    );
  }
  return (
    <section id="works" className="block works-block">
      <Container fluid>
        <div className="title-holder">
          <h2>Our Works</h2>
          <div className="subtitle">Our Awesome works</div>
        </div>
        <Row className="portfoliolist">
          {worksData.map((work) => {
            return (
              <Col key={work.id} sm={4}>
                <div className="portfolio-wrapper">
                  <a href={work.link}>
                    <Image src={work.image}></Image>
                    <div className="label text-center">
                      <h3>{work.title}</h3>
                      <p>{work.subtitle}</p>
                    </div>
                  </a>
                </div>
              </Col>
            );
          })}
        </Row>
        <Pagination>{items}</Pagination>
      </Container>
    </section>
  );
}
