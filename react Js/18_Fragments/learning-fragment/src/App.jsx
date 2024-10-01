import "./App.css";
import HeaderPart from "./components/HeaderPart";
import "bootstrap/dist/css/bootstrap.min.css";
import FoodItem from "./components/FoodItem";
import ErrorMessage from "./components/ErrorMessage";
import GameItem from "./components/GameItem";
import FruitItem from "./components/FruitItem";
import VegetableItem from "./components/VegetableItem";
import Container from "./components/Container";
import Input from "./components/Input";
import { useState } from "react";
import DataValue from "./components/DataValue";
import PasswordInput from "./components/PasswordInput";
import InputGameItem from "./components/InputGameItem";
import InputFruitItem from "./components/InputFruitItem";
import InputVegetableItem from "./components/InputVegetableItem";

function App() {
  // let foodItem = [];

  // let foodItem = ["Dal", "Rice", "fruits", "Vegetables", "Milk", "Ghee"];

  let [foodItem, setFoodItem] = useState(["Dal", "Rice", "fruits"]);

  const onKeyDown = (event) => {
    // let newFoodItem = event.target.value;
    // setFoodItem(...foodItem, newFoodItem);

    if (event.key === "Enter") {
      let newFoodItem = event.target.value;
      let newItems = [...foodItem, newFoodItem];
      setFoodItem(newItems);
      console.log("new food item is: " + newFoodItem);
    }
  };

  let data = ["krishna", "krishnasah@gmail.com", "98765678"];

  // if (foodItem.length === 0) {
  //   return <h2>No food</h2>;
  // }

  let [textOfInput, setTextValue] = useState("Enter email here:");
  let [textOfPassword, setTextPasswordValue] = useState(
    "Enter the password Here:"
  );

  // console.log(textOfInput);
  const inputText = (event) => {
    // console.log(event.target.value);
    textOfInput = event.target.value;
    setTextValue(event.target.value);
  };

  const inputPassword = (event) => {
    textOfPassword = event.target.value;
    setTextPasswordValue(event.target.value);
  };

  let [gameItem, setGameItem] = useState([
    "cricket",
    "foodball",
    "tennis",
    "volleyball",
  ]);

  const handOnKeyDownGameItem = (event) => {
    if (event.key === "Enter") {
      let newGameItem = event.target.value;
      let newGameItems = [...gameItem, newGameItem];
      setGameItem(newGameItems);
    }
  };

  let [fruitItem, setFruitItem] = useState(["grapes", "orange", "apple"]);

  const handOnKeyDownFruitItem = (event) => {
    if (event.key === "Enter") {
      let newFruitItem = event.target.value;
      let newFruitItems = [...fruitItem, newFruitItem];
      setFruitItem(newFruitItems);
      console.log(newFruitItem);
    }
  };

  let [vegetableItem, setVegetableItem] = useState([
    "carrot",
    "onion",
    "potato",
  ]);
  const handOnKeyDownVegetable = (event) => {
    if (event.key === "Enter") {
      let newVegetableItem = event.target.value;
      let newVegetableItems = [...vegetableItem, newVegetableItem];
      setVegetableItem(newVegetableItems);
      console.log(newVegetableItem);
    }
  };

  return (
    <>
      <Container>
        <HeaderPart></HeaderPart>
        {/* <DataValue listOfData={data}></DataValue> */}
        <div className="row">
          <div className="col-md-6">
            {/* <p>{textOfInput}</p> */}
            {/* <Input textInput={inputText}></Input> */}
            {/* <p>{textOfPassword}</p> */}
            <Container>
              <PasswordInput handOnKeyDown={onKeyDown}></PasswordInput>
              <ErrorMessage listOfItem={foodItem}></ErrorMessage>
              <FoodItem listOfItem={foodItem}></FoodItem>
            </Container>
          </div>
          <div className="col-md-6">
            <Container>
              <InputGameItem handOnKey={handOnKeyDownGameItem}></InputGameItem>
              <GameItem listOfItem={gameItem}></GameItem>
            </Container>
          </div>
        </div>
        <hr />
        <div className="row mt-3">
          <div className="col-md-6">
            <Container>
              <InputFruitItem
                handOnkey={handOnKeyDownFruitItem}
              ></InputFruitItem>
              <FruitItem listOfItem={fruitItem}></FruitItem>
            </Container>
          </div>
          <div className="col-md-6">
            <Container>
              <InputVegetableItem
                handOnKey={handOnKeyDownVegetable}
              ></InputVegetableItem>
              <VegetableItem listOfItem={vegetableItem}></VegetableItem>
            </Container>
          </div>
        </div>
      </Container>
    </>
  );
}

export default App;
