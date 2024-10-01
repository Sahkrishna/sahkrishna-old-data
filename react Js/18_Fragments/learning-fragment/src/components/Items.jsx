import styles from "./Items.module.css";
const Items = ({ foodItem, handOnClickFoodItem }) => {
  // let foodItemBuyClicked = (event) => {
  //   console.log(`${foodItem} is being clicked`);
  // };
  return (
    <>
      <li className="list-group-item">
        <span className="food-item">{foodItem}</span>
        <button
          className={`${styles.button} btn btn-warning`}
          onClick={handOnClickFoodItem}
        >
          Buy
        </button>
      </li>
    </>
  );
};

export default Items;
