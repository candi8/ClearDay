document.addEventListener("DOMContentLoaded", () => {
  const todosContainer = document.getElementById("Todos");
  const addButton = document.querySelector(".addbutton");
  const MAX_TODOS = 50;

  const createTodo = (text = "") => {
    const currentCount = todosContainer.querySelectorAll(".todo").length;
    if (currentCount >= MAX_TODOS) {
      alert("You have exceeded the limit of todos (50).");
      return;
    }

    const todoDiv = document.createElement("div");
    todoDiv.className = "todo";

    const input = document.createElement("input");
    input.type = "text";
    input.value = text;
    input.style.flexGrow = "1";
    input.style.fontSize = "20px";
    input.style.border = "none";
    input.style.background = "transparent";
    input.style.outline = "none";

    const deleteBtn = document.createElement("button");
    deleteBtn.className = "deletebtn";
    deleteBtn.textContent = "Delete 🗑";
    deleteBtn.title = "to delete this task press this Button";
    deleteBtn.style.marginLeft = "10px";
    deleteBtn.style.cursor = "pointer";

    deleteBtn.addEventListener("click", () => {
      todoDiv.nextElementSibling?.remove();
      todoDiv.remove();
      renumberTodos();
    });

    todoDiv.appendChild(input);
    todoDiv.appendChild(deleteBtn);

    todosContainer.appendChild(todoDiv);
    const hr = document.createElement("hr");
    todosContainer.appendChild(hr);

    renumberTodos();
  };

  const renumberTodos = () => {
    const todoItems = todosContainer.querySelectorAll(".todo input");
    todoItems.forEach((input, index) => {
      if (!input.value.trim()) {
        input.value = `Todo ${index + 1}`;
      }
    });
  };

  addButton.addEventListener("click", () => createTodo());

  const existingTodos = todosContainer.querySelectorAll(".todo");
  if (existingTodos.length > 0) {
    todosContainer.innerHTML = "";
  }

  ["Todo 1", "Todo 2", "Todo 3", "Todo 4", "Todo 5", "Todo 6", "Todo 7"].forEach(createTodo);
});


  


