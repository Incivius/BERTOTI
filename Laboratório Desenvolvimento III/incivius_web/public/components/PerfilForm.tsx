import React, { useState } from 'react';

const ProfileForm = ({ onCreateProfile }) => {
    const [profileData, setProfileData] = useState({
        nome: '',
        dataNascimento: '',
        sobre: '',
        email: '',
        projeto: {
            nome: '',
            link: '',
            imagePath: '',
            tagsStack: [''],
            descricao: '',
        },
        experiencia: {
            nome: '',
            durationMeses: '',
            descricao: '',
            dataInicio: '',
        },
        habilidade: {
            habilidade: [''],
            descricao: '',
        },
    });

    const handleChange = (e) => {
        const { name, value } = e.target;
        setProfileData({
            ...profileData,
            [name]: value,
        });
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        onCreateProfile(profileData);
    };

    return (
        <form onSubmit={handleSubmit}>
            <input
                type="text"
                name="nome"
                placeholder="Nome"
                value={profileData.nome}
                onChange={handleChange}
            />
            <input
                type="text"
                name="dataNascimento"
                placeholder="Data de Nascimento"
                value={profileData.dataNascimento}
                onChange={handleChange}
            />
            <input
                type="text"
                name="sobre"
                placeholder="Sobre"
                value={profileData.sobre}
                onChange={handleChange}
            />
            <input
                type="text"
                name="email"
                placeholder="E-mail"
                value={profileData.email}
                onChange={handleChange}
            />
            {/* Campos do projeto */}
            <input
                type="text"
                name="projeto.nome"
                placeholder="Nome do Projeto"
                value={profileData.projeto.nome}
                onChange={handleChange}
            />
            <input
                type="text"
                name="projeto.link"
                placeholder="Link do Projeto"
                value={profileData.projeto.link}
                onChange={handleChange}
            />
            <input
                type="text"
                name="projeto.imagePath"
                placeholder="Caminho da Imagem"
                value={profileData.projeto.imagePath}
                onChange={handleChange}
            />
            <input
                type="text"
                name="projeto.tagsStack"
                placeholder="Tags da Stack (separadas por vírgula)"
                value={profileData.projeto.tagsStack.join(',')}
                onChange={handleChange}
            />
            <input
                type="text"
                name="projeto.descricao"
                placeholder="Descrição do Projeto"
                value={profileData.projeto.descricao}
                onChange={handleChange}
            />
            {/* Campos da experiência */}
            <input
                type="text"
                name="experiencia.nome"
                placeholder="Nome da Experiência"
                value={profileData.experiencia.nome}
                onChange={handleChange}
            />
            <input
                type="text"
                name="experiencia.durationMeses"
                placeholder="Duração (em meses)"
                value={profileData.experiencia.durationMeses}
                onChange={handleChange}
            />
            <input
                type="text"
                name="experiencia.descricao"
                placeholder="Descrição da Experiência"
                value={profileData.experiencia.descricao}
                onChange={handleChange}
            />
            <input
                type="text"
                name="experiencia.dataInicio"
                placeholder="Ano de Início"
                value={profileData.experiencia.dataInicio}
                onChange={handleChange}
            />
            {/* Campos da habilidade */}
            <input
                type="text"
                name="habilidade.habilidade"
                placeholder="Habilidades (separadas por vírgula)"
                value={profileData.habilidade.habilidade.join(',')}
                onChange={handleChange}
            />
            <input
                type="text"
                name="habilidade.descricao"
                placeholder="Descrição da Habilidade"
                value={profileData.habilidade.descricao}
                onChange={handleChange}
            />
            <button type="submit">Cadastrar Perfil</button>
        </form>
    );
};

export default ProfileForm;
