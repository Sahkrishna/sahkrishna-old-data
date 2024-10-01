import Container from "react-bootstrap/Container";
import Carousel from "react-bootstrap/Carousel";
export default function AppTestmonials() {
  const testimonialsData = [
    {
      id: 1,
      name: "John Doe",
      designation: "CEO",
      description: "He is the ceo of the company",
    },
    {
      id: 2,
      name: "David Lacey",
      designation: "Data Analyst",
      description: "He is the Data Analyst at this company",
    },
    {
      id: 3,
      name: "John Anderson",
      designation: "Finance Manager",
      description: "He is the Finance Manager at this company",
    },
  ];
  return (
    <section id="testimonials" className="testimonials-block">
      <Container fluid>
        <div className="title-holder">
          <h2>Client Testimonials</h2>
          <div className="subtitle">what client says about us!</div>
        </div>
        <Carousel controls={false}>
          {testimonialsData.map((testimonial) => {
            return (
              <Carousel.Item key={testimonial.id}>
                <blockquote>
                  <p>{testimonial.description}</p>
                  <cite>
                    <span className="name">{testimonial.name}</span>
                    <span className="designation">
                      {testimonial.designation}
                    </span>
                  </cite>
                </blockquote>
              </Carousel.Item>
            );
          })}
        </Carousel>
      </Container>
    </section>
  );
}
