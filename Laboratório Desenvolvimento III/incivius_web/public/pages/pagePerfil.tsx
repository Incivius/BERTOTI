import React, { useEffect, useState } from 'react';
import { getPerfis } from '../service/perfilService';

interface Profile {
    nome: string;
    dataNascimento: string;
    sobre: string;
    email: string;
    projetos: {
        nome: string;
        link: string;
        imagePath: string;
        tagsStack: string[];
        descricao: string;
    }[];
    experiencias: {
        nome: string;
        durationMeses: number;
        descricao: string;
        dataInicio: string;
    }[];
    habilidades: {
        habilidade: string[];
        descricao: string;
    }[];
}

const ProfilePage = () => {
    const [perfis, setPerfis] = useState<Profile[]>([]);
    const [selectedProfile, setSelectedProfile] = useState<Profile | null>();

    const fetchPerfis = async () => {
        try {
            const response = await getPerfis();
            setPerfis(response);
        } catch (error) {
            console.error('Erro ao buscar perfis:', error);
        }
    };

    useEffect(() => {
        fetchPerfis();
    }, []);

    return (
        <div>
            <h1>Perfis</h1>
            <ul>
                {perfis.map((profile) => (
                    <li key={profile.nome} onClick={() => setSelectedProfile(profile)}>
                        {profile.nome}
                    </li>
                ))}
            </ul>

        </div>
    );
}
export default ProfilePage;
