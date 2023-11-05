import axios from 'axios';

const API_BASE_URL = 'http://localhost:8070';

export async function getPerfis() {
    try {
        const response = await axios.get(`${API_BASE_URL}/perfis`);
        return response.data;
    } catch (error) {
        console.error('Erro ao buscar perfis:', error);
        throw error;
    }
}

export async function criarPerfil(perfilData) {
    try {
        const response = await axios.post(`${API_BASE_URL}/perfis`, perfilData);
        return response.data;
    } catch (error) {
        console.error('Erro ao criar perfil:', error);
        throw error;
    }
}

export async function atualizarPerfil(id, perfilData) {
    try {
        const response = await axios.put(`${API_BASE_URL}/perfis/${id}`, perfilData);
        return response.data;
    } catch (error) {
        console.error('Erro ao atualizar perfil:', error);
        throw error;
    }
}

export async function excluirPerfil(id) {
    try {
        await axios.delete(`${API_BASE_URL}/perfis/${id}`);
    } catch (error) {
        console.error('Erro ao excluir perfil:', error);
        throw error;
    }
}
