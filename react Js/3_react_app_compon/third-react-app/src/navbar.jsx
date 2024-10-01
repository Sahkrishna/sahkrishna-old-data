function NavBar(){

  let name="Krishna";
  let age=25;

  let addr=()=>{

    return "india";
  }

  return <p>Hello my name is {name} and I am a {age} and address: {addr()}</p>;
}
export default NavBar;