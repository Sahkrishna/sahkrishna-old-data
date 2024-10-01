import ItemV from "./ItemV";
const VegetableItem = ({ listOfItem }) => {
  const vegetableItemClicked = (item) => {
    console.log(`${item} is clicked`);
  };
  return (
    <>
      <ul className="list-group vegetable-item">
        {listOfItem.map((item) => (
          <ItemV
            key={item}
            handleClick={() => vegetableItemClicked(item)}
            vegetableItem={item}
          ></ItemV>
        ))}
      </ul>
    </>
  );
};
export default VegetableItem;
