import Container from "react-bootstrap/Container";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import Form from "react-bootstrap/Form";
import Button from "react-bootstrap/Button";
export default function AppContact() {
  return (
    <section id="contact" className="block contact-block">
      <Container fluid>
        <div className="title-holder">
          <h2>contact us</h2>
          <div className="subtitle">get connected to us</div>
        </div>
        <Form className="contact-form">
          <Row>
            <Col sm={4}>
              <Form.Control
                type="text"
                placeholder="Enter your name"
                required
              />
            </Col>
            <Col sm={4}>
              <Form.Control
                type="email"
                placeholder="Enter your email"
                required
              />
            </Col>
            <Col sm={4}>
              <Form.Control
                type="tel"
                placeholder="Enter your phone number"
                required
              />
            </Col>
          </Row>
          <Row>
            <Col sm={12}>
              <Form.Control
                as="textarea"
                placeholder="Leave a comment here"
                required
              />
            </Col>
          </Row>
          <div className="btn-holder">
            <Button type="submit">Submit</Button>
          </div>
        </Form>
      </Container>

      <div className="google-map">
        <iframe
          title="map"
          src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d28256.73833599882!2d85.25199621081408!3d27.714436575380702!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x39eb1882a40441d5%3A0xb78abafbac008ba5!2sSitapaila%2C%20Nagarjun%2044600!5e0!3m2!1sen!2snp!4v1716285989272!5m2!1sen!2snp"
          allowFullScreen=""
          loading="lazy"
          referrerPolicy="no-referrer-when-downgrade"
        ></iframe>
      </div>

      <Container fluid>
        <div className="contact-info">
          <ul>
            <li>
              <i className="fa-solid fa-envelope"></i>
              krishnashah4214@gmail.com
            </li>
            <li>
              <i className="fa-solid fa-phone"></i>
              0000-0000-0000
            </li>
            <li>
              <i className="fa-sharp fa-solid fa-location-dot"></i>
              Sitapaila, Kathmandu, Nepal
            </li>
          </ul>
        </div>
      </Container>
    </section>
  );
}
