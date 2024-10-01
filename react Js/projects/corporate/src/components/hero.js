import Carousel from "react-bootstrap/Carousel";
export default function AppHero() {
  const heroData = [
    {
      id: 1,
      image: require("../assets/images/img-hero1.jpg"),
      title: "The perfect design for your website",
      description:
        "Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old.",
      link: "https://www.google.com",
    },
    {
      id: 2,
      image: require("../assets/images/img-hero2.jpg"),
      title: "start your future Financial plan",
      description:
        "Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old.",
      link: "https://www.facebook.com",
    },
    {
      id: 3,
      image: require("../assets/images/img-hero3.jpg"),
      title: "Enjoy the difference",
      description:
        "Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old.",
      link: "https://www.twitter.com",
    },
  ];

  return (
    <section id="home" className="hero-block">
      <Carousel>
        {heroData.map((hero) => {
          return (
            <Carousel.Item key={hero.id}>
              <img
                className="d-block w-100"
                src={hero.image}
                alt={"slide " + hero.id}
              />
              <Carousel.Caption>
                <h5>{hero.title}</h5>
                <p>{hero.description}</p>
                <a className="btn btn-primary" href={hero.link}>
                  Learn More
                  <i className="fa fa-chevron-right"></i>
                </a>
              </Carousel.Caption>
            </Carousel.Item>
          );
        })}
      </Carousel>
    </section>
  );
}
