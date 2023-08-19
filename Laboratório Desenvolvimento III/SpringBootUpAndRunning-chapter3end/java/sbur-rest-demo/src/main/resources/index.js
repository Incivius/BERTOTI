document.addEventListener("DOMContentLoaded", () => {
    fetch("http://localhost:8070/coffees")
    .then(response => response.json())
    .then(data => {
        // coffeeList é uma variavél que representará a lista que será utilizada (Tag ul)
        const coffeeList = document.getElementById("coffees-list");
        data.forEach(coffee => {
             
            const listItem = document.createElement("li");
           // const upItem = document.createElement("input");
            //  const upButton = document.createElement("button");
            listItem.textContent = coffee.name;
            coffeeList.appendChild(listItem)
        });

    })
})