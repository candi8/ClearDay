document.addEventListener("DOMContentLoaded", () => {
  const todo = document.getElementById("todo-section");

  const addTask = (val = "") => {
    const card = document.createElement("div");
    card.className = "todo-card";
    card.innerHTML = `<input value="${val}" type="text">
                      <button><i class="fa fa-trash"></i></button>`;
    card.querySelector("button").onclick = () => card.remove();
    todo.insertBefore(card, addBtnCard);
  };

  const addBtnCard = document.createElement("div");
  addBtnCard.className = "todo-card";
  addBtnCard.innerHTML = `<span>Ajouter</span><button><i class="fa fa-plus"></i></button>`;
  addBtnCard.querySelector("button").onclick = () => addTask();
  todo.appendChild(addBtnCard);

  ["Todo 1", "Todo 2", "Todo 3","Todo 4","Todo 5","Todo 6"].forEach(addTask);
});
