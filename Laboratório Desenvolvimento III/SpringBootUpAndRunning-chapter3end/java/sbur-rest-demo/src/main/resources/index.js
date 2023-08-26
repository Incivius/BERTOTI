document.addEventListener("DOMContentLoaded", () => {
    fetch("http://localhost:8070/coffees")
    .then(response => response.json())
    .then(data => {
        const cartasContainer = document.querySelector(".cartas-container");
        data.forEach(coffee => {
            const carta = document.createElement("div");
            carta.classList.add("carta");

            const frente = document.createElement("div");
            frente.classList.add("conteudo-frente");

            const imagemCarta = document.createElement("div");
            imagemCarta.classList.add("imagem-carta");
            imagemCarta.style.backgroundImage = `url(${coffee.imagePath})`;
            imagemCarta.innerHTML = `<img src="${coffee.imagemPath}" alt="${coffee.nome}" />`;
            const textoCarta = document.createElement("div");
            textoCarta.classList.add("texto-carta");
            textoCarta.innerHTML = `
                <h2>${coffee.nome}</h2>
                <p>${coffee.descrição}</p>
                <p><strong>Tipo:</strong> ${coffee.tipo}</p>
                <p><strong>Habilidades:</strong> ${coffee.hab}</p>`;
            frente.appendChild(imagemCarta);
            frente.appendChild(textoCarta);


            const verso = document.createElement("div");
            verso.classList.add("conteudo-verso");
            verso.innerHTML = `
                <h2>${coffee.nome}</h2>
                <p>${coffee.descrição}</p>
                <p><strong>Tipo:</strong> ${coffee.tipo}</p>
                <p><strong>Habilidades:</strong> ${coffee.hab}</p>
            `;

            carta.appendChild(frente);
            carta.appendChild(verso);
            cartasContainer.appendChild(carta);

            // Adicione um ouvinte de evento de clique para cada carta
            carta.addEventListener('click', () => {
                carta.classList.toggle('clicada');
            });
        });
    });
});
