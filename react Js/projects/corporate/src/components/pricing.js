import Container from "react-bootstrap/Container";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import ListGroup from "react-bootstrap/ListGroup";
export default function AppPricing() {
  const pricingData = [
    {
      id: 1,
      plan: "Basic",
      price: "$99",
      features: [
        "Wireframing",
        "Visual Studio",
        "5 pages",
        "Free Hosting",
        "Support & Assistance",
      ],
      link: "https://www.google.com",
    },
    {
      id: 2,
      plan: "Premium",
      price: "$199",
      features: [
        "Wireframing",
        "Visual Studio",
        "5 pages",
        "Free Hosting",
        "Support & Assistance",
      ],
      link: "https://www.facebook.com",
    },
    {
      id: 3,
      plan: "Ultimate",
      price: "$349",
      features: [
        "Wireframing",
        "Visual Studio",
        "5 pages",
        "Free Hosting",
        "Support & Assistance",
      ],
      link: "https://www.google.com",
    },
  ];
  return (
    <section id="pricing" className="block pricing-block">
      <Container fluid>
        <div className="title-holder">
          <h2>Pricing &amp; Plans</h2>
          <div className="subtitle">Check our pricing and plans</div>
        </div>
        <Row>
          {pricingData.map((price) => {
            return (
              <Col key={price.id} sm={4}>
                <div className="heading">
                  <h3>{price.plan}</h3>
                  <span className="price">{price.price}</span>
                </div>
                <div className="content">
                  <ListGroup>
                    {price.features.map((features, index) => {
                      return (
                        <ListGroup.Item key={index}>{features}</ListGroup.Item>
                      );
                    })}
                  </ListGroup>
                </div>
                <div className="btn-holder">
                  <a href={price.link} className="btn btn-primary">
                    Order Now
                  </a>
                </div>
              </Col>
            );
          })}
        </Row>
      </Container>
    </section>
  );
}
