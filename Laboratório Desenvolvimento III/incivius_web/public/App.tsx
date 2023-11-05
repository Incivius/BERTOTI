import React from 'react';
import { Route, BrowserRouter as Router, Routes } from 'react-router-dom';
import ProfilePage from './pages/pagePerfil';

function App() {
    return (
        <Router>
            <Routes>
                <Route path="perfil" element={<ProfilePage />} />
            </Routes>
        </Router>
    );
}

export default App;
