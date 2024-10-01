import Container from "react-bootstrap/Container";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import Image from "react-bootstrap/Image";
import img1 from "../assets/images/img1.jpg";
import ProgressBar from "react-bootstrap/ProgressBar";
export default function AppAbout() {
  const html = "90";
  const css = "60";
  const js = "80";
  return (
    <section id="about" className="block about-block">
      <Container fluid>
        <div className="title-holder">
          <h2>About Us</h2>
          <div className="subtitle">Learn more about us</div>
        </div>
        <Row>
          <Col sm={6}>
            <Image src={img1}></Image>
          </Col>
          <Col sm={6}>
            <p>
              Lorem Ipsum is simply dummy text of the printing and typesetting
              industry. Lorem Ipsum has been the industry's standard dummy text
              ever since the 1500s, when an unknown printer took a galley of
              type and scrambled it to make a type specimen book.
            </p>

            <p>
              Lorem Ipsum is simply dummy text of the printing and typesetting
              industry. Lorem Ipsum has been the industry's standard dummy text
              ever since the 1500s, when an unknown printer took a galley of
              type and scrambled it to make a type specimen book.
            </p>

            <div className="progress-block">
              <h4>HTML</h4>
              <ProgressBar now={html} label={`${html}%`} />
            </div>
            <div className="progress-block">
              <h4>CSS</h4>
              <ProgressBar now={css} label={`${css}%`} />
            </div>
            <div className="progress-block">
              <h4>JAVASCRIPT</h4>
              <ProgressBar now={js} label={`${js}%`} />
            </div>
          </Col>
        </Row>
      </Container>
    </section>
  );
}
