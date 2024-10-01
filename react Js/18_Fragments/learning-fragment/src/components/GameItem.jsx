import ItemG from "./ItemG";
const GameItem = ({ listOfItem }) => {
  const handOnClickGameItem = (gameItem) => {
    console.log(`${gameItem} is clicked`);
  };
  return (
    <>
      <ul className="list-group">
        {listOfItem.map((item) => (
          <ItemG
            key={item}
            handOnClickGameItem={() => handOnClickGameItem(item)}
            gameItem={item}
          ></ItemG>
        ))}
      </ul>
    </>
  );
};
export default GameItem;
