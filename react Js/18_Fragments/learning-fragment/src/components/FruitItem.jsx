import ItemF from "./ItemF";

const FruitItem = ({ listOfItem }) => {
  const handOnClickFruitItems = (fruitItems) => {
    console.log(`${fruitItems} is clicked`);
  };
  return (
    <>
      <ul className="list-group">
        {listOfItem.map((item) => (
          <ItemF
            handOnClickFruitItems={() => handOnClickFruitItems(item)}
            key={item}
            fruitItem={item}
          ></ItemF>
        ))}
      </ul>
    </>
  );
};
export default FruitItem;
