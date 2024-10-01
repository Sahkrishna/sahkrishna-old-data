import Items from "./Items";
const FoodItem = ({ listOfItem }) => {
  // let foodItem = ["Dal", "Rice", "fruits", "Vegetables", "Milk", "Ghee"];
  const handOnClickFoodItems = (foodItem) => {
    console.log(`${foodItem} is clicked`);
  };
  return (
    <>
      <ul className="list-group ">
        {listOfItem.map((item) => (
          <Items
            key={item}
            handOnClickFoodItem={() => handOnClickFoodItems(item)}
            foodItem={item}
          ></Items>
        ))}
      </ul>
    </>
  );
};
export default FoodItem;
