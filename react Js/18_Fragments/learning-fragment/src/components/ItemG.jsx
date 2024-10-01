import styles from "./ItemG.module.css";
const ItemG = ({ gameItem, handOnClickGameItem }) => {
  return (
    <li className="list-group-item">
      <span className="game-item">{gameItem}</span>
      <button
        onClick={handOnClickGameItem}
        className={`${styles.button} btn btn-info`}
      >
        Buy
      </button>
    </li>
  );
};
export default ItemG;
