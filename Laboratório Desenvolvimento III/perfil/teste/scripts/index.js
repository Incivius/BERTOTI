const urlParams = new URLSearchParams(window.location.search);
const email = urlParams.get('email');

const URL_DA_API = 'http://localhost:8080/perfis';

// Adiciona o e-mail à URL
const urlCompleta = `${URL_DA_API}/?email=${encodeURIComponent(email)}`;

fetch(urlCompleta)
    .then(response => response.json())
    .then(data => {
        if (data && data.length > 0) {
            const { nome, dataNascimento, sobre, email, projeto, experiencia, habilidade } = data[0];

            // Preenchendo informações pessoais
            document.getElementById('nome').textContent = nome;
            document.getElementById('dataNascimento').textContent = dataNascimento;
            document.getElementById('sobre').textContent = sobre;
            document.getElementById('email').textContent = email;

            // Preenchendo informações do projeto
            const projetoCard = document.getElementById('projeto-card');
            projetoCard.innerHTML = `
                <p><strong>Nome do Projeto:</strong> ${projeto.nome}</p>
                <p><strong>Link do Projeto:</strong> <a href="${projeto.link}" target="_blank">${projeto.link}</a></p>
                <p><strong>Descrição do Projeto:</strong> ${projeto.descricao}</p>
                <p><strong>Tecnologias:</strong> ${projeto.tagsStack}</p>
            `;

            // Preenchendo informações de experiência
            const experienciaCard = document.getElementById('experiencia-card');
            experienciaCard.innerHTML = `
                <p><strong>Nome da Experiência:</strong> ${experiencia.nome}</p>
                <p><strong>Duração (meses):</strong> ${experiencia.durationMeses}</p>
                <p><strong>Data de Início:</strong> ${experiencia.dataInicio}</p>
                <p><strong>Descrição da Experiência:</strong> ${experiencia.descricao}</p>
            `;

            // Preenchendo informações de habilidade
            const habilidadeCard = document.getElementById('habilidade-card');
            habilidadeCard.innerHTML = `
                <p><strong>Habilidade:</strong> ${habilidade.habilidade}</p>
                <p><strong>Descrição da Habilidade:</strong> ${habilidade.descricao}</p>
            `;
        } else {
            console.error('A matriz de dados está vazia ou não é um array.');
        }
    })
    .catch(error => {
        console.error('Erro ao obter dados da API:', error);
    });
