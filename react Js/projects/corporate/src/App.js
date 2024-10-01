import "./App.css";
import "bootstrap/dist/css/bootstrap.min.css";
import AppHeader from "./components/header";
import AppHero from "./components/hero";
import AppAbout from "./components/about";
import AppService from "./components/services";
import AppWorks from "./components/works";
import AppTeam from "./components/teams";
import AppTestmonials from "./components/testimonials";
import AppPricing from "./components/pricing";
import AppBlog from "./components/blog";
import AppContact from "./components/contact";
import AppFooter from "./components/footer";

function App() {
  return (
    <div className="App">
      <header id="header">
        <AppHeader></AppHeader>
      </header>
      <main>
        <AppHero></AppHero>
        <AppAbout></AppAbout>
        <AppService></AppService>
        <AppWorks></AppWorks>
        <AppTeam></AppTeam>
        <AppTestmonials></AppTestmonials>
        <AppPricing></AppPricing>
        <AppBlog></AppBlog>
        <AppContact></AppContact>
      </main>
      <footer id="footer">
        <AppFooter></AppFooter>
      </footer>
    </div>
  );
}

export default App;
