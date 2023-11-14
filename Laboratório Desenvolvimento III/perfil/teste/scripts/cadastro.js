document.addEventListener('DOMContentLoaded', function () {
    const perfilForm = document.getElementById('perfilForm');

    perfilForm.addEventListener('submit', async function (event) {
        event.preventDefault(); // Evita que o formulário seja enviado normalmente

        try {
            // Obtenha os valores do formulário
            const nome = document.getElementById('nome').value;
            const dataNascimento = document.getElementById('dataNascimento').value;
            const sobre = document.getElementById('sobre').value;
            const email = document.getElementById('email').value;
            const nomeProjeto = document.getElementById('nomeProjeto').value;
            const linkProjeto = document.getElementById('linkProjeto').value;
            const descricaoProjeto = document.getElementById('descricaoProjeto').value;
            const tecnologias = document.getElementById('tecnologias').value;
            const nomeExperiencia = document.getElementById('nomeExperiencia').value;
            const duracaoExperiencia = document.getElementById('duracaoExperiencia').value;
            const dataInicioExperiencia = document.getElementById('dataInicioExperiencia').value;
            const descricaoExperiencia = document.getElementById('descricaoExperiencia').value;
            const habilidades = document.getElementById('habilidades').value;
            const descricaoHabilidade = document.getElementById('descricaoHabilidade').value;

            // Crie o objeto de dados para o perfil
            const novoPerfil = {
                nome,
                dataNascimento,
                sobre,
                email,
                projeto: {
                    nome: nomeProjeto,
                    link: linkProjeto,
                    descricao: descricaoProjeto,
                    tagsStack: tecnologias,
                },
                experiencia: {
                    nome: nomeExperiencia,
                    durationMeses: duracaoExperiencia,
                    dataInicio: dataInicioExperiencia,
                    descricao: descricaoExperiencia,
                },
                habilidade: {
                    habilidade: habilidades,
                    descricao: descricaoHabilidade,
                },
            };

            // Faça uma solicitação POST para a API
            const URL_DA_API = 'http://localhost:8080/perfis';
            const response = await fetch(URL_DA_API, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(novoPerfil),
            });

            if (!response.ok) {
                throw new Error(`Erro ao cadastrar perfil. Status: ${response.status}`);
            }

            const data = await response.json();
            console.log('Perfil cadastrado com sucesso:', data);
            // Redirecione para a página de exibição do perfil ou faça outras ações necessárias
            window.location.href = 'pagina_de_exibicao_do_perfil.html';
        } catch (error) {
            console.error('Erro ao cadastrar perfil:', error);
            // Adicione lógica de tratamento de erros, como exibição de mensagem de erro para o usuário
        }
    });
});
