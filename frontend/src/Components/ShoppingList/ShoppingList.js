import React from "react";
import Navigator from "../navigation/Navigator";
import "./shoppinglist.css";
import { FaRegTrashAlt, FaRegCheckCircle } from "react-icons/fa";

export default function ShoppingList(props) {
  const {addPurchasedItem, deletePurchasedItem, purchaseditems,deleteShoppingList} = props;
  const purchasedIngredient = (ingredientname) => {
    if (purchaseditems.includes(ingredientname)) {
      deletePurchasedItem(ingredientname);
    } else {
      addPurchasedItem(ingredientname);
    }
  };

  const shoppingItem = props.shoppingList.map((item, index) => {

    return (
      <div key={index}>
      
        <li id="shopping-list">
          <div
            onClick={() => {
              purchasedIngredient(item.ingredientname);
            }}
          >
            {purchaseditems.includes(item.ingredientname) ? (
              <p style={{ textDecorationLine: "line-through", color: "grey" }} className="shopping-list-item">
                <FaRegCheckCircle
                  id="checkcircle"
                  style={{ color: "#80F57E" }}
                />
                {item.ingredientname}
              </p>
            ) : (
              <p className="shopping-list-item">
                <FaRegCheckCircle id="checkcircle" />
                {item.ingredientname}
              </p>
            )}
          </div>
          <div className="recipeTitle">{item.recipeTitle}</div>
          <div>{item.measurementUnit}</div>
          <FaRegTrashAlt
            className="hidebutton"
            id="trash"
            onClick={() => deleteShoppingList(item.ingredientname)}
          />
        </li>
      </div>
    );
  });
  //display pantry items
  return (

    
    <>
      <Navigator />
      <h3>ShoppingList</h3>

      {props.shoppingList.length !== 0 && (
        <ul id="shopping-items">
          
          {shoppingItem}
          
          </ul>
      )}
      <br></br>
    </>
  );

}
