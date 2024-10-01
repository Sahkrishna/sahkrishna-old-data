import Container from "react-bootstrap/Container";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import Image from "react-bootstrap/Image";

export default function AppTeam() {
  const teamData = [
    {
      id: 1,
      image: require("../assets/images/team1.jpg"),
      fbLink: "https://www.facebook.com",
      twitterLink: "https://www/twitter.com",
      linkedinLink: "https://www.linkedin.com",
      name: "Krishna sah",
      designation: "Ceo",
      description: "He is the ceo of the company",
    },
    {
      id: 2,
      image: require("../assets/images/team2.jpg"),
      fbLink: "https://www.facebook.com",
      twitterLink: "https://www/twitter.com",
      linkedinLink: "https://www.linkedin.com",
      name: "Krishna sah",
      designation: "Data Analyst",
      description:
        "Contrary to popular belief, Lorem Ipsum is not simply random text.",
    },
    {
      id: 3,
      image: require("../assets/images/team3.jpg"),
      fbLink: "https://www.facebook.com",
      twitterLink: "https://www/twitter.com",
      linkedinLink: "https://www.linkedin.com",
      name: "John martin",
      designation: "Java Developer",
      description:
        "The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested.",
    },
    {
      id: 4,
      image: require("../assets/images/team4.jpg"),
      fbLink: "https://www.facebook.com",
      twitterLink: "https://www/twitter.com",
      linkedinLink: "https://www.linkedin.com",
      name: "Martin",
      designation: "React Developer",
      description:
        " The generated Lorem Ipsum is therefore always free from repetition, injected humour, or non-characteristic words etc.",
    },
    {
      id: 5,
      image: require("../assets/images/team5.jpg"),
      fbLink: "https://www.facebook.com",
      twitterLink: "https://www/twitter.com",
      linkedinLink: "https://www.linkedin.com",
      name: "Balram sah",
      designation: "Devoop Engineer",
      description:
        " The generated Lorem Ipsum is therefore always free from repetition, injected humour, or non-characteristic words etc.",
    },
    {
      id: 6,
      image: require("../assets/images/team6.jpg"),
      fbLink: "https://www.facebook.com",
      twitterLink: "https://www/twitter.com",
      linkedinLink: "https://www.linkedin.com",
      name: "Ramesh sah",
      designation: "AI Engineer",
      description:
        " The generated Lorem Ipsum is therefore always free from repetition, injected humour, or non-characteristic words etc.",
    },
    {
      id: 7,
      image: require("../assets/images/team7.jpg"),
      fbLink: "https://www.facebook.com",
      twitterLink: "https://www/twitter.com",
      linkedinLink: "https://www.linkedin.com",
      name: "Ganpati",
      designation: "Django developer",
      description:
        " The generated Lorem Ipsum is therefore always free from repetition, injected humour, or non-characteristic words etc.",
    },
    {
      id: 8,
      image: require("../assets/images/team8.jpg"),
      fbLink: "https://www.facebook.com",
      twitterLink: "https://www/twitter.com",
      linkedinLink: "https://www.linkedin.com",
      name: "Latin",
      designation: "Laravel developer",
      description:
        " The generated Lorem Ipsum is therefore always free from repetition, injected humour, or non-characteristic words etc.",
    },
  ];

  return (
    <section id="teams" className="block teams-block">
      <Container fluid>
        <div className="title-holder">
          <h2>Our Teams</h2>
          <div className="subtitle">Some of our experts</div>
        </div>

        <Row>
          {teamData.map((team) => {
            return (
              <Col key={team.id} sm={3}>
                <div className="image">
                  <Image src={team.image}></Image>
                  <div className="overlay">
                    <div className="socials">
                      <ul>
                        <li>
                          <a href={team.fbLink}>
                            <i className="fa-brands fa-facebook"></i>
                          </a>
                        </li>
                        <li>
                          <a href={team.twitterLink}>
                            <i className="fa-brands fa-twitter"></i>
                          </a>
                        </li>
                        <li>
                          <a href={team.linkedinLink}>
                            <i className="fa-brands fa-linkedin"></i>
                          </a>
                        </li>
                      </ul>
                    </div>
                  </div>
                </div>
                <div className="content">
                  <h3>{team.name}</h3>
                  <span className="designation">{team.designation}</span>
                  <p>{team.description}</p>
                </div>
              </Col>
            );
          })}
        </Row>
      </Container>
    </section>
  );
}
