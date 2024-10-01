import styles from "./ItemV.module.css";
const ItemV = ({ vegetableItem, handleClick }) => {
  // console.log(styles);

  const buttonClicked = (item) => {
    console.log(`${item} is clicked`);
  };
  return (
    <li className="list-group-item ">
      <span className={styles.veg}>{vegetableItem}</span>
      <button
        onClick={handleClick}
        className={`${styles.button} btn btn-info `}
      >
        Buy
      </button>
    </li>
  );
};
export default ItemV;
