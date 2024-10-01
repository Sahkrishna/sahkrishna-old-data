import styles from "./ItemF.module.css";
const ItemF = ({ fruitItem, handOnClickFruitItems }) => {
  return (
    <>
      <li className="list-group-item fruit-item">
        {fruitItem}
        <button
          onClick={handOnClickFruitItems}
          className={`${styles.button} btn btn-primary`}
        >
          Buy
        </button>
      </li>
    </>
  );
};
export default ItemF;
